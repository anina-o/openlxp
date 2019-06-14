package cn.elvea.lxp.common.jpa;

import cn.elvea.lxp.common.utils.IdWorker;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

/**
 * SnowflakeGenerator
 *
 * @author elvea
 */
public class SnowflakeGenerator implements IdentifierGenerator, Configurable {

    IdWorker getIdWorker() {
        return new IdWorker();
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return getIdWorker().nextId();
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
    }

}