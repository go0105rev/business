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

import com.example.todo.app.mapper.AuthMapper;

/**
 * ログイン・ログアウト。
 */
@Controller
@RequestMapping(value = "codeLearn")
public class CertController {

    private static final Logger logger = LoggerFactory.getLogger(
            CertController.class);

    @ModelAttribute
    public AuthMapper setForm() {
        AuthMapper input = new AuthMapper();
        return input;
    }

    /**
     * ホーム制御。
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "/")
    public String access(Locale locale, Model model) {

        return "access";

    }

    /**
     * ホーム制御。
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "/menu")
    public String home(AuthMapper input, Model model) {



        // TODO 認証実装
        boolean auth = true;

        if (!auth) {
            return "redirect:/codeLearn/";
        } else {
            return "menu";
        }

    }

    /**
     * ログイン制御。
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "/login")
    public String login(@Valid AuthMapper input,BindingResult binding, Model model) {

        // TODO リダイレクトしたい。
        return "menu";

    }

    /**
     * ログアウト制御。
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "/logout")
    public String logout(Locale locale, Model model) {

        return "access";

    }
}
