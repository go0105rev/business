package com.example.todo.app.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "codeLearn/lab")
public class LabController {

    @GetMapping(value = "/")
    public String lab() {
        return "lab";
    }
    
    @GetMapping(value = "/commit")
    public String sourceCommit() {
        return "";
    }

    @GetMapping(value = "/scope")
    public String chooseScope() {
        return "";
    }

    @GetMapping(value = "/Ques")
    public String chooseQues() {
        return "";
    }
}
