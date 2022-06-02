package Listeners;

import Alarm.EventAlarm;
import gui.TabAlarmMonitor;

public class MonitorB implements Listener {
    private TabAlarmMonitor tabAlarmMon;
    public MonitorB() {
        
    }

    public void setTabAlarmMon(TabAlarmMonitor t){
        this.tabAlarmMon = t;
    }

    @Override
    public void Listen(EventAlarm alarmEvent) {
        String res = this.getClass() + " detected a " + alarmEvent.getClass()
                + " in the room " + alarmEvent.getLocalisation();
        System.out.println(res);
        // System.out.println(alarmEvent);
        this.tabAlarmMon.addAlarmEvent(alarmEvent);
    }
}