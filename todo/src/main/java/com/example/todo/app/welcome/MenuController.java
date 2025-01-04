package com.example.todo.app.welcome;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.todo.app.mapper.AccountUserDetails;

@Controller
public class MenuController {

    /**
     * ログイン制御。
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "codeLearn/dashBoard")
    public String dashboard(@AuthenticationPrincipal AccountUserDetails userDetails,Model model) {
            return "dashBoard";
    }

}
