package rc.bootsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;

@ControllerAdvice
public class GlobalExceptionHandler {

    //private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

//    @ExceptionHandler(SQLException.class)
//    public String handleSQLException(HttpServletRequest request, Exception ex){
//        //logger.info("SQLException Occured:: URL="+request.getRequestURL());
//        return "database_error";
//    }

    // creates model attrs: 'status' and 'error' !!!!!!!!!!!!
    //@ResponseStatus(value = HttpStatus.CONFLICT, reason="IOException occured.....") // затирает модель!!!!!!!
    @ExceptionHandler(Exception.class) //IOException.class
    public String handle1(@ModelAttribute("exception") Exception ex
                          //, RedirectAttributes redirectAttributes
                            ,Model model
    ) {
        int a = 1;
        //logger.error("IOException handler executed");
        //returning 404 error code

        //redirectAttributes.addFlashAttribute("exception", ex);
        //model.addAttribute("exception", ex);
        model.addAttribute("err", "ffffffffffffff");

        return "error2";
    }
}