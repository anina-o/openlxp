package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 关于控制器
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/about")
public class XApiAboutController extends XApiAbstractController {
    @GetMapping
    @ResponseBody
    public XAPIResponse about() {
        return XAPIResponse.success(this.xapiService.about());
    }
}
