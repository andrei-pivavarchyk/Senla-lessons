package Utility;

import Domain.Entities.Room;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EntityReader {
    public static ArrayList<Room> readRoomsFromFile() {
        try {
            File f = new File("J:\\Rooms.txt");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            System.out.println("Reading file using Buffered Reader");

            ArrayList<Room> rooms = new ArrayList<>();
            while ((readLine = b.readLine()) != null) {
                String[] str = readLine.split("\\|");
                int number = Integer.parseInt(str[0]);
                int cost = Integer.parseInt(str[1]);
                int capacity = Integer.parseInt(str[2]);
                int stars = Integer.parseInt(str[3]);
                Room room = new Room(number, cost, capacity, stars, 2);
                rooms.add(room);
            }

            return rooms;
        } catch (IOException ex) {
            return null;
        }
    }
}
