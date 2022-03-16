package emergon.controller;

import emergon.entity.MyUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class AuthenticationController {
    
    @GetMapping("/loginPage")
    public String showLoginPage(){
        return "login-form"; // login-form.jsp
    }
    
    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){
        return "access-denied";
    }  
    
    
    //@ResponseBody // Convert to JSON
    //@RequestMapping("/person")
    @GetMapping("/person")
    public String showPeson(){
        //MyUser u=new MyUser(1,"kostas","katsavaros","kks@gmail.com","kks","123456");
        return "json_test";
    }
    
    
    
    
}
