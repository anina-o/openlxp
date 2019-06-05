package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Score {
    /**
     *
     */
    private Double scaled;
    /**
     *
     */
    private Double raw;
    /**
     *
     */
    private Double min;
    /**
     *
     */
    private Double max;
}
