package com.example.todo.app.welcome;

import java.util.Date;

import jakarta.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo.app.mapper.AccountUserDetails;
import com.example.todo.app.mapper.UserForm;
import com.example.todo.domain.model.UserInf;
import com.example.todo.domain.service.UserManageServiceImpl;

/**
 * ユーザ管理。
 */
@Controller
@RequestMapping(value = "login/userInf")
public class UserManageController {

//    TODO mapStructs使いたい
//    @Inject
//    BeanMapper beanMapper;
    
    @Inject
    UserManageServiceImpl userManageService;

    @ModelAttribute
    public UserForm setUserForm() {
        UserForm form = new UserForm();
        return form;
    }

    /**
     * ユーザ情報画面。
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "/userInf")
    public String userMenu(
            @AuthenticationPrincipal AccountUserDetails userDetails,
            UserForm input, Model model) {
        model.addAttribute(userDetails.getUserInf());
        return "userInf";
    }

    /**
     * ユーザ情報の作成画面。
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "/create")
    public String create(Model model) {
        return "createForm";
    }

    /**
     * ユーザ情報の作成制御。
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "confirm")
    public String create(UserForm input, Model model) {
        
//        UserInf userInf = beanMapper.map(input);
        UserInf userInf = new UserInf(input.getTeamId(),input.getUserId(),input.getUserName(),input.getGender(),input.getAge(),input.getExp(),null,null);
        userInf.setsDate(new Date());
        
        userManageService.register(userInf,input.getPass());
        
        return "redirect:complete";
    }

    /**
     * ユーザ情報の変更画面。
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "/userModify")
    public String modify(Model model) {
        return "modifyForm";
    }

    /**
     * ユーザ情報の変更制御。
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "modify")
    public String modify(UserForm input, Model model) {
        return "menu";
    }
    
    
    /**
     * ユーザ情報の完了画面。
     * @param locale
     * @param model
     * @return ビュー名
     */
    @GetMapping(value = "complete")
    public String complete(Model model) {
        return "complete";
    }
}
