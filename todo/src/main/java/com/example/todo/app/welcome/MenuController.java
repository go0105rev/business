package com.example.todo.app.welcome;

import org.springframework.stereotype.Controller;

@Controller
public class MenuController {

    public String menu() {
        return "menu";
    }
    
    public String lab() {
        return "lab";
    }
}
