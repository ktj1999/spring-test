package net.kimtj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;

@Controller 
public class HomeController {
	
    @RequestMapping("home/index") //URL�� ��û�� ��쿡 �� �׼� �޼ҵ尡 ���� (GET, POST ����)
    public String index(Model model) {
        model.addAttribute("message", "hello");
        model.addAttribute("now",new Date());
        return "home/index";
    }
    
    @GetMapping("home/login") //URL�� GET ������� ������ ��û�Ǹ� ����
    public String text1(Model model) {
    	model.addAttribute("message", "�α��� ȭ���Դϴ�.");
    	model.addAttribute("now",new Date());
    	return "home/login";
    }
    
    @PostMapping("home/login") //URL�� Post ������� ������ ��û�Ǹ� ����
    public String text2(Model model, String userid, String passwd) {
    	model.addAttribute("ID", userid);
    	model.addAttribute("PWD", passwd);
    	model.addAttribute("now",new Date());
    	System.out.println(userid);
        System.out.println(passwd);
        return "home/index";
    }
}
