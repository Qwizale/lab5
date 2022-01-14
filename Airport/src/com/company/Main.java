package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //генератор самолетов
        // int planeCount = (int)(Math.random() * 100); // не болле 100 самолетов
        ArrayList<Plane> planes = new ArrayList<>();
        PlaneGenerator planeGenerator = new PlaneGenerator();
        Airport airport = new Airport();
        Dispatcher dispatcher = new Dispatcher(airport);
        Tableau tableau = new Tableau();

        Scanner in = new Scanner(System.in);
        int menu = 188;
        int i = -1;
        while (menu != 1488) {
            System.out.println("============================");
            System.out.println("choice option:");
            System.out.println("1. Generate plane");
            System.out.println("2. Show info");
            System.out.println("3. request");
            System.out.println("4. save");
            System.out.println("5. load");
            System.out.println("============================");
            menu = in.nextInt();
            switch (menu) {
                case 0:
                    return;
                case 1:
                    i++;
                    planes.add(planeGenerator.generateOnePlane());

                    break;
                case 2:
                    System.out.println(planes.get(i).getPlaneStatus());
                    System.out.println(planes.get(i).getPlaneFlightNumber());
                    System.out.println(planes.get(i).getPlaneDepartureTime());
                    System.out.println(planes.get(i).getPlaneArrivalTime());
                    break;
                case 3:
                    dispatcher.processPlane(planes.get(i).sendRequest());
                    break;
                case 4:
                    save(planes);
                    break;
                case 5:
                    load();
                    break;

                default:
                    System.out.println("Incorrect");
            }


        }

    }

    private static void save(ArrayList<Plane> planes) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("data.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        try(objectOutputStream) {
            objectOutputStream.writeObject(planes);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void load() throws IOException {
        ArrayList<Plane> planes = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"))){
            planes = (ArrayList<Plane>) ois.readObject();

            for (int i = 0; i < planes.size(); i++) {
                System.out.println(planes.get(i).toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
