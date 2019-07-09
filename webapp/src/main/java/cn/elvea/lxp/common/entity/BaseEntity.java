package cn.elvea.lxp.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * BaseEntity
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "SnowflakeGenerator")
    @GenericGenerator(name = "SnowflakeGenerator",
            strategy = "cn.elvea.lxp.common.jpa.SnowflakeGenerator")
    private Long id;

}
