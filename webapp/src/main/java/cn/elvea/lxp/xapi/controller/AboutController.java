package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import cn.elvea.lxp.xapi.service.XAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * About Resource
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/about")
public class AboutController {

    private XAPIService xapiService;

    /**
     * About
     */
    @GetMapping
    @ResponseBody
    public XAPIResponse about() {
        return XAPIResponse.success(this.xapiService.about());
    }

    @Autowired
    public void setXapiService(XAPIService xapiService) {
        this.xapiService = xapiService;
    }

}
