package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.Statement;
import cn.elvea.lxp.xapi.StatementsResult;

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
    void saveStatement(Statement statement);

    /**
     *
     */
    Statement getStatement(String statementId);

    /**
     *
     */
    StatementsResult getStatements();

    /**
     *
     */
    List<String> saveStatements(List<Statement> statements);

}
