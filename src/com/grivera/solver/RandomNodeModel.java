package com.grivera.solver;

import com.grivera.generator.DataNode;
import com.grivera.generator.Network;
import com.grivera.generator.StorageNode;

import java.util.List;
import java.util.stream.Collectors;

public class RandomNodeModel extends AbstractModel {

    private int totalCost;

    public RandomNodeModel(Network network) {
        super(network);
    }

    public RandomNodeModel(String fileName) {
        super(fileName);
    }

    public RandomNodeModel(String fileName, int overflowPackets, int storageCapacity) {
        super(fileName, overflowPackets, storageCapacity);
    }

    @Override
    public void run() {
        super.run();

        Network network = this.getNetwork();
        this.totalCost = 0;

        List<StorageNode> sns = network.getStorageNodes();
        List<StorageNode> currSns;

        int index;
        while (this.overflowPacketsRemain()) {
            for (DataNode dn : network.getDataNodes()) {
                if (dn.isEmpty()) {
                    System.out.printf("%s is done!\n", dn.getName());
                    continue;
                }

                currSns = sns.stream()
                        .filter(sn -> sn.canStore(1))
                        .collect(Collectors.toList());

                if (currSns.isEmpty()) {
                    continue;
                }

                do {
                    index = (int) (currSns.size() * Math.random());
                } while (!network.canSendPackets(dn, currSns.get(index), 1));

                this.totalCost += network.calculateMinCost(dn, currSns.get(index));
                network.sendPackets(dn, currSns.get(index), 1);
            }
        }

    }

    @Override
    public int getTotalCost() {
        super.getTotalCost();
        return this.totalCost;
    }
}
