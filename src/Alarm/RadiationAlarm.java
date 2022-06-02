package Alarm;

import Alarm.EventAlarm;
import Sensors.Sensor;

import java.time.LocalDateTime;

public class RadiationAlarm extends EventAlarm {
    public RadiationAlarm(LocalDateTime dateEvent, Room localisation, int priorityLevel, Sensor source) {
        super(dateEvent, localisation, priorityLevel, source);
    }
}
