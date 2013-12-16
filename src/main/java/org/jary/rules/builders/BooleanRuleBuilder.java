package org.jary.rules.builders;

import org.drools.lang.DrlDumper;
import org.drools.lang.api.DescrFactory;
import org.drools.lang.api.PackageDescrBuilder;
import org.jary.rules.enums.RuleActionEnum;
import org.jary.rules.model.Vehicle;
import org.jary.rules.ruleTypes.BooleanRuleType;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author jary
 * @since Dec/13/2013
 */
@Component
public class BooleanRuleBuilder implements RuleBuilder {

    /**
     * return the intended rule type for this builder
     *
     * @return String rule type
     */
    @Override
    public String getRuleType() {
        return BooleanRuleType.class.getSimpleName();
    }

    /**
     * build the DRL rule from params input and known format needed for rule type
     *
     * @param params info from editor UI
     * @return String DRL rule representation
     */
    @Override
    public String build(Map<String, String> params) {

        PackageDescrBuilder builder = DescrFactory.newPackage().name("org.jary.rules");

        return new DrlDumper().dump(
                builder.newRule().name("maintenance rule")
                        .lhs()
                        .pattern().type(Vehicle.class.getSimpleName()).constraint(
                        (params.get("operator").equalsIgnoreCase("true") ? "" : "!") + params.get("operand")).end()
                        .end()
                        .rhs("   " + RuleActionEnum.valueOf(params.get("action")).getAction() + "\n")
                        .end().getDescr());
    }
}