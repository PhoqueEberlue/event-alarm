package gui;

import Alarm.EventAlarm;
import Listeners.Listener;
import Listeners.MonitorA;
import Listeners.MonitorB;
import Sensors.Sensor;
import Sensors.SensorNotCompatibleException;
import jdk.nashorn.internal.scripts.JD;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TabAlarmMonitor implements Listener {
    private ArrayList<Sensor> sensorList;
    private ArrayList<EventAlarm> alarmList;
    private JPanel panel;
    private JPanel newAlarms;

    public TabAlarmMonitor(JTabbedPane tabbedPane){
        this.sensorList = new ArrayList<>();
        this.alarmList = new ArrayList<>();
        this.panel = new JPanel();
        this.newAlarms = new JPanel();
        this.panel.setLayout(new GridLayout(1,2));
        this.panel.add(newAlarms);
        tabbedPane.addTab("Alarm Monitor", null, panel,"peepoMeltdown");
    }

    @Override
    public void Listen(EventAlarm alarmEvent){
        alarmList.add(alarmEvent);
        JDialog dialog = new JDialog();
        JLabel text = new JLabel(alarmEvent.toString());
        JButton btn = new JButton("details");
        dialog.add(text);
        dialog.add(btn);
    }
}