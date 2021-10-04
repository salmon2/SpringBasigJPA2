package com.salmon.board.controller;


import com.salmon.board.exception.NoMatchingAdminCode;
import com.salmon.board.exception.UserNameDuplicationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNameDuplicationException.class)
    public String UserNameDuplicationException(Exception e, RedirectAttributes redirectAttributes) {

        redirectAttributes.addAttribute("msg", "아이디가 중복 입니다.");

        return "redirect:/user/signup";
    }

    @ExceptionHandler(NoMatchingAdminCode.class)
    public String NoMatchingAdminCode(Exception e, RedirectAttributes redirectAttributes) {

        redirectAttributes.addAttribute("msg", "관리자 코드가 유효하지 않습니다.");

        return "redirect:/user/signup";
    }

}
