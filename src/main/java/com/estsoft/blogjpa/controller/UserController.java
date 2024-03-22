package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.dto.AddUserRequest;
import com.estsoft.blogjpa.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }  // -> @RequiredArgsConstructor 로 대체

    @PostMapping("/user")
    public String signup(@ModelAttribute AddUserRequest request) {
        userService.save(request);  // 회원 가입(저장)
        return "redirect:/login";   // GET /login 회원 가입 처리 후 로그인 페이지로 강제 이동
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}