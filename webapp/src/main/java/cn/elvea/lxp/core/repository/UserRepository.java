package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.core.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 *
 * @author elvea
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 用户
     */
    UserEntity findByUsername(String username);

}
