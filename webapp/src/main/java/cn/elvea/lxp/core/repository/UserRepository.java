package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.core.entity.UserEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
    Optional<UserEntity> findByUsername(@NotNull String username);





}
