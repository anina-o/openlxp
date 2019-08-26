package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.Statement;

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
    List<String> saveStatements(List<Statement> statements);

}
