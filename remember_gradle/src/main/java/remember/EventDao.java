package remember;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import remember.model.Event;

public class EventDao {

    Set<Event> events = new HashSet<Event>();

    public void addEvent(Event e) {
        events.add(e);
    }

    public int countEvents() {
        return events.size();
    }

    public List<Event> contains(String string) {
        List<Event> result = new ArrayList<Event>();
        String[] matches = string.split(" ");
        boolean match;
        for(Event event : events) {
            match=true;
            for (String s : matches) {
                if((!event.data.contains(s))) {
                    match=false;
                    break;
                }      
            }
            if(match) {
                result.add(event);
            }
        }
        return result;
    }

}
