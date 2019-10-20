package cn.elvea.lxp.core.system.mapper;

import cn.elvea.lxp.core.system.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

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
    UserEntity findByUsername(@NotNull @Param("condition") Map<String, Object> condition);

    /**
     * 根据邮箱获取用户
     */
    UserEntity findByEmail(@NotNull @Param("condition") Map<String, Object> condition);

    /**
     * 根据手机号码获取用户
     */
    UserEntity findByMobile(@NotNull @Param("condition") Map<String, Object> condition);

}
