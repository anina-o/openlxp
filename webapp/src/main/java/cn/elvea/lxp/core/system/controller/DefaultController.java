package cn.elvea.lxp.core.system.controller;

import cn.elvea.lxp.common.web.WebResponse;
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
public class DefaultController {

    /**
     * 首页
     */
    @GetMapping
    @ResponseBody
    public WebResponse index() {
        return WebResponse.success("Index");
    }

}
