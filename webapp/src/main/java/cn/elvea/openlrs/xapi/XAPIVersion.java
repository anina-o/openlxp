package cn.elvea.openlrs.xapi;

/**
 * XAPIVersion
 *
 * @author elvea
 */
public enum XAPIVersion {
    V103("1.0.3");

    /**
     *
     */
    private final String text;

    /**
     * @param text String
     */
    private XAPIVersion(final String text) {
        this.text = text;
    }

    /**
     * @return {{@link XAPIVersion}}
     */
    public static XAPIVersion latest() {
        return XAPIVersion.values()[0];
    }

}
