package com.accuweather.glacier.api.objects1;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class DailyForeCast2 {
	//@JsonProperty("Headline")
	private Headline2 headline;
	//@JsonProperty("DailyForecasts")
	private List<DailyForecast4> dailyForecasts;
	
	/*
	 * public DailyForeCast2(Headline headline,List<DailyForecast> dailyForecasts) {
	 * super(); this.headline = headline; this.dailyForecasts = dailyForecasts; }
	 */
	
	
	//@JsonProperty("Headline")
	public Headline2 getHeadline() {
		return headline;
	}


	//@JsonProperty("Headline")
	public void setHeadline(Headline2 headline) {
		this.headline = headline;
	}



	//@JsonProperty("DailyForecasts")
	public List<DailyForecast4> getDailyForecasts() {
	return dailyForecasts;
	}

	//@JsonProperty("DailyForecasts")
	public void setDailyForecasts(List<DailyForecast4> dailyForecasts) {
	this.dailyForecasts = dailyForecasts;
	}

	@Override
	public String toString() {
	return new ToStringBuilder(this).append("headline", headline).append("dailyForecasts", dailyForecasts).toString();
	}

	@Override
	public int hashCode() {
	return new HashCodeBuilder().append(headline).append(dailyForecasts).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
	if (other == this) {
	return true;
	}
	if ((other instanceof DailyForeCast2) == false) {
	return false;
	}
	DailyForeCast2 rhs = ((DailyForeCast2) other);
	return new EqualsBuilder().append(headline, rhs.headline).append(dailyForecasts, rhs.dailyForecasts).isEquals();
	}
}
