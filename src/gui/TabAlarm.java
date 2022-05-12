package gui;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class TabAlarm{
    private JTabbedPane tabbedPane;
    private JPanel panel;
    public TabAlarm(JTabbedPane tabbedPane){
        panel = new JPanel(false);
        tabbedPane.addTab("Alarm", null, panel,"monkaS");
    }
}
