package com.example.todo.app.welcome;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.example.todo.app.mapper.LabMapper;
import com.example.todo.domain.model.Content;
import com.example.todo.domain.model.Lab;
import com.example.todo.domain.model.UnitTest;
import com.example.todo.domain.service.UnitTestServiceImpl;

@Controller
@RequestMapping(value = "codeLearn/lab")
@SessionAttributes(value = { "content" })
public class LabController {

    String ques = "ques";

    String scope = "scope";

    String user = "user";

    @Inject
    UnitTestServiceImpl service;

    @ModelAttribute
    public LabMapper setForm() {
        LabMapper input = new LabMapper();
        return input;
    }

    /**
     * ジャンル一覧。
     * 
     * @param session
     * @param model
     * @return
     */
    @GetMapping(value = "/")
    public String labs(SessionStatus session, Model model) {
        session.setComplete();
        List<Lab> result = service.findTittle();
        model.addAttribute("output", result);
        return "labMenu";
    }

    /**
     * 問題集一覧。
     * 
     * @param ques
     * @param input
     * @param session
     * @param model
     * @return
     */
    @GetMapping(value = "/scope")
    public String labsQues(LabMapper input, Model model) {
        List<Content> result = service.findQues(input.getScope());
        model.addAttribute("output", result);
        return "labMenu2";
    }

    /**
     * 問題詳細。
     * 
     * @param ques
     * @param scope
     * @param input
     * @param model
     * @return
     */
    @GetMapping(value = "/scope/ques")
    public String labsDetail(LabMapper input, Model model) {

        Content result = service.findDetail(input.getQuesNum());
        if(result != null) {
            model.addAttribute("quesName", result.getQuesName());
            model.addAttribute("content", result.getDetail());
            model.addAttribute("rule", Arrays.asList(result.getRule().split(",")));
        }else {
            throw new IllegalArgumentException();
        }

        try {

            UnitTest unitTest = service.findBySnum("R20240104" + ques + scope);
            if (unitTest == null) {
                ;
            } else {
                String u = IOUtils.toString(unitTest.getSource(), "UTF-8");
                model.addAttribute("unitTest", u);
            }


        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }

        return "lab";
    }

    /**
     * 問題回答提出。
     * 
     * @param input
     * @param validInput
     * @param model
     * @param attribute
     * @return
     */
    @PostMapping("/commit")
    public String sourceCommit(@Valid LabMapper input,
            BindingResult validInput, Model model,
            RedirectAttributes attribute) {

        if (validInput.hasErrors()) {
            return labsDetail(input, model);
        } else {
            ;
        }

        try {
            service.execute(input);
        } catch (BusinessException e) {
            model.addAttribute(e.getResultMessages());
            return labsDetail(input, model);
        }

        attribute.addFlashAttribute(ResultMessages.success().add(ResultMessage
                .fromText("commit Successfully!")));

        return "redirect:/codeLearn/lab/ques/scope";
    }

}
