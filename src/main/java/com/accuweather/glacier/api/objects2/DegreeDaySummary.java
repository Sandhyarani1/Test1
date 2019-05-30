package com.accuweather.glacier.api.objects2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class DegreeDaySummary {
	@JsonProperty("Heating")
	private Heating heating;
	@JsonProperty("Cooling")
	private Cooling cooling;
	
	public DegreeDaySummary() {}
	
	public DegreeDaySummary(Heating heating,Cooling cooling) {
		super();
		this.heating = heating;
		this.cooling = cooling;
	}
	@JsonProperty("Heating")
	public Heating getHeating() {
	return heating;
	}

	@JsonProperty("Heating")
	public void setHeating(Heating heating) {
	this.heating = heating;
	}

	@JsonProperty("Cooling")
	public Cooling getCooling() {
	return cooling;
	}

	@JsonProperty("Cooling")
	public void setCooling(Cooling cooling) {
	this.cooling = cooling;
	}

	/*
	 * @Override public String toString() { return new
	 * ToStringBuilder(this).append("heating", heating).append("cooling",
	 * cooling).toString(); }
	 * 
	 * @Override public int hashCode() { return new
	 * HashCodeBuilder().append(cooling).append(heating).toHashCode(); }
	 * 
	 * @Override public boolean equals(Object other) { if (other == this) { return
	 * true; } if ((other instanceof DegreeDaySummary) == false) { return false; }
	 * DegreeDaySummary rhs = ((DegreeDaySummary) other); return new
	 * EqualsBuilder().append(cooling, rhs.cooling).append(heating,
	 * rhs.heating).isEquals(); }
	 */
}
