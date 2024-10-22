package com.example.GoogleAndGitAuth2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Auth2Controller {

    @GetMapping("/home")
    public String home(){
        return "Welcome Home";
    }
}
