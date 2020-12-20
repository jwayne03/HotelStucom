package model;

import java.util.*;

public class Room {

    private int room_id;
    private int max_size;
    private Set<String> service;

    private List<Room> rooms;

    public Room() {
        rooms = new ArrayList<>();
    }

    public Room(int room_id, int max_size, Set<String> service) {
        this.room_id = room_id;
        this.max_size = max_size;
        this.service = service;
    }

    public Room(int room_id, int max_size) {
        this.room_id = room_id;
        this.max_size = max_size;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getMax_size() {
        return max_size;
    }

    public void setMax_size(int max_size) {
        this.max_size = max_size;
    }

    public Set<String> getService() {
        return service;
    }

    public void setService(Set<String> service) {
        this.service = service;
    }

    public void addRoom(String[] data) {
        if (checkRoomId(Integer.parseInt(data[1]))) {
            System.out.println(" --> Wrong room number " + data[1] + "<--");
        }

        if (data[1].contentEquals("013") || data[1].contentEquals("113")) {
            thisRoomCantBeAdded(data);
            return;
        }

        roomAdded(data);
    }

    private void thisRoomCantBeAdded(String[] data) {
        System.out.println("ROOM " + Integer.parseInt(data[1])
                            + " " + Integer.parseInt(data[2])
                            + " " + Collections.singleton(data[3]));
        System.out.println(" --> No ROOM " + data[1] +" can be added. <-- ");
    }

    private void roomAdded(String[] data) {
        if (data.length == 4) {
            rooms.add(new Room(Integer.parseInt(data[1]), Integer.parseInt(data[2]), Collections.singleton(data[3])));
            System.out.println("ROOM " + Integer.parseInt(data[1])
                                + " " + Integer.parseInt(data[2])
                                + " " + Collections.singleton(data[3]));
            System.out.println(" --> new Room added " + data[1] + " <-- ");
        }

        if (data.length == 3) {
            rooms.add(new Room(Integer.parseInt(data[1]), Integer.parseInt(data[2])));
            System.out.println("ROOM " + Integer.parseInt(data[1]) + " " + Integer.parseInt(data[2]));
            System.out.println(" --> new Room added " + data[1] + " <-- ");
        }
    }

    private boolean checkRoomId(int data) {
        for (Room room : rooms) {
            if (room.getRoom_id() == data) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(room_id, room.room_id) && Objects.equals(service, room.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room_id, service);
    }

    @Override
    public String toString() {
        return "Room: " + "customer_id: " + room_id + " max_size: " + max_size + " service: " + service;
    }
}
