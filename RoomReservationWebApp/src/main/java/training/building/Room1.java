package training.building;

import java.io.Serializable;

public class Room1 implements Serializable {
    private String name;
    private RoomTypes roomTypes;
    private int capacity;

    public Room1(String name, RoomTypes roomTypes, int capacity) {
        this.name = name;
        this.roomTypes = roomTypes;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public RoomTypes getRoomTypes() {
        return roomTypes;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoomTypes(RoomTypes roomTypes) {
        this.roomTypes = roomTypes;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Room1() {
    }
}
