package Sensors;

import Alarm.Room;

public class GasSensor extends Sensor {

    //----------CONSTRUCTORS----------
    public GasSensor(String name, Room room, int valMax, int valMin){
        this.unit = "ppm";
        this.name = name;
        this.room = room;
        this.valMax = valMax;
        this.valMin = valMin;
    }

    public GasSensor(String name, Room room){
        this.unit = "ppm";
        this.name = name;
        this.room = room;
        this.valMax = 1000;
        this.valMin = 0;
    }

    //----------TO STRING----------
    @Override
    public java.lang.String toString() {
        return "Sensors.Sensors.GasSensor{}";
    }
    //----------GETTER----------
    public Room getRoom(){
        return this.room;
    }

    public String getUnit(){
        return this.unit;
    }

    public int getValMax(){
        return this.valMax;
    }
    public int getValMin(){
        return this.valMin;
    }
    public String getName(){
        return this.name;
    }
}