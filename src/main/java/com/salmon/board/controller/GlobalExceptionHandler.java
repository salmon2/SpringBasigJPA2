package com.salmon.board.controller;


import com.salmon.board.exception.UserNameDuplicationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNameDuplicationException.class)
    public String handleError(Exception e, RedirectAttributes redirectAttributes) {

        redirectAttributes.addAttribute("msg", "아이디가 중복 입니다.");

        return "redirect:/user/signup";
    }

}
