package cn.elvea.lxp.core.mapper;

import cn.elvea.lxp.core.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.jetbrains.annotations.NotNull;

/**
 * UserMapper
 *
 * @author elvea
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 根据用户名获取用户
     */
    UserEntity findByUsername(@NotNull String username);

}
