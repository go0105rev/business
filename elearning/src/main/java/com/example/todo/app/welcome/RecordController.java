package com.example.todo.app.welcome;

import java.util.List;

import jakarta.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.todo.app.mapper.RecordMapper;
import com.example.todo.app.mapper.RecordSession;
import com.example.todo.domain.model.Lab;
import com.example.todo.domain.service.MenuServiceImpl;
import com.example.todo.domain.service.RecordOutput;
import com.example.todo.domain.service.RecordServiceImpl;
import com.example.todo.domain.service.UnitTestOutput;

@Controller
@RequestMapping(value = "codeLearn/record")
@SessionAttributes(types = {RecordSession.class})
public class RecordController {

    @Inject
    RecordServiceImpl service;
    
    @Inject
    MenuServiceImpl menu;

    @ModelAttribute
    public RecordMapper setForm() {
        RecordMapper input = new RecordMapper();
        return input;
    }

    @ModelAttribute(value = "resordSession")
    public RecordSession setSession() {
        return new RecordSession();
    }

    @GetMapping(value = "/")
    public String recodes(Model model,RecordSession session) {
        List<Lab> result = service.findTittle(session.getUserId());
        model.addAttribute("scope", true);
        session.setLab(result);
        model.addAttribute(session);

        return "recordMenu";
    }

    @GetMapping(value = "/scope")
    public String recodeQues(RecordMapper input,Model model,RecordSession session) {
        List<RecordOutput> result = service.findByScope(input.getScope());
        model.addAttribute("scope", false);
        model.addAttribute("size", result.size());
        model.addAttribute("output", result);

        return "recordMenu";
    }

    @GetMapping(value = "/detail")
    public String toDetail(RecordMapper input, Model model) {
        UnitTestOutput unitTest = menu.findSource(input.getQuesNum(), input.getSourceId());
        model.addAttribute("output", unitTest);
        return "labDetail";
    }

    @GetMapping(value = "/back")
    public String back() {

        return "redirect:/codeLearn/record/scope";
    }
}
