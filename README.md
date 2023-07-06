# Data-Preservation-Simulation

---
A simulation for testing data preservation of base station-less networks (BSNs).

## Table of Contents

---
- [About](#about)
- [Setup](#setup)
- [Example](#example)
    - [Terminal Output](#terminal-output)
- [Related Projects](#related-projects)
- [Author](#author)

## About

---
This data preservation simulation uses the project [grivera64/Sensor-Network-with-MCF](https://github.com/grivera64/Sensor-Generator-with-MCF)
to generate a suite of base station-less networks (BSNs) and applies several
multi-agent policies, such as Random (R), Node-Ordered Greedy (NG), and Distance-Ordered Greedy (DG).

This simulation outputs the energy consumption of using the above algorithms, denoted by E_strategy.

This simulation was used jointly in our paper "Nash Equilibria of Data Preservation in Base Station-less Sensor Networks" by Giovanni Rivera,
Yutian Chen, and Bin Tang, pp. 6-7. for analyzing the Rate of Efficiency Loss (REL) for each of these strategies in compared
to the optimal energy consumption from the Minimum Cost Flow algorithm. You can view the paper [here](https://scholarworks.calstate.edu/concern/publications/vx021n445).

## Setup

---

### Dependencies

- JDK 14 or newer ([Latest JDK from Oracle](https://www.oracle.com/java/technologies/downloads/))

### 1. Clone the Repository

Open a command line or terminal instance and enter the following command:
```sh
git clone https://github.com/grivera64/Data-Preservation-Simulation.git
```

You can also download the repository as a zip file directly
from GitHub [here](https://github.com/grivera64/Data-Preservation-Simulation/archive/refs/heads/main.zip) and unzip it.

### 2. Change directories into the source folder.

```sh
cd Data-Preservation-Simulation
cd src
```

### 3. Compile using javac

```sh
javac -p "." *.java -d ../bin
```

### 4. Change directories into the binaries folder

```sh
cd ..
cd bin
```

### 5. Run the program
```sh
java -p "."  RunModelTests
```

## Example

---
### Terminal output

```txt
Welcome to the Data Preservation Simulator!
===========================================
Please enter an option: (G)enerate/(F)ile/(Q)uit:
> G
Please enter the width (x) of the sensor network:
x = 10
Please enter the height (y) of the sensor network: 
y = 10
Please enter the number of sensor nodes (N) to generate in the sensor network:
N = 10
Please enter the number the transmission range (Tr) in meters:
Tr = 5
Please enter the number of Data Nodes (p) to generate:
p = 5
Please enter the number of data packets (q) each Data Node has:
q = 2
Please enter the amount of packets (m) each Storage Node has:
m = 2
Saved sensor network in file "network.sn"!

E_R  = 10226 micro J (0.01 J)
E_NG = 9002 micro J (0.01 J)
E_DG = 7708 micro J (0.01 J)
```

## Related Projects

---

- Sensor Generator with MCF ([grivera64/Sensor-Generator-with-MCF](https://github.com/grivera64/Sensor-Generator-with-MCF))
  - Sensor Network generator and visualizer for CS2 Min-Cost Flow input.
  - By Giovanni Rivera ([@grivera64](https://github.com/grivera64))

- Sensor Generator with Max Profit ([grivera64/Sensor-Generator-with-Max-Profit](https://github.com/grivera64/Sensor-Generator-with-Max-Profit))
  - Reimplementation of [grivera64/SensorGenerator-with-MCF](https://github.com/grivera64/Sensor-Generator-with-MCF) for maximizing profit in data preservation.
  - By Giovanni Rivera ([@grivera64](https://github.com/grivera64))
 
- Max Profit Data Preservation Simulation ([grivera64/Max-Profit-Data-Preservation-Simulation](https://github.com/grivera64/Max-Profit-Data-Preservation-Simulation))
  - Reimplementation of [grivera64/Data-Preservation-Simulation](https://github.com/grivera64/Data-Preservation-Simulation) for maximizing profit in data preservation.
  - By Giovanni Rivera ([@grivera64](https://github.com/grivera64)) & Christopher Gonzalez ([@chrisagonza97](https://github.com/chrisagonza97))

## Author

---
Giovanni Rivera ([@grivera64](https://github.com/grivera64))
