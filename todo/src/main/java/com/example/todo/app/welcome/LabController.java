package com.example.todo.app.welcome;

import java.util.Collection;

import jakarta.inject.Inject;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.example.todo.domain.model.UnitTest;
import com.example.todo.domain.service.UnitTestServiceImpl;

@Controller
@RequestMapping(value = "codeLearn/lab")
public class LabController {

    @Inject
    UnitTestServiceImpl service;
    
    @ModelAttribute
    public UnitTestInput setForm() {
        UnitTestInput input = new UnitTestInput();
        return input;
    }

    @GetMapping(value = "/")
    public String lab(Model model) {
        Collection<UnitTest> lists = service.findAll();
        model.addAttribute("unitTests", lists);
        return "lab";
    }
    
    @PostMapping("commit")
    public String sourceCommit(@Valid UnitTestInput input, BindingResult validInput, Model model, RedirectAttributes attribute){
        
        if(validInput.hasErrors()){
            return lab(model);
        }else {
            ;
        }
        

        try {
            service.execute(input);
        }catch(BusinessException e) {
            model.addAttribute(e.getResultMessages());
            return lab(model);
        }
        
        attribute.addFlashAttribute(ResultMessages.success().add(ResultMessage.fromText("commit Successfully!")));
        
        return "redirect:/codeLearn/lab/";
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
