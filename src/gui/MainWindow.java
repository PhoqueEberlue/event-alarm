package gui;
import Alarm.Room;
import Sensors.Sensor;
import Tests.MakeRoomTests;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.util.ArrayList;

public class MainWindow {
    protected JFrame frame;

    public TabMonitor getTabMonitor() {
        return tabMonitor;
    }

    public TabAlarm getTabAlarm() {
        return tabAlarm;
    }

    public TabAlarmMonitor getTabAlarmMonitor() {
        return tabAlarmMonitor;
    }

    private JTabbedPane tabbedPane;
    private TabMonitor tabMonitor;
    private TabAlarm tabAlarm;
    private TabAlarmMonitor tabAlarmMonitor;
    private MakeRoomTests room;

    public MainWindow(MakeRoomTests r){
        this.room = r;
        this.frame = new JFrame("Alarm tester");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(600, 600);
        this.frame.setMinimumSize(new Dimension(400,400));
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.tabbedPane = new JTabbedPane();
        this.createTabAlarm();
        this.createTabAlarmMonitor();
        this.createTabMonitor();
        this.addAllMonitorCells();
        this.frame.getContentPane().add(this.tabbedPane, BorderLayout.CENTER);
    }

    private void createTabAlarm(){
        this.tabAlarm = new TabAlarm(this.tabbedPane, this);
    }

    private void addAllMonitorCells(){
        for(Sensor s : this.room.getGasSensorList()){
            this.tabMonitor.addCell(s);
        }
        for(Sensor s : this.room.getFireSensorList()){
            this.tabMonitor.addCell(s);
        }
        for(Sensor s : this.room.getRadiationSensorsList()){
            this.tabMonitor.addCell(s);
        }
    }

    private void createTabMonitor(){
        this.tabMonitor = new TabMonitor(this.tabbedPane);
    }
    
    private void createTabAlarmMonitor() {
        this.tabAlarmMonitor = new TabAlarmMonitor(this.tabbedPane, this);
    }

    public MakeRoomTests getRoom() {
        return this.room;
    }

    public Sensor findRadiationSensor(String name){
        for(Sensor s : this.room.getRadiationSensorsList()){
            if(s.getName() == name)
                return s;
        }
        return null;
    }

    public Sensor findFireSensor(String name){
        for(Sensor s : this.room.getFireSensorList()){
            if(s.getName() == name)
                return s;
        }
        return null;
    }
}