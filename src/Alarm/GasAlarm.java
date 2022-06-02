package Alarm;

import Sensors.Sensor;

import java.time.LocalDateTime;

public class GasAlarm extends EventAlarm {
    String typeGas;
    public GasAlarm(LocalDateTime dateEvent, Room localisation, int priorityLevel, Sensor source) {
        super(dateEvent, localisation, priorityLevel, source);
    }
}