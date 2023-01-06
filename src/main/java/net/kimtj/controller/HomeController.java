package net.kimtj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;

import javax.servlet.http.HttpSession;

@Controller 
public class HomeController {
	
	/*@RequestMapping("home/index") //URL�� ��û�� ��쿡 �� �׼� �޼ҵ尡 ���� (GET, POST ����)
    public String index(Model model) {
        model.addAttribute("message", "hello");
        model.addAttribute("now",new Date());
        return "home/index";
    }*/
    
    @GetMapping("home/login") //URL�� GET ������� ������ ��û�Ǹ� ����
    public String text1(Model model) {
    	model.addAttribute("message", "�α��� ȭ���Դϴ�.");
    	model.addAttribute("now",new Date());
    	return "home/login";
    }
    
    @PostMapping("home/login") //URL�� Post ������� ������ ��û�Ǹ� ����
    public String text2(Model model, String userid, String passwd, Boolean autologin, HttpSession session) {
    	String errorMsg = null; //�����޼���
    	model.addAttribute("now",new Date());
    	if (userid == null || userid.length() == 0)
            errorMsg = "����� ���̵� �Է��ϼ���";
        else if (passwd == null || passwd.length() == 0)
            errorMsg = "��й�ȣ�� �Է��ϼ���";
        else if (userid.equals(passwd) == false)
            errorMsg = "��й�ȣ ����ġ";
        else {
            session.setAttribute("userid", userid);
            session.setAttribute("password", userid);
            session.setAttribute("autologin", autologin);
            return "redirect:index";
        }
        model.addAttribute("now", new Date());
        model.addAttribute("userid", userid);
        model.addAttribute("password", passwd);
        model.addAttribute("autologin", autologin);
        model.addAttribute("errorMsg", errorMsg);

    	System.out.println(userid);
        System.out.println(passwd);
        return "home/login";
    }
    @GetMapping("home/index")
    public String login_success(Model model) {
        return "home/index";
    }

}
