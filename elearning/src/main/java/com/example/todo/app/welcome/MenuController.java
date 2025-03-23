package com.example.todo.app.welcome;

import java.util.List;

import jakarta.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo.app.mapper.AccountUserDetails;
import com.example.todo.app.mapper.MenuMapper;
import com.example.todo.domain.model.UnitTest;
import com.example.todo.domain.service.MenuServiceImpl;
import com.example.todo.domain.service.UnitTestOutput;

@Controller
@RequestMapping(value = "codeLearn/menu")
public class MenuController {

    @Inject
    MenuServiceImpl service;

    @ModelAttribute
    public MenuMapper setForm() {
        MenuMapper input = new MenuMapper();
        return input;
    }

    /**
     * ログイン制御。
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "dashBoard")
    public String dashboard(@AuthenticationPrincipal AccountUserDetails userDetails,Model model) {
            model.addAttribute("userInf",userDetails.getUserInf());
            List<UnitTest> unitTest = service.findAll();
            model.addAttribute("cnt", unitTest.size());
            model.addAttribute("output", unitTest);

            return "dashBoard";
    }

    /**
     * ソース詳細参照。
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "detail")
    public String detail(MenuMapper input,Model model) {
        UnitTestOutput unitTest = service.findSource(input.getQuesNum(),input.getSourceId());
        model.addAttribute("output", unitTest);

        return "labDetail";
    }
}
