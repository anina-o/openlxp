package cn.elvea.lxp.core.controller;

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
@RequestMapping("/user")
public class UserController {

    /**
     * Index
     */
    @GetMapping
    @ResponseBody
    public WebResponse index() {
        return WebResponse.success("Index");
    }

}
