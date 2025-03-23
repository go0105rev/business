package com.example.todo.app.welcome;

import java.util.Arrays;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.example.todo.app.mapper.LabMapper;
import com.example.todo.app.mapper.LabSession;
import com.example.todo.domain.model.Content;
import com.example.todo.domain.model.Lab;
import com.example.todo.domain.model.UnitTest;
import com.example.todo.domain.service.MenuServiceImpl;
import com.example.todo.domain.service.UnitTestOutput;
import com.example.todo.domain.service.UnitTestServiceImpl;

@Controller
@RequestMapping(value = "codeLearn/lab")
@SessionAttributes(types = { LabSession.class })
public class LabController {

    @Inject
    UnitTestServiceImpl service;
    
    @Inject
    MenuServiceImpl menu;

    @ModelAttribute
    public LabMapper setForm() {
        LabMapper input = new LabMapper();
        return input;
    }

    @ModelAttribute(value = "labSession")
    public LabSession setLabSession() {
        return new LabSession();
    }

    /**
     * ジャンル一覧。
     * @param model
     * @param session
     * @return
     */
    @GetMapping(value = "/")
    public String labs(Model model, LabSession session) {
        List<Lab> result = service.findTittle(session.getUserId());
        model.addAttribute("output", result);
        model.addAttribute("scope", true);
        return "labMenu";
    }

    /**
     * 問題集一覧。
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
        model.addAttribute("scope", false);
        return "labMenu";
    }

    /**
     * 問題詳細。
     * @param ques
     * @param scope
     * @param input
     * @param model
     * @return
     */
    @GetMapping(value = "/scope/ques")
    public String labsDetail(LabMapper input, Model model, LabSession session) {

        Content result = service.findDetail(session.getQuesNum());
        if (result != null) {
            model.addAttribute("content", result.getDetail());
            model.addAttribute("rule", Arrays.asList(result.getRule().split(
                    ",")));
        } else {
            throw new IllegalArgumentException();
        }

        List<UnitTest> unitTest = service.findBySnum(session.getUserId(), session.getQuesNum());
        int cnt = unitTest.size();

        model.addAttribute("output", unitTest);
        model.addAttribute("cnt", cnt);
        session.setQuesName(result.getQuesName());
        model.addAttribute(session);

        return "lab";
    }

    /**
     * 問題回答提出。
     * @param input
     * @param validInput
     * @param model
     * @param attribute
     * @return
     */
    @PostMapping("/commit")
    public String sourceCommit(@Valid LabMapper input, BindingResult validInput,
            Model model, LabSession session,RedirectAttributes attribute) {

        if (validInput.hasErrors()) {
            return "redirect:/codeLearn/lab/scope/ques";
        } else {
            ;
        }

        try {
            service.execute(input,session.getQuesNum(),session.getUserId());
        } catch (BusinessException e) {
            model.addAttribute(e.getResultMessages());
            return "redirect:/codeLearn/lab/scope/ques";
        }

        attribute.addFlashAttribute(ResultMessages.success().add(ResultMessage
                .fromText("commit Successfully!")));

        return "redirect:/codeLearn/lab/scope/ques";
    }

    /**
     * 回答評価詳細。
     * @param ques
     * @param scope
     * @param input
     * @param model
     * @return
     */
    @GetMapping(value = "/detail")
    public String toDetail(LabMapper input, Model model, LabSession session) {

        UnitTestOutput unitTest = menu.findSource(session.getQuesNum(), input.getSourceId());
        model.addAttribute("output", unitTest);

        return "labDetail";
    }
}
