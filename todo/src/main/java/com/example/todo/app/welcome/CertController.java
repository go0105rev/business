package com.example.todo.app.welcome;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ログイン・ログアウト。
 */
@Controller
@RequestMapping(value = "codeLearn")
public class CertController {

    private static final Logger logger = LoggerFactory
            .getLogger(CertController.class);

    /**
     * ホーム制御。
     * 
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "/")
    public String home(Locale locale, Model model) {

        String a = "no session";
        if("no session".equals(a)) {
            return "access";
        }else {
            // TODO リダイレクトしたい。
            return "menu";
        }

    }
    
    /**
     * ログイン制御。
     * 
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "/login")
    public String login(Locale locale, Model model) {

        // TODO リダイレクトしたい。
        return "menu";

    }
    
    /**
     * ログアウト制御。
     * 
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "/logout")
    public String logout(Locale locale, Model model) {

            return "access";

    }
}
