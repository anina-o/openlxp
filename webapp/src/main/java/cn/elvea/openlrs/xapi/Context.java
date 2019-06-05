package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Context
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Context {
    /**
     *
     */
    private UUID registration;
    /**
     *
     */
    private Agent instructor;
    /**
     *
     */
    private Agent team;
    /**
     *
     */
    private ContextActivities contextActivities;
    /**
     *
     */
    private String revision;
    /**
     *
     */
    private String platform;
    /**
     *
     */
    private String language;
    /**
     *
     */
    private StatementRef statement;
    /**
     *
     */
    private Extensions extensions;
}
