import java.time.LocalDateTime;

public class RadiationAlarm extends EventAlarm {
    public RadiationAlarm(LocalDateTime dateEvent, Room localisation, int priorityLevel) {
        super(dateEvent, localisation, priorityLevel);
    }
}
