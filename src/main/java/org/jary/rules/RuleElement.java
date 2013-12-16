package org.jary.rules;

import java.lang.reflect.Method;

/**
 * @author jary
 * @since Dec/11/2013
 */
public class RuleElement {

    private Class ownerType;
    private String name;
    private Class type;
    private Method readMethod;

    public RuleElement(String name, Class type, Method readMethod, Class ownerType) {
        setName(name);
        setType(type);
        setReadMethod(readMethod);
        setOwnerType(ownerType);
    }

    public Class getOwnerType() {
        return ownerType;
    }

    public String getName() {
        return name;
    }

    public Class getType() {
        return type;
    }

    public Method getReadMethod() {
        return readMethod;
    }

    public void setOwnerType(Class ownerType) {
        this.ownerType = ownerType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public void setReadMethod(Method readMethod) {
        this.readMethod = readMethod;
    }
}