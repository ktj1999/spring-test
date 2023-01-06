package net.kimtj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
    @RequestMapping("home/index")
    public String index(Model model) {
        model.addAttribute("message", "hello");
        return "home/index";
    }

}
