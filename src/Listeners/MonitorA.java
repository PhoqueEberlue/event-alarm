package Listeners;

import Alarm.EventAlarm;
import gui.TabAlarmMonitor;

import java.util.ArrayList;

public class MonitorA implements Listener {
    public MonitorA() {
    }

    @Override//should this notify the sensor as well ? how ?
    public void Listen(EventAlarm alarmEvent){
        String res = this.getClass() + " detected a " + alarmEvent.getClass()
                + " in the room " + alarmEvent.getLocalisation();
        System.out.println(res);
        // System.out.println(alarmEvent);
    }
}