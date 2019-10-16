package cn.elvea.lxp.core.mapper;

import cn.elvea.lxp.core.entity.RoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.jetbrains.annotations.NotNull;

/**
 * RoleMapper
 *
 * @author elvea
 */
@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {
    /**
     * 根据用户ID获取用户
     */
    RoleEntity findById(@NotNull Long id);

    /**
     * 保存用户
     */
    <S extends RoleEntity> S save(@NotNull S entity);

    /**
     * 删除用户
     */
    void delete(@NotNull RoleEntity entity);

    /**
     * 清空缓存
     */
    default void clear() {
    }

}
