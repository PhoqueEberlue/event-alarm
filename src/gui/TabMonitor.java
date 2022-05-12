package gui;
import Sensors.Sensor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TabMonitor{
    private ArrayList<JButton> sensorList;
    private JTabbedPane tabbedPane;
    private JPanel panel;
    public TabMonitor(JTabbedPane tabbedPane, JFrame frame){
        panel = new JPanel(false);
        tabbedPane.addTab("monitor", null, panel,"POGGERS");
        panel.setLayout(new GridLayout(getSize(frame).height / 100, getSize(frame).width / 100));
    }

    private Rectangle getSize(JFrame frame){
        return frame.getBounds();
    }

    public void addCell(Sensor s){
        JButton b = new JButton(s.getName());
        sensorList.add(b);
        panel.add(b);
    }

    public void refresh(JFrame frame){
        SwingUtilities.updateComponentTreeUI(frame);
    }
}