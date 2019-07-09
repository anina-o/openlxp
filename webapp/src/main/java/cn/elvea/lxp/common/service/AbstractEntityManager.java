package cn.elvea.lxp.common.service;

import cn.elvea.lxp.common.model.BaseEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * AbstractEntityManager
 *
 * @author elvea
 * @see BaseManager
 */
public abstract class AbstractEntityManager<T extends BaseEntity, K> implements BaseManager<T, K> {

    /**
     * @return PagingAndSortingRepository
     */
    protected abstract PagingAndSortingRepository<T, K> getRepository();

    /**
     * @see BaseManager#save(Object)
     */
    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    /**
     * @see BaseManager#findById(Object)
     */
    @Override
    public T findById(K k) {
        return getRepository().findById(k).orElse(null);
    }

    /**
     * @see BaseManager#delete(Object)
     */
    @Override
    public void delete(T entity) {
        getRepository().delete(entity);
    }

}
