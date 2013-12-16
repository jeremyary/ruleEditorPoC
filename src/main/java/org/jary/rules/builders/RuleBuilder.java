package org.jary.rules.builders;

import java.util.Map;

/**
 * @author jary
 * @since Dec/13/2013
 */
public interface RuleBuilder {

    public String getRuleType();

    public String build(Map<String, String> params);
}
