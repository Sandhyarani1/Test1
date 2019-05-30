package com.accuweather.glacier.api.objects1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Moon {
	@JsonProperty("Rise")
	private String rise;
	@JsonProperty("EpochRise")
	private Integer epochRise;
	@JsonProperty("Set")
	private String set;
	@JsonProperty("EpochSet")
	private Integer epochSet;
	@JsonProperty("Phase")
	private String phase;
	@JsonProperty("Age")
	private Integer age;
	
	public Moon() {
		
	}
	
	public Moon(String rise,Integer epochRise,String set,Integer epochSet,String phase,Integer age) {
		super();
		this.age = age;
		this.epochRise = epochRise;
		this.epochSet = epochSet;
		this.phase = phase;
		this.rise = rise;
		this.set = set;
		
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
	public Integer getEpochRise() {
	return epochRise;
	}

	@JsonProperty("EpochRise")
	public void setEpochRise(Integer epochRise) {
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
	public Integer getEpochSet() {
	return epochSet;
	}

	@JsonProperty("EpochSet")
	public void setEpochSet(Integer epochSet) {
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
	public Integer getAge() {
	return age;
	}

	@JsonProperty("Age")
	public void setAge(Integer age) {
	this.age = age;
	}

	/*
	 * @Override public String toString() { return new
	 * ToStringBuilder(this).append("{").append("rise", rise).append("epochRise",
	 * epochRise).append("set", set).append("epochSet", epochSet).append("phase",
	 * phase).append("age", age).append("}").append(",").toString(); }
	 * 
	 * @Override public int hashCode() { return new
	 * HashCodeBuilder().append(set).append(rise).append(age).append(epochRise).
	 * append(phase).append(epochSet).toHashCode(); }
	 * 
	 * @Override public boolean equals(Object other) { if (other == this) { return
	 * true; } if ((other instanceof Moon) == false) { return false; } Moon rhs =
	 * ((Moon) other); return new EqualsBuilder().append(set, rhs.set).append(rise,
	 * rhs.rise).append(age, rhs.age).append(epochRise, rhs.epochRise).append(phase,
	 * rhs.phase).append(epochSet, rhs.epochSet).isEquals(); }
	 */
}
