package cn.elvea.lxp.common.manager;

/**
 * BaseManager
 *
 * @author elvea
 */
public interface BaseManager<T, ID> {

    T save(T entity);

    T findById(ID id);

}
