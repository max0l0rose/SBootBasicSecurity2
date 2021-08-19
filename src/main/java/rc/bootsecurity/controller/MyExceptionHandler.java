package rc.bootsecurity.controller;

import javassist.NotFoundException;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler
        //extends ResponseEntityExceptionHandler
{

    @GetMapping("error")
    @ExceptionHandler(Exception.class)
    public String error(//HttpServletRequest request
                        //@RequestHeader(name = "errorcode") String errorCode
                        //ErrorAttributes errorAttributes
                        Model model,
                        @ModelAttribute("exception") Exception exception
    ) {
        //String a = errorCode;
        //model.addAttribute("exception", exception);
        return "error";
    }


    //@GetMapping("error")
    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request)
    {
        return new ResponseEntity<Object>(
                "Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }


//    @ExceptionHandler({ NotFoundException.class })
//    public ResponseEntity<Object> handlenfe(
//            Exception ex, WebRequest request)
//    {
//        return new ResponseEntity<Object>(
//                "nfe", new HttpHeaders(), HttpStatus.NOT_FOUND);
//    }

}
