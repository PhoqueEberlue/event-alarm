package gui;
import Alarm.EventAlarm;
import Alarm.FireAlarm;
import Alarm.GasAlarm;
import Alarm.RadiationAlarm;
import Listeners.Listener;
import Sensors.FireSensor;
import Sensors.GasSensor;
import Sensors.RadiationSensor;
import Sensors.Sensor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CellMonitor implements Listener {
    private JLabel name;
    private JLabel value;
    private JLabel roomName;
    private JPanel panel;
    private Sensor sensor;
    private JLabel prioLvl;
    private static TabMonitor tabMon;

    public CellMonitor(Sensor s, JPanel parentPanel){
        this.sensor = s;
        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(100,100));
        this.name = new JLabel(s.getName());
        this.value = new JLabel(String.valueOf(s.getVal()));
        this.roomName = new JLabel(s.getRoom().toString());
        this.prioLvl = new JLabel("Priority : 0");
        this.panel.add(this.name);
        //this.panel.add(this.value); dont care, never updated, we'll look the priolvl instead
        this.panel.add(this.roomName);
        this.panel.add(this.prioLvl);
        parentPanel.add(panel);
    }

    public void setTabMon(TabMonitor tabMon) {
        CellMonitor.tabMon = tabMon;
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

    private void update(EventAlarm e){
        //this.value.setText(String.valueOf(this.sensor.getVal()));
        this.name.setText(this.sensor.getName());
        this.prioLvl.setText("Priority : " + Integer.toString(e.getPriorityLevel()));
        this.panel.repaint();
    }

    @Override
    public void Listen(EventAlarm e) {
        if(e instanceof GasAlarm && this.sensor instanceof GasSensor &&
                e.getLocalisation() == this.sensor.getRoom()){
            this.update(e);
        }
        else if(e instanceof FireAlarm && this.sensor instanceof FireSensor &&
                e.getLocalisation() == this.sensor.getRoom()){
            this.update(e);
        }
        else if(e instanceof RadiationAlarm && this.sensor instanceof RadiationSensor &&
                e.getLocalisation() == this.sensor.getRoom()){
            this.update(e);
        }
    }
}