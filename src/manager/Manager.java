package manager;

import exception.MyException;
import model.Hotel;
import model.Room;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Manager {

    private static Manager manager;
    private Room room;
    private Hotel hotel;
    private List<Room> rooms;
    private List<Hotel> hotels;
    private final String INPUT_FILE = "LoadHotel.txt";

    public Manager() {
        room = new Room();
        hotel = new Hotel();
    }

    public static Manager getInstance() {
        if (manager == null) manager = new Manager();
        return manager;
    }

    public void run() {
        boolean exit = false;
        try {
            File file = new File(INPUT_FILE);
            if (!file.exists()) fileNotFound();
            BufferedReader read = new BufferedReader(new FileReader(file));
            String line;

            while ((line = read.readLine()) != null && (!exit)) {
                System.out.println(line);
                if (line.isEmpty()) throw new MyException(MyException.WRONG_PARAMETER);
                try {
                    String[] data = line.split(" ");
                    dataManager(data);
                } catch (MyException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (MyException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void dataManager(String[] data) throws MyException {
        rooms = room.getRooms();
        switch (data[0].toUpperCase()) {
            case "ROOM":
                room.addRoom(data);
                break;
            case "RESERVATION":
                hotel.reservation(room, data, rooms);
                break;
            case "HOTEL":
                System.out.println("HOTEL");
                break;
            default:
                throw new MyException(MyException.WRONG_PARAMETER);
        }
    }

    private void fileNotFound() throws MyException {
        throw new MyException(MyException.FILE_NOT_FOUND);
    }
}
