package event_finder.controller;

import event_finder.model.Event;
import event_finder.service.EventService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public String showEventPage(
            @RequestParam(required = false) String sport,
            HttpSession session,
            Model model) {


        if(session.getAttribute("loggedInUser") == null) {
            return "redirect:/login";
        }

        List<Event> events;

        if(sport != null && !sport.isEmpty()) {
            events = eventService.getEventBySport(sport);
        } else {
            events = eventService.getAllEvents();
        }

        model.addAttribute("events", events);
        model.addAttribute("selectedSport", sport);
        model.addAttribute("username", session.getAttribute("loggedInUser"));
        return "events";
    }
}