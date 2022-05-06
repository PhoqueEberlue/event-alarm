package Alarm;

import java.time.LocalDateTime;

public class FireAlarm extends EventAlarm {

    public FireAlarm(LocalDateTime dateEvent, Room localisation, int priorityLevel) {
        super(dateEvent, localisation, priorityLevel);
    }
}
