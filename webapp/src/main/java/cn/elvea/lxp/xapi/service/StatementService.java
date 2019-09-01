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
    Statement getStatement(String statementId);

    /**
     *
     */
    StatementsResult getStatements();

}
