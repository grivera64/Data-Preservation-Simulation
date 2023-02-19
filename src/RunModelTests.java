import com.grivera.generator.Network;
import com.grivera.generator.SensorNetwork;
import com.grivera.solver.DistanceOrderedGreedyModel;
import com.grivera.solver.Model;
import com.grivera.solver.NodeOrderedGreedyModel;
import com.grivera.solver.RandomNodeModel;

import java.util.Scanner;

public class RunModelTests {
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Data Preservation Simulator!");
        System.out.println("===========================================");

        System.out.print("Please enter an option: (G)enerate/(F)ile/(Q)uit:\n> ");
        int option = keyboard.nextLine().charAt(0);

        Network network = null;
        switch (option) {
            case 'F', 'f' ->  network = readNetwork();
            case 'G', 'g' -> {
                network = generateNetwork();
                network.save("network.sn");
            }
            default -> {
                System.out.println("Thank you for using Sensor-Generator-with-MCF!");
                System.exit(0);
            }
        }
        System.out.println();

        Model model;
        model = new RandomNodeModel(network);
        long total = 0;
        for (int i = 0; i < 10; i++) {
            model.run();
            total += model.getTotalCost();
        }
        total /= 10;
        System.out.printf("E_R  = %d micro J (%.2f J)\n",
                total, total * Math.pow(10, -6)
        );

        model = new NodeOrderedGreedyModel(network);
        model.run();
        total = model.getTotalCost();
        System.out.printf("E_NG = %d micro J (%.2f J)\n",
                total, total * Math.pow(10, -6)
        );

        model = new DistanceOrderedGreedyModel(network);
        model.run();
        total = model.getTotalCost();
        System.out.printf("E_DG = %d micro J (%.2f J)\n",
                total, total * Math.pow(10, -6)
        );
    }

    public static Network readNetwork() {
        System.out.print("Please enter the file name:\nF > ");
        String fileName = keyboard.nextLine().trim();
        return SensorNetwork.from(fileName);
    }

    public static Network generateNetwork() {
        System.out.println("Please enter the width (x) of the sensor network:");
        System.out.print("x = ");
        double width = keyboard.nextDouble();
        keyboard.nextLine();

        System.out.println("Please enter the height (y) of the sensor network: ");
        System.out.print("y = ");
        double height = keyboard.nextDouble();
        keyboard.nextLine();

        System.out.println("Please enter the number of sensor nodes (N) to generate in the sensor network:");
        System.out.print("N = ");
        int nodeCount = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("Please enter the number the transmission range (Tr) in meters:");
        System.out.print("Tr = ");
        double transmissionRange = keyboard.nextDouble();
        keyboard.nextLine();

        System.out.println("Please enter the number of Data Nodes (p) to generate:");
        System.out.print("p = ");
        int gNodeCount = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("Please enter the number of data packets (q) each Data Node has:");
        System.out.print("q = ");
        int packetsCount = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("Please enter the amount of packets (m) each Storage Node has:");
        System.out.print("m = ");
        int storageCount = keyboard.nextInt();
        keyboard.nextLine();

        return SensorNetwork.of(width, height, nodeCount, transmissionRange, gNodeCount, packetsCount, storageCount);
    }
}
