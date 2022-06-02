package gui;

import Alarm.EventAlarm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class TabAlarmMonitor {
    private JPanel panel;
    private MainWindow mainWindow;
    private static DetailsButton detailsButton;
    private static TabMonitor tabMon;

    public TabAlarmMonitor(JTabbedPane tabbedPane, MainWindow mainWindow){
        this.mainWindow = mainWindow;
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(3,2));
        tabbedPane.addTab("Alarm Monitor", null, panel,"pepeMeltdown");
    }

    public void addAlarmEvent(EventAlarm alarmEvent){
        JLabel text = new JLabel(alarmEvent.toString());
        JPanel container = new JPanel();
        JButton btn = new JButton("details");
        container.add(text);
        container.add(btn);
        this.panel.add(container);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//when click new print in window details
                detailsButton = new DetailsButton(alarmEvent, panel, container, tabMon);
            }
        });
    }

    public static void setTabMon(TabMonitor tabMon) {
        TabAlarmMonitor.tabMon = tabMon;
    }
}