package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ContextActivities {
    /**
     *
     */
    private List<Activity> parent;
    /**
     *
     */
    private List<Activity> grouping;
    /**
     *
     */
    private List<Activity> other;
    /**
     *
     */
    private List<Activity> category;
}
