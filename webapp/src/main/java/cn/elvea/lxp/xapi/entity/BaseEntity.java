package cn.elvea.lxp.xapi.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * BaseEntity
 *
 * @author elvea
 */
@Data
public abstract class BaseEntity implements Serializable {
    /**
     * ID
     */
    @Id
    String objectId;
}
