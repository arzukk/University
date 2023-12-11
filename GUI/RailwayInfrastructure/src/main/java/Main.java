import Mechanics.Locomotive;
import Mechanics.RailroadCar;
import Mechanics.Trainset;
import Mechanics2.*;
import Station.RailwayStation;
import Exception.*;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static Enums.BasicFreightType.*;
import static Enums.HeavyFreightType.*;

public class Main {

    public static void main(String[] args) throws Exception, RailroadHazardException {
        //100 railway stations with connections between them, 25 trainsets(with randomly 5-10 railroad cars each).
        BasicRrFreightCar basicRrFreightCar1 = new BasicRrFreightCar(50.0, "metal", LIQUID_RR_CAR);
        HeavyRrFreightCar heavyRrFreightCar1 = new HeavyRrFreightCar(70.5, "metal", TOXIC_RR_CAR);
        MailCar mailCar1 = new MailCar(20.0, "metal");
        PassengerRailroadCar passengerRailroadCar1 = new PassengerRailroadCar(120.0, 2);
        RrRestaurantCar rrRestaurantCar1 = new RrRestaurantCar(120.0, "metal");

        BasicRrFreightCar basicRrFreightCar2 = new BasicRrFreightCar(100.0, "metal", GAS_RR_CAR);
        HeavyRrFreightCar heavyRrFreightCar2 = new HeavyRrFreightCar(200.5, "metal", EXPLOSIVE_RR_CAR);
        MailCar mailCar2 = new MailCar(70.0, "steel");
        PassengerRailroadCar passengerRailroadCar2 = new PassengerRailroadCar(150.0, 100);
        RrRestaurantCar rrRestaurantCar2 = new RrRestaurantCar(300.0, "metal");

        BasicRrFreightCar basicRrFreightCar3 = new BasicRrFreightCar(100.0, "steel", REFRIGERATOR_RR_CAR);
        HeavyRrFreightCar heavyRrFreightCar3 = new HeavyRrFreightCar(70.5, "steel", TOXIC_RR_CAR);
        MailCar mailCar3 = new MailCar(60.0, "metal");
        PassengerRailroadCar passengerRailroadCar3 = new PassengerRailroadCar(200.0, 4);
        RrRestaurantCar rrRestaurantCar3 = new RrRestaurantCar(120.0, "metal");

        BasicRrFreightCar basicRrFreightCar4 = new BasicRrFreightCar(200.0, "metal", LIQUID_RR_CAR);
        HeavyRrFreightCar heavyRrFreightCar4 = new HeavyRrFreightCar(60.5, "metal", TOXIC_RR_CAR);
        MailCar mailCar4 = new MailCar(20.0, "metal");
        PassengerRailroadCar passengerRailroadCar4 = new PassengerRailroadCar(160.0, 2);
        RrRestaurantCar rrRestaurantCar4 = new RrRestaurantCar(120.0, "metal");

        BasicRrFreightCar basicRrFreightCar5 = new BasicRrFreightCar(200.0, "metal", GAS_RR_CAR);
        HeavyRrFreightCar heavyRrFreightCar5 = new HeavyRrFreightCar(70.5, "metal", EXPLOSIVE_RR_CAR);
        MailCar mailCar5 = new MailCar(20.0, "metal");
        PassengerRailroadCar passengerRailroadCar5 = new PassengerRailroadCar(200.0, 2);
        RrRestaurantCar rrRestaurantCar5 = new RrRestaurantCar(120.0, "metal");

//        Map<RailwayStation, List<RailwayStation>> railwayRoute = new HashMap<>();

        //STATION CREATION
        RailwayStation stationA = new RailwayStation("Station A");
        RailwayStation stationB = new RailwayStation("Station B");
        RailwayStation stationC = new RailwayStation("Station C");
        RailwayStation stationD = new RailwayStation("Station D");
        RailwayStation stationE = new RailwayStation("Station E");
        RailwayStation stationF = new RailwayStation("Station F");
        RailwayStation stationG = new RailwayStation("Station G");
        RailwayStation stationH = new RailwayStation("Station H");
        RailwayStation stationJ = new RailwayStation("Station J");
        RailwayStation stationK = new RailwayStation("Station K");
        RailwayStation stationL = new RailwayStation("Station L");
        RailwayStation stationM = new RailwayStation("Station M");
        RailwayStation stationN = new RailwayStation("Station N");
        RailwayStation stationO = new RailwayStation("Station O");
        RailwayStation stationP = new RailwayStation("Station P");
        RailwayStation stationR = new RailwayStation("Station R");
        RailwayStation stationS = new RailwayStation("Station S");
        RailwayStation stationT = new RailwayStation("Station T");
        RailwayStation stationU = new RailwayStation("Station U");
        RailwayStation stationV = new RailwayStation("Station V");
        RailwayStation stationY = new RailwayStation("Station Y");
        RailwayStation stationZ = new RailwayStation("Station Z");
        RailwayStation stationX = new RailwayStation("Station X");
        RailwayStation stationQ = new RailwayStation("Station Q");
        RailwayStation stationW = new RailwayStation("Station W");
        RailwayStation stationA1 = new RailwayStation("Station A1");
        RailwayStation stationB1 = new RailwayStation("Station B1");
        RailwayStation stationC1 = new RailwayStation("Station C1");
        RailwayStation stationD1 = new RailwayStation("Station D1");
        RailwayStation stationE1 = new RailwayStation("Station E1");
        RailwayStation stationF1 = new RailwayStation("Station F1");
        RailwayStation stationG1 = new RailwayStation("Station G1");
        RailwayStation stationH1 = new RailwayStation("Station H1");
        RailwayStation stationJ1 = new RailwayStation("Station J1");
        RailwayStation stationK1 = new RailwayStation("Station K1");
        RailwayStation stationL1 = new RailwayStation("Station L1");
        RailwayStation stationM1 = new RailwayStation("Station M1");
        RailwayStation stationN1 = new RailwayStation("Station N1");
        RailwayStation stationO1 = new RailwayStation("Station O1");
        RailwayStation stationP1 = new RailwayStation("Station P1");
        RailwayStation stationR1 = new RailwayStation("Station R1");
        RailwayStation stationS1 = new RailwayStation("Station S1");
        RailwayStation stationT1 = new RailwayStation("Station T1");
        RailwayStation stationU1 = new RailwayStation("Station U1");
        RailwayStation stationV1 = new RailwayStation("Station V1");
        RailwayStation stationY1 = new RailwayStation("Station Y1");
        RailwayStation stationZ1 = new RailwayStation("Station Z1");
        RailwayStation stationX1 = new RailwayStation("Station X1");
        RailwayStation stationQ1 = new RailwayStation("Station Q1");
        RailwayStation stationW1 = new RailwayStation("Station W1");
        RailwayStation stationA2 = new RailwayStation("Station A2");
        RailwayStation stationB2 = new RailwayStation("Station B2");
        RailwayStation stationC2 = new RailwayStation("Station C2");
        RailwayStation stationD2 = new RailwayStation("Station D2");
        RailwayStation stationE2 = new RailwayStation("Station E2");
        RailwayStation stationF2 = new RailwayStation("Station F2");
        RailwayStation stationG2 = new RailwayStation("Station G2");
        RailwayStation stationH2 = new RailwayStation("Station H2");
        RailwayStation stationJ2 = new RailwayStation("Station J2");
        RailwayStation stationK2 = new RailwayStation("Station K2");
        RailwayStation stationL2 = new RailwayStation("Station L2");
        RailwayStation stationM2 = new RailwayStation("Station M2");
        RailwayStation stationN2 = new RailwayStation("Station N2");
        RailwayStation stationO2 = new RailwayStation("Station O2");
        RailwayStation stationP2 = new RailwayStation("Station P2");
        RailwayStation stationR2 = new RailwayStation("Station R2");
        RailwayStation stationS2 = new RailwayStation("Station S2");
        RailwayStation stationT2 = new RailwayStation("Station T2");
        RailwayStation stationU2 = new RailwayStation("Station U2");
        RailwayStation stationV2 = new RailwayStation("Station V2");
        RailwayStation stationY2 = new RailwayStation("Station Y2");
        RailwayStation stationZ2 = new RailwayStation("Station Z2");
        RailwayStation stationX2 = new RailwayStation("Station X2");
        RailwayStation stationQ2 = new RailwayStation("Station Q2");
        RailwayStation stationW2 = new RailwayStation("Station W2");
        RailwayStation stationA3 = new RailwayStation("Station A3");
        RailwayStation stationB3 = new RailwayStation("Station B3");
        RailwayStation stationC3 = new RailwayStation("Station C3");
        RailwayStation stationD3= new RailwayStation("Station D3");
        RailwayStation stationE3 = new RailwayStation("Station E3");
        RailwayStation stationF3= new RailwayStation("Station F3");
        RailwayStation stationG3 = new RailwayStation("Station G3");
        RailwayStation stationH3 = new RailwayStation("Station H3");
        RailwayStation stationJ3 = new RailwayStation("Station J3");
        RailwayStation stationK3 = new RailwayStation("Station K3");
        RailwayStation stationL3 = new RailwayStation("Station L3");
        RailwayStation stationM3 = new RailwayStation("Station M3");
        RailwayStation stationN3 = new RailwayStation("Station N3");
        RailwayStation stationO3 = new RailwayStation("Station O3");
        RailwayStation stationP3 = new RailwayStation("Station P3");
        RailwayStation stationR3 = new RailwayStation("Station R3");
        RailwayStation stationS3 = new RailwayStation("Station S3");
        RailwayStation stationT3 = new RailwayStation("Station T3");
        RailwayStation stationU3 = new RailwayStation("Station U3");
        RailwayStation stationV3 = new RailwayStation("Station V3");
        RailwayStation stationY3 = new RailwayStation("Station Y3");
        RailwayStation stationZ3 = new RailwayStation("Station Z3");
        RailwayStation stationX3 = new RailwayStation("Station X3");
        RailwayStation stationQ3 = new RailwayStation("Station Q3");
        RailwayStation stationW3 = new RailwayStation("Station W3");
        RailwayStation stationA4 = new RailwayStation("Station A4");
        RailwayStation stationB4 = new RailwayStation("Station B4");
        RailwayStation stationC4 = new RailwayStation("Station C4");
        RailwayStation stationD4 = new RailwayStation("Station D4");
        RailwayStation stationE4 = new RailwayStation("Station E4");
        RailwayStation stationF4 = new RailwayStation("Station F4");
        RailwayStation stationG4 = new RailwayStation("Station G4");
        RailwayStation stationH4 = new RailwayStation("Station H4");
        RailwayStation stationJ4 = new RailwayStation("Station J4");
        RailwayStation stationK4 = new RailwayStation("Station K4");
        RailwayStation stationL4 = new RailwayStation("Station L4");
        RailwayStation stationM4 = new RailwayStation("Station M4");
        RailwayStation stationN4 = new RailwayStation("Station N4");
        RailwayStation stationO4 = new RailwayStation("Station O4");
        RailwayStation stationP4 = new RailwayStation("Station P4");
        RailwayStation stationR4 = new RailwayStation("Station R4");
        RailwayStation stationS4 = new RailwayStation("Station S4");
        RailwayStation stationT4 = new RailwayStation("Station T4");
        RailwayStation stationU4 = new RailwayStation("Station U4");
        RailwayStation stationV4 = new RailwayStation("Station V4");
        RailwayStation stationY4 = new RailwayStation("Station Y4");
        RailwayStation stationZ4 = new RailwayStation("Station Z4");
        RailwayStation stationX4 = new RailwayStation("Station X4");
        RailwayStation stationQ4 = new RailwayStation("Station Q4");
        RailwayStation stationW4 = new RailwayStation("Station W4");
        //STATION CONNECTION
        stationA.addNeighbor(stationB, 100.0);
        stationA.addNeighbor(stationC, 150.0);
        stationB.addNeighbor(stationC, 50.0);
        stationC.addNeighbor(stationD, 200.0);
        stationD.addNeighbor(stationE, 200.0);
        stationE.addNeighbor(stationF, 250.0);
        stationF.addNeighbor(stationG, 350.0);
        stationG.addNeighbor(stationH, 500.0);
        stationH.addNeighbor(stationJ, 700.0);
        stationJ.addNeighbor(stationK, 550.0);
        stationK.addNeighbor(stationL, 600.0);
        stationL.addNeighbor(stationM, 120.0);
        stationM.addNeighbor(stationN, 300.0);
        stationN.addNeighbor(stationO, 450.0);
        stationO.addNeighbor(stationP, 550.0);
        stationR.addNeighbor(stationS, 290.0);
        stationS.addNeighbor(stationT, 900.0);
        stationT.addNeighbor(stationU, 350.0);
        stationU.addNeighbor(stationV, 750.0);
        stationV.addNeighbor(stationY, 800.0);
        stationY.addNeighbor(stationZ, 900.0);
        stationZ.addNeighbor(stationX, 750.0);
        stationX.addNeighbor(stationQ, 580.0);
        stationQ.addNeighbor(stationW, 270.0);
        stationA.addNeighbor(stationZ, 200.0);
        stationB.addNeighbor(stationY, 750.0);
        stationV.addNeighbor(stationS, 860.0);
        stationO.addNeighbor(stationZ, 900.0);
        stationT.addNeighbor(stationN, 750.0);
        stationL.addNeighbor(stationM, 580.0);
        stationL.addNeighbor(stationN, 270.0);
        stationN.addNeighbor(stationA1, 270.0);
        stationA1.addNeighbor(stationB1, 100.0);
        stationA1.addNeighbor(stationC1, 150.0);
        stationB1.addNeighbor(stationC1, 50.0);
        stationC1.addNeighbor(stationD1, 200.0);
        stationD1.addNeighbor(stationE1, 200.0);
        stationE1.addNeighbor(stationF1, 250.0);
        stationF1.addNeighbor(stationG1, 350.0);
        stationG1.addNeighbor(stationH1, 500.0);
        stationH1.addNeighbor(stationJ1, 700.0);
        stationJ1.addNeighbor(stationK1, 550.0);
        stationK1.addNeighbor(stationL1, 600.0);
        stationL1.addNeighbor(stationM1, 120.0);
        stationM1.addNeighbor(stationN1, 300.0);
        stationN1.addNeighbor(stationO1, 450.0);
        stationO1.addNeighbor(stationP1, 550.0);
        stationR1.addNeighbor(stationS1, 290.0);
        stationS1.addNeighbor(stationT1, 900.0);
        stationT1.addNeighbor(stationU1, 350.0);
        stationU1.addNeighbor(stationV1, 750.0);
        stationV1.addNeighbor(stationY1, 800.0);
        stationY1.addNeighbor(stationZ1, 900.0);
        stationZ1.addNeighbor(stationX1, 750.0);
        stationX1.addNeighbor(stationQ1, 580.0);
        stationQ1.addNeighbor(stationW1, 270.0);
        stationW1.addNeighbor(stationA2, 270.0);
        stationA2.addNeighbor(stationB2, 100.0);
        stationA2.addNeighbor(stationC2, 150.0);
        stationB2.addNeighbor(stationC2, 50.0);
        stationC2.addNeighbor(stationD2, 200.0);
        stationD2.addNeighbor(stationE2, 200.0);
        stationE2.addNeighbor(stationF2, 250.0);
        stationF2.addNeighbor(stationG2, 350.0);
        stationG2.addNeighbor(stationH2, 500.0);
        stationH2.addNeighbor(stationJ2, 700.0);
        stationJ2.addNeighbor(stationK2, 550.0);
        stationK2.addNeighbor(stationL2, 600.0);
        stationL2.addNeighbor(stationM2, 120.0);
        stationM2.addNeighbor(stationN2, 300.0);
        stationN2.addNeighbor(stationO2, 450.0);
        stationO2.addNeighbor(stationP2, 550.0);
        stationR2.addNeighbor(stationS2, 290.0);
        stationS2.addNeighbor(stationT2, 900.0);
        stationT2.addNeighbor(stationU2, 350.0);
        stationU2.addNeighbor(stationV2, 750.0);
        stationV2.addNeighbor(stationY2, 800.0);
        stationY2.addNeighbor(stationZ2, 900.0);
        stationZ2.addNeighbor(stationX2, 750.0);
        stationX2.addNeighbor(stationQ2, 580.0);
        stationQ2.addNeighbor(stationW2, 270.0);
        stationW2.addNeighbor(stationA3, 270.0);
        stationA3.addNeighbor(stationB3, 100.0);
        stationA3.addNeighbor(stationC3, 150.0);
        stationB3.addNeighbor(stationC3, 50.0);
        stationC3.addNeighbor(stationD3, 200.0);
        stationD3.addNeighbor(stationE3, 200.0);
        stationE3.addNeighbor(stationF3, 250.0);
        stationF3.addNeighbor(stationG3, 350.0);
        stationG3.addNeighbor(stationH3, 500.0);
        stationH3.addNeighbor(stationJ3, 700.0);
        stationJ3.addNeighbor(stationK3, 550.0);
        stationK3.addNeighbor(stationL3, 600.0);
        stationL3.addNeighbor(stationM3, 120.0);
        stationM3.addNeighbor(stationN3, 300.0);
        stationN3.addNeighbor(stationO3, 450.0);
        stationO3.addNeighbor(stationP3, 550.0);
        stationR3.addNeighbor(stationS3, 290.0);
        stationS3.addNeighbor(stationT3, 900.0);
        stationT3.addNeighbor(stationU3, 350.0);
        stationU3.addNeighbor(stationV3, 750.0);
        stationV3.addNeighbor(stationY3, 800.0);
        stationY3.addNeighbor(stationZ3, 900.0);
        stationZ3.addNeighbor(stationX3, 750.0);
        stationX3.addNeighbor(stationQ3, 580.0);
        stationQ3.addNeighbor(stationW3, 270.0);
        stationA4.addNeighbor(stationW3, 270.0);
        stationA4.addNeighbor(stationB4, 100.0);
        stationA4.addNeighbor(stationC4, 150.0);
        stationB4.addNeighbor(stationC4, 50.0);
        stationC4.addNeighbor(stationD4, 200.0);
        stationD4.addNeighbor(stationE4, 200.0);
        stationE4.addNeighbor(stationF4, 250.0);
        stationF4.addNeighbor(stationG4, 350.0);
        stationG4.addNeighbor(stationH4, 500.0);
        stationH4.addNeighbor(stationJ4, 700.0);
        stationJ4.addNeighbor(stationK4, 550.0);
        stationK4.addNeighbor(stationL4, 600.0);
        stationL4.addNeighbor(stationM4, 120.0);
        stationM4.addNeighbor(stationN4, 300.0);
        stationN4.addNeighbor(stationO4, 450.0);
        stationO4.addNeighbor(stationP4, 550.0);
        stationR4.addNeighbor(stationS4, 290.0);
        stationS4.addNeighbor(stationT4, 900.0);
        stationT4.addNeighbor(stationU4, 350.0);
        stationU4.addNeighbor(stationV4, 750.0);
        stationV4.addNeighbor(stationY4, 800.0);
        stationY4.addNeighbor(stationZ4, 900.0);
        stationZ4.addNeighbor(stationX4, 750.0);
        stationX4.addNeighbor(stationQ4, 580.0);
        stationQ4.addNeighbor(stationW4, 270.0);

//        //generate random route
//        List<RailwayStation> route = stationA.getRandomRoute(stationA, stationD);

        Locomotive locomotive1 = new Locomotive(30, 500F, "metal", 100.0,32, "locomotive1", stationA, stationC2);
        Locomotive locomotive2 = new Locomotive(5, 200F, "metal", 100.0,7 , "loc2", stationB2, stationT3);
        Locomotive locomotive3 = new Locomotive(7, 300F, "metal", 20.0,9, "LOC3", stationU2, stationL1);
        Locomotive locomotive4 = new Locomotive(10, 400F, "metal", 30.0,11, "LOC4", stationM3, stationB1);
        Locomotive locomotive5 = new Locomotive(20, 500F, "steel", 200.0,21, "LOC5", stationJ2, stationN1);
        Locomotive locomotive6 = new Locomotive(5, 220F, "metal", 100.0,7, "LOC6", stationL1, stationB3);
        Locomotive locomotive7 = new Locomotive(5, 600F, "metal", 70.0,7, "LOC7", stationC1, stationX);
        Locomotive locomotive8 = new Locomotive(30, 500F, "metal", 100.0,32, "LOC8", stationS1, stationZ3);
        Locomotive locomotive9 = new Locomotive(5, 200F, "metal", 100.0,9, "LOC9", stationV2, stationY1);
        Locomotive locomotive10 = new Locomotive(7, 300F, "metal", 20.0,10, "LOC10", stationB3, stationW3);
        Locomotive locomotive11 = new Locomotive(10, 400F, "metal", 30.0,11, "LOC11", stationL, stationB);
        Locomotive locomotive12 = new Locomotive(20, 500F, "steel", 200.0,21, "LOC12", stationM1, stationJ2);
        Locomotive locomotive13 = new Locomotive(5, 220F, "metal", 100.0,15, "LOC13", stationH1, stationX3);
        Locomotive locomotive14 = new Locomotive(5, 600F, "metal", 70.0,7, "LOC14", stationV1, stationQ3);
        Locomotive locomotive15 = new Locomotive(30, 500F, "metal", 100.0, 32, "LOC15", stationX, stationY);
        Locomotive locomotive16 = new Locomotive(5, 200F, "metal", 100.0, 7, "LOC16", stationL, stationX);
        Locomotive locomotive17 = new Locomotive(7, 300F, "metal", 20.0, 8, "LOC17", stationJ1, stationX1);
        Locomotive locomotive18 = new Locomotive(10, 400F, "metal", 30.0, 10, "LOC18", stationC2, stationB3);
        Locomotive locomotive19 = new Locomotive(20, 500F, "steel", 200.0,20, "LOC19", stationC3, stationB3);
        Locomotive locomotive20 = new Locomotive(5, 220F, "metal", 100.0,7, "LOC20", stationX2, stationT3);
        Locomotive locomotive21 = new Locomotive(5, 600F, "metal", 70.0,7, "LOC21", stationL, stationQ1);
        Locomotive locomotive22 = new Locomotive(30, 500F, "metal", 100.0,32, "LOC22", stationL1, stationT3);
        Locomotive locomotive23 = new Locomotive(5, 200F, "metal", 100.0,7, "LOC23", stationJ1, stationV3);
        Locomotive locomotive24 = new Locomotive(7, 300F, "metal", 20.0,8, "LOC24", stationK1, stationM1);
        Locomotive locomotive25 = new Locomotive(10, 400F, "metal", 30.0,11, "LOC25", stationV1, stationX2);

        Trainset trainset1 = new Trainset(locomotive1, 20, 300.0);
        Trainset trainset2 = new Trainset(locomotive2, 30, 600.0);
        Trainset trainset3 = new Trainset(locomotive3, 30, 500.0);
        Trainset trainset4 = new Trainset(locomotive4, 40, 500.0);
        Trainset trainset5 = new Trainset(locomotive5, 50, 400.0);
        Trainset trainset6 = new Trainset(locomotive6, 50, 400.0);
        Trainset trainset7 = new Trainset(locomotive7, 21, 400.0);
        Trainset trainset8 = new Trainset(locomotive8, 22, 300.0);
        Trainset trainset9 = new Trainset(locomotive9, 23, 200.0);
        Trainset trainset10 = new Trainset(locomotive10, 24, 500.0);
        Trainset trainset11 = new Trainset(locomotive11, 25, 1400.0);
        Trainset trainset12 = new Trainset(locomotive12, 26, 1003.0);
        Trainset trainset13 = new Trainset(locomotive13, 26, 1000.0);
        Trainset trainset14 = new Trainset(locomotive14, 21, 1300.0);
        Trainset trainset15 = new Trainset(locomotive15, 22, 200.0);
        Trainset trainset16 = new Trainset(locomotive16, 12, 100.0);
        Trainset trainset17 = new Trainset(locomotive17, 13, 800.0);
        Trainset trainset18 = new Trainset(locomotive18, 14, 200.0);
        Trainset trainset19 = new Trainset(locomotive19, 15, 300.0);
        Trainset trainset20 = new Trainset(locomotive20, 11, 100.0);
        Trainset trainset21 = new Trainset(locomotive21, 10, 600.0);
        Trainset trainset22 = new Trainset(locomotive22, 22, 500.0);
        Trainset trainset23 = new Trainset(locomotive23, 20, 400.0);
        Trainset trainset24 = new Trainset(locomotive24, 10, 300.0);
        Trainset trainset25 = new Trainset(locomotive25, 23, 200.0);


            trainset2.getLocomotive().addElectricityGrid(basicRrFreightCar3);
            trainset24.getLocomotive().addElectricityGrid(basicRrFreightCar1);
            trainset22.getLocomotive().addElectricityGrid(heavyRrFreightCar1);
            trainset22.getLocomotive().addElectricityGrid(heavyRrFreightCar1);
            trainset25.getLocomotive().addElectricityGrid(passengerRailroadCar1);
            trainset3.getLocomotive().addElectricityGrid(passengerRailroadCar1);
            trainset3.getLocomotive().addElectricityGrid(basicRrFreightCar3);
            trainset4.getLocomotive().addElectricityGrid(basicRrFreightCar1);
            trainset4.getLocomotive().addElectricityGrid(heavyRrFreightCar1);
            trainset5.getLocomotive().addElectricityGrid(heavyRrFreightCar1);
            trainset6.getLocomotive().addElectricityGrid(passengerRailroadCar1);
            trainset7.getLocomotive().addElectricityGrid(passengerRailroadCar1);
        trainset8.getLocomotive().addElectricityGrid(basicRrFreightCar3);
        trainset8.getLocomotive().addElectricityGrid(basicRrFreightCar4);
        trainset9.getLocomotive().addElectricityGrid(basicRrFreightCar1);
        trainset10.getLocomotive().addElectricityGrid(heavyRrFreightCar1);
        trainset11.getLocomotive().addElectricityGrid(heavyRrFreightCar1);
        trainset12.getLocomotive().addElectricityGrid(passengerRailroadCar1);
        trainset13.getLocomotive().addElectricityGrid(passengerRailroadCar1);
        trainset13.getLocomotive().addElectricityGrid(basicRrFreightCar3);
        trainset14.getLocomotive().addElectricityGrid(basicRrFreightCar1);
        trainset14.getLocomotive().addElectricityGrid(heavyRrFreightCar1);
        trainset15.getLocomotive().removeElectricityGrid(heavyRrFreightCar1);
        trainset16.getLocomotive().addElectricityGrid(passengerRailroadCar1);
        trainset17.getLocomotive().addElectricityGrid(passengerRailroadCar1);
        trainset18.getLocomotive().addElectricityGrid(basicRrFreightCar3);
        trainset19.getLocomotive().addElectricityGrid(basicRrFreightCar4);
        trainset20.getLocomotive().addElectricityGrid(basicRrFreightCar1);
        trainset21.getLocomotive().addElectricityGrid(heavyRrFreightCar1);
        trainset21.getLocomotive().addElectricityGrid(passengerRailroadCar1);
        trainset22.getLocomotive().addElectricityGrid(passengerRailroadCar1);
        trainset23.getLocomotive().addElectricityGrid(basicRrFreightCar3);
        trainset24.getLocomotive().addElectricityGrid(mailCar1);
        trainset24.getLocomotive().addElectricityGrid(passengerRailroadCar4);


        System.out.printf("SELECT AN OPTION\n" + "1 to display all basic information about trainset\n" + "2 to display rate of the distance completed between the starting and destination railway stations\n"
                + "3 to display  a summary of information about railroad cars, the number of people based on the goods\n" +
                "transported\n" + "4 to display rate of the distance completed between the nearest railway stations on your route\n" +
                "5 to create objects\n" + "6 to attach a railroadCar to a locomotive \n" + "7 to remove railroadCar from locomotive\n" + "Select 0 to quit\n"
        );

        Scanner sSelect = new Scanner(System.in);
        int select = sSelect.nextInt();
        if (select == 1){
            Trainset.getInfo(trainset1);
        } else if (select == 2){
            trainset1.run();
        } else if(select == 3){
            trainset1.getLocomotive().addElectricityGrid(basicRrFreightCar3);
            trainset1.getLocomotive().addElectricityGrid(basicRrFreightCar4);
            trainset1.getLocomotive().addElectricityGrid(basicRrFreightCar1);
            trainset1.getLocomotive().addElectricityGrid(heavyRrFreightCar1);
            trainset1.getLocomotive().removeElectricityGrid(heavyRrFreightCar1);
            trainset1.getLocomotive().addElectricityGrid(passengerRailroadCar1);
//            trainset1.getLocomotive().addElectricityGrid(passengerRailroadCar1);

            System.out.println(trainset1.getLocomotive().getElectricityGrid());
            System.out.println(trainset1.getLocomotive());
            System.out.printf("Total number of people based on the goods transport:%d", trainset1.getLocomotive().getTotalNumOfPeople());
        }
        else if(select == 4){
            trainset1.run2();
        }
        else if(select == 5) {
            System.out.println("Select 1 to create new locomotive\n" + "Select 2 to create new RailroadCar\n" + "Select 3 to create new Railway Station\n" +
                    "Select 4 to create new station connection\n");
            Scanner sSelect1 = new Scanner(System.in);
            int select1 = sSelect1.nextInt();
            if (select1 == 1) {
                System.out.println("Integer for electricity grid capacity:\n");
                Scanner sSelect11 = new Scanner(System.in);
                int select11 = sSelect11.nextInt();
//                locomotive.setElectricityGridCapacity(select11);
                System.out.println("Float for load weight:\n");
                Scanner sSelect12 = new Scanner(System.in);
                float select12 = sSelect12.nextFloat();
//                locomotive.setLoadWeight(select12);
                System.out.println("String for source:\n");
                Scanner sSelect13 = new Scanner(System.in);
                String select13 = sSelect13.nextLine();
//                locomotive.setSource(select13);
                System.out.println("Double for speed:\n");
                Scanner sSelect14 = new Scanner(System.in);
                double select14 = sSelect14.nextDouble();
//                locomotive.setSpeed(select14);
                System.out.println("Integer for max RailroadCar:\n");
                Scanner sSelect15 = new Scanner(System.in);
                int select15 = sSelect15.nextInt();
//                locomotive.setMaxRailroadCar(select15);
                System.out.println("String for locomotive name:\n");
                Scanner sSelect16 = new Scanner(System.in);
                String select16 = sSelect16.nextLine();
//                locomotive.setName(select16);
                System.out.println("Home station:\n");
                Scanner sSelect17 = new Scanner(System.in);
                String select17 = sSelect17.nextLine();
                RailwayStation homeStation = new RailwayStation(select17);
//                locomotive.setHomeRs(homeStation);
                System.out.println("Destination station:\n");
                Scanner sSelect18 = new Scanner(System.in);
                String select18 = sSelect18.nextLine();
                RailwayStation destStation = new RailwayStation(select18);
//                locomotive.setDestinationRs(destStation);
                Locomotive locomotive = new Locomotive(select11, select12, select13, select14, select15, select16, homeStation, destStation);
                System.out.printf("New locomotive %s is created\n", locomotive);
            } else if (select1 == 2) {
                System.out.println("Double for net weight:\n");
                Scanner sSelect19 = new Scanner(System.in);
                double select19 = sSelect19.nextDouble();
//                railroadCar.setNetWeight(select19);
                System.out.println("Double for gross weight:\n");
                Scanner sSelect199 = new Scanner(System.in);
                double select199 = sSelect199.nextDouble();
//                railroadCar.setGrossWeight(select199);
                RailroadCar railroadCar = new RailroadCar(select19, select199);
                System.out.printf("New railroadCar %s is created:\n", railroadCar);
            } else if (select1 == 3) {
                System.out.println("Railway Station name:\n");
                Scanner sSelect20 = new Scanner(System.in);
                String select20 = sSelect20.nextLine();
//                station.setName(select20);
                RailwayStation station = new RailwayStation(select20);
                System.out.printf("New station %s is created", station);
            } else if (select1 == 4) {
                System.out.println("Railway Station1 name:\n");
                Scanner sSelect21 = new Scanner(System.in);
                String select21 = sSelect21.nextLine();
//                station1.setName(select21);
                System.out.println("Railway Station2 name:\n");
                Scanner sSelect22 = new Scanner(System.in);
                String select22 = sSelect22.nextLine();
//                station2.setName(select22);
                System.out.println("Distance(double):\n");
                Scanner sSelect24 = new Scanner(System.in);
                double select24 = sSelect24.nextDouble();
                RailwayStation station1 = new RailwayStation(select21);
                RailwayStation station2 = new RailwayStation(select22);
                station1.addNeighbor(station2, select24);
                System.out.printf("Station %s and station %s connected successfully with %d distance between", station1, station2, select24);
            }
            else{
                System.out.println("The option is not valid choose a valid option!!!");
            }
        }
        else if(select == 6){
            System.out.println("1 to add basic railroad freight car\n" + "2 to add heavy freight railroad car\n" + "3 to add mailcar\n" + "4 to add passenger railroad car\n");
            Scanner sSelect6 = new Scanner(System.in);
            int select6 = sSelect6.nextInt();
            if(select6 == 1){
                System.out.println("Choose car id\n");
                Scanner sSelect61 = new Scanner(System.in);
                int select61 = sSelect61.nextInt();
                if(select61 == 1){
                trainset1.getLocomotive().addElectricityGrid(basicRrFreightCar1);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if(select61 == 2){
                    trainset1.getLocomotive().addElectricityGrid(basicRrFreightCar2);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if(select61 == 3){
                    trainset1.getLocomotive().addElectricityGrid(basicRrFreightCar3);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if(select61 == 4){
                    trainset1.getLocomotive().addElectricityGrid(basicRrFreightCar4);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if (select61 == 5) {
                    trainset1.getLocomotive().addElectricityGrid(basicRrFreightCar5);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                } else {
                    System.out.println("No such car exists");
                }
            }
            if(select6 == 2){
                System.out.println("Choose car id\n");
                Scanner sSelect62 = new Scanner(System.in);
                int select62 = sSelect62.nextInt();
                if(select62 == 1){
                    trainset1.getLocomotive().addElectricityGrid(heavyRrFreightCar1);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if(select62 == 2){
                    trainset1.getLocomotive().addElectricityGrid(heavyRrFreightCar2);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if(select62 == 3){
                    trainset1.getLocomotive().addElectricityGrid(heavyRrFreightCar3);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if(select62 == 4){
                    trainset1.getLocomotive().addElectricityGrid(heavyRrFreightCar4);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if(select62 == 5){
                    trainset1.getLocomotive().addElectricityGrid(heavyRrFreightCar5);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else{
                    System.out.println("No such car exists");
                }
            }
            if(select6 == 3){
                System.out.println("Choose car id\n");
                Scanner sSelect63 = new Scanner(System.in);
                int select63 = sSelect63.nextInt();
                if(select63 == 1){
                    trainset1.getLocomotive().addElectricityGrid(mailCar1);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if(select63 == 2){
                    trainset1.getLocomotive().addElectricityGrid(mailCar2);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if(select63 == 3){
                    trainset1.getLocomotive().addElectricityGrid(mailCar3);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if(select63 == 4){
                    trainset1.getLocomotive().addElectricityGrid(mailCar4);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if(select63 == 5){
                    trainset1.getLocomotive().addElectricityGrid(mailCar5);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else{
                    System.out.println("No such car exists");
                }
            }

            if(select6 == 4){
                System.out.println("Choose car id\n");
                Scanner sSelect64 = new Scanner(System.in);
                int select64 = sSelect64.nextInt();
                if(select64 == 1){
                    trainset1.getLocomotive().addElectricityGrid(passengerRailroadCar1);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if(select64 == 2){
                    trainset1.getLocomotive().addElectricityGrid(passengerRailroadCar2);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if(select64 == 3){
                    trainset1.getLocomotive().addElectricityGrid(passengerRailroadCar3);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if(select64 == 4){
                    trainset1.getLocomotive().addElectricityGrid(passengerRailroadCar4);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else if(select64 == 5){
                    trainset1.getLocomotive().addElectricityGrid(passengerRailroadCar5);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("Trainset is updated");
                }
                else{
                    System.out.println("No such car exists");
                }
            }
        }
        else if(select == 7 ){
            locomotive1.addElectricityGrid(basicRrFreightCar1);
            System.out.println(locomotive1);
            System.out.println("1 to remove basic railroad freight car\n" + "2 to remove heavy freight railroad car\n" + "3 to remove mailcar\n" + "4 to remove passenger railroad car\n");
            Scanner sSelect6 = new Scanner(System.in);
            int select6 = sSelect6.nextInt();
            if(select6 == 1){
                System.out.println("Choose car id\n");
                Scanner sSelect71 = new Scanner(System.in);
                int select71 = sSelect71.nextInt();
                if(select71 == 1){
                    trainset1.getLocomotive().removeElectricityGrid(basicRrFreightCar1);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select71 == 2){
                    trainset1.getLocomotive().removeElectricityGrid(basicRrFreightCar2);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select71 == 3){
                    trainset1.getLocomotive().removeElectricityGrid(basicRrFreightCar3);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select71 == 4){
                    trainset1.getLocomotive().removeElectricityGrid(basicRrFreightCar4);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select71 == 5){
                    trainset1.getLocomotive().removeElectricityGrid(basicRrFreightCar5);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else{
                    System.out.println("No such car exists");
                }
            }
            if(select6 == 2){
                System.out.println("Choose car id\n");
                Scanner sSelect72 = new Scanner(System.in);
                int select72 = sSelect72.nextInt();
                if(select72 == 1){
                    trainset1.getLocomotive().removeElectricityGrid(heavyRrFreightCar1);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select72 == 2){
                    trainset1.getLocomotive().removeElectricityGrid(heavyRrFreightCar2);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select72 == 3){
                    trainset1.getLocomotive().removeElectricityGrid(heavyRrFreightCar3);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select72 == 4){
                    trainset1.getLocomotive().removeElectricityGrid(heavyRrFreightCar4);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select72 == 5){
                    trainset1.getLocomotive().removeElectricityGrid(heavyRrFreightCar5);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else{
                    System.out.println("No such car exists");
                }
            }
            if(select6 == 3){
                System.out.println("Choose car id\n");
                Scanner sSelect73 = new Scanner(System.in);
                int select73 = sSelect73.nextInt();
                if(select73 == 1){
                    trainset1.getLocomotive().removeElectricityGrid(mailCar1);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select73 == 2){
                    trainset1.getLocomotive().removeElectricityGrid(mailCar2);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select73 == 3){
                    trainset1.getLocomotive().removeElectricityGrid(mailCar3);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select73 == 4){
                    trainset1.getLocomotive().removeElectricityGrid(mailCar4);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select73 == 5){
                    trainset1.getLocomotive().removeElectricityGrid(mailCar5);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else{
                    System.out.println("No such car exists");
                }
            }

            if(select6 == 4){
                System.out.println("Choose car id\n");
                Scanner sSelect74 = new Scanner(System.in);
                int select74 = sSelect74.nextInt();
                PassengerRailroadCar passengerRailroadCar = new PassengerRailroadCar();
                if(select74 == 1){
                    trainset1.getLocomotive().removeElectricityGrid(passengerRailroadCar1);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select74 == 2){
                    trainset1.getLocomotive().removeElectricityGrid(passengerRailroadCar2);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select74 == 3){
                    trainset1.getLocomotive().removeElectricityGrid(passengerRailroadCar3);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select74 == 4){
                    trainset1.getLocomotive().removeElectricityGrid(passengerRailroadCar4);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else if(select74 == 5){
                    trainset1.getLocomotive().removeElectricityGrid(passengerRailroadCar5);
                    System.out.println(trainset1.getLocomotive());
                    System.out.println("The trainset is updated");
                }
                else{
                    System.out.println("No such car exists");
                }
            }
        }
        else if(select == 0){
            System.exit(0);
        }
        else{
            System.out.println("The option is not valid choose a valid option!!!");
        }
        //File Writer
        List<Trainset> trainsets = new ArrayList<>();
        trainsets.add(trainset1);
        trainsets.add(trainset2);
        trainsets.add(trainset3);
        trainsets.add(trainset4);
        trainsets.add(trainset5);
        trainsets.add(trainset6);
        trainsets.add(trainset7);
        trainsets.add(trainset8);
        trainsets.add(trainset9);
        trainsets.add(trainset10);
        trainsets.add(trainset11);
        trainsets.add(trainset12);
        trainsets.add(trainset13);
        trainsets.add(trainset14);
        trainsets.add(trainset15);
        trainsets.add(trainset16);
        trainsets.add(trainset17);
        trainsets.add(trainset18);
        trainsets.add(trainset19);
        trainsets.add(trainset20);
        trainsets.add(trainset21);
        trainsets.add(trainset22);
        trainsets.add(trainset23);
        trainsets.add(trainset24);
        trainsets.add(trainset25);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @SneakyThrows
            @Override
            public void run() {
                trainsets.sort(Comparator.comparingDouble(trainset -> ((Trainset) trainset).getRouteLength()).reversed());

                StringBuilder sb = new StringBuilder();
                sb.append("List of all trainsets:\n");

                for (Trainset trainset : trainsets) {

                    List<RailroadCar> railroadCars = trainset.getLocomotive().getElectricityGrid();
                    sb.append("Railroad Cars:\n");
                    railroadCars.stream()
                            .sorted(Comparator.comparingDouble(RailroadCar::getGrossWeight))
                            .forEachOrdered(railroadCar -> {
                                sb.append(railroadCar.toString());
                                sb.append("\n");
                            });
                    sb.append("Trainset: ");
                    sb.append(trainset);
                    sb.append("\n");
                    sb.append("Locomotive: ");
                    sb.append(trainset.getLocomotive());
                    sb.append("\n");
                    sb.append("Total weight: ");
                    sb.append(trainset.getLocomotive().getWeight());
                    sb.append("\n");
                    sb.append("Route length: ");
                    sb.append(trainset.getRouteLength());
                    sb.append("\n");
                    sb.append("\n");
                }

                try {
//                    System.out.println(sb);
//                    System.out.println(sb.toString());
                    FileWriter writer = new FileWriter("/Users/arzukilic/IdeaProjects/Railway Infrastructure/src/main/java/Files/AppState.txt");
                    writer.write(sb.toString());
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.schedule(task, 0, 5000);
    }
}
