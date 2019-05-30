package com.accuweather.glacier.api.objects2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Date",
"EpochDate",
"Sun",
"Moon",
"Temperature",
"RealFeelTemperature",
"RealFeelTemperatureShade",
"HoursOfSun",
"DegreeDaySummary",
"AirAndPollen",
"Day",
"Night",
"Sources",
"MobileLink",
"Link"
})

public class DailyForecast {

	@JsonProperty("Date")
	private String date;
	@JsonProperty("EpochDate")
	private int epochDate;
	@JsonProperty("Sun")
	private Sun sun;
	@JsonProperty("Moon")
	private Moon moon;
	@JsonProperty("Temperature")
	private Temperature temperature;
	@JsonProperty("RealFeelTemperature")
	private RealFeelTemperature realFeelTemperature;
	@JsonProperty("RealFeelTemperatureShade")
	private RealFeelTemperatureShade realFeelTemperatureShade;
	@JsonProperty("HoursOfSun")
	private double hoursOfSun;
	@JsonProperty("DegreeDaySummary")
	private DegreeDaySummary degreeDaySummary;
	@JsonProperty("AirAndPollen")
	private List<AirAndPollen> airAndPollen = new LinkedList<AirAndPollen>();
	@JsonProperty("Day")
	private Day day;
	@JsonProperty("Night")
	private Night night;
	@JsonProperty("Sources")
	private List<String> sources = new LinkedList<String>();
	@JsonProperty("MobileLink")
	private String mobileLink;
	@JsonProperty("Link")
	private String link;

	/*
	 * @JsonIgnore private Map<String, Object> additionalProperties = new
	 * HashMap<String, Object>();
	 */
	/**
	* No args constructor for use in serialization
	* 
	*/
	public DailyForecast() {
	}

