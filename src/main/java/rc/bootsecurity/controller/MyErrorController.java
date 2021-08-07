package rc.bootsecurity.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyErrorController implements ErrorController {

    @GetMapping("error")
    @ExceptionHandler
    //@Override
    public ModelAndView eerror(
            Exception ex
            , Model model
            , RedirectAttributes ra
    ) {
        System.out.println("MyErrorController: error " + System.identityHashCode(model));

        //model.addAttribute("err", "aaaaaaaaaaaaaaa");
        //ra.addFlashAttribute("err", "bbbbbbbbbbbbbbbbbbbbb");

        //return "error";

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("err", ex);
        //modelAndView.addObject("url", request.getRequestURL());

        modelAndView.setViewName("error");
        return modelAndView;
    }
}