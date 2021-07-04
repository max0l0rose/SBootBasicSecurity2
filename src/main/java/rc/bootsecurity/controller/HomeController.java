package rc.bootsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rc.bootsecurity.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping(value = {"/", "index"})
    public String index(ModelMap model
//            , @RequestHeader(name = "errorcode") String h1
//            , @RequestHeader(name = "Content-Type") String h2
            , @RequestHeader(name = "Accept-Language") String h3
                        )
    {
        model.addAttribute("err", "qqqqq");
        return "/index";
    }


    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "/register";
    }


    @PostMapping("reg_process")
    public String reg_process(//, HttpServletRequest request
                              Model model,
                              //HttpServletRequest httpServletRequest,
                              RedirectAttributes redirectAttributes,
                              //HttpSession session,
                              @Valid User user, BindingResult bindingResult
    ) {
        redirectAttributes.addFlashAttribute("user", user);
        if(bindingResult.hasErrors()) {
            return "/register";
        }

        //model.addAttribute("message", "Success. Person: " + user.getUsername());
        redirectAttributes.addAttribute("regsuccess", "1");
        redirectAttributes.addFlashAttribute("message", user.getUsername());

        //request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return "redirect:/login";
    }


    //@GetMapping("login")
    @RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(Model model) {
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new User());
        }
        return "/login";
    }


    @RequestMapping(value = "error", method = {RequestMethod.GET, RequestMethod.POST})
    //@ExceptionHandler()
    public void error(HttpServletRequest request
                        //, HttpServletResponse resp
                        //, @RequestHeader(name = "errorcode") String errorCode
                        , Model model
                        , RedirectAttributes ra
                        )
    {
        model.addAttribute("err", "qqqqq");
        ra.addFlashAttribute("err", "qqqqq");
        //int err = (Integer) request.getAttribute("javax.servlet.error.status_code");
        //return "/error1111";
    }


    //@RequestMapping(value="/testredirect",method = { RequestMethod.POST, RequestMethod.GET })
    @PostMapping("mysignin")
    public String signin(//RedirectAttributes ra
                         HttpServletRequest request
                        , RedirectAttributes redirectAttributes
                        , @Valid User user
                        , BindingResult bindingResult
                        ) {
        redirectAttributes.addFlashAttribute("user", user);
        if(bindingResult.hasErrors()) {
            return "/login";
        }
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return "redirect:/signin";//signin";
    }


    @PostMapping("mylogout")
    public String logoutPost()
    {
        return "redirect:/logout";
    }


    @GetMapping("mylogout")
    public String logoutGet()
    {
        return "redirect:/logout";
    }
}
