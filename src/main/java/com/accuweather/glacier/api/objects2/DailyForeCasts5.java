package com.accuweather.glacier.api.objects2;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DailyForeCasts5 {
	@JsonProperty("Headline")
	private Headline2 headline;
	@JsonProperty("DailyForecasts")
	private List<DailyForecast4> dailyForecasts;
	//private List<Object> dailyForecasts;
	//private List<DailyForecast> dailyForecasts = new ArrayList<DailyForecast>();
	// private DailyForecast dailyForecasts;
	
	  @JsonProperty("Date") private String date;
	  
	  @JsonProperty("EpochDate") private Integer epochDate;
	  
	  @JsonProperty("Sun") private Sun sun;
	  
	  @JsonProperty("Moon") private Moon moon;
	  
	  @JsonProperty("Temperature") private Temperature temperature;
	  
	  @JsonProperty("RealFeelTemperature") private RealFeelTemperature
	  realFeelTemperature;
	  
	  @JsonProperty("RealFeelTemperatureShade") private RealFeelTemperatureShade
	  realFeelTemperatureShade;
	  
	  @JsonProperty("HoursOfSun") private Double hoursOfSun;
	  
	  @JsonProperty("DegreeDaySummary") private DegreeDaySummary degreeDaySummary;
	  
	  @JsonProperty("AirAndPollen") private List<AirAndPollen> airAndPollen = new
	  ArrayList<AirAndPollen>(); // private AirAndPollen airAndPollen;
	  
	  @JsonProperty("Day") private Day day;
	  
	  @JsonProperty("Night") private Night night;
	  
	  @JsonProperty("Sources") private List<String> sources; // private String 	  sources;
	  
	  @JsonProperty("MobileLink") private String mobileLink;
	  
	  @JsonProperty("Link") private String link;
	 

	public DailyForeCasts5() {
	}

	//public DailyForeCasts(Headline headline, List<DailyForecast> dailyForecasts)
	//public DailyForeCasts(List<DailyForecast> dailyForecasts)
	
	  public DailyForeCasts5(Headline2 headline, List<DailyForecast4> dailyForecasts,
	  String date, Integer epochDate, Sun sun, Moon moon, Temperature temperature,
	  RealFeelTemperature realFeelTemperature, RealFeelTemperatureShade
	  realFeelTemperatureShade, Double hoursOfSun, DegreeDaySummary
	  degreeDaySummary, List<AirAndPollen> airAndPollen, Day day, Night night,
	  List<String> sources, String mobileLink, String link)
	 
	/*
	 * public DailyForeCasts(String date,Integer epochDate,Sun sun,Moon
	 * moon,Temperature temperature, RealFeelTemperature
	 * realFeelTemperature,RealFeelTemperatureShade realFeelTemperatureShade, Double
	 * hoursOfSun,DegreeDaySummary degreeDaySummary,List<AirAndPollen> airAndPollen,
	 * Day day,Night night,List<String> sources,String mobileLink,String link)
	 */
	{
		super();
		this.headline = headline;
		this.dailyForecasts = dailyForecasts;
		
		  this.date = date; this.epochDate = epochDate; this.sun = sun; this.moon =
		  moon; this.temperature = temperature; this.realFeelTemperature =
		  realFeelTemperature; this.realFeelTemperatureShade =
		  realFeelTemperatureShade; this.hoursOfSun = hoursOfSun; this.degreeDaySummary
		  = degreeDaySummary; this.airAndPollen = airAndPollen; this.day = day;
		  this.night = night; this.sources = sources; this.mobileLink = mobileLink;
		  this.link = link;
		 

	}

	
	  @JsonProperty("Headline") public Headline2 getHeadline() { return headline; }
	 

	
	  @JsonProperty("Headline") public void setHeadline(Headline2 headline) {
	  this.headline = headline; }
	 

	/*
	 * @JsonProperty("DailyForecasts") public List<DailyForecast>
	 * getDailyForecasts() { return dailyForecasts; }
	 */
	@JsonProperty("DailyForecasts")
	public List<DailyForecast4> getDailyForecasts() {
		return dailyForecasts;
	}

	@JsonProperty("DailyForecasts")
	public void setDailyForecasts(List<DailyForecast4> dailyForecasts) {
		this.dailyForecasts = dailyForecasts;
	}

	
	  @JsonProperty("Date") public String getDate() { return date; }
	  
	  @JsonProperty("Date") public void setDate(String date) { this.date = date; }
	  
	  @JsonProperty("EpochDate") public Integer getEpochDate() { return epochDate;
	  }
	  
	  @JsonProperty("EpochDate") public void setEpochDate(Integer epochDate) {
	  this.epochDate = epochDate; }
	  
	  @JsonProperty("Sun") public Sun getSun() { return sun; }
	  
	  @JsonProperty("Sun") public void setSun(Sun sun) { this.sun = sun; }
	  
	  @JsonProperty("Moon") public Moon getMoon() { return moon; }
	  
	  @JsonProperty("Moon") public void setMoon(Moon moon) { this.moon = moon; }
	  
	  @JsonProperty("Temperature") public Temperature getTemperature() { return
	  temperature; }
	  
	  @JsonProperty("Temperature") public void setTemperature(Temperature
	  temperature) { this.temperature = temperature; }
	  
	  @JsonProperty("RealFeelTemperature") public RealFeelTemperature
	  getRealFeelTemperature() { return realFeelTemperature; }
	  
	  @JsonProperty("RealFeelTemperature") public void
	  setRealFeelTemperature(RealFeelTemperature realFeelTemperature) {
	  this.realFeelTemperature = realFeelTemperature; }
	  
	  @JsonProperty("RealFeelTemperatureShade") public RealFeelTemperatureShade
	  getRealFeelTemperatureShade() { return realFeelTemperatureShade; }
	  
	  @JsonProperty("RealFeelTemperatureShade") public void
	  setRealFeelTemperatureShade(RealFeelTemperatureShade
	  realFeelTemperatureShade) { this.realFeelTemperatureShade =
	  realFeelTemperatureShade; }
	  
	  @JsonProperty("HoursOfSun") public Double getHoursOfSun() { return
	  hoursOfSun; }
	  
	  @JsonProperty("HoursOfSun") public void setHoursOfSun(Double hoursOfSun) {
	  this.hoursOfSun = hoursOfSun; }
	  
	  @JsonProperty("DegreeDaySummary") public DegreeDaySummary
	  getDegreeDaySummary() { return degreeDaySummary; }
	  
	  @JsonProperty("DegreeDaySummary") public void
	  setDegreeDaySummary(DegreeDaySummary degreeDaySummary) {
	  this.degreeDaySummary = degreeDaySummary; }
	  
	  @JsonProperty("AirAndPollen") public List<AirAndPollen> getAirAndPollen() {
	  return airAndPollen; }
	  
	  @JsonProperty("AirAndPollen") public void setAirAndPollen(List<AirAndPollen>
	  airAndPollen) { this.airAndPollen = airAndPollen; }
	  
	  @JsonProperty("Day") public Day getDay() { return day; }
	  
	  @JsonProperty("Day") public void setDay(Day day) { this.day = day; }
	  
	  @JsonProperty("Night") public Night getNight() { return night; }
	  
	  @JsonProperty("Night") public void setNight(Night night) { this.night =
	  night; }
	  
	  @JsonProperty("Sources") public List<String> getSources() { return sources; }
	  
	  @JsonProperty("Sources") public void setSources(List<String> sources) {
	  this.sources = sources; }
	  
	  @JsonProperty("MobileLink") public String getMobileLink() { return
	  mobileLink; }
	  
	  @JsonProperty("MobileLink") public void setMobileLink(String mobileLink) {
	  this.mobileLink = mobileLink; }
	  
	  @JsonProperty("Link") public String getLink() { return link; }
	  
	  @JsonProperty("Link") public void setLink(String link) { this.link = link; }
	 
	

	/*
	 * @Override public String toString() { return new ToStringBuilder(this).append
	 * ("headline", headline).append( "dailyForecasts", dailyForecasts).toString();
	 * }
	 * 
	 * @Override public int hashCode() { return new
	 * HashCodeBuilder().append("{\"Headline\":").append
	 * (headline).append(dailyForecasts).toHashCode(); }
	 * 
	 * @Override public boolean equals(Object other) { if (other == this) { return
	 * true; } if ((other instanceof DailyForeCasts) == false) { return false; }
	 * DailyForeCasts rhs = ((DailyForeCasts) other); return new
	 * EqualsBuilder().append(headline,rhs.headline).append(dailyForecasts,rhs.
	 * dailyForecasts).isEquals(); }
	 */
	
	/*
	 * @Override public String toString() { return new
	 * ToStringBuilder(this).append("{").append("{\"Headline\":").append("{").append
	 * ("headline", headline)
	 * .append("}").append("DailyForecasts\":").append("[{").append(
	 * "dailyForecasts", dailyForecasts) .append("}]").toString(); }
	 * 
	 * @Override public int hashCode() { return new
	 * HashCodeBuilder().append(headline).append(dailyForecasts).toHashCode(); }
	 * 
	 * 
	 * 
	 * @Override public boolean equals(Object other) { if (other == this) { return
	 * true; } if ((other instanceof DailyForeCasts) == false) { return false; }
	 * DailyForeCasts rhs = ((DailyForeCasts) other); return new
	 * EqualsBuilder().append(headline, rhs.headline).append(dailyForecasts,
	 * rhs.dailyForecasts).isEquals(); }
	 */
	 

	
	  @Override public String toString() { return new
	  ToStringBuilder(this).append("{\r\n").append("\"Headline\":").append("{\r\n")
	  .append("headline", headline).append("},\r\n").append("\"DailyForecasts\":")
	  .append("[").append("{\r\n").append("{\r\n")
	  .append("date", date).append(":")
	  .append("epochDate", epochDate).append(":")
	  .append("sun",sun).append(":").append("{\r\n").append("moon", moon).append("temperature", temperature)
	  .append("realFeelTemperature",realFeelTemperature).append("realFeelTemperatureShade",
	  realFeelTemperatureShade) .append("hoursOfSun",hoursOfSun).append("degreeDaySummary",
	  degreeDaySummary).append("airAndPollen", airAndPollen).append("day", day).append("night", night)
	  .append("sources", sources).append("mobileLink",mobileLink).append("link", link).append("}").toString(); }
	  
	  
	  
	  @Override public int hashCode() { return new
	  HashCodeBuilder().append(headline).append(dailyForecasts).append(date)
	  .append(epochDate).append(sun).append(moon).append(temperature)
	  .append(realFeelTemperature).append(realFeelTemperatureShade).append(hoursOfSun)
	  .append(degreeDaySummary).append(airAndPollen).append(day).append(night).append(sources)
	  .append(mobileLink).append(link).toHashCode(); }
	  
	  
	  
	
	  @Override public boolean equals(Object other) { if (other == this) { return
	  true; } if ((other instanceof DailyForeCasts5) == false) { return false; }
	  DailyForeCasts5 rhs = ((DailyForeCasts5) other); return new
	  EqualsBuilder().append(headline, rhs.headline).append(dailyForecasts,
	  rhs.dailyForecasts) .append(realFeelTemperatureShade,
	  rhs.realFeelTemperatureShade) .append(realFeelTemperature,
	  rhs.realFeelTemperature).append(moon, rhs.moon) .append(epochDate,
	  rhs.epochDate).append(degreeDaySummary, rhs.degreeDaySummary) .append(date,
	  rhs.date).append(sources, rhs.sources).append(sun, rhs.sun)
	  .append(temperature, rhs.temperature).append(night, rhs.night).append(day,
	  rhs.day) .append(airAndPollen, rhs.airAndPollen).append(hoursOfSun,
	  rhs.hoursOfSun) .append(mobileLink, rhs.mobileLink).append(link,
	  rhs.link).isEquals(); }
	 
	 

	/*
	 * @Override public String toString() { return new
	 * ToStringBuilder(this).append("date", date).append("epochDate", epochDate)
	 * .append("sun", sun).append("moon", moon).append("temperature", temperature)
	 * .append("realFeelTemperature",
	 * realFeelTemperature).append("realFeelTemperatureShade",
	 * realFeelTemperatureShade) .append("hoursOfSun",
	 * hoursOfSun).append("degreeDaySummary",
	 * degreeDaySummary).append("airAndPollen", airAndPollen) .append("day",
	 * day).append("night", night).append("sources", sources) .append("mobileLink",
	 * mobileLink).append("link", link).append("}").toString(); }
	 * 
	 * @Override public int hashCode() { return new HashCodeBuilder().append(date)
	 * .append(realFeelTemperatureShade).append(realFeelTemperature).append(moon).
	 * append(epochDate)
	 * .append(degreeDaySummary).append(date).append(sources).append(sun).append(
	 * temperature)
	 * .append(night).append(day).append(airAndPollen).append(hoursOfSun).append(
	 * mobileLink) .append(link).toHashCode(); }
	 * 
	 * @Override public boolean equals(Object other) { if (other == this) { return
	 * true; } if ((other instanceof DailyForeCasts) == false) { return false; }
	 * DailyForeCasts rhs = ((DailyForeCasts) other); return new EqualsBuilder()
	 * .append(realFeelTemperatureShade, rhs.realFeelTemperatureShade)
	 * .append(realFeelTemperature, rhs.realFeelTemperature).append(moon, rhs.moon)
	 * .append(epochDate, rhs.epochDate).append(degreeDaySummary,
	 * rhs.degreeDaySummary) .append(date, rhs.date).append(sources,
	 * rhs.sources).append(sun, rhs.sun) .append(temperature,
	 * rhs.temperature).append(night, rhs.night).append(day, rhs.day)
	 * .append(airAndPollen, rhs.airAndPollen).append(hoursOfSun, rhs.hoursOfSun)
	 * .append(mobileLink, rhs.mobileLink).append(link, rhs.link).isEquals(); }
	 */

	/*
	 * @Override public String toString() { return new
	 * ToStringBuilder(this).append("headline", headline).append("effectiveDate",
	 * effectiveDate).append("effectiveEpochDate",
	 * effectiveEpochDate).append("severity", severity).append("text",
	 * text).append("category", category).append("endDate",
	 * endDate).append("endEpochDate", endEpochDate).append("mobileLink",
	 * mobileLink).append("link", link) .append("dailyForecasts",
	 * dailyForecasts).append("date", date).append("epochDate",
	 * epochDate).append("sun", sun).append("moon", moon).append("temperature",
	 * temperature).append("realFeelTemperature",
	 * realFeelTemperature).append("realFeelTemperatureShade",
	 * realFeelTemperatureShade).append("hoursOfSun",
	 * hoursOfSun).append("degreeDaySummary", degreeDaySummary)
	 * .append("airAndPollen", airAndPollen).append("day", day).append("night",
	 * night).append("sources", sources).toString(); }
	 * 
	 * @Override public int hashCode() { return new
	 * HashCodeBuilder().append(headline).append(mobileLink).append(category).append
	 * (text).append(endEpochDate)
	 * .append(link).append(effectiveEpochDate).append(endDate).append(severity).
	 * append(effectiveDate)
	 * .append(realFeelTemperatureShade).append(realFeelTemperature).append(moon).
	 * append(epochDate)
	 * .append(degreeDaySummary).append(dailyForecasts).append(date).append(sources)
	 * .append(sun).append(temperature)
	 * .append(night).append(day).append(airAndPollen).append(hoursOfSun).toHashCode
	 * (); }
	 * 
	 * @Override public boolean equals(Object other) { if (other == this) { return
	 * true; } if ((other instanceof DailyForeCasts) == false) { return false; }
	 * DailyForeCasts rhs = ((DailyForeCasts) other); return new
	 * EqualsBuilder().append(headline, rhs.headline).append(mobileLink,
	 * rhs.mobileLink).append(category, rhs.category) .append(text,
	 * rhs.text).append(endEpochDate, rhs.endEpochDate).append(link, rhs.link)
	 * .append(effectiveEpochDate, rhs.effectiveEpochDate).append(endDate,
	 * rhs.endDate) .append(severity, rhs.severity).append(effectiveDate,
	 * rhs.effectiveDate) .append(realFeelTemperatureShade,
	 * rhs.realFeelTemperatureShade) .append(realFeelTemperature,
	 * rhs.realFeelTemperature).append(moon, rhs.moon) .append(epochDate,
	 * rhs.epochDate).append(degreeDaySummary, rhs.degreeDaySummary)
	 * .append(dailyForecasts, rhs.dailyForecasts).append(date,
	 * rhs.date).append(sources, rhs.sources).append(sun, rhs.sun)
	 * .append(temperature, rhs.temperature).append(night, rhs.night).append(day,
	 * rhs.day) .append(airAndPollen, rhs.airAndPollen).append(hoursOfSun,
	 * rhs.hoursOfSun).isEquals(); }
	 */

}
