package Alarm;

import Sensors.Sensor;

import java.time.LocalDateTime;

public class GasAlarm extends EventAlarm {
    String typeGas;
    public GasAlarm(LocalDateTime dateEvent, Room localisation, int priorityLevel, String typeGas, Sensor source) {
        super(dateEvent, localisation, priorityLevel, source);
        this.typeGas = typeGas;
    }

    public String getTypeGas() {
        return typeGas;
    }

    @Override
    public String toString() {
        return "EventAlarm{" +
                "dateEvent=" + this.dateEvent +
                ", localisation=" + this.localisation +
                ", priorityLevel=" + this.priorityLevel +
                ", radiationLevel=" + this.typeGas +
                '}';
    }
}
