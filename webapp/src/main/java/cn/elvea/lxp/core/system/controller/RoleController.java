package cn.elvea.lxp.core.system.controller;

import cn.elvea.lxp.common.web.WebResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * DefaultController
 *
 * @author elvea
 */
@Controller
@RequestMapping("/role")
@Api(tags = "角色接口")
public class RoleController {

    /**
     * Index
     */
    @GetMapping
    @ResponseBody
    @ApiOperation("获取角色管理首页相关信息接口")
    public WebResponse index() {
        return WebResponse.success("Index");
    }

}
