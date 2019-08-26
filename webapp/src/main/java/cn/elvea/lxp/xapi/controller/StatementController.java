package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.Statement;
import cn.elvea.lxp.xapi.StatementsResult;
import cn.elvea.lxp.xapi.http.XAPIResponse;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;

import static cn.elvea.lxp.xapi.utils.XApiConstants.XAPI_CONTENT_TYPE;

/**
 * Statement ResourceEntity
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/statements")
public class StatementController extends AbstractController {

    /**
     * Get
     */
    @GetMapping(produces = XAPI_CONTENT_TYPE)
    @ResponseBody
    public XAPIResponse getStatement(@RequestParam(value = "statementId", required = false) String statementId,
                                     @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                     @RequestParam(value = "limit", required = false, defaultValue = "1000") String limit) {
        if (StringUtils.isEmpty(statementId)) {
            Statement statement = new Statement();
            return XAPIResponse.success(statement);
        } else {
            StatementsResult statementsResult = new StatementsResult();
            return XAPIResponse.success(statementsResult);
        }

    }

    /**
     * Put
     */
    @PutMapping
    @ResponseBody
    public XAPIResponse putStatement(@RequestBody String json) throws Exception {
        Statement statement = new Statement(json);
        this.statementService.saveStatement(statement);
        return XAPIResponse.success();
    }

    /**
     * Post
     */
    @PostMapping
    @ResponseBody
    public XAPIResponse postStatement(@RequestBody String json) throws NoSuchAlgorithmException, IOException, URISyntaxException {
        return XAPIResponse.success(this.statementService.saveStatements(Statement.fromJson(json)));
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
