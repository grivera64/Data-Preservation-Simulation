package com.grivera.solver;

import com.grivera.generator.DataNode;
import com.grivera.generator.Network;
import com.grivera.generator.SensorNetwork;

public abstract class AbstractModel implements Model {
    private final Network network;
    private boolean hasRan;

    public AbstractModel(String fileName) {
        this(SensorNetwork.from(fileName));
    }

    public AbstractModel(String fileName, int overflowPackets, int storageCapacity) {
        this(SensorNetwork.from(fileName, overflowPackets, storageCapacity));
    }

    public AbstractModel(Network network) {
        this.network = network;
        this.hasRan = false;
    }

    @Override
    public void run() {
        this.hasRan = true;
        this.network.resetPackets();
    }

    @Override
    public int getTotalCost() {
        if (!this.hasRan) {
            throw new IllegalStateException("Cannot get the total cost before running the model!");
        }
        return -1;
    }

    public final Network getNetwork() {
        return this.network;
    }

    protected boolean overflowPacketsRemain() {
        for (DataNode dn : this.network.getDataNodes()) {
            if (!dn.isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
