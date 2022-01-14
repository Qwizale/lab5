package com.company;

public class PlaneGenerator {
    public Plane[] planeGenerator(Plane[] planes) {
        for (int i = 0; i < planes.length ; i++) {
            int depHours = (int)(Math.random() * 24); // генератор времени отправления
            int depMinutes = (int)(Math.random() * 60);
            String departureTime = depHours + ":" + depMinutes;
            if (depMinutes < 10)
                departureTime = depHours + ":0" + depMinutes;
            int hoursInFlight = (int)(Math.random() * 19); // генерация часов в полете
            int minutesInFlight = (int)(Math.random() * 60); // генерация минут в полете
            int arrHours = (depHours+hoursInFlight); //генерация времени прибытия
            int arrMinutes = (depMinutes+minutesInFlight);
            if (arrHours > 23)
                arrHours -= 24;
            if (arrMinutes > 59)
                arrMinutes -= 60;
            String arrivalTime = arrHours + ":" + arrMinutes;
            if (arrMinutes < 10) //время будет отображаться в корректном формате
                arrivalTime = arrHours + ":0" + arrMinutes;
            int flightNumber = (int)(Math.random() * 1000);
            int temp = (int)(Math.random() * 2); // генерация состояния самолета, ожидает посадки или ожидает вылета
            PlaneStatus status;
            if (temp == 1)
                status = PlaneStatus.ON_LAND;
            else
                status = PlaneStatus.ON_FLIGHT;
            planes[i] = new Plane(arrivalTime, departureTime, flightNumber, status );

        }
        return planes;
    }
    public Plane generateOnePlane() {
        int depHours = (int)(Math.random() * 24); // генератор времени отправления
        int depMinutes = (int)(Math.random() * 60);
        String departureTime = depHours + ":" + depMinutes;
        if (depMinutes < 10)
            departureTime = depHours + ":0" + depMinutes;
        int hoursInFlight = (int)(Math.random() * 19); // генерация часов в полете
        int minutesInFlight = (int)(Math.random() * 60); // генерация минут в полете
        int arrHours = (depHours+hoursInFlight); //генерация времени прибытия
        int arrMinutes = (depMinutes+minutesInFlight);
        if (arrHours > 23)
            arrHours -= 24;
        if (arrMinutes > 59)
            arrMinutes -= 60;
        String arrivalTime = arrHours + ":" + arrMinutes;
        if (arrMinutes < 10) //время будет отображаться в корректном формате
            arrivalTime = arrHours + ":0" + arrMinutes;
        int flightNumber = (int)(Math.random() * 1000);
        int temp = (int)(Math.random() * 2); // генерация состояния самолета, ожидает посадки или ожидает вылета
        PlaneStatus status;
        if (temp == 1)
            status = PlaneStatus.ON_LAND;
        else
            status = PlaneStatus.ON_FLIGHT;
        Plane plane = new Plane(arrivalTime, departureTime, flightNumber, status );
        return plane;
    }
}
