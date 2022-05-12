package Sensors;

import Alarm.Room;
import Listeners.Listener;
import Listeners.MonitorA;
import Listeners.MonitorB;

public class RadiationSensor extends Sensor {

    //----------CONSTRUCTORS----------
    public RadiationSensor(String name, Room room, int valMax, int valMin){
        this.unit = "Becquerel";
        this.name = name;
        this.room = room;
        this.valMax = valMax;
        this.valMin = valMin;
    }

    public RadiationSensor(String name, Room room){
        this.unit = "Becquerel";
        this.name = name;
        this.room = room;
        this.valMax = 1000;
        this.valMin = 0;
    }

    //----------TO STRING----------
    @Override
    public java.lang.String toString() {
        return "RadiationSensor{}";
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

    //----------SETTER----------
    @Override
    public void addListener(Listener listener) throws SensorNotCompatibleException {
        if (listener instanceof MonitorB) {
            this.listListener.add(listener);
        } else {
            throw new SensorNotCompatibleException(listener.getClass() + " class is not supported by " + this.getClass());
        }
    }
}