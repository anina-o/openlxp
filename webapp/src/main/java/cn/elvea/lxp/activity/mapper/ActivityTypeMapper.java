package cn.elvea.lxp.activity.mapper;

import cn.elvea.lxp.activity.entity.ActivityTypeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

/**
 * ActivityTypeMapper
 *
 * @author elvea
 */
@Mapper
public interface ActivityTypeMapper extends BaseMapper<ActivityTypeEntity> {

    Optional<ActivityTypeEntity> findByType(@NotNull String type);

}
