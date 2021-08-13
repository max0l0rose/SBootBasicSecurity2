package rc.bootsecurity.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController
{

    @GetMapping("error")
    //@ExceptionHandler(Exception.class)
    //@Override
    public ModelAndView eerror(
            // Exception ex
            //, Model model
            //, RedirectAttributes ra
            HttpServletRequest request
    ) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object msg = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        Object uri = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);

        System.out.printf("MyErrorController: error '%d', '%s', '%s' \n", status, msg, uri);

        if (status != null) {
            Integer code = Integer.valueOf(status.toString());
            if (code == 403)
                throw new AccessDeniedException("qqqqqqqqqqqqqqqq");
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