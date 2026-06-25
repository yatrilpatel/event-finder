package event_finder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String sport;
    private LocalDate date;
    private String venue;
    private String city;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    };
    public void setTitle(String title) {
        this.title = title;
    }

    public String getSport() {
        return sport;
    }
    public void setSport(String sport) {
        this.sport = sport;
    }

    public LocalDate getDate(){
        return date;
    }
    public void setDate(){
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }
    public void setVenue(String venue){
        this.venue = venue;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

}