package Sensors;

import Alarm.EventAlarm;
import Alarm.Room;
import Listeners.Listener;

import java.util.ArrayList;
import java.util.List;

public abstract class Sensor {
    public Sensor() {
        this.listListener = new ArrayList<>();
    }

    public void addListener(Listener listener) throws SensorNotCompatibleException {
        this.listListener.add(listener);
    }

    public void removeListener(Listener listener) {
        this.listListener.remove(listener);
    }


    public void launchAlert(EventAlarm eventAlarm) {
        for (Listener listener :
                this.listListener) {
            listener.Listen(eventAlarm);
        }
    }

    protected List<Listener> listListener;
    protected String name;
    protected Room room;
    protected int valMax;
    protected int valMin;


    protected int val;
    protected String unit;

    public List<Listener> getListListener() {
        return listListener;
    }

    public void setListListener(List<Listener> listListener) {
        this.listListener = listListener;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getValMax() {
        return valMax;
    }

    public void setValMax(int valMax) {
        this.valMax = valMax;
    }

    public int getValMin() {
        return valMin;
    }

    public void setValMin(int valMin) {
        this.valMin = valMin;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "listListener=" + listListener +
                ", name='" + name + '\'' +
                ", room=" + room +
                ", valMax=" + valMax +
                ", valMin=" + valMin +
                ", unit='" + unit + '\'' +
                '}';
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}