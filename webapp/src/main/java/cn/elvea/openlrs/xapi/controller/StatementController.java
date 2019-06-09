package cn.elvea.openlrs.xapi.controller;

import cn.elvea.openlrs.xapi.http.XAPIResponse;
import cn.elvea.openlrs.xapi.service.XAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Statement Resource
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/statements")
public class StatementController {

    @Autowired
    XAPIService xapiService;

    /**
     * Get
     */
    @GetMapping
    @ResponseBody
    public XAPIResponse getStatement() {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Put
     */
    @PutMapping
    @ResponseBody
    public XAPIResponse putStatement() {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Post
     */
    @PostMapping
    @ResponseBody
    public XAPIResponse postStatement() {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Delete
     */
    @DeleteMapping
    @ResponseBody
    public XAPIResponse deleteStatement() {
        return XAPIResponse.success(this.xapiService.about());
    }
}
