package com.grivera.solver;

import com.grivera.generator.DataNode;
import com.grivera.generator.Network;
import com.grivera.generator.StorageNode;

public class NodeOrderedGreedyModel extends AbstractModel {

    private int totalCost;

    public NodeOrderedGreedyModel(Network network) {
        super(network);
    }

    public NodeOrderedGreedyModel(String fileName) {
        super(fileName);
    }

    public NodeOrderedGreedyModel(String fileName, int overflowPackets, int storageCapacity) {
        super(fileName, overflowPackets, storageCapacity);
    }

    @Override
    public void run() {
        super.run();

        Network network = this.getNetwork();
        StorageNode to = null;
        this.totalCost = 0;

        int minCost;
        int currCost;

        while (this.overflowPacketsRemain()) {
            for (DataNode dn : network.getDataNodes()) {
                if (dn.isEmpty()) {
                    continue;
                }

                minCost = Integer.MAX_VALUE;
                for (StorageNode sn : network.getStorageNodes()) {
                    if (sn.isFull()) {
                        continue;
                    }

                    currCost = network.calculateMinCost(dn, sn);
                    if (currCost < minCost && network.canSendPackets(dn, sn, 1)) {
                        minCost = currCost;
                        to = sn;
                    }
                }
                network.sendPackets(dn, to, 1);
                this.totalCost += minCost;
            }
        }
    }

    @Override
    public int getTotalCost() {
        super.getTotalCost();

        return this.totalCost;
    }
}
