package com.accuweather.glacier.api.objects1;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Imperial {

    @JsonProperty("Value")
    private Double value;
    @JsonProperty("Unit")
    private String unit;
    @JsonProperty("UnitType")
    private Integer unitType;

    /**
     * No args constructor for use in serialization
     *
     */
    public Imperial() {
    }

    /**
     *
     * @param unit
     * @param unitType
     * @param value
     */
    public Imperial(Double value, String unit, Integer unitType) {
        super();
        this.value = value;
        this.unit = unit;
        this.unitType = unitType;
    }

    @JsonProperty("Value")
    public Double getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(Double value) {
        this.value = value;
    }

    @JsonProperty("Unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("Unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @JsonProperty("UnitType")
    public Integer getUnitType() {
        return unitType;
    }

    @JsonProperty("UnitType")
    public void setUnitType(Integer unitType) {
        this.unitType = unitType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("value", value).append("unit", unit).append("unitType", unitType).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(unit).append(unitType).append(value).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Imperial) == false) {
            return false;
        }
        Imperial rhs = ((Imperial) other);
        return new EqualsBuilder().append(unit, rhs.unit).append(unitType, rhs.unitType).append(value, rhs.value).isEquals();
    }

}