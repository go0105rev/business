package com.example.todo.app.welcome;

import jakarta.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo.app.mapper.LabMapper;
import com.example.todo.domain.service.RecordOutput;
import com.example.todo.domain.service.RecordServiceImpl;

@Controller
@RequestMapping(value = "codeLearn/record")
public class RecordController {

    @Inject
    RecordServiceImpl service;

    @ModelAttribute
    public LabMapper setForm() {
        LabMapper input = new LabMapper();
        input.setUserId("testUser001");
        return input;
    }

    @GetMapping(value = "/")
    public String recode(Model model) {
        RecordOutput result = service.findAllRecord();
        model.addAttribute("size", result.getUnitTest().size());
        model.addAttribute("output", result.getUnitTest());

        return "recordMenu";
    }

    @GetMapping(value = "/detail")
    public String toDetail(LabMapper input, Model model) {
        service.findDetail();

        return "detail";
    }

    @GetMapping(value = "/back")
    public String back() {

        return "redirect:/codeLearn/record/";
    }
}
