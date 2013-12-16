package org.jary.rules.model;

import org.jary.rules.enums.RuleEditorEnum;
import org.jary.rules.annotations.RuleModel;
import org.jary.rules.annotations.RuleModelExclusion;

/**
 * @author jary
 * @since Dec/11/2013
 */
@RuleModel
public class Occupant {

    private String name;
    private Integer age;
    private Integer accidents;
    private Integer tickets;
    private boolean isLicensed;
    private String SSN;

    @RuleModelExclusion(RuleEditorEnum.VEHICLE)
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isLicensed() {
        return isLicensed;
    }

    @RuleModelExclusion
    public String getSSN() {
        return SSN;
    }

    @RuleModelExclusion(RuleEditorEnum.VEHICLE)
    public Integer getAccidents() {
        return accidents;
    }

    @RuleModelExclusion(RuleEditorEnum.VEHICLE)
    public Integer getTickets() {
        return tickets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setLicensed(boolean isLicensed) {
        this.isLicensed = isLicensed;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
}