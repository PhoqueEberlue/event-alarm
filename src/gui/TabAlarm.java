package gui;
import Alarm.EventAlarm;
import Alarm.FireAlarm;
import Alarm.GasAlarm;
import Alarm.RadiationAlarm;
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
import java.util.Date;
import java.util.Locale;

public class TabAlarm{
    private JTabbedPane tabbedPane;
    private JPanel panel;
    private MainWindow mainWindow;

    private JTextField priorityLevelTextField;
    private JButton submitButton;
    private JButton chooseAlarmType;


    public TabAlarm(JTabbedPane tabbedPane, MainWindow mainWindow){
        this.mainWindow = mainWindow;
        this.panel = new JPanel(false);
        this.panel.setLayout(new GridBagLayout());
        tabbedPane.addTab("Alarm", null, panel,"monkaS");
        this.handleTypeAlarm();
    }

    private void handleTypeAlarm(){ //first pane, asking for the type of alarm to trigger
                                    //It is ugly to do this by checking strings, but how it was described in the
                                    //assignment


        JPanel jPanel = new JPanel();//not needed, but makes it handy to remove

        String[] choices = {"FireAlarm", "GasAlarm", "RadiationAlarm"};

        JComboBox<String> jComboChoice = new JComboBox<>(choices);

        //typeField.setPreferredSize(new Dimension(150, 30));
        JButton button = new JButton("submit");
        jPanel.add(button);
        jPanel.add(jComboChoice);


        this.panel.add(jPanel);//add handy panel to actual panel

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//on click check what was input
                if(jComboChoice.getSelectedItem().toString().equals("FireAlarm")){
                    panel.remove(jPanel);
                    createFireForm();//go to form
                }
                else if(jComboChoice.getSelectedItem().toString().equals("GasAlarm")){
                    panel.remove(jPanel);
                    createGasForm();//go to form
                }
                else if(jComboChoice.getSelectedItem().equals("RadiationAlarm")) {
                    panel.remove(jPanel);
                    createRadiationForm();//go to form
                }
            }
        });
    }

    private void createFireForm(){
        JPanel jPanel = new JPanel();//handy panel

        JButton backBtn = new JButton("Go back");
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panel.remove(jPanel);
                handleTypeAlarm();
                panel.repaint();
            }
        });


        jPanel.setLayout(new GridLayout());
        this.priorityLevelTextField = new JTextField("Priority level");
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

        jPanel.add(this.priorityLevelTextField);
        jPanel.add(jComboBoxFire);
        jPanel.add(this.submitButton);
        jPanel.add(backBtn);

        this.panel.add(jPanel);//adding handy to main panel

        this.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String sensorName = (String) jComboBoxFire.getSelectedItem();//casting from obj
                Sensor sensor = mainWindow.findFireSensor(sensorName);

                if(sensor == null){//check for null (see findXXXSensor in mainWindow)
                    return;
                }

                int priority;
                if(priorityLevelTextField.getText().equals("Priority level"))//if empty assume 1
                    priority = 1;
                else
                    priority = Integer.parseInt(priorityLevelTextField.getText());

                EventAlarm eventAlarm = new FireAlarm(LocalDateTime.now(),//create event to pass
                        sensor.getRoom(), priority, sensor);

                mainWindow.getRoom().getMonitorA().Listen(eventAlarm);//not sure if handle it here or in monitor
                }
            });
    }

    private void createGasForm(){//same as above, but change Fire->Gas
        JPanel jPanel = new JPanel();

        JButton backBtn = new JButton("Go back");
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panel.remove(jPanel);
                handleTypeAlarm();
                panel.repaint();
            }
        });

        jPanel.setLayout(new GridLayout());
        this.priorityLevelTextField = new JTextField("Priority level");
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

        jPanel.add(this.priorityLevelTextField);
        jPanel.add(jComboBoxGas);
        jPanel.add(this.submitButton);
        jPanel.add(backBtn);

        this.panel.add(jPanel);

        this.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sensorName = (String) jComboBoxGas.getSelectedItem();//casting from obj
                Sensor sensor = mainWindow.findGasSensor(sensorName);

                if(sensor == null){
                    System.out.println("NULL SENSOR ! " + sensorName);
                }

                int priority;
                if(priorityLevelTextField.getText().equals("Priority level"))
                    priority = 1;
                else
                    priority = Integer.parseInt(priorityLevelTextField.getText());

                EventAlarm eventAlarm = new GasAlarm(LocalDateTime.now(),
                        sensor.getRoom(), priority, sensor);

                mainWindow.getRoom().getMonitorA().Listen(eventAlarm);//not sure if handle it here or in monitor
            }
        });

    }

    private void createRadiationForm(){//same as above, but change Gas->Radiation
        JPanel jPanel = new JPanel();

        JButton backBtn = new JButton("Go back");
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panel.remove(jPanel);
                handleTypeAlarm();
                panel.repaint();
            }
        });

        jPanel.setLayout(new GridLayout());
        this.priorityLevelTextField = new JTextField("Priority level");
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

        jPanel.add(this.priorityLevelTextField);
        jPanel.add(jComboBoxRadiation);
        jPanel.add(this.submitButton);
        jPanel.add(backBtn);

        this.panel.add(jPanel);

        this.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sensorName = (String) jComboBoxRadiation.getSelectedItem();//casting from obj
                Sensor sensor = mainWindow.findRadiationSensor(sensorName);

                if(sensor == null){
                    System.out.println("NULL SENSOR ! " + sensorName);
                }

                int priority;
                if(priorityLevelTextField.getText().equals("Priority level"))
                    priority = 1;
                else
                    priority = Integer.parseInt(priorityLevelTextField.getText());

                EventAlarm eventAlarm = new RadiationAlarm(LocalDateTime.now(),
                        sensor.getRoom(), priority, sensor);

                mainWindow.getRoom().getMonitorA().Listen(eventAlarm);//not sure if handle it here or in monitor
            }
        });
    }
}