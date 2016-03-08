
package remember;
import java.time.LocalDateTime;
import java.util.List;

import remember.model.Distance;
import remember.model.Event;

public class EventService {


    EventDao eventDao = new EventDao();
    
    public Event addEvent(String data) {
        Event e = new Event();
        e.data = data;
        e.date = LocalDateTime.now().toString();
        eventDao.addEvent(e);
        return e;
    }

    public Event addData(String data, String date) {
        Event e = new Event();
        e.data = data;
        e.date = date;
        eventDao.addEvent(e);
        return e;
    }

    public int countEvents() {
        return eventDao.countEvents();
    }

    public Distance distanceBetween(Event event1, Event event2) {
        return new Distance(event1, event2);
    }

    public Distance distanceSince(Event event) {
        return new Distance(event);
    }

    public List<Event> retrieveEventsWith(String string) {
        return eventDao.contains(string);
    }
}
