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
@RequestMapping("")
@Api(tags = "公共接口")
public class DefaultController {

    /**
     * 首页
     */
    @GetMapping
    @ResponseBody
    @ApiOperation("获取首页相关内容接口")
    public WebResponse index() {
        return WebResponse.success("Index");
    }

}
