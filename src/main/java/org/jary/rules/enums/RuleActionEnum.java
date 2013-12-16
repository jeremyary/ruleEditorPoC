package org.jary.rules.enums;

/**
 * rule consequence actions for UI editor mapping
 *
 * @author jary
 * @since Dec/16/2013
 */
public enum RuleActionEnum {

    ACTION_1("do something", "System.out.println(\"do something\");"),

    ACTION_2("do something else", "System.out.println(\"do else\");"),

    ACTION_3("do different", "System.out.println(\"do different\");");

    private String displayText;

    private String action;

    private RuleActionEnum(String displayText, String action) {
        this.displayText = displayText;
        this.action = action;
    }

    public String getDisplayText() {
        return displayText;
    }

    public String getAction() {
        return action;
    }
}
