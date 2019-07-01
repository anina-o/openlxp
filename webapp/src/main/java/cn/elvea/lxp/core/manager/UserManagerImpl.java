package cn.elvea.lxp.core.manager;

import cn.elvea.lxp.core.entity.UserEntity;
import cn.elvea.lxp.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * UserManagerImpl
 *
 * @author elvea
 */
@Service
public class UserManagerImpl implements UserManager {

    private final static String CACHE_NAME = "lxp-user";

    @Autowired
    UserRepository userRepository;

    /**
     * 保存用户
     *
     * @param entity 用户实体
     */
    @Override
    @Caching(put = {
            @CachePut(value = CACHE_NAME, key = "#entity.id"),
            @CachePut(value = CACHE_NAME, key = "#entity.username")
    })
    public UserEntity save(UserEntity entity) {
        return userRepository.save(entity);
    }

    /**
     * 根据ID查询用户
     *
     * @param id ID
     * @return 用户
     */
    @Override
    @Cacheable(value = CACHE_NAME, key = "#id")
    public UserEntity findById(Long id) {
        return userRepository.findById(id).get();
    }

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户
     */
    @Override
    @Cacheable(value = CACHE_NAME, key = "#username")
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * 删除用户
     *
     * @param entity 用户实体
     */
    @Override
    @Caching(evict = {
            @CacheEvict(value = CACHE_NAME, key = "#entity.id"),
            @CacheEvict(value = CACHE_NAME, key = "#entity.username")
    })
    public void delete(UserEntity entity) {
        userRepository.delete(entity);
    }

}
