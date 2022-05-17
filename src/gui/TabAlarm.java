package gui;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;

public class TabAlarm{
    private JTabbedPane tabbedPane;
    private JPanel panel;
    public TabAlarm(JTabbedPane tabbedPane){
        panel = new JPanel(false);
        panel.setLayout(new GridLayout(1,3));
        tabbedPane.addTab("Alarm", null, panel,"monkaS");
    }

    private void createFireForm(){

    }
}
