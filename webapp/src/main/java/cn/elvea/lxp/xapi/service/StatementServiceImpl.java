package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.common.utils.ConvertUtils;
import cn.elvea.lxp.xapi.Statement;
import cn.elvea.lxp.xapi.StatementsResult;
import cn.elvea.lxp.xapi.entity.StatementEntity;
import cn.elvea.lxp.xapi.repository.StatementRepository;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * StatementServiceImpl
 *
 * @author elvea
 */
@Service
public class StatementServiceImpl implements StatementService {
    /**
     *
     */
    StatementRepository statementRepository;

    @Override
    public void saveStatement(Statement statement) {
        StatementEntity entity = new StatementEntity();
        ConvertUtils.copyProperties(statement, entity);
        this.statementRepository.save(entity);
    }

    @Override
    public Statement getStatement(String statementId) {
        StatementEntity entity = this.statementRepository.findById(statementId).orElse(null);
        Statement statement = new Statement();
        ConvertUtils.copyProperties(entity, statement);
        return statement;
    }

    @Override
    public StatementsResult getStatements() {
        return null;
    }

    @Override
    public List<String> saveStatements(List<Statement> statements) {
        List<String> ids = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(statements)) {
            List<StatementEntity> statementEntities = Lists.newArrayList();
            for (Statement statement : statements) {
                StatementEntity entity = new StatementEntity();
                ConvertUtils.copyProperties(statement, entity);
                statementEntities.add(entity);
            }
            this.statementRepository.saveAll(statementEntities);

            for (StatementEntity entity : statementEntities) {
                ids.add(entity.getId());
            }
        }
        return ids;
    }

    @Autowired
    public void setStatementRepository(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }
}
