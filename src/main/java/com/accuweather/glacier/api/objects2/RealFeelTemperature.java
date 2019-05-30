
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
"Minimum",
"Maximum"
})


public class RealFeelTemperature {

	@JsonProperty("Minimum")
	private Minimum minimum;
	@JsonProperty("Maximum")
	private Maximum maximum;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	* No args constructor for use in serialization
	* 
	*/
	public RealFeelTemperature() {
	}

	/**
	* 
	* @param minimum
	* @param maximum
	*/
	public RealFeelTemperature(Minimum minimum, Maximum maximum) {
	super();
	this.minimum = minimum;
	this.maximum = maximum;
	}

	@JsonProperty("Minimum")
	public Minimum getMinimum() {
	return minimum;
	}

	@JsonProperty("Minimum")
	public void setMinimum(Minimum minimum) {
	this.minimum = minimum;
	}

	@JsonProperty("Maximum")
	public Maximum getMaximum() {
	return maximum;
	}

	@JsonProperty("Maximum")
	public void setMaximum(Maximum maximum) {
	this.maximum = maximum;
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
	return new ToStringBuilder(this).append("minimum", minimum).append("maximum", maximum).append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
	return new HashCodeBuilder().append(minimum).append(additionalProperties).append(maximum).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
	if (other == this) {
	return true;
	}
	if ((other instanceof RealFeelTemperature) == false) {
	return false;
	}
	RealFeelTemperature rhs = ((RealFeelTemperature) other);
	return new EqualsBuilder().append(minimum, rhs.minimum).append(additionalProperties, rhs.additionalProperties).append(maximum, rhs.maximum).isEquals();
	}


}
