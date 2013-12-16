package org.jary.rules.enums;

/**
 * defines all rule editors so that {@link org.jary.rules.annotations.RuleModel} classes can specify which editors they're exposed to
 *
 * @author jary
 * @since Dec/11/2013
 */
public enum RuleEditorEnum {

    VEHICLE,

    OCCUPANT,

    /**
     * exposed to all rule editors
     */
    ALL
}