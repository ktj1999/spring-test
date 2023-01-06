package net.kimtj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;

@Controller
public class HomeController {
	
    @RequestMapping("home/index")
    public String index(Model model) {
        model.addAttribute("message", "hello");
        model.addAttribute("now",new Date());
        return "home/index";
    }

}
