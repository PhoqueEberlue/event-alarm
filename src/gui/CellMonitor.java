package gui;
import Sensors.Sensor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CellMonitor {
    private JLabel name;
    private JLabel value;
    private JLabel roomName;
    private JPanel panel;
    private Sensor sensor;

    public CellMonitor(Sensor s, JPanel parentPanel){
        this.sensor = s;
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(100,100));
        this.name = new JLabel(s.getName());
        this.value = new JLabel(String.valueOf(s.getVal()));
        this.roomName = new JLabel(s.getRoom().toString());
        this.panel.add(this.name);
        this.panel.add(this.value);
        this.panel.add(this.roomName);
        parentPanel.add(panel);
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

    public void update(){
        this.value.setText(String.valueOf(this.sensor.getVal()));
        this.name.setText(this.sensor.getName());
    }
}
