package Alarm;

import Sensors.Sensor;

import java.time.LocalDateTime;

public class FireAlarm extends EventAlarm {
    public FireAlarm(LocalDateTime dateEvent, Room localisation, int priorityLevel, Sensor source) {
        super(dateEvent, localisation, priorityLevel, source);
    }
}