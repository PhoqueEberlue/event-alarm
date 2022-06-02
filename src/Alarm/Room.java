package Alarm;

public class Room {
    private String name;

    public String getName() {
        return this.name;
    }

    public Room(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Room " + this.name;
    }
}