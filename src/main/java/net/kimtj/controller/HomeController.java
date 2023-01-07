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
	
	@RequestMapping("home/index") //URL이 요청된 경우에 이 액션 메소드가 실행 (GET, POST 무관)
    public String index(Model model) {
        model.addAttribute("message", "회원가입 성공");
        model.addAttribute("now",new Date());
        return "home/index";
    }
    
    @GetMapping("home/login") //URL이 GET 방식으로 서버에 요청되면 실행
    public String text1(Model model) {
    	String passwd = "";  //새로고침시 비밀번호는 입력칸 초기화
    	model.addAttribute("message", "로그인 화면입니다.");
    	model.addAttribute("now",new Date());
    	model.addAttribute("password",passwd);
    	return "home/login";
    }
    
    @PostMapping("home/login") //URL이 Post 방식으로 서버에 요청되면 실행
    public String text2(Model model, String userid, String passwd, Boolean autologin, HttpSession session) {
    	String errorMsg = null; //에러메세지
    	model.addAttribute("now", new Date());
       
    	if (userid == null || userid.length() == 0)
            errorMsg = "사용자 아이디를 입력하세요";
        else if (passwd == null || passwd.length() == 0)
            errorMsg = "비밀번호를 입력하세요";
        else if (passwd.equals("test") == false) //비밀번호 = test
            errorMsg = "비밀번호 불일치";
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
            errorMsg = "사용자 아이디를 입력하세요";
        else if (password1 == null || password1.length() == 0)
            errorMsg = "비밀번호1을 입력하세요";
        else if (password2 == null || password2.length() == 0)
            errorMsg = "비밀번호2를 입력하세요";
        else if (password1.equals(password2) == false)
            errorMsg = "비밀번호 불일치";
        else if (email == null || email.length() == 0)
            errorMsg = "이메일 주소를 입력하세요";
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
