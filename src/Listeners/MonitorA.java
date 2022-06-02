package Listeners;

import Alarm.EventAlarm;
import gui.TabAlarmMonitor;
import gui.TabMonitor;

import java.util.ArrayList;

public class MonitorA implements Listener {
    private TabAlarmMonitor tabAlarmMon ;
    public MonitorA() {}

    public void setTabAlarmMon(TabAlarmMonitor t){
        this.tabAlarmMon = t;
    }


    @Override//should this notify the sensor as well ? how ?
    public void Listen(EventAlarm alarmEvent){
        String res = this.getClass() + " detected a " + alarmEvent.getClass()
                + " in the room " + alarmEvent.getLocalisation();
        System.out.println(res);
        // System.out.println(alarmEvent);
        this.tabAlarmMon.addAlarmEvent(alarmEvent);
    }
}