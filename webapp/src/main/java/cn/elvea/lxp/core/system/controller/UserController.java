package cn.elvea.lxp.core.system.controller;

import cn.elvea.lxp.common.web.WebResponse;
import cn.elvea.lxp.core.system.form.Register;
import cn.elvea.lxp.core.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.elvea.lxp.common.utils.ValidationUtils.handleEntityValidationException;

/**
 * 用户控制器
 *
 * @author elvea
 */
@Controller
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    /**
     * 用户注册
     */
    @PostMapping("register")
    @ResponseBody
    public WebResponse register(@RequestBody @Validated Register register, BindingResult result) {
        if (result.hasFieldErrors()) {
            return handleEntityValidationException(result);
        }
        this.userService.register(register);
        return WebResponse.success(register);
    }

    /**
     * 用户个人信息
     */
    @GetMapping("profile")
    @ResponseBody
    public WebResponse profile() {
        return WebResponse.success();
    }

    /**
     * 修改个人信息
     */
    @PostMapping("profile")
    @ResponseBody
    public WebResponse postProfile() {
        return WebResponse.success();
    }

    /**
     * 修改个人密码
     */
    @PostMapping("change-password")
    @ResponseBody
    public WebResponse changePassword() {
        return WebResponse.success();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
