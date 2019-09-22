package cn.elvea.lxp.common.service;

import cn.elvea.lxp.common.model.BaseEntity;
import cn.elvea.lxp.core.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * AbstractEntityManager
 *
 * @author elvea
 * @see BaseManager
 */
public abstract class AbstractEntityManager<R extends PagingAndSortingRepository<T, K>, T extends BaseEntity, K> implements BaseManager<T, K> {

    /**
     * PagingAndSortingRepository
     */
    protected R repository;

    /**
     * @see BaseManager#save(Object)
     */
    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    /**
     * @see BaseManager#findById(Object)
     */
    @Override
    public T findById(K k) {
        return repository.findById(k).orElse(null);
    }

    /**
     * @see BaseManager#delete(Object)
     */
    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

}
