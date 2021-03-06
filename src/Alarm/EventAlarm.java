package Alarm;
import Sensors.Sensor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.EventObject;

public abstract class EventAlarm extends EventObject {
    protected LocalDateTime dateEvent;
    protected Room localisation;
    protected int priorityLevel;

    public EventAlarm(LocalDateTime dateEvent, Room localisation, int priorityLevel, Sensor source) {
        super(source);
        this.dateEvent = dateEvent;
        this.localisation = localisation;
        this.priorityLevel = priorityLevel;
    }

    public LocalDateTime getDateEvent() {
        return dateEvent;
    }

    public Room getLocalisation() {
        return localisation;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    @Override
    public String toString() {
        return "Alarm in " +
                this.localisation.toString() +
                " at " + this.dateEvent.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)) +
                " with priority " + this.priorityLevel +
                " and type " + this.getClass().getSimpleName();
    }
}