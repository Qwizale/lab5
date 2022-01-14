package com.company;

public class Tableau {
    public static void printToTableau(Plane plane, String answer) {
        System.out.println("_________________________________");
        System.out.println(plane.getPlaneDepartureTime());
        System.out.println(plane.getPlaneArrivalTime());
        System.out.println(plane.getPlaneStatus());
        System.out.println(answer);
    }
}
