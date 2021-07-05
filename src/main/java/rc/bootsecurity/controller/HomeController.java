package rc.bootsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

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

        if (userService.findByName(user.getUsername()).isPresent()) {
            ObjectError err = new ObjectError("username", "User exists!");
            bindingResult.addError(err);
            return "/register";
        }

        // TODO: add to DB
        userService.save(user);

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
