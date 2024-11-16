package com.example.todo.app.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "codeLearn/recode")
public class RecordController {

    @GetMapping(value = "/")
    public String recode() {
        return "recode";
    }
    
    @GetMapping(value = "/search")
    public String search() {
        return "";
    }

    @GetMapping(value = "/detail")
    public String toDetail() {
        return "";
    }

    // TODO 重複可能か確認したい
    @GetMapping(value = "/back")
    public String back() {
        return "";
    }
}
