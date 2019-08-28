package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.Statement;
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
                                     @RequestParam(value = "voidedStatementId ", required = false) String voidedStatementId,
                                     @RequestParam(value = "agent", required = false, defaultValue = "") String agentJson,
                                     @RequestParam(value = "verb", required = false, defaultValue = "") String verb,
                                     @RequestParam(value = "activity", required = false, defaultValue = "") String activity,
                                     @RequestParam(value = "registration", required = false, defaultValue = "") String registration,
                                     @RequestParam(value = "related_activities", required = false, defaultValue = "false") Boolean relatedActivities,
                                     @RequestParam(value = "related_agents", required = false, defaultValue = "false") Boolean relatedAgents,
                                     @RequestParam(value = "since", required = false, defaultValue = "") String since,
                                     @RequestParam(value = "until", required = false, defaultValue = "") String until,
                                     @RequestParam(value = "format", required = false, defaultValue = "exact") String format,
                                     @RequestParam(value = "attachments", required = false, defaultValue = "false") Boolean attachments,
                                     @RequestParam(value = "ascending", required = false, defaultValue = "false") Boolean ascending,
                                     @RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                     @RequestParam(value = "limit", required = false, defaultValue = "0") String limit) {
        if (!StringUtils.isEmpty(statementId) || !StringUtils.isEmpty(voidedStatementId)) {
            return XAPIResponse.success(this.statementService.getStatement(statementId));
        } else {
            return XAPIResponse.success(this.statementService.getStatements());
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
