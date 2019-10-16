package cn.elvea.lxp.common.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * BaseEntity
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
public class BaseEntity implements Serializable {

    @TableId
    private Long id;

    public BaseEntity(Long id) {
        this.id = id;
    }

}
