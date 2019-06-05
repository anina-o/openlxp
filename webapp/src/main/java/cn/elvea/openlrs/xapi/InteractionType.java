package cn.elvea.openlrs.xapi;

public enum InteractionType {
    /**
     *
     */
    CHOICE("choice"),
    /**
     *
     */
    SEQUENCING("sequencing"),
    /**
     *
     */
    LIKERT("likert"),
    /**
     *
     */
    MATCHING("matching"),
    /**
     *
     */
    PERFORMANCE("performance"),
    /**
     *
     */
    TRUE_FALSE("true-false"),
    /**
     *
     */
    FILL_IN("fill-in"),
    /**
     *
     */
    LONG_FILL_IN("long-fill-in"),
    /**
     *
     */
    NUMERIC("numeric"),
    /**
     *
     */
    OTHER("other");

    private InteractionType(final String text) {
        this.text = text;
    }

    private final String text;
}
