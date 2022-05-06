package Sensors;

import Alarm.Room;
import Listeners.Listener;
import java.util.List;

public abstract class Sensor {
    protected List<Listener> ListListener;
    protected String name;
    protected Room room;
    protected int valMax;
    protected int valMin;
    protected String unit;
}