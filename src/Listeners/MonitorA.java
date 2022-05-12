package Listeners;

import Alarm.EventAlarm;

public class MonitorA implements Listener {
    public MonitorA() {
    }

    @Override
    public void Listen(EventAlarm alarmEvent) {
        String res = this.getClass() + " detected a " + alarmEvent.getClass() + " in the room " + alarmEvent.getLocalisation();
        System.out.println(res);
        // System.out.println(alarmEvent);
    }
}
