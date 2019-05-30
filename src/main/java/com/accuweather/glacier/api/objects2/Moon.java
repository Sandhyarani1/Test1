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
"Rise",
"EpochRise",
"Set",
"EpochSet",
"Phase",
"Age"
})

public class Moon {
	@JsonProperty("Rise")
	private String rise;
	@JsonProperty("EpochRise")
	private int epochRise;
	@JsonProperty("Set")
	private String set;
	@JsonProperty("EpochSet")
	private int epochSet;
	@JsonProperty("Phase")
	private String phase;
	@JsonProperty("Age")
	private int age;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	* No args constructor for use in serialization
	* 
	*/
	public Moon() {
	}

	/**
	* 
	* @param set
	* @param rise
	* @param age
	* @param epochRise
	* @param phase
	* @param epochSet
	*/
	public Moon(String rise, int epochRise, String set, int epochSet, String phase, int age) {
	super();
	this.rise = rise;
	this.epochRise = epochRise;
	this.set = set;
	this.epochSet = epochSet;
	this.phase = phase;
	this.age = age;
	}

	@JsonProperty("Rise")
	public String getRise() {
	return rise;
	}

	@JsonProperty("Rise")
	public void setRise(String rise) {
	this.rise = rise;
	}

	@JsonProperty("EpochRise")
	public int getEpochRise() {
	return epochRise;
	}

	@JsonProperty("EpochRise")
	public void setEpochRise(int epochRise) {
	this.epochRise = epochRise;
	}

	@JsonProperty("Set")
	public String getSet() {
	return set;
	}

	@JsonProperty("Set")
	public void setSet(String set) {
	this.set = set;
	}

	@JsonProperty("EpochSet")
	public int getEpochSet() {
	return epochSet;
	}

	@JsonProperty("EpochSet")
	public void setEpochSet(int epochSet) {
	this.epochSet = epochSet;
	}

	@JsonProperty("Phase")
	public String getPhase() {
	return phase;
	}

	@JsonProperty("Phase")
	public void setPhase(String phase) {
	this.phase = phase;
	}

	@JsonProperty("Age")
	public int getAge() {
	return age;
	}

	@JsonProperty("Age")
	public void setAge(int age) {
	this.age = age;
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
	return new ToStringBuilder(this).append("rise", rise).append("epochRise", epochRise).append("set", set).append("epochSet", epochSet).append("phase", phase).append("age", age).append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
	return new HashCodeBuilder().append(additionalProperties).append(set).append(rise).append(age).append(epochRise).append(phase).append(epochSet).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
	if (other == this) {
	return true;
	}
	if ((other instanceof Moon) == false) {
	return false;
	}
	Moon rhs = ((Moon) other);
	return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(set, rhs.set).append(rise, rhs.rise).append(age, rhs.age).append(epochRise, rhs.epochRise).append(phase, rhs.phase).append(epochSet, rhs.epochSet).isEquals();
	}
}
