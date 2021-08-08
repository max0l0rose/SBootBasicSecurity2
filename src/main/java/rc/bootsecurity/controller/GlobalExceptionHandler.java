package rc.bootsecurity.controller;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.StringUtils;

import javax.jws.WebParam;
import java.util.ArrayList;


//TODO Надо изучить:   InitBinder    binder.addCustomFormatter, binder.registerCustomEditor


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
    @GetMapping("error")
    @ExceptionHandler(Exception.class) //IOException.class
    public String handle1(@ModelAttribute("exception") Exception exception
                          //, RedirectAttributes redirectAttributes
                            , Model model
                          //, ErrorAttributes errorAttributes //https://stackoverflow.com/questions/41424130/handle-org-thymeleaf-exceptions-templateinputexception
    ) {
        //logger.error("IOException handler executed");
        //returning 404 error code

        //redirectAttributes.addFlashAttribute("exception", ex);
        //model.addAttribute("exception", ex);
        ArrayList<String> arr = new ArrayList<>();
        String s = "";
        Throwable ex = exception;
        while (ex != null) {
            if (!StringUtils.equals(s, ex.getMessage())) {
                s = ex.getMessage();
                ex = ex.getCause();
                arr.add(s);
            }
        }
        model.addAttribute("err", arr);

        return "error";
    }
}