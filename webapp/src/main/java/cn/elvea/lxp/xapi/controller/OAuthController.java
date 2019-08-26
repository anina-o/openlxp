package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * OAuth ResourceEntity
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/OAuth")
public class OAuthController extends AbstractController {

    /**
     * Temporary Credential Request
     */
    @RequestMapping("initiate")
    @ResponseBody
    public XAPIResponse initiate() {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * ResourceEntity Owner Authorization
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
