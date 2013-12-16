package org.jary.rules.builders;

import org.drools.lang.DrlDumper;
import org.drools.lang.api.DescrFactory;
import org.drools.lang.api.PackageDescrBuilder;
import org.jary.rules.enums.OperatorEnum;
import org.jary.rules.enums.RuleActionEnum;
import org.jary.rules.model.Occupant;
import org.jary.rules.ruleTypes.MathEqualityRuleType;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * build occupant age rule dynamically from provided UI params
 *
 * @author jary
 * @since Dec/13/2013
 */
@Component
public class MathEqualityRuleBuilder implements RuleBuilder {

    /**
     * return the intended rule type for this builder
     *
     * @return String rule type
     */
    @Override
    public String getRuleType() {
        return MathEqualityRuleType.class.getSimpleName();
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
                builder.newRule().name("occupant rule")
                        .lhs()
                        .pattern().type(Occupant.class.getSimpleName()).constraint(params.get("operand") +
                        OperatorEnum.getSymbolByName(params.get("operator")) +
                        params.get("constraint")).end()
                        .end()
                        .rhs("   " + RuleActionEnum.valueOf(params.get("action")).getAction() + "\n")
                        .end().getDescr());
    }
}