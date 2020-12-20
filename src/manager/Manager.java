package manager;

import exception.MyException;
import model.Room;

import java.io.*;

public class Manager implements Runnable {

    private static Manager manager;
    private Room room;
    private final String INPUT_FILE = "LoadHotel.txt";

    public Manager() {
        room = new Room();
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
                System.out.println("RESERVATION");
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
