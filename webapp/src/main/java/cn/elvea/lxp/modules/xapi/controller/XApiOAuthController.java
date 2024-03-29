package cn.elvea.lxp.modules.xapi.controller;

import cn.elvea.lxp.modules.xapi.http.XAPIResponse;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * XApiOAuthController
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/OAuth")
@Api(tags = "XApi OAuth Resource")
public class XApiOAuthController extends XApiAbstractController {

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
