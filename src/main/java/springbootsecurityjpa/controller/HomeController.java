package springbootsecurityjpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {
    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String home(){
        return ("<h1>HOME PAGE</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>ADMIN PAGE</h1>");
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>USER PAGE</h1>");
    }
}