	/**
	* 
	* @param realFeelTemperatureShade
	* @param moon
	* @param realFeelTemperature
	* @param epochDate
	* @param link
	* @param degreeDaySummary
	* @param date
	* @param sources
	* @param sun
	* @param temperature
	* @param mobileLink
	* @param night
	* @param day
	* @param airAndPollen
	* @param hoursOfSun
	*/
	//@JsonCreator
	//public DailyForecast(@JsonProperty("Date")String date, @JsonProperty("EpochDate")int epochDate,
			//@JsonProperty("Sun")Sun sun, @JsonProperty("Moon")Moon moon, 
			//@JsonProperty("Temperature")Temperature temperature, 
			//@JsonProperty("RealFeelTemperatureShade")RealFeelTemperature realFeelTemperature, 
			//@JsonProperty("HoursOfSun")RealFeelTemperatureShade realFeelTemperatureShade, 
			//double hoursOfSun, @JsonProperty("DegreeDaySummary")DegreeDaySummary degreeDaySummary, 
			//@JsonProperty("AirAndPollen")List<AirAndPollen> airAndPollen, @JsonProperty("Day")Day day, 
			//@JsonProperty("Night")Night night, @JsonProperty("Sources")List<String> sources, 
			//@JsonProperty("MobileLink")String mobileLink, @JsonProperty("Link")String link) 
	public DailyForecast(String date,int epochDate,
			Sun sun, Moon moon, 
			Temperature temperature, 
			RealFeelTemperature realFeelTemperature, 
			RealFeelTemperatureShade realFeelTemperatureShade, 
			double hoursOfSun, DegreeDaySummary degreeDaySummary, 
			List<AirAndPollen> airAndPollen, Day day, 
			Night night,List<String> sources, 
			String mobileLink,String link) 
	{
	super();
	this.date = date;
	this.epochDate = epochDate;
	this.sun = sun;
	this.moon = moon;
	this.temperature = temperature;
	this.realFeelTemperature = realFeelTemperature;
	this.realFeelTemperatureShade = realFeelTemperatureShade;
	this.hoursOfSun = hoursOfSun;
	this.degreeDaySummary = degreeDaySummary;
	this.airAndPollen = airAndPollen;
	this.day = day;
	this.night = night;
	this.sources = sources;
	this.mobileLink = mobileLink;
	this.link = link;
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
	public int getEpochDate() {
	return epochDate;
	}

	@JsonProperty("EpochDate")
	public void setEpochDate(int epochDate) {
	this.epochDate = epochDate;
	}

	@JsonProperty("Sun")
	public Sun getSun() {
	return sun;
	}

	@JsonProperty("Sun")
	public void setSun(Sun sun) {
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
	public Temperature getTemperature() {
	return temperature;
	}

	@JsonProperty("Temperature")
	public void setTemperature(Temperature temperature) {
	this.temperature = temperature;
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
	public double getHoursOfSun() {
	return hoursOfSun;
	}

	@JsonProperty("HoursOfSun")
	public void setHoursOfSun(double hoursOfSun) {
	this.hoursOfSun = hoursOfSun;
	}

	@JsonProperty("DegreeDaySummary")
	public DegreeDaySummary getDegreeDaySummary() {
	return degreeDaySummary;
	}

	@JsonProperty("DegreeDaySummary")
	public void setDegreeDaySummary(DegreeDaySummary degreeDaySummary) {
	this.degreeDaySummary = degreeDaySummary;
	}

	@JsonProperty("AirAndPollen")
	public List<AirAndPollen> getAirAndPollen() {
	return airAndPollen;
	}

	@JsonProperty("AirAndPollen")
	public void setAirAndPollen(List<AirAndPollen> airAndPollen) {
	this.airAndPollen = airAndPollen;
	}

	@JsonProperty("Day")
	public Day getDay() {
	return day;
	}

	@JsonProperty("Day")
	public void setDay(Day day) {
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

	/*
	 * @JsonAnyGetter public Map<String, Object> getAdditionalProperties() { return
	 * this.additionalProperties; }
	 * 
	 * @JsonAnySetter public void setAdditionalProperty(String name, Object value) {
	 * this.additionalProperties.put(name, value); }
	 */
	
	@Override
	public String toString() {
	return new ToStringBuilder(this).append("date", date).append("epochDate", epochDate).append("sun", sun).append("moon", moon).append("temperature", temperature).append("realFeelTemperature", realFeelTemperature).append("realFeelTemperatureShade", realFeelTemperatureShade).append("hoursOfSun", hoursOfSun).append("degreeDaySummary", degreeDaySummary).append("airAndPollen", airAndPollen).append("day", day).append("night", night).append("sources", sources).append("mobileLink", mobileLink).append("link", link).toString();
	}

	@Override
	public int hashCode() {
	return new HashCodeBuilder().append(realFeelTemperatureShade).append(realFeelTemperature).append(moon).append(epochDate).append(link).append(degreeDaySummary).append(date).append(sources).append(sun).append(temperature).append(mobileLink).append(night).append(day).append(airAndPollen).append(hoursOfSun).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
	if (other == this) {
	return true;
	}
	if ((other instanceof DailyForecast) == false) {
	return false;
	}
	DailyForecast rhs = ((DailyForecast) other);
	return new EqualsBuilder().append(realFeelTemperatureShade, rhs.realFeelTemperatureShade).append(realFeelTemperature, rhs.realFeelTemperature).append(moon, rhs.moon).append(epochDate, rhs.epochDate).append(link, rhs.link).append(degreeDaySummary, rhs.degreeDaySummary).append(date, rhs.date).append(sources, rhs.sources).append(sun, rhs.sun).append(temperature, rhs.temperature).append(mobileLink, rhs.mobileLink).append(night, rhs.night).append(day, rhs.day).append(airAndPollen, rhs.airAndPollen).append(hoursOfSun, rhs.hoursOfSun).isEquals();
	}

	/*
	 * @Override public String toString() { return new
	 * ToStringBuilder(this).append("date", date).append("epochDate",
	 * epochDate).append("sun", sun).append("moon", moon).append("temperature",
	 * temperature).append("realFeelTemperature",
	 * realFeelTemperature).append("realFeelTemperatureShade",
	 * realFeelTemperatureShade).append("hoursOfSun",
	 * hoursOfSun).append("degreeDaySummary",
	 * degreeDaySummary).append("airAndPollen", airAndPollen).append("day",
	 * day).append("night", night).append("sources", sources).append("mobileLink",
	 * mobileLink).append("link", link).append("additionalProperties",
	 * additionalProperties).toString(); }
	 * 
	 * @Override public int hashCode() { return new
	 * HashCodeBuilder().append(realFeelTemperatureShade).append(realFeelTemperature
	 * ).append(moon).append(epochDate).append(link).append(degreeDaySummary).append
	 * (date).append(sources).append(sun).append(temperature).append(mobileLink).
	 * append(additionalProperties).append(night).append(day).append(airAndPollen).
	 * append(hoursOfSun).toHashCode(); }
	 * 
	 * @Override public boolean equals(Object other) { if (other == this) { return
	 * true; } if ((other instanceof DailyForecast) == false) { return false; }
	 * DailyForecast rhs = ((DailyForecast) other); return new
	 * EqualsBuilder().append(realFeelTemperatureShade,
	 * rhs.realFeelTemperatureShade).append(realFeelTemperature,
	 * rhs.realFeelTemperature).append(moon, rhs.moon).append(epochDate,
	 * rhs.epochDate).append(link, rhs.link).append(degreeDaySummary,
	 * rhs.degreeDaySummary).append(date, rhs.date).append(sources,
	 * rhs.sources).append(sun, rhs.sun).append(temperature,
	 * rhs.temperature).append(mobileLink,
	 * rhs.mobileLink).append(additionalProperties,
	 * rhs.additionalProperties).append(night, rhs.night).append(day,
	 * rhs.day).append(airAndPollen, rhs.airAndPollen).append(hoursOfSun,
	 * rhs.hoursOfSun).isEquals(); }
	 */
}
