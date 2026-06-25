package event_finder.controller;

import event_finder.model.User;
import event_finder.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController{

    private UserRepository userRepository;

    public LoginController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email,
                               @RequestParam String password,
                               HttpSession session,
                               Model model) {
        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("loggedInUser", user.getName());
                    return "redirect:/";

        } else {
            model.addAttribute("errorMessage", "Invalid email or password!");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String processLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}