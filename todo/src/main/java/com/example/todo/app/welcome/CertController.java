package com.example.todo.app.welcome;

import java.util.Locale;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo.app.mapper.UserForm;

/**
 * ログイン・ログアウト。
 */
@Controller
@RequestMapping(value = "login")
public class CertController {

    private static final Logger logger = LoggerFactory.getLogger(
            CertController.class);

    @ModelAttribute
    public UserForm setForm() {
        UserForm input = new UserForm();
        return input;
    }

    /**
     * スタート画面。
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "loginForm")
    public String access(Locale locale, Model model) {

        return "loginForm";

    }

    /**
     * ログアウト制御。
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "/logout")
    public String logout(@Valid UserForm input, BindingResult binding,
            Model model) {

        return "redirect:/codeLearn/";

    }

}
