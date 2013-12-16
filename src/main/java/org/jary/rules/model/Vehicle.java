package org.jary.rules.model;

import org.jary.rules.enums.RuleEditorEnum;
import org.jary.rules.annotations.RuleModel;
import org.jary.rules.annotations.RuleModelExclusion;

import java.util.Date;

/**
 * @author jary
 * @since Dec/11/2013
 */
@RuleModel
public class Vehicle {

    private String model;
    private Date productionDate;
    private Integer capacity;
    private boolean isMaintenanceRequired;
    private boolean isFull;

    public String getModel() {
        return model;
    }

    @RuleModelExclusion
    public Date getProductionDate() {
        return productionDate;
    }

    @RuleModelExclusion(RuleEditorEnum.OCCUPANT)
    public Integer getCapacity() {
        return capacity;
    }

    @RuleModelExclusion(RuleEditorEnum.OCCUPANT)
    public boolean isMaintenanceRequired() {
        return isMaintenanceRequired;
    }

    @RuleModelExclusion(RuleEditorEnum.VEHICLE)
    public boolean isFull() {
        return isFull;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setMaintenanceRequired(boolean isMaintenanceRequired) {
        this.isMaintenanceRequired = isMaintenanceRequired;
    }

    public void setFull(boolean isFull) {
        this.isFull = isFull;
    }
}