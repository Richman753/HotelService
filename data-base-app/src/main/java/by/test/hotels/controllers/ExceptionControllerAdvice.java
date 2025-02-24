package by.test.hotels.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String handleUnexpectedExceptions(Exception exception, Model model)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        model.addAttribute("message", exception.getMessage());
        model.addAttribute("class", exception.getClass());
        model.addAttribute("trace", sw);
        return "error.html";
    }
}
