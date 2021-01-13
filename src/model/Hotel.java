package model;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Hotel {

    private int customer_id;
    private int capacity;
    private String services;

    private Room room;
    private List<Hotel> hotels;

    public Hotel() {

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

    public int getCustomer_id() {
        return customer_id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getServices() {
        return services;
    }

    public void reservation(String[] data) {
//        if (data.length == 3)
//            noRoomPreferences(data);
//        if (data.length == 4)
//            roomPreferences(data);
    }

//    private void roomPreferences(String[] data) {
//        hotels.add(new Hotel(Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3]));
//
//        System.out.println(data[0] + " " + data[1] + " " + data[2] + " " + data[3]);
//    }

//    private void noRoomPreferences(String[] data) {
//        hotels.add(new Hotel(Integer.parseInt(data[1]), Integer.parseInt(data[2])));
//        System.out.println(data[0] + " " + data[1] + " " + data[2]);
//    }
}
