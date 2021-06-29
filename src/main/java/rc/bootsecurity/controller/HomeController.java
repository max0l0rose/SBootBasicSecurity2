package rc.bootsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("index")
    public String index(){
        return "index";
    }


    @GetMapping("login")
    public String login(){
        return "login";
    }


    //@RequestMapping(value="/testredirect",method = { RequestMethod.POST, RequestMethod.GET })
    @PostMapping("mysignin")
    public String signin(//RedirectAttributes qq
                         HttpServletRequest request
                        ) {
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return "redirect:/mylogout";//signin";
    }


    @PostMapping("mylogout")
    public String logout()
    {
        return "redirect:/logout";
    }


    @GetMapping("mylogout")
    public String logoutGet()
    {
        return "redirect:/logout";
    }
}
