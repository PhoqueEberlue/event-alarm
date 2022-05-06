package Alarm;

import java.time.LocalDateTime;

public class GasAlarm extends EventAlarm {
    public GasAlarm(LocalDateTime dateEvent, Room localisation, int priorityLevel) {
        super(dateEvent, localisation, priorityLevel);
    }
}
