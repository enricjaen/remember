
package remember;

import org.junit.Test;

import remember.model.Distance;
import remember.model.Event;

import static org.junit.Assert.*;

import java.util.List;


public class EventServiceTest {

    EventService service = new EventService();
    
    @Test
    public void canAddEventNowAndHere() {
        String data = "vacuna pau triple virica 2a dosis";
        Event event = service.addEvent(data);
        assertNotNull(event);
        assertNotNull(event.date);
        assertEquals(data,event.data);
    }

    @Test
    public void canAdd1Event() {
        String data = "vacuna pau triple virica";
        String date = "2009-09-03";
        Event event = addEvent(data,date);
        assertNotNull(data);
        assertNotNull(event.date);
        assertEquals(data,event.data);
    }

    @Test
    public void canAdd2Events() {
        addEvent("vacuna pau triple virica", "2009-09-03");
        addEvent("vacuna pau triple virica 2a dosis", "2011-08-03");
        int number = service.countEvents();
        assertEquals(2,number);
    }
    
    @Test
    public void canCalculateTimeBetween2Events() {
        Event event1 = addEvent("vacuna pau triple virica", "2009-09-03");
        Event event2 = addEvent("vacuna pau triple virica 2a dosis", "2011-09-02");
        Distance distance = service.distanceBetween(event1,event2);
        assertNotNull(distance);
        System.out.println(distance.getYears());
        System.out.println(distance.getMonths());
        System.out.println(distance.getDays());
    }
    
    @Test
    public void canCalculateTimeFromEvent() {
        Event event = addEvent("muere mi papa", "1997-11-17");
        Distance distance = service.distanceSince(event);
        assertNotNull(distance);
        System.out.println(distance.getYears());
        System.out.println(distance.getMonths());
        System.out.println(distance.getDays());
    }

    @Test
    public void canFindEventsContaining() {
        addEvent("vacuna pau triple virica", "2009-09-03");
        addEvent("vacuna pau triple virica 2a dosis", "2011-08-03");
        List<Event>  events = service.retrieveEventsWith("vacuna pau");
        assertEquals(2,events.size());
    }
    
    private Event addEvent(String data, String date) {
        return service.addData(data,date);
    }
       
    
}
