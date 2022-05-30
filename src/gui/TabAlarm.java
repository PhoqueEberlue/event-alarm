package gui;
import Alarm.EventAlarm;
import Alarm.FireAlarm;
import Listeners.MonitorA;
import Sensors.FireSensor;
import Sensors.GasSensor;
import Sensors.RadiationSensor;
import Sensors.Sensor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

public class TabAlarm{
    private JTabbedPane tabbedPane;
    private JPanel panel;
    private MainWindow mainWindow;

    private JTextField dateTextField;
    private JTextField priorityLevelTextField;
    private JButton submitButton;
    private JButton chooseAlarmType;


    public TabAlarm(JTabbedPane tabbedPane, MainWindow mainWindow){
        this.mainWindow = mainWindow;
        this.panel = new JPanel(false);
        this.panel.setLayout(new GridLayout(1,3));
        tabbedPane.addTab("Alarm", null, panel,"monkaS");
        this.handleTypeAlarm();
    }

    private void handleTypeAlarm(){ //first pane, asking for the type of alarm to trigger
                                    //It is ugly to do this by checking strings, but how it was described in the
                                    //assignment
        //TODO : comboBox ?
        JPanel jPanel = new JPanel();//not needed, but makes it handy to remove
        JTextField typeField = new JTextField("What kind of alarm do you want to trigger ?");
        typeField.setPreferredSize(new Dimension(150, 30));
        JButton button = new JButton("submit");
        jPanel.add(button);
        jPanel.add(typeField);

        this.panel.add(jPanel);//add handy panel to actual panel

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//on click check what was input
                System.out.println(typeField.getText());
                if(typeField.getText().equalsIgnoreCase("fire")){//NOTE cant use this here dont blame me
                    System.out.println("fire");
                    panel.remove(jPanel);
                    createFireForm();//go to form
                }
                else if(typeField.getText().toLowerCase().equals("gas")) {
                    panel.remove(jPanel);
                    createGasForm();//go to form
                }
                else if(typeField.getText().toLowerCase().equals("radiation")) {
                    panel.remove(jPanel);
                    createRadiationForm();//go to form
                }
            }
        });
    }

    private void createFireForm(){
        JPanel jPanel = new JPanel();//handy panel
        this.dateTextField = new JTextField();
        this.dateTextField.setPreferredSize(new Dimension(150, 30));

        this.priorityLevelTextField = new JTextField();
        this.priorityLevelTextField.setPreferredSize(new Dimension(150, 30));

        this.submitButton = new JButton("Submit fire Alarm");
        this.submitButton.setPreferredSize(new Dimension(150, 30));

        String[] listFireSensor = new String[this.mainWindow.getRoom().getNb_sensors()];

        int i = 0;

        for (FireSensor fireSensor: this.mainWindow.getRoom().getFireSensorList()) {//for combo box
            listFireSensor[i] = fireSensor.getName();
            i++;
        }

        JComboBox<String> jComboBoxFire = new JComboBox<>(listFireSensor);

        jPanel.add(this.dateTextField);
        jPanel.add(this.priorityLevelTextField);
        jPanel.add(jComboBoxFire);
        jPanel.add(this.submitButton);

        this.panel.add(jPanel);//adding handy to main panel

        this.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String sensorName = (String) jComboBoxFire.getSelectedItem();//casting from obj
                Sensor sensor = mainWindow.findFireSensor(sensorName);

                if(sensor == null){//check for null (see findXXXSensor in mainWindow)
                    System.out.println("NULL SENSOR ! " + sensorName);
                    return;
                }

                int priority;
                if(priorityLevelTextField.getText().equals(""))//if empty assume 1
                    priority = 1;
                else
                    priority = Integer.parseInt(priorityLevelTextField.getText());

                EventAlarm eventAlarm = new FireAlarm(LocalDateTime.now(),//create event to pass
                        sensor.getRoom(), priority, sensor);

                mainWindow.getRoom().getMonitorA().Listen(eventAlarm);//not sure if handle it here or in monitor
                mainWindow.getTabAlarmMonitor().Listen(eventAlarm);//good enough Clueless
                }
            });
    }

    private void createGasForm(){//same as above, but change Fire->Gas
        JPanel jPanel = new JPanel();
        this.dateTextField = new JTextField();
        this.dateTextField.setPreferredSize(new Dimension(150, 30));

        this.priorityLevelTextField = new JTextField();
        this.priorityLevelTextField.setPreferredSize(new Dimension(150, 30));

        this.submitButton = new JButton("Submit fire Alarm");
        this.submitButton.setPreferredSize(new Dimension(150, 30));

        String[] listGasSensor = new String[this.mainWindow.getRoom().getNb_sensors()];

        int i = 0;

        for (GasSensor fireSensor: this.mainWindow.getRoom().getGasSensorList()) {
            listGasSensor[i] = fireSensor.getName();
            i++;
        }

        JComboBox<String> jComboBoxGas = new JComboBox<>(listGasSensor);

        jPanel.add(this.dateTextField);
        jPanel.add(this.priorityLevelTextField);
        jPanel.add(jComboBoxGas);
        jPanel.add(this.submitButton);

        this.panel.add(jPanel);

        this.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sensorName = (String) jComboBoxGas.getSelectedItem();//casting from obj
                Sensor sensor = mainWindow.findRadiationSensor(sensorName);

                if(sensor == null){
                    System.out.println("NULL SENSOR ! " + sensorName);
                }

                int priority;
                if(priorityLevelTextField.getText().equals(""))
                    priority = 1;
                else
                    priority = Integer.parseInt(priorityLevelTextField.getText());

                EventAlarm eventAlarm = new FireAlarm(LocalDateTime.now(),
                        sensor.getRoom(), priority, sensor);

                mainWindow.getRoom().getMonitorA().Listen(eventAlarm);//not sure if handle it here or in monitor
                mainWindow.getTabAlarmMonitor().Listen(eventAlarm);//good enough Clueless
            }
        });

    }

    private void createRadiationForm(){//same as above, but change Gas->Radiation
        JPanel jPanel = new JPanel();
        this.dateTextField = new JTextField();//NOTE need to be a member ?
        this.dateTextField.setPreferredSize(new Dimension(150, 30));

        this.priorityLevelTextField = new JTextField();
        this.priorityLevelTextField.setPreferredSize(new Dimension(150, 30));

        this.submitButton = new JButton("Submit radiation Alarm");
        this.submitButton.setPreferredSize(new Dimension(150, 30));

        String[] listRadiationSensor = new String[this.mainWindow.getRoom().getNb_sensors()];

        int i = 0;

        for (RadiationSensor radiationSensor: this.mainWindow.getRoom().getRadiationSensorsList()) {
            listRadiationSensor[i] = radiationSensor.getName();
            i++;
        }

        JComboBox<String> jComboBoxRadiation = new JComboBox<>(listRadiationSensor);

        jPanel.add(this.dateTextField);
        jPanel.add(this.priorityLevelTextField);
        jPanel.add(jComboBoxRadiation);
        jPanel.add(this.submitButton);

        this.panel.add(jPanel);

        this.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//why isnt ass an offensive word
                String sensorName = (String) jComboBoxRadiation.getSelectedItem();//casting from obj
                Sensor sensor = mainWindow.findRadiationSensor(sensorName);

                if(sensor == null){
                    System.out.println("NULL SENSOR ! " + sensorName);
                }

                int priority;
                if(priorityLevelTextField.getText().equals(""))
                    priority = 1;
                else
                    priority = Integer.parseInt(priorityLevelTextField.getText());

                EventAlarm eventAlarm = new FireAlarm(LocalDateTime.now(),
                        sensor.getRoom(), priority, sensor);

                mainWindow.getRoom().getMonitorA().Listen(eventAlarm);//not sure if handle it here or in monitor
                mainWindow.getTabAlarmMonitor().Listen(eventAlarm);//good enough Clueless
            }
        });
    }
}