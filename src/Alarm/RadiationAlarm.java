package Alarm;

import Alarm.EventAlarm;
import Sensors.Sensor;

import java.time.LocalDateTime;

public class RadiationAlarm extends EventAlarm {
    int radiationLevel;

    public RadiationAlarm(LocalDateTime dateEvent, Room localisation, int priorityLevel, int radiationLevel, Sensor source) {
        super(dateEvent, localisation, priorityLevel, source);
        this.radiationLevel = radiationLevel;
    }

    public int getRadiationLevel() {
        return radiationLevel;
    }

    @Override
    public String toString() {
        return "EventAlarm{" +
                "dateEvent=" + this.dateEvent +
                ", localisation=" + this.localisation +
                ", priorityLevel=" + this.priorityLevel +
                ", radiationLevel=" + this.radiationLevel +
                '}';
    }
}
