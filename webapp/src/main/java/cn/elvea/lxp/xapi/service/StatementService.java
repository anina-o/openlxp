package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.model.Statement;
import cn.elvea.lxp.xapi.model.StatementsResult;

import java.util.List;

/**
 * StatementService
 *
 * @author elvea
 */
public interface StatementService {

    /**
     *
     */
    void saveStatement(String statementId, Statement statement);

    /**
     *
     */
    List<String> saveStatements(List<Statement> statements);

    /**
     *
     */
    Statement getStatement(String statementId, String voidedStatementId);

    /**
     *
     */
    StatementsResult getStatements(String agentJson,
                                   String verb,
                                   String activity,
                                   String registration,
                                   Boolean relatedActivities,
                                   Boolean relatedAgents,
                                   String since,
                                   String until,
                                   String format,
                                   Boolean attachments,
                                   Boolean ascending,
                                   String limit
    );

}
