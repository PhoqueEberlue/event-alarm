package Alarm;

import java.time.LocalDateTime;

public abstract class EventAlarm {
    private LocalDateTime dateEvent;
    private Room localisation;
    private int priorityLevel;

    public EventAlarm(LocalDateTime dateEvent, Room localisation, int priorityLevel) {
        this.dateEvent = dateEvent;
        this.localisation = localisation;
        this.priorityLevel = priorityLevel;
    }
}
