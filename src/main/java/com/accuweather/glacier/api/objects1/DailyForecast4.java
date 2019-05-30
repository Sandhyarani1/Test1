package com.accuweather.glacier.api.objects1;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DailyForecast4 {
	
	@JsonProperty("Date")
	private String date;
	@JsonProperty("EpochDate")
	private Integer epochDate;
	@JsonProperty("Sun")
	private String sun;
	@JsonProperty("Moon")
	private Moon moon;
	@JsonProperty("Temperature")
	private static Temperature temperature;
	@JsonProperty("RealFeelTemperature")
	private RealFeelTemperature realFeelTemperature;
	@JsonProperty("RealFeelTemperatureShade")
	private RealFeelTemperatureShade realFeelTemperatureShade;
	@JsonProperty("HoursOfSun")
	private Double hoursOfSun;
	@JsonProperty("AirAndPollen")
	private List<AirAndPollen> airAndPollen;
	@JsonProperty("Day")
	private String day;
	@JsonProperty("Night")
	private Night night;
	@JsonProperty("Sources")
	private List<String> sources;
	@JsonProperty("MobileLink")
	private String mobileLink;
	@JsonProperty("Link")
	private String link;
	
	/**
     * No args constructor for use in serialization
     *
     */
    public DailyForecast4() {
    }
	
	/**
    *
    * @param <moon>
	 * @param date
    * @param epochDate
    * @param sun
    * @param moon
	 * @param day 
    */
   public DailyForecast4(String date, Integer epochDate, String sun, 
	Moon moon,Temperature temperature,RealFeelTemperature realFeelTemperature,
	Double hoursOfSun,List<AirAndPollen> airAndPollen,Night night,List<String> sources,
	String mobileLink,String link, String day)
	 {
       super();
       this.date = date;
       this.epochDate = epochDate;
       this.sun = sun;
       this.moon = moon;
       this.airAndPollen = airAndPollen;
       this.hoursOfSun = hoursOfSun;
       this.moon = moon;
       this.day = day;
       this.night = night;
       this.realFeelTemperature = realFeelTemperature;
       this.sources = sources;
       DailyForecast4.temperature = temperature;
       
   }
	@JsonProperty("Date")
	public String getDate() {
	return date;
	}

	@JsonProperty("Date")
	public void setDate(String date) {
	this.date = date;
	}

	@JsonProperty("EpochDate")
	public Integer getEpochDate() {
	return epochDate;
	}

	@JsonProperty("EpochDate")
	public void setEpochDate(Integer epochDate) {
	this.epochDate = epochDate;
	}

	@JsonProperty("Sun")
	public String getSun() {
	return sun;
	}

	@JsonProperty("Sun")
	public void setSun(String sun) {
	this.sun = sun;
	}

	@JsonProperty("Moon")
	public Moon getMoon() {
	return moon;
	}

	@JsonProperty("Moon")
	public void setMoon(Moon moon) {
	this.moon = moon;
	}

	@JsonProperty("Temperature")
	public static Temperature getTemperature() {
	return temperature;
	}

	@JsonProperty("Temperature")
	public void setTemperature(Temperature temperature) {
	DailyForecast4.temperature = temperature;
	}

	@JsonProperty("RealFeelTemperature")
	public RealFeelTemperature getRealFeelTemperature() {
	return realFeelTemperature;
	}

	@JsonProperty("RealFeelTemperature")
	public void setRealFeelTemperature(RealFeelTemperature realFeelTemperature) {
	this.realFeelTemperature = realFeelTemperature;
	}

	@JsonProperty("RealFeelTemperatureShade")
	public RealFeelTemperatureShade getRealFeelTemperatureShade() {
	return realFeelTemperatureShade;
	}

	@JsonProperty("RealFeelTemperatureShade")
	public void setRealFeelTemperatureShade(RealFeelTemperatureShade realFeelTemperatureShade) {
	this.realFeelTemperatureShade = realFeelTemperatureShade;
	}

	@JsonProperty("HoursOfSun")
	public Double getHoursOfSun() {
	return hoursOfSun;
	}

	@JsonProperty("HoursOfSun")
	public void setHoursOfSun(Double hoursOfSun) {
	this.hoursOfSun = hoursOfSun;
	}

	/*
	 * @JsonProperty("DegreeDaySummary") public DegreeDaySummary
	 * getDegreeDaySummary() { return degreeDaySummary; }
	 * 
	 * @JsonProperty("DegreeDaySummary") public void
	 * setDegreeDaySummary(DegreeDaySummary degreeDaySummary) {
	 * this.degreeDaySummary = degreeDaySummary; }
	 */

	@JsonProperty("AirAndPollen")
	public List<AirAndPollen> getAirAndPollen() {
	return airAndPollen;
	}

	@JsonProperty("AirAndPollen")
	public void setAirAndPollen(List<AirAndPollen> airAndPollen) {
	this.airAndPollen = airAndPollen;
	}

		
	@JsonProperty("Day")
	public String getDay() {
		return day;
	}
	
	@JsonProperty("Day")
	public void setDay(String day) {
	this.day = day;
	}

	@JsonProperty("Night")
	public Night getNight() {
	return night;
	}

	@JsonProperty("Night")
	public void setNight(Night night) {
	this.night = night;
	}

	@JsonProperty("Sources")
	public List<String> getSources() {
	return sources;
	}

	@JsonProperty("Sources")
	public void setSources(List<String> sources) {
	this.sources = sources;
	}

	@JsonProperty("MobileLink")
	public String getMobileLink() {
	return mobileLink;
	}

	@JsonProperty("MobileLink")
	public void setMobileLink(String mobileLink) {
	this.mobileLink = mobileLink;
	}

	@JsonProperty("Link")
	public String getLink() {
	return link;
	}

	@JsonProperty("Link")
	public void setLink(String link) {
	this.link = link;
	}

	@Override
	public String toString() {
	return new ToStringBuilder(this).append("date", date).append("epochDate", epochDate)
	.append("sun", sun).append("moon", moon).append("temperature", temperature)
	.append("realFeelTemperature", realFeelTemperature)
	.append("realFeelTemperatureShade", realFeelTemperatureShade)
	.append("hoursOfSun", hoursOfSun).append("airAndPollen", airAndPollen)
	.append("day", day).append("night", night).append("sources", sources)
	.append("mobileLink", mobileLink).append("link", link).toString();
	}

	@Override
	public int hashCode() {
	return new HashCodeBuilder().append(date).append(epochDate).append(sun).append(moon)
	.append(temperature).append(realFeelTemperature).append(realFeelTemperatureShade).append(hoursOfSun)
	.append(airAndPollen).append(day).append(night).append(sources).append(mobileLink)
	.append(link).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
	if (other == this) {
	return true;
	}
	if ((other instanceof DailyForecast4) == false) {
	return false;
	}
	DailyForecast4 rhs = ((DailyForecast4) other);
	return new EqualsBuilder().append(date, rhs.date)
	.append(epochDate, rhs.epochDate).append(sun, rhs.sun)
	.append(moon, rhs.moon).append(temperature, rhs.temperature).append(realFeelTemperature, rhs.realFeelTemperature)
	.append(realFeelTemperatureShade, rhs.realFeelTemperatureShade).append(hoursOfSun, rhs.hoursOfSun)
	.append(airAndPollen, airAndPollen).append(day, rhs.day).append(night, rhs.night)
	.append(sources, rhs.sources).append(mobileLink, rhs.mobileLink).append(link, rhs.link).isEquals();
	}

}
