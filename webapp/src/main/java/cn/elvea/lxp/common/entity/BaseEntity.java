package cn.elvea.lxp.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * BaseEntity
 *
 * @author elvea
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    private Long id;
}
