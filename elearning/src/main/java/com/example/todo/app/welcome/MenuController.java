package com.example.todo.app.welcome;

import java.util.List;

import jakarta.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.todo.app.mapper.AccountUserDetails;
import com.example.todo.app.mapper.MenuMapper;
import com.example.todo.app.mapper.MenuSession;
import com.example.todo.domain.model.Lab;
import com.example.todo.domain.service.MenuServiceImpl;
import com.example.todo.domain.service.RankOutput;
import com.example.todo.domain.service.RanksOutput;
import com.example.todo.domain.service.UnitTestOutput;

@Controller
@RequestMapping(value = "codeLearn/menu")
@SessionAttributes(types = { MenuSession.class })
public class MenuController {

    @Inject
    MenuServiceImpl service;

    @ModelAttribute
    public MenuMapper setForm() {
        MenuMapper input = new MenuMapper();
        return input;
    }

    @ModelAttribute(value = "menuSession")
    public MenuSession setSession() {
        return new MenuSession();
    }

    /**
     * ダッシュボート。
     * 
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "dashBoard")
    public String dashboard(MenuMapper input,
            @AuthenticationPrincipal AccountUserDetails userDetails,
            Model model) {

        List<Lab> result = service.findTittle(userDetails.getUserInf()
                .getUserId());
        List<RankOutput> rank = service.findRank(result);
        model.addAttribute("scope", true);
        MenuSession session = new MenuSession();
        session.setLab(result);
        model.addAttribute(session);

        return "dashBoard";
    }

    /**
     * ソース一覧。
     * 
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "getAllRanks")
    public String getAllRanks(MenuMapper input,
            @AuthenticationPrincipal AccountUserDetails userDetails,
            MenuSession session, Model model) {

        model.addAttribute("userInf", userDetails.getUserInf());
        List<RanksOutput> unitTest = service.findRankbyScope(session.getScope());
        model.addAttribute("cnt", unitTest.size());
        model.addAttribute("output", unitTest);

        return "dashBoard";
    }

    /**
     * ソース詳細参照。
     * 
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "detail")
    public String detail(MenuMapper input, Model model) {
        UnitTestOutput unitTest = service.findSource(input.getQuesNum(), input
                .getSourceId());
        model.addAttribute("output", unitTest);

        return "labDetail";
    }
}
