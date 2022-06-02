package gui;

import Alarm.EventAlarm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DetailsButton {
    private JDialog dialog;
    private JLabel localisation;
    private JLabel prioLvl;
    private JLabel date;
    private JButton closeB;
    private EventAlarm eventAlarm;
    private JPanel panel;
    private JPanel container;
    private TabMonitor tabMon;

    public DetailsButton(EventAlarm eventAlarm, JPanel panel, JPanel container, TabMonitor tabMon){
        this.panel = panel;
        this.container = container;
        this.dialog = new JDialog();
        this.eventAlarm = eventAlarm;
        this.localisation = new JLabel(eventAlarm.getLocalisation().toString());
        this.date = new JLabel("date : " + eventAlarm.getDateEvent().
            format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
        this.closeB = new JButton("close");

        this.prioLvl = new JLabel("Priority : " + Integer.toString(eventAlarm.getPriorityLevel()));
        this.tabMon = tabMon;

        closeB.addActionListener(new ActionListener() {
            @Override//im dying lets override the overridden override
            public void actionPerformed(ActionEvent actionEvent) {
                if(container.getComponentCount() <= 2) {//cant add multiple buttons (trick to make button oneshot)
                    JButton closeAlert = new JButton("Activate alarm");
                    closeAlert.addActionListener(new ActionListener() {
                        @Override//WKLJH icant
                        public void actionPerformed(ActionEvent actionEvent) {
                            tabMon.Listen(eventAlarm);
                            panel.remove(container);
                            //panel.revalidate(); ?? y no working me big sad
                            panel.repaint();
                        }
                    });
                    container.add(closeAlert);
                }
                panel.revalidate();
                dialog.dispose();
            }
        });


        this.dialog.setVisible(true);
        this.closeB.setPreferredSize(new Dimension(120, 30));//wtf ? not working
        this.dialog.add(localisation);
        this.dialog.setLayout(new GridLayout(4,1));
        this.dialog.add(prioLvl);
        this.dialog.add(date);
        this.dialog.add(closeB);
    }
}