package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.joda.time.Period;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Result {
    /**
     *
     */
    private Score score;
    /**
     *
     */
    private Boolean success;
    /**
     *
     */
    private Boolean completion;
    /**
     *
     */
    private Period duration;
    /**
     *
     */
    private String response;
    /**
     *
     */
    private Map<String, XAPIObject> extensions;
}
