package rc.bootsecurity.controller;

import javassist.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler
        //extends ResponseEntityExceptionHandler
{

//    @ExceptionHandler({ AccessDeniedException.class })
//    public ResponseEntity<Object> handleAccessDeniedException(
//            Exception ex, WebRequest request) {
//        return new ResponseEntity<Object>(
//                "Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
//    }

//    @ExceptionHandler()
//    public String error(//HttpServletRequest request
//                        //@RequestHeader(name = "errorcode") String errorCode
//    ) {
//        //String a = errorCode;
//        return "error";
//    }
}
