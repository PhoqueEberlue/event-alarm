package gui;
import Sensors.Sensor;

public class CellMonitor {
    private Sensor sensor;
    public CellMonitor(Sensor s){
        this.sensor = s;
    }

    public boolean getState(){
        return (this.sensor.getVal() > sensor.getValMin()) &&
                (sensor.getVal() < sensor.getValMax());
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
