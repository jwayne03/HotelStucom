package model;

import exception.MyException;

import java.util.HashSet;
import java.util.Set;

public class Room {

    private String customer_id;
    private int max_size;
    private Set<String> service;

    public Room() {

    }

    public Room(String customer_id, int max_size) {
        this.customer_id = customer_id;
        this.max_size = max_size;
        this.service = new HashSet<>();
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
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

    public void addRoom(String[] data) throws MyException {
        if (data.length != 4) throw new MyException(MyException.ROOM_WITHOUT_SERVICE);



    }

    @Override
    public String toString() {
        return "Room{" +
                "customer_id='" + customer_id + '\'' +
                ", max_size=" + max_size +
                ", service=" + service +
                '}';
    }
}
