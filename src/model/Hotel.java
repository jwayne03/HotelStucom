package model;

import exception.MyException;

import java.util.*;

public class Hotel {

    private int customer_id;
    private int capacity;
    private String services;

    private Room room;
    private List<Hotel> hotels;

    public Hotel() {
        hotels = new ArrayList<>();
        room = new Room();
    }

    public Hotel(int customer_id, int capacity, String services) {
        this.customer_id = customer_id;
        this.capacity = capacity;
        this.services = services;
    }

    public Hotel(int customer_id, int capacity) {
        this.customer_id = customer_id;
        this.capacity = capacity;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getServices() {
        return services;
    }

    public void reservation(Room room, String[] data, List<Room> rooms) throws MyException {
        if (data.length == 3) noRoomPreferences(room, data, rooms);
        if (data.length == 4) roomPreferences(room, data, rooms);
    }

    private void roomPreferences(Room room, String[] data, List<Room> rooms) throws MyException {
        if (data[1].length() != 8) throw new MyException(MyException.WRONG_IDENTIFIER_FOR_RESERVATION);

        if (data[1].matches("^[0-9]{8}")) {
            addReservation(data, rooms);
        } else {
            throw new MyException(MyException.WRONG_IDENTIFIER_FOR_RESERVATION);
        }
    }

    private void addReservation(String[] data, List<Room> rooms) throws MyException {
        searchRoom(data, rooms);
        hotels.add(new Hotel(Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3]));
        System.out.println(data[0] + " " + data[1] + " " + data[2] + " " + data[3]);
        assigned(data, rooms);

    }

    private void assigned(String[] data, List<Room> rooms) throws MyException {
        for (Room room: rooms) {
            if (Integer.parseInt(data[2]) == room.getMax_size()) {
                System.out.println("--> Assigned " + data[1] + " to Room " + room.getRoom_id() + " <--");
                return;
            } else {
                throw new MyException(MyException.CUSTOMER_NOT_ASIGNED);
            }
        }
    }

    private int searchRoom(String[] data, List<Room> rooms) throws MyException {
        for (Room room : rooms) {
            if (Integer.parseInt(data[2]) == room.getMax_size()) {
                return room.getRoom_id();
            }
        }
        throw new MyException(MyException.CUSTOMER_NOT_ASIGNED);
    }

    private void noRoomPreferences(Room room, String[] data, List<Room> rooms) {
        hotels.add(new Hotel(Integer.parseInt(data[1]), Integer.parseInt(data[2])));
        System.out.println(data[0] + " " + data[1] + " " + data[2]);
    }
}
