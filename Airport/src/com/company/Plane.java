package com.company;

import java.io.Serializable;

public class Plane implements Serializable
{
    private static final long serialVersionUID = 1L;
    private final String arrivalTime;
    private final String departureTime;
    private final int flightNumber;
    private PlaneStatus status;

    public Plane(String arrivalTime, String departureTime, int flightNumber, PlaneStatus status) {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.flightNumber = flightNumber;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "arrivalTime='" + arrivalTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", flightNumber=" + flightNumber +
                ", status=" + status +
                '}';
    }

    public String getPlaneArrivalTime() {
        return arrivalTime;
    }

    public String getPlaneDepartureTime() {
        return departureTime;
    }

    public int getPlaneFlightNumber() {
        return flightNumber;
    }

    public PlaneStatus getPlaneStatus() {
        return status;
    }

    public void setStatus(PlaneStatus status) {
        this.status = status;
    }

    public Plane sendRequest() {
        return this;
    }

}
