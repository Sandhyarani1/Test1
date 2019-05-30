package com.accuweather.glacier.api.objects1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Headline2 {
	/*
	 * @JsonProperty("Headline") private Headline headline;
	 * 
	 * @JsonProperty("DailyForecasts") private List<Object> dailyForecasts;
	 * 
	 * @JsonProperty("Link") private static String link;
	 */
	
	
	  //@JsonProperty("Headline") private Headline headline;
	  
	  @JsonProperty("EffectiveDate") private String effectiveDate;
	  
	  @JsonProperty("EffectiveEpochDate") private Integer effectiveEpochDate;
	  
	  @JsonProperty("Severity") private Integer severity;
	  
	  @JsonProperty("Text") private String text;
	  
	  @JsonProperty("Category") private String category;
	  
	  @JsonProperty("EndDate") private String endDate;
	  
	  @JsonProperty("EndEpochDate") private Integer endEpochDate;
	  
	  @JsonProperty("MobileLink") private String mobileLink;
	  
	   @JsonProperty("Link") private static String link;

	  
	    
	/**
     * No args constructor for use in serialization
     *
     */
	
	
	  public Headline2() { }
	 
	
	public Headline2(String effectiveDate, Integer effectiveEpochDate,
			Integer severity, String text,String category,String endDate, 
			Integer endEpochDate,String mobileLink,String link
			) {
       // public Headline(Headline headline,List<Object> dailyForecasts,String link) {
		super();
		/*
		 * Headline.link = link; this.dailyForecasts = dailyForecasts; Headline.link =
		 * link;
		 */
        
		
		  this.effectiveDate = effectiveDate; 
		  this.effectiveEpochDate =	effectiveEpochDate; 
		  this.severity = severity; 
		  this.text = text; 
		  this.category	= category; 
		  this.endDate = endDate; 
		  this.endEpochDate = endEpochDate;
		  this.mobileLink = mobileLink; 
		  Headline2.link = link; 
		  
		 
    }
	
	/*
	 * @JsonProperty("Headline") public Headline getHeadline() { return headline; }
	 * 
	 * @JsonProperty("Headline") public void setHeadline(Headline headline) {
	 * this.headline = headline; }
	 * 
	 * @JsonProperty("DailyForecasts") public List<Object> getDailyForecasts() {
	 * return dailyForecasts; }
	 * 
	 * @JsonProperty("DailyForecasts") public void setDailyForecasts(List<Object>
	 * dailyForecasts) { this.dailyForecasts = dailyForecasts; }
	 * 
	 * @JsonProperty("Link") public String getLink() { return link; }
	 * 
	 * @JsonProperty("Link") public void setLink(String link) { Headline.link =
	 * link; }
	 * 
	 * @Override public String toString() { return new
	 * ToStringBuilder(this).append("headline", headline).append("dailyForecasts",
	 * dailyForecasts).append("link", link).toString(); }
	 * 
	 * @Override public int hashCode() { return new
	 * HashCodeBuilder().append(headline).append(dailyForecasts).append(link).
	 * toHashCode(); }
	 * 
	 * @Override public boolean equals(Object other) { if (other == this) { return
	 * true; } if ((other instanceof Headline) == false) { return false; } Headline
	 * rhs = ((Headline) other); return new EqualsBuilder().append(headline,
	 * rhs.headline).append(dailyForecasts, rhs.link).append(link,
	 * rhs.dailyForecasts).isEquals(); }
	 */

	
	@JsonProperty("EffectiveDate")
	public String getEffectiveDate() {
	return effectiveDate;
	}

	@JsonProperty("EffectiveDate")
	public void setEffectiveDate(String effectiveDate) {
	this.effectiveDate = effectiveDate;
	}

	@JsonProperty("EffectiveEpochDate")
	public Integer getEffectiveEpochDate() {
	return effectiveEpochDate;
	}

	@JsonProperty("EffectiveEpochDate")
	public void setEffectiveEpochDate(Integer effectiveEpochDate) {
	this.effectiveEpochDate = effectiveEpochDate;
	}

	@JsonProperty("Severity")
	public Integer getSeverity() {
	return severity;
	}

	@JsonProperty("Severity")
	public void setSeverity(Integer severity) {
	this.severity = severity;
	}

	@JsonProperty("Text")
	public String getText() {
	return text;
	}

	@JsonProperty("Text")
	public void setText(String text) {
	this.text = text;
	}

	@JsonProperty("Category")
	public String getCategory() {
	return category;
	}

	@JsonProperty("Category")
	public void setCategory(String category) {
	this.category = category;
	}

	@JsonProperty("EndDate")
	public String getEndDate() {
	return endDate;
	}

	@JsonProperty("EndDate")
	public void setEndDate(String endDate) {
	this.endDate = endDate;
	}

	@JsonProperty("EndEpochDate")
	public Integer getEndEpochDate() {
	return endEpochDate;
	}

	@JsonProperty("EndEpochDate")
	public void setEndEpochDate(Integer endEpochDate) {
	this.endEpochDate = endEpochDate;
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
	Headline2.link = link;
	}
	

	/*
	 * @Override public String toString() { return new
	 * ToStringBuilder(this).append("\"Headline\":").append("{\r\n").append(
	 * "effectiveDate", effectiveDate) .append("effectiveEpochDate",
	 * effectiveEpochDate).append("severity", severity) .append("text",
	 * text).append("category", category).append("endDate", endDate)
	 * .append("endEpochDate", endEpochDate).append("mobileLink",
	 * mobileLink).append("link", link).toString(); }
	 * 
	 * @Override public int hashCode() { return new
	 * HashCodeBuilder().append(effectiveDate).append(effectiveEpochDate).append(
	 * severity)
	 * .append(text).append(category).append(endDate).append(endDate).append(
	 * endEpochDate) .append(mobileLink).append(link).toHashCode(); }
	 * 
	 * @Override public boolean equals(Object other) { if (other == this) { return
	 * true; } if ((other instanceof Headline) == false) { return false; } Headline
	 * rhs = ((Headline) other); return new EqualsBuilder().append(effectiveDate,
	 * rhs.effectiveDate) .append(effectiveEpochDate, rhs.effectiveEpochDate)
	 * .append(severity, rhs.severity).append(text, rhs.text).append(category,
	 * rhs.category) .append(effectiveEpochDate,
	 * rhs.effectiveEpochDate).append(endDate, rhs.endDate) .append(endDate,
	 * rhs.endDate).append(endEpochDate, rhs.endEpochDate) .append(mobileLink,
	 * rhs.mobileLink).append(link, rhs.link).isEquals(); }
	 */
	 
}
