package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import cn.elvea.lxp.xapi.service.XAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * OAuth Resource
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/OAuth")
public class OAuthController {

    @Autowired
    XAPIService xapiService;

    /**
     * Temporary Credential Request
     */
    @RequestMapping("initiate")
    @ResponseBody
    public XAPIResponse initiate() {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Resource Owner Authorization
     */
    @RequestMapping("authorize")
    @ResponseBody
    public XAPIResponse authorize() {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Token Request
     */
    @RequestMapping("token")
    @ResponseBody
    public XAPIResponse token() {
        return XAPIResponse.success(this.xapiService.about());
    }

}
