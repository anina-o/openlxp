package cn.elvea.lxp.activity.repository;

import cn.elvea.lxp.activity.entity.ActivityTypeEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * ActivityTypeRepository
 *
 * @author elvea
 */
@Repository
public interface ActivityTypeRepository extends PagingAndSortingRepository<ActivityTypeEntity, Long> {

    Optional<ActivityTypeEntity> findByType(@NotNull String type);

}
