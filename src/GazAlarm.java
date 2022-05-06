import java.time.LocalDateTime;

public class GazAlarm extends EventAlarm {
    public GazAlarm(LocalDateTime dateEvent, Room localisation, int priorityLevel) {
        super(dateEvent, localisation, priorityLevel);
    }
}
