package org.jary.rules.ruleTypes;

import org.jary.rules.RuleElement;
import org.jary.rules.builders.RuleMarkup;
import org.jary.rules.enums.OperatorEnum;
import org.jary.rules.enums.RuleEditorEnum;
import org.jary.rules.service.RuleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * rule type for mathematical comparison rules
 *
 * @author jary
 * @since Dec/13/2013
 */
@Component
public class MathEqualityRuleType implements RuleType {

    /**
     * service to return annotation-based rule elements
     */
    @Autowired
    private RuleModelService ruleModelService;

    /**
     * build HTML markup for rule instance for editor UI injection
     *
     * @return String markup for rule entry
     */
    @Override
    public String getMarkup() {

        RuleMarkup ruleMarkup = new RuleMarkup.RuleMarkupBuilder(getClass().getSimpleName())
                .open()
                .addCancel()
                .addAccept()
                .lhs();

        ruleMarkup.append("<select name='operand'>" + getOperands() + "</select>");
        ruleMarkup.append("<select name='operator'>" + getOperators() + "</select>");
        ruleMarkup.append("<input name='constraint' type='number'/>");

        return ruleMarkup.getBuilder()
                .rhs()
                .close();
    }

    /**
     * get annotation-based operands from data model for Vehicle
     *
     * @return String options markup for operands
     */
    private String getOperands() {

        String operands = "";
        for (RuleElement element : ruleModelService.getRuleElements(RuleEditorEnum.OCCUPANT)) {

            if (element.getType().getSimpleName().equalsIgnoreCase("integer")) {
                operands += "<option value='" + element.getName() + "'>" + element.getName() + "</option>";
            }
        }
        return operands;
    }

    /**
     * get operators needed
     *
     * @return String options markup for math operators
     */
    private String getOperators() {

        String options = "";
        for (OperatorEnum operator : OperatorEnum.getByType("math")) {
            options += "<option value='" + operator.getName() + "'>" + operator.getDisplayText() + "</option>";
        }
        return options;
    }
}