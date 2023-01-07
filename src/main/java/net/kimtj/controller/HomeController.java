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
	
	@RequestMapping("home/index") //URL�� ��û�� ��쿡 �� �׼� �޼ҵ尡 ���� (GET, POST ����)
    public String index(Model model) {
        model.addAttribute("message", "ȸ������ ����");
        model.addAttribute("now",new Date());
        return "home/index";
    }
    
    @GetMapping("home/login") //URL�� GET ������� ������ ��û�Ǹ� ����
    public String text1(Model model) {
    	String passwd = "";  //���ΰ�ħ�� ��й�ȣ�� �Է�ĭ �ʱ�ȭ
    	model.addAttribute("message", "�α��� ȭ���Դϴ�.");
    	model.addAttribute("now",new Date());
    	model.addAttribute("password",passwd);
    	return "home/login";
    }
    
    @PostMapping("home/login") //URL�� Post ������� ������ ��û�Ǹ� ����
    public String text2(Model model, String userid, String passwd, Boolean autologin, HttpSession session) {
    	String errorMsg = null; //�����޼���
    	model.addAttribute("now", new Date());
       
    	if (userid == null || userid.length() == 0)
            errorMsg = "����� ���̵� �Է��ϼ���";
        else if (passwd == null || passwd.length() == 0)
            errorMsg = "��й�ȣ�� �Է��ϼ���";
        else if (passwd.equals("test") == false) //��й�ȣ = test
            errorMsg = "��й�ȣ ����ġ";
        else {
            session.setAttribute("userid", userid);
            session.setAttribute("password", userid);
            session.setAttribute("autologin", autologin);
            return "redirect:login_success";
        }
    	model.addAttribute("errorMsg", errorMsg);
    	passwd = "";
    	model.addAttribute("userid", userid);
        model.addAttribute("autologin", autologin);
    	model.addAttribute("password", passwd);
    	System.out.println(userid);
        System.out.println(passwd);
        return "home/login";
    }
    @GetMapping("home/login_success")
    public String login_success(Model model) {
        return "home/login_success";
    }
    
    @GetMapping("home/register")
    public String register(Model model) {
        return "home/register";
    }

    @PostMapping("home/register")
    public String register(Model model, HttpSession session, String userid, 
    		String password1, String password2, String email)
    {
        String errorMsg = null;
        if (userid == null || userid.length() == 0)
            errorMsg = "����� ���̵� �Է��ϼ���";
        else if (password1 == null || password1.length() == 0)
            errorMsg = "��й�ȣ1�� �Է��ϼ���";
        else if (password2 == null || password2.length() == 0)
            errorMsg = "��й�ȣ2�� �Է��ϼ���";
        else if (password1.equals(password2) == false)
            errorMsg = "��й�ȣ ����ġ";
        else if (email == null || email.length() == 0)
            errorMsg = "�̸��� �ּҸ� �Է��ϼ���";
        else {
            session.setAttribute("userid", userid);
            session.setAttribute("email", email);
            return "redirect:index";
        }
        password1 = "";
        password2 = "";
        email = "";
        model.addAttribute("userid", userid);
        model.addAttribute("email", email);
        model.addAttribute("errorMsg", errorMsg);
        return "home/register";
    }

}
