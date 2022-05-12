package gui;
import Sensors.Sensor;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.util.ArrayList;

public class MainWindow {
    protected JFrame frame;
    private JTabbedPane tabbedPane;
    private TabMonitor tabMonitor;
    private TabAlarm tabAlarm;
    public MainWindow(){
        createMainWindow();
    }
    private void createMainWindow(){
        frame = new JFrame("Alarm tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setMinimumSize(new Dimension(400,400));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        tabbedPane = new JTabbedPane();
        createTabMonitor(tabbedPane);
        createTabAlarm(tabbedPane);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    private void createTabAlarm(JTabbedPane tabbedPane){
        tabAlarm = new TabAlarm(tabbedPane);
    }

    private void addAllMonitorCells(ArrayList<Sensor> sensorArray){
        for(Sensor s : sensorArray){

        }
    }

    private void createTabMonitor(JTabbedPane tabbedPane){
        tabMonitor = new TabMonitor(tabbedPane, frame);
    }
}