package cn.elvea.lxp.core.system.controller;

import cn.elvea.lxp.common.web.WebResponse;
import cn.elvea.lxp.core.system.form.Register;
import cn.elvea.lxp.core.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "用户接口")
public class UserController {

    private UserService userService;

    /**
     * 用户注册
     */
    @PostMapping("register")
    @ResponseBody
    @ApiOperation("用户注册")
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
    @ApiOperation("获取用户个人信息接口")
    public WebResponse profile() {
        return WebResponse.success();
    }

    /**
     * 修改个人信息
     */
    @PostMapping("profile")
    @ResponseBody
    @ApiOperation("修改用户个人信息接口")
    public WebResponse postProfile() {
        return WebResponse.success();
    }

    /**
     * 修改个人密码
     */
    @PostMapping("change-password")
    @ResponseBody
    @ApiOperation("修改用户密码信息接口")
    public WebResponse changePassword() {
        return WebResponse.success();
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
