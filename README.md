# Data-Preservation-Simulation

---
A simulation for testing data preservation of base station-less networks (BSNs).

## Table of Contents

---
- [About](#about)
- [Setup](#setup)
- [Example](#example)
    - [Terminal Output](#terminal-output)
- [Author](#author)

## About

---
This data preservation simulation uses the project [grivera64/Sensor-Network-with-MCF](https://github.com/grivera64/Sensor-Generator-with-MCF)
to generate a suite of base station-less networks (BSNs) and applies several
multi-agent policies, such as Random (R), Node-Ordered Greedy (NG), and Distance-Ordered Greedy (DG). 

This simulation was used jointly in our paper "Nash Equilibria of Data Preservation in Base Station-less Sensor Networks" by Giovanni Rivera,
Yutian Chen, and Bin Tang, pp. 6-7.

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

## Author

---
Giovanni Rivera ([@grivera64](https://github.com/grivera64))
