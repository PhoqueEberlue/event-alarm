package Listeners;

import Alarm.EventAlarm;

public class MonitorB implements Listener {
    public MonitorB() {
        
    }

    @Override
    public void Listen(EventAlarm alarmEvent) {
        String res = this.getClass() + " detected a " + alarmEvent.getClass()
                + " in the room " + alarmEvent.getLocalisation();
        System.out.println(res);
        // System.out.println(alarmEvent);
    }
}
