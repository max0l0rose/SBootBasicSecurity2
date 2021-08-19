package rc.bootsecurity.controller;


import javassist.NotFoundException;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MyErrorController

        //Marker interface used to identify a @Controller that should be used to render errors.
        //implements ErrorController

        extends AbstractErrorController
{

    public MyErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }



    @ModelAttribute("s")
    String gets() {
        return "qqq";
    }



    @GetMapping("error")
    //@ExceptionHandler(Exception.class)
    //@Override
    public ModelAndView eerror(
            // Exception ex
            //, Model model
            //, RedirectAttributes ra
            @ModelAttribute("s") String s,
            HttpServletRequest request
                                        ) throws NotFoundException
    {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object msg = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        Object uri = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);

        System.out.printf("MyErrorController: error '%d', '%s', '%s' \n", status, msg, uri);

        if (status != null) {
            Integer code = Integer.valueOf(status.toString());
            if (code == 403)
                throw new AccessDeniedException("qqqqqqqqqqqqqqqq");
            else
            if (code == 404)
                throw new NotFoundException("wwwwwww");
//
//            if(statusCode == HttpStatus.NOT_FOUND.value()) {
////                return "error-404";
////            }
////            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
////                return "error-500";
//            }
        }

        //model.addAttribute("err", "aaaaaaaaaaaaaaa");
        //ra.addFlashAttribute("err", "bbbbbbbbbbbbbbbbbbbbb");

        //return "error";

        ModelAndView modelAndView = new ModelAndView();
        //modelAndView.addObject("err", ex);
        //modelAndView.addObject("url", request.getRequestURL());

        modelAndView.setViewName("error");
        return modelAndView;
    }
}