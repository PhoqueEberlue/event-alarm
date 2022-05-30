package gui;

import Alarm.EventAlarm;
import Listeners.Listener;
import Listeners.MonitorA;
import Listeners.MonitorB;
import Sensors.Sensor;
import Sensors.SensorNotCompatibleException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TabAlarmMonitor implements Listener {
    private ArrayList<Sensor> sensorList;//needed ?
    private ArrayList<EventAlarm> alarmList;
    private JPanel panel;
    private JPanel newAlarms;
    private MainWindow mainWindow;

    public TabAlarmMonitor(JTabbedPane tabbedPane, MainWindow mainWindow){
        this.mainWindow = mainWindow;
        this.sensorList = new ArrayList<>();
        this.alarmList = new ArrayList<>();
        this.panel = new JPanel();
        this.newAlarms = new JPanel();
        this.panel.setLayout(new GridLayout(1,2));
        this.panel.add(newAlarms);
        tabbedPane.addTab("Alarm Monitor", null, panel,"pepeMeltdown");
    }

    @Override
    public void Listen(EventAlarm alarmEvent){//why caps for a func name ? cant make own ? not implementing fancy listen
        alarmList.add(alarmEvent);
        JDialog dialog = new JDialog();
        JLabel text = new JLabel(alarmEvent.toString());
        JButton btn = new JButton("details");
        dialog.add(text);
        dialog.add(btn);
        dialog.setVisible(true);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//when click new print in window details

            }
        });
    }
}