package gui;
import Sensors.Sensor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TabMonitor{
    private ArrayList<JPanel> sensorList;
    private ArrayList<CellMonitor> cellList;
    private JTabbedPane tabbedPane;
    private JPanel panel;
    public TabMonitor(JTabbedPane tabbedPane){
        this.sensorList = new ArrayList<>();
        this.cellList = new ArrayList<>();
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(3,3));
        tabbedPane.addTab("monitor", null, panel,"POGGERS");
    }

    private Rectangle getSize(JFrame frame){
        return frame.getBounds();
    }

    public void addCell(Sensor s){
        this.cellList.add(new CellMonitor(s, this.panel));
    }

    //private void refresh(){
    //    for(CellMonitor c : this.cellList){
    //        c.update();
    //    }
    //}
}