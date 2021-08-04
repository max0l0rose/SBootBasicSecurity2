package rc.bootsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import rc.bootsecurity.Services.UserService;
import rc.bootsecurity.model.User;

import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController
//            implements ErrorController
{
    @Autowired
    private UserService userService;


    @GetMapping(value = {"/", "index"})
    public String index(ModelMap model
//            , @RequestHeader(name = "errorcode") String h1
//            , @RequestHeader(name = "Content-Type") String h2
            , @RequestHeader(name = "Accept-Language") String h3
                        )
    {
        if (!model.containsAttribute("err"))
            model.addAttribute("err", "qqqqq");
        return "/index";
    }


    @GetMapping("register")
    public String register(@ModelAttribute("user") User user) {
        //model.addAttribute("user", new User());
        return "/register";
    }


    @PostMapping("reg_process")
    public String reg_process(//, HttpServletRequest request
                              //Model model,
                              //HttpServletRequest httpServletRequest,
                              RedirectAttributes redirectAttributes,
                              //HttpSession session,
                              @Valid User user,
                              BindingResult bindingResult
                              //, BCryptPasswordEncoder passwordEncoder
                              )
    {
        //redirectAttributes.addFlashAttribute("user", user);
        if(bindingResult.hasErrors()) {
            return "/register";
        }

        if (userService.findByName(user.getUsername()).isPresent()) {
            //ObjectError err = new ObjectError("username", "User exists!!!!");
            //bindingResult.addError(err);
            bindingResult.reject("username1", new Object[]{"aaaa"}, "An account already exists for this email...");
            bindingResult.rejectValue("username", "register.userExists", "already exists");
            return "/register";
        }

        // TODO: add to DB
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);

        //model.addAttribute("message", "Success. Person: " + user.getUsername());
        redirectAttributes.addAttribute("regsuccess", "1");
        redirectAttributes.addAttribute("message", user.getUsername());

        //request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return "redirect:/login";
    }





    //@GetMapping("login")
    @RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login( User user) {
//        if (!model.containsAttribute("user")) {
//            model.addAttribute("user", new User());
//        }
        return "/login";
    }

    //@RequestMapping(value="/testredirect",method = { RequestMethod.POST, RequestMethod.GET })
    @PostMapping("mysignin")
    public String signin(//RedirectAttributes redirectAttributes,
                         HttpServletRequest request
                        //, RedirectAttributes redirectAttributes
                        , @Valid User user
                        , BindingResult bindingResult
                        ) {
        //redirectAttributes.addFlashAttribute("user", user);
        //redirectAttributes.addAttribute("user", user);
        if(bindingResult.hasErrors()) {
            return "/login";
        }
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        request.setAttribute("user", user);
        //redirectAttributes.addAttribute("user", user);
        return "redirect:/signin";//signin";
    }



    //
//    @RequestMapping(value = "error", method = {RequestMethod.GET}) //, RequestMethod.POST
//    @ResponseStatus(value= HttpStatus.SEE_OTHER, reason="IOException occured")
//    //@ExceptionHandler()
//    public String error(HttpServletRequest request
//                        //, HttpServletResponse resp
//                        //, @RequestHeader(name = "errorcode") String errorCode
//                        , Model model
//                        , RedirectAttributes ra
//                        )
//    {
//        System.out.println("HomeController: error " + System.identityHashCode(model));
//
//        model.addAttribute("err", "zzzzzzzzzzzzz");
//        ra.addFlashAttribute("err", "xxxxxxxxxxxxxxx");
//        int err = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        return "/error";
//    }



    @PostMapping("mylogout")
    public RedirectView logoutPost(RedirectAttributes redirectAttributes)
    {
        //return "redirect:/logout";

        RedirectView redirectView = new RedirectView("/index");
        redirectAttributes.addFlashAttribute("err", "111111111111");
        return redirectView;
    }


    @GetMapping("mylogout")
    public ModelAndView logoutGet(
                                    //RedirectAttributes redirectAttributes
                                )
    {
        //return "redirect:/logout";

//        RedirectView redirectView = new RedirectView("/index");
//        redirectView.addStaticAttribute("err", new User());

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("err", "33333333333333333333333333");
        //redirectAttributes.addFlashAttribute("err", "111111111111");
        return modelAndView;
    }
}
