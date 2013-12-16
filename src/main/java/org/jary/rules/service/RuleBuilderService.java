package org.jary.rules.service;

import org.jary.rules.builders.RuleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * service class that will dynamically build a rule based on editor UI input
 *
 * @author jary
 * @since Dec/13/2013
 */
@Component
public class RuleBuilderService {

    @Autowired
    List<RuleBuilder> ruleBuilders;

    public String build(Map<String, String> params) {

        if(params.get("ruleType") == null || params.get("ruleType").isEmpty())
            throw new IllegalArgumentException("parameter ruleType required");

        for (RuleBuilder builder : ruleBuilders) {
            if (builder.getRuleType().equals(params.get("ruleType")))
                return builder.build(params);
        }

        throw new IllegalStateException("no builder could be found for ruleType " + params.get("ruleType"));
    }
}
