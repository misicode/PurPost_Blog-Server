package com.misicode.eggnews.controllers;

import com.misicode.eggnews.payload.SigninRequest;
import com.misicode.eggnews.payload.SigninResponse;
import com.misicode.eggnews.services.IAuthService;
import com.misicode.eggnews.services.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private IAuthService authService;
    private IUserService userService;

    public AuthController(IAuthService authService, IUserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<SigninResponse> showSignIn(@RequestBody @Valid SigninRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    /*@GetMapping("/signup")
    public String showSignUp(ModelMap model) {
        model.addAttribute("user", new User());
        return "signup-page";
    }

    @PostMapping("/signup/form")
    public String signUp(User user) {
        return userService.registerUser(user) ? "redirect:../signin" : "redirect:./error";
    }*/
}
