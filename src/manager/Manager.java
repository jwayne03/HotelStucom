package manager;

import exception.MyException;
import model.Hotel;
import model.Room;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;

public class Manager implements Runnable {

    private static Manager manager;
    private Room room;
    private Hotel hotel;
    private final String INPUT_FILE = "LoadHotel.txt";

    public Manager() {
        room = new Room();
        hotel = new Hotel();
    }

    public static Manager getInstance() {
        if (manager == null) manager = new Manager();
        return manager;
    }

    @Override
    public void run() {
        boolean exit = false;
        try {
            File file = new File(INPUT_FILE);
            if (!file.exists()) fileNotFound();
            BufferedReader read = new BufferedReader(new FileReader(file));
            String line;

            while ((line = read.readLine()) != null && (!exit)) {
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
        switch (data[0].toUpperCase()) {
            case "ROOM":
                room.addRoom(data);
                break;
            case "RESERVATION":
                hotel.reservation(data);
                break;
            case "HOTEL":
                System.out.println("HOTEL");
                break;
            default:
                checkRoomParameter(data);
                throw new MyException(MyException.WRONG_PARAMETER);
        }
    }

    private void checkRoomParameter(String[] data) throws MyException {
        if (!data[0].equalsIgnoreCase("room")) {
            System.out.println(data[0] + " " + Integer.parseInt(data[1])
                    + " " + Integer.parseInt(data[2])
                    + " " + Collections.singleton(data[3]));
            throw new MyException(MyException.WRONG_PARAMETER);
        }
    }

    private void fileNotFound() throws MyException {
        throw new MyException(MyException.FILE_NOT_FOUND);
    }
}
