package event_finder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("appName", "Event Finder");
        model.addAttribute("tagline", "Find events near you!");
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}