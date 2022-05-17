package gui;
import Sensors.FireSensor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TabAlarm{
    private JTabbedPane tabbedPane;
    private JPanel panel;
    private MainWindow mainWindow;

    private JTextField dateTextField;
    private JTextField priorityLevelTextField;
    private JButton fireSubmitButton;


    public TabAlarm(JTabbedPane tabbedPane, MainWindow mainWindow){
        this.mainWindow = mainWindow;
        this.panel = new JPanel(false);
        this.panel.setLayout(new GridLayout(1,3));
        tabbedPane.addTab("Alarm", null, panel,"monkaS");


        this.createFireForm();

    }

    private void createFireForm(){
        JPanel jPanel = new JPanel();
        this.dateTextField = new JTextField();
        this.dateTextField.setPreferredSize(new Dimension(150, 30));

        this.priorityLevelTextField = new JTextField();
        this.priorityLevelTextField.setPreferredSize(new Dimension(150, 30));

        this.fireSubmitButton = new JButton("Submit fire Alarm");
        this.fireSubmitButton.setPreferredSize(new Dimension(400, 400));

        String[] listFireSensor = new String[this.mainWindow.getRoom().getNb_sensors()];
        int i = 0;
        for (FireSensor fireSensor: this.mainWindow.getRoom().getFireSensorList()
             ) {
            listFireSensor[i] = fireSensor.getName();
            i++;
        }

        JComboBox<String> jComboBox = new JComboBox<>(listFireSensor);

        jPanel.add(this.dateTextField);
        jPanel.add(this.priorityLevelTextField);
        jPanel.add(jComboBox);
        jPanel.add(fireSubmitButton);

        this.panel.add(jPanel);

        this.fireSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



}
