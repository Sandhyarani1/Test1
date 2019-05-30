package com.accuweather.glacier.api.objects2;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DailyForeCast1 {
	@JsonProperty("Headline")
	private Headline2 headline;
	@JsonProperty("DailyForecasts")
	private List<DailyForecast4> dailyForecasts;
	//private List<DailyForecast> dailyForecasts = new ArrayList<>();
	
	public DailyForeCast1() {}
	
	public DailyForeCast1(Headline2 headline,List<DailyForecast4> dailyForecasts) {
		super();
		this.headline = headline;
		this.dailyForecasts = dailyForecasts;
	}
	
	@JsonProperty("DailyForecasts")
	public List<DailyForecast4> getDailyForecasts() {
	return dailyForecasts;
	}

	@JsonProperty("DailyForecasts")
	public void setDailyForecasts(List<DailyForecast4> dailyForecasts) {
	this.dailyForecasts = dailyForecasts;
	}

		
	  @Override public String toString() { return new
	  ToStringBuilder(this).append("{\r\n").append("\"Headline\":").append("{\r\n")
	  .append("headline",
	  headline).append("},\r\n").append("\"DailyForecasts\":").append("[").append(
	  "{\r\n").append("dailyForecasts",
	  dailyForecasts).append("}").append("]\r\n").append("}").toString(); }
	 
	  
	  @Override public int hashCode() { return new
	  HashCodeBuilder().append(headline).append(dailyForecasts).toHashCode(); }
	  
	  @Override public boolean equals(Object other) { if (other == this) { return
	  true; } if ((other instanceof DailyForeCast1) == false) { return false; }
	  DailyForeCast1 rhs = ((DailyForeCast1) other); return new
	  EqualsBuilder().append(headline, rhs.headline).append(dailyForecasts,
	  rhs.dailyForecasts).isEquals(); }
	 
	 
}
