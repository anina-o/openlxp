package cn.elvea.lxp.core.mapper;

import cn.elvea.lxp.core.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * UserRoleRelationMapper
 *
 * @author elvea
 */
@Mapper
public interface UserRoleRelationMapper extends BaseMapper<UserEntity> {

    /**
     * 查询用户所有权限的ID集合
     */
    List<Long> findByUserId(@Param("userId") Long userId);

    /**
     * 删除用户所有角色关联
     */
    void deleteByUserId(@Param("userId") Long userId);

}
