package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import cn.elvea.lxp.xapi.model.Statement;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.elvea.lxp.xapi.utils.XApiConstants.XAPI_CONTENT_TYPE;

/**
 * Statement ResourceEntity
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/statements")
public class XApiStatementController extends XApiAbstractController {

    /**
     * GET Statements
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
        if (StringUtils.isEmpty(statementId)) {
            return XAPIResponse.success(this.statementService.getStatement(statementId));
        } else {
            return XAPIResponse.success(this.statementService.getStatements());
        }
    }

    /**
     * PUT Statements
     */
    @ResponseBody
    @PutMapping
    public XAPIResponse putStatement(@RequestParam(value = "statementId", required = false) String statementId,
                                     @RequestBody String json) throws Exception {
        Statement statement = new Statement(json);
        this.statementService.saveStatement(statementId, statement);
        return XAPIResponse.success();
    }

    /**
     * POST Statements
     */
    @ResponseBody
    @PostMapping
    public XAPIResponse postStatement(@RequestBody String json) throws Exception {
        List<Statement> statementList = Statement.fromJson(json);
        return XAPIResponse.success(this.statementService.saveStatements(statementList));
    }

}
