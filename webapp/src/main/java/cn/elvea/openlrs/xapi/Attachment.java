package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.net.URL;

/**
 * Attachment
 *
 * @author elveas
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Attachment {
    /**
     *
     */
    private URI usageType;
    /**
     *
     */
    private LanguageMap display;
    /**
     *
     */
    private LanguageMap description;
    /**
     *
     */
    private String contentType;
    /**
     *
     */
    private Integer length;
    /**
     *
     */
    private String sha2;
    /**
     *
     */
    private URL fileUrl;
    /**
     *
     */
    private byte[] content;
}
