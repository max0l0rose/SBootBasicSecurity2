package rc.bootsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    //private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

//    @ExceptionHandler(SQLException.class)
//    public String handleSQLException(HttpServletRequest request, Exception ex){
//        //logger.info("SQLException Occured:: URL="+request.getRequestURL());
//        return "database_error";
//    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="IOException occured.....")
    @ExceptionHandler(Exception.class) //IOException.class
    public void handle1() {
        int a = 1;
        //logger.error("IOException handler executed");
        //returning 404 error code
    }
}