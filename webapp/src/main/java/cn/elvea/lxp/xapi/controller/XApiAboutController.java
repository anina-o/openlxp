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

    /**
     * Returns JSON Object containing information about this LRS,
     * including the xAPI version supported.
     * <p>
     * Primarily this resource exists to allow Clients that support multiple xAPI versions
     * to decide which version to use when communicating with the LRS.
     * Extensions are included to allow other uses to emerge.
     */
    @GetMapping
    @ResponseBody
    public XAPIResponse about() {
        return XAPIResponse.success(this.xapiService.about());
    }

}
