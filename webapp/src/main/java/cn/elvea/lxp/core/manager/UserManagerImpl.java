package cn.elvea.lxp.core.manager;

import cn.elvea.lxp.core.entity.UserEntity;
import cn.elvea.lxp.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Override
    @CachePut(value = CACHE_NAME, key = "#entity.id")
    public UserEntity save(UserEntity entity) {
        return userRepository.save(entity);
    }

    @Cacheable(value = CACHE_NAME, key = "#id")
    public UserEntity findById(Long id) {
        return userRepository.findById(id).get();
    }

    @CacheEvict(value = CACHE_NAME, key = "#id")
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
