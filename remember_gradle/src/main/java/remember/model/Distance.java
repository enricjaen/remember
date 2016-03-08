package remember.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Distance {

    public Distance(Event event1, Event event2) {
        period = Period.between(asLocalDate(event1.date), asLocalDate(event2.date));
    }

    public Distance(Event event) {
        period = Period.between(asLocalDate(event.date), LocalDate.now());
    }

    
    public int getYears() {
        return period.getYears();
    }

    public int getMonths() {
        return period.getMonths();
    }

    public int getDays() {
        return period.getDays();
    }
    
    private LocalDate asLocalDate(String date) {
        return LocalDate.parse(date,formatter);
    }
    
    private Period period;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

}
