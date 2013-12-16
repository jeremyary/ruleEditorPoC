package org.jary.rules.enums;

import java.util.*;

/**
 * Enum for operators to handle readable text to operatorEnum symbol conversion
 *
 * @author jary
 * @since Dec/13/2013
 */
public enum OperatorEnum {

    GREATER_THAN(">", "greaterThan", "greater than", "math"),

    LESS_THAN("<", "lessThan", "less than", "math"),

    EQUALS("==", "equals", "equals", "math"),

    GREATER_THAN_EQUALS(">=", "greaterThanEquals", "equals or greater than", "math"),

    LESS_THAN_EQUALS("<=", "lessThanEquals", "equals or less than", "math"),

    TRUE("", "true", "true", "boolean"),

    FALSE("", "false", "false", "boolean");

    private String symbol;

    private String name;

    private String displayText;

    private String type;

    private static Map<String, String> symbolMap = new HashMap<String, String>();
    private static Map<String, List<OperatorEnum>> typeMap = new HashMap<String, List<OperatorEnum>>();

    static {
        for (OperatorEnum operatorEnum : OperatorEnum.values()) {

            symbolMap.put(operatorEnum.getName(), operatorEnum.getSymbol());

            if (!typeMap.containsKey(operatorEnum.getType()))
                typeMap.put(operatorEnum.getType(), new ArrayList<OperatorEnum>());

            typeMap.get(operatorEnum.getType()).add(operatorEnum);
        }
    }

    private OperatorEnum(String symbol, String name, String displayText, String type) {
        this.symbol = symbol;
        this.name = name;
        this.displayText = displayText;
        this.type = type;
    }

    public static String getSymbolByName(String name) {
        return symbolMap.get(name);
    }

    public static List<OperatorEnum> getByType(String type) {
        return typeMap.get(type.toLowerCase());
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getDisplayText() {
        return displayText;
    }

    public String getType() {
        return type;
    }
}