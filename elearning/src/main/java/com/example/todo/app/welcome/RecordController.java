package com.example.todo.app.welcome;

import java.util.List;

import jakarta.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo.app.mapper.LabMapper;
import com.example.todo.app.mapper.RecordMapper;
import com.example.todo.domain.model.Lab;
import com.example.todo.domain.service.RecordOutput;
import com.example.todo.domain.service.RecordServiceImpl;

@Controller
@RequestMapping(value = "codeLearn/record")
public class RecordController {

    @Inject
    RecordServiceImpl service;

    @ModelAttribute
    public RecordMapper setForm() {
        RecordMapper input = new RecordMapper();
        return input;
    }

    @GetMapping(value = "/")
    public String recodes(Model model) {
        List<Lab> result = service.findTittle();
        model.addAttribute("output", result);
        model.addAttribute("scope", true);

        return "recordMenu";
    }

    @GetMapping(value = "/scope")
    public String recodeQues(Model model) {
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
