package com.grivera.solver;

import com.grivera.generator.DataNode;
import com.grivera.generator.Network;
import com.grivera.generator.StorageNode;

import java.util.List;
import java.util.stream.Collectors;

public class DistanceOrderedGreedyModel extends AbstractModel {

    private int totalCost;

    public DistanceOrderedGreedyModel(Network network) {
        super(network);
    }
    
    public DistanceOrderedGreedyModel(String fileName) {
        super(fileName);
    }

    public DistanceOrderedGreedyModel(String fileName, int overflowPackets, int storageCapacity) {
        super(fileName, overflowPackets, storageCapacity);
    }

    @Override
    public void run() {
        super.run();

        Network network = this.getNetwork();
        DataNode from = null;
        StorageNode to = null;
        List<StorageNode> options;
        this.totalCost = 0;

        int minCost;
        int currCost;
        int minPackets;
        while (this.overflowPacketsRemain()) {
            minCost = Integer.MAX_VALUE;
            for (DataNode dn : network.getDataNodes()) {
                if (dn.isEmpty()) {
                    continue;
                }

                options = network.getStorageNodes().stream()
                        .filter(sn -> !sn.isFull())
                        .collect(Collectors.toList());

                for (StorageNode sn : options) {
                    currCost = network.calculateMinCost(dn, sn);
                    if (currCost < minCost && network.canSendPackets(dn, sn, 1)) {
                        minCost = currCost;
                        from = dn;
                        to = sn;
                    }
                }
            }

            if (from == null || minCost == Integer.MAX_VALUE) {
                throw new IllegalStateException("Unknown error!");
            }

            minPackets = Math.min(from.getPacketsLeft(), to.getSpaceLeft());

            if (!network.canSendPackets(from, to, minPackets)) {
                throw new IllegalStateException("ERROR: Failed to find minimum-cost DN->SN pair!");
            }
            network.sendPackets(from, to, minPackets);
            this.totalCost += minCost * minPackets;
        }
    }

    @Override
    public int getTotalCost() {
        super.getTotalCost();
        return this.totalCost;
    }
}
