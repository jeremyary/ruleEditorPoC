package org.jary.rules.builders;

import org.jary.rules.enums.RuleActionEnum;

/**
 * builder class providing rule types' common HTML markup elements
 *
 * @author jary
 * @since Dec/16/2013
 */
public class RuleMarkup {

    private String ruleType;

    private String markup;

    private RuleMarkupBuilder builder;

    public RuleMarkup(String ruleType) {
        this.ruleType = ruleType;
        this.markup = "";
    }

    public void append(String markup) {
        this.markup += markup;
    }

    public RuleMarkupBuilder getBuilder() {
        return builder;
    }

    public static class RuleMarkupBuilder {

        private RuleMarkup ruleMarkup;

        public RuleMarkupBuilder(String ruleType) {
            this.ruleMarkup = new RuleMarkup(ruleType);
            this.ruleMarkup.builder = this;
        }

        public RuleMarkupBuilder open() {
            this.ruleMarkup.markup += "<div class='ruleStage'>";
            return this;
        }

        public RuleMarkupBuilder addCancel() {
            this.ruleMarkup.markup += "<div class='cancel'>&nbsp;</div>";
            return this;
        }

        public RuleMarkupBuilder addAccept() {
            this.ruleMarkup.markup += "<div class='accept'>&nbsp;</div>";
            return this;
        }

        public RuleMarkup lhs() {
            this.ruleMarkup.markup += "<div class='when'>WHEN:</div><form class='ruleForm'>" +
                    "<input type='hidden' name='ruleType' value='" + this.ruleMarkup.ruleType + "'/><div class='lhs'>";
            return this.ruleMarkup;
        }

        public RuleMarkupBuilder rhs() {
            this.ruleMarkup.markup += "</div><div class='then'>THEN:</div><div class='rhs'><select name='action' class='action'>";
            for(RuleActionEnum action : RuleActionEnum.values()) {
                this.ruleMarkup.markup += "<option  value='" + action.toString() + "'>" + action.getDisplayText() + "</option>";
            }
            return this;
        }

        public String close() {
            return this.ruleMarkup.markup;
        }
    }
}