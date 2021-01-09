package br.com.cpdias.contact.error;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
class GlobalExceptionHandler {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    //@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleIOException(HttpServletRequest req, NoHandlerFoundException e){
        LOGGER.error("IOException handler executed");
        //returning 404 error code
        ModelAndView mav = new ModelAndView();
        mav.setStatus(HttpStatus.NOT_FOUND);
        mav.addObject("URL", req.getRequestURL());
        mav.setViewName("error/404");
        
        return mav;
    }
    
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView handleNullPointerException(Exception e) {

        LOGGER.error("A null pointer exception ocurred {} " , e.getMessage(), e);
        ModelAndView mav = new ModelAndView();
        mav.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        
        mav.setViewName("error/generic");
        return mav;
    }
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        LOGGER.error("Request:  {}. raised {}. ", req.getRequestURL(), ex.getMessage(), ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        
        mav.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        mav.setViewName("error/error");
        return mav;
    }
}