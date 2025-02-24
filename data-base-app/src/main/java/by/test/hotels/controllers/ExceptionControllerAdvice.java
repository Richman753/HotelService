package by.test.hotels.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private StringWriter getExceptionStackTrace(Exception exception)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        return sw;
    }

    @ExceptionHandler(Exception.class)
    public String handleUnexpectedExceptions(Exception exception, Model model)
    {
        model.addAttribute("message", exception.getMessage());
        model.addAttribute("class", exception.getClass());
        model.addAttribute("explanation", "Неожиданная ошибка, объяснения нет");
        model.addAttribute("trace", getExceptionStackTrace(exception));
        return "error.html";
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerExceptions(NullPointerException exception, Model model)
    {
        model.addAttribute("message", exception.getMessage());
        model.addAttribute("class", exception.getClass());
        model.addAttribute("explanation", "Какое-то из полей нулевое");
        model.addAttribute("trace", getExceptionStackTrace(exception));
        return "error.html";
    }
}
