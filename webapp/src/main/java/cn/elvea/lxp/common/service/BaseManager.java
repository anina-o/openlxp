package cn.elvea.lxp.common.service;

/**
 * BaseManager
 *
 * @author elvea
 */
public interface BaseManager<T, ID> {

    /**
     * 保存实体
     */
    T save(T entity);

    /**
     * 根据ID查找实体
     */
    T findById(ID id);

    /**
     * 删除实体
     */
    void delete(T entity);

}
