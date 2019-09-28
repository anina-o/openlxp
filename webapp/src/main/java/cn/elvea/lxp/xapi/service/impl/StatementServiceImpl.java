package cn.elvea.lxp.xapi.service.impl;

import cn.elvea.lxp.common.utils.ConvertUtils;
import cn.elvea.lxp.xapi.entity.StatementEntity;
import cn.elvea.lxp.xapi.model.Statement;
import cn.elvea.lxp.xapi.model.StatementsResult;
import cn.elvea.lxp.xapi.service.StatementService;
import cn.elvea.lxp.xapi.utils.XApiUtils;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * StatementServiceImpl
 *
 * @author elvea
 */
@Service
public class StatementServiceImpl extends AbstractXApiService implements StatementService {

    @Override
    public void saveStatement(String statementId, Statement statement) {
        StatementEntity entity = new StatementEntity();
        ConvertUtils.copyProperties(statement, entity);
        entity.setId(statementId);
        this.statementRepository.save(entity);
    }

    @Override
    public List<String> saveStatements(List<Statement> statements) {
        List<String> ids = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(statements)) {
            List<StatementEntity> statementEntities = Lists.newArrayList();
            for (Statement statement : statements) {
                StatementEntity entity = new StatementEntity();
                ConvertUtils.copyProperties(statement, entity);
                if (StringUtils.isEmpty(entity.getId())) {
                    entity.setId(XApiUtils.randomUUID());
                }
                statementEntities.add(entity);
            }
            this.statementRepository.saveAll(statementEntities);
            for (StatementEntity entity : statementEntities) {
                ids.add(entity.getId());
            }
        }
        return ids;
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

}
