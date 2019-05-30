package com.accuweather.glacier.api.objects1;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Sun {
	@JsonProperty("Rise")
	private String rise;
	@JsonProperty("EpochRise")
	private Integer epochRise;
	@JsonProperty("Set")
	private String set;
	@JsonProperty("EpochSet")
	private Integer epochSet;
	
	public Sun() {}
	
	public Sun(String rise,Integer epochRise,String set,Integer epochSet) 
	{
	 super();
	 this.epochRise = epochRise;
	 this.epochSet = epochSet;
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

	/*
	 * @Override public String toString() { return new
	 * ToStringBuilder(this).append("\"Sun\":").append("{\r\n").append("rise",
	 * rise).append(":").append("epochRise", epochRise).append("set",
	 * set).append("epochSet", epochSet).append("}").toString(); }
	 * 
	 * @Override public int hashCode() { return new
	 * HashCodeBuilder().append(set).append(rise).append(epochRise).append(epochSet)
	 * .toHashCode(); }
	 * 
	 * @Override public boolean equals(Object other) { if (other == this) { return
	 * true; } if ((other instanceof Sun) == false) { return false; } Sun rhs =
	 * ((Sun) other); return new EqualsBuilder().append(set, rhs.set).append(rise,
	 * rhs.rise).append(epochRise, rhs.epochRise).append(epochSet,
	 * rhs.epochSet).isEquals(); }
	 */
}
