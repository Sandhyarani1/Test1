
package com.accuweather.glacier.api.objects2;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Value",
"Unit",
"UnitType"
})
public class Speed {

	@JsonProperty("Value")
	private double value;
	@JsonProperty("Unit")
	private String unit;
	@JsonProperty("UnitType")
	private int unitType;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	* No args constructor for use in serialization
	* 
	*/
	public Speed() {
	}

	/**
	* 
	* @param unit
	* @param unitType
	* @param value
	*/
	public Speed(double value, String unit, int unitType) {
	super();
	this.value = value;
	this.unit = unit;
	this.unitType = unitType;
	}

	@JsonProperty("Value")
	public double getValue() {
	return value;
	}

	@JsonProperty("Value")
	public void setValue(double value) {
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
	public int getUnitType() {
	return unitType;
	}

	@JsonProperty("UnitType")
	public void setUnitType(int unitType) {
	this.unitType = unitType;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
	return new ToStringBuilder(this).append("value", value).append("unit", unit).append("unitType", unitType).append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
	return new HashCodeBuilder().append(unit).append(unitType).append(additionalProperties).append(value).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
	if (other == this) {
	return true;
	}
	if ((other instanceof Speed) == false) {
	return false;
	}
	Speed rhs = ((Speed) other);
	return new EqualsBuilder().append(unit, rhs.unit).append(unitType, rhs.unitType).append(additionalProperties, rhs.additionalProperties).append(value, rhs.value).isEquals();
	}

}
