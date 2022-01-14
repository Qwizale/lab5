package com.company;

public class Dispatcher {
    private final Airport airport;

    public Dispatcher(Airport airport) {
        this.airport = airport;
    }


    public void processPlane(Plane plane) { //распределитель по полосам
        String answer = "all runways are busy";
        int freeRunway = airport.getFreeRunwayIndex();
        if (freeRunway == -1) {
            Tableau.printToTableau(plane, answer);
            return;
        }
        airport.takeRunway(freeRunway);
        if (plane.getPlaneStatus() == PlaneStatus.ON_FLIGHT)
            answer = "Flight number: " + plane.getPlaneFlightNumber() + " Landing runway " + freeRunway;
        if (plane.getPlaneStatus() == PlaneStatus.ON_LAND)
            answer = "Flight number: " + plane.getPlaneFlightNumber() + " Take off runway " + freeRunway;

        Tableau.printToTableau(plane, answer);
    }
}


