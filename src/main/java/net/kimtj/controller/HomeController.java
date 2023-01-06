package net.kimtj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;

@Controller 
public class HomeController {
	
    @RequestMapping("home/index") //URL이 요청된 경우에 이 액션 메소드가 실행 (GET, POST 무관)
    public String index(Model model) {
        model.addAttribute("message", "hello");
        model.addAttribute("now",new Date());
        return "home/index";
    }
    
    @GetMapping("home/login") //URL이 GET 방식으로 서버에 요청되면 실행
    public String text1(Model model) {
    	model.addAttribute("message", "로그인 화면입니다.");
    	model.addAttribute("now",new Date());
    	return "home/login";
    }
    
    @PostMapping("home/login") //URL이 Post 방식으로 서버에 요청되면 실행
    public String text2(Model model, String userid, String passwd) {
    	model.addAttribute("ID", userid);
    	model.addAttribute("PWD", passwd);
    	model.addAttribute("now",new Date());
    	System.out.println(userid);
        System.out.println(passwd);
        return "home/index";
    }
}
