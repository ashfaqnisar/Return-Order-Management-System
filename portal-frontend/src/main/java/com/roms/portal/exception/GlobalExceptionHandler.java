package com.roms.portal.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllErrors(Exception exception) {
        log.error(exception.getMessage());
        return new ModelAndView("redirect:/login");
    }

    @ExceptionHandler(TokenInvalidException.class)
    public ModelAndView handleTokenInvalidException(TokenInvalidException exception) {
        log.error(exception.getMessage());
        return new ModelAndView("redirect:/login");
    }

    @ExceptionHandler(RequestIdNotFoundException.class)
    public ModelAndView handleRequestIdNotFoundException(RequestIdNotFoundException exception) {
        log.error(exception.getMessage());
        return new ModelAndView("redirect:/");
    }
}
