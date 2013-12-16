package org.jary.rules.annotations;

import org.jary.rules.enums.RuleEditorEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * annotation for classes whose properties should be exposed to rule editors as rule elements
 *
 * @author jary
 * @since Dec/11/2013
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RuleModel {

    /**
     * optional value that will allow inclusion to specific rule editors only
     * defaults to exposure to ALL rule editors
     *
     * @return {@link org.jary.rules.enums.RuleEditorEnum} array
     */
    RuleEditorEnum[] value() default {RuleEditorEnum.ALL};
}