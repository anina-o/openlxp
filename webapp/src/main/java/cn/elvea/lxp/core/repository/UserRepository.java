package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.core.entity.UserEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static cn.elvea.lxp.core.CoreConstants.CACHE_USER_KEY;

/**
 * UserRepository
 *
 * @author elvea
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    /**
     * 根据用户名获取用户
     */
    @Cacheable(value = CACHE_USER_KEY, key = "#username")
    Optional<UserEntity> findByUsername(String username);

    /**
     * 根据用户ID获取用户
     */
    @Override
    @Cacheable(value = CACHE_USER_KEY, key = "#id")
    Optional<UserEntity> findById(Long id);

    /**
     * 删除用户
     */
    @Override
    @Caching(evict = {
            @CacheEvict(value = CACHE_USER_KEY, key = "#entity.id"),
            @CacheEvict(value = CACHE_USER_KEY, key = "#entity.username")
    })
    void delete(UserEntity entity);

}
