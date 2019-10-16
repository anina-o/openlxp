package cn.elvea.lxp.common.service;

import cn.elvea.lxp.common.model.BaseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AbstractEntityManager
 *
 * @author elvea
 * @see BaseManager
 */
public abstract class AbstractEntityManager<R extends BaseMapper<T>, T extends BaseEntity, K extends Long>
        implements BaseManager<T, K> {

    /**
     * PagingAndSortingRepository
     */
    @Autowired
    protected R repository;

    /**
     * @see BaseManager#save(Object)
     */
    @Override
    public T save(T entity) {
        repository.updateById(entity);
        return entity;
    }

    /**
     * @see BaseManager#findById(Object)
     */
    @Override
    public T findById(K k) {
        return repository.selectById(k);
    }

    /**
     * @see BaseManager#delete(Object)
     */
    @Override
    public void delete(T entity) {
        repository.deleteById(entity);
    }

}
