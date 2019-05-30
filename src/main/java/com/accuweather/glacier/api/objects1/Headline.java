package com.accuweather.glacier.api.objects1;

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
"EffectiveDate",
"EffectiveEpochDate",
"Severity",
"Text",
"Category",
"EndDate",
"EndEpochDate",
"MobileLink",
"Link"
})
public class Headline {
	@JsonProperty("EffectiveDate")
	private String effectiveDate;
	@JsonProperty("EffectiveEpochDate")
	private int effectiveEpochDate;
	@JsonProperty("Severity")
	private int severity;
	@JsonProperty("Text")
	private String text;
	@JsonProperty("Category")
	private String category;
	@JsonProperty("EndDate")
	private String endDate;
	@JsonProperty("EndEpochDate")
	private int endEpochDate;
	@JsonProperty("MobileLink")
	private String mobileLink;
	@JsonProperty("Link")
	private String link;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	* No args constructor for use in serialization
	* 
	*/
	public Headline() {
	}

	/**
	* 
	* @param mobileLink
	* @param category
	* @param text
	* @param endEpochDate
	* @param link
	* @param effectiveEpochDate
	* @param endDate
	* @param severity
	* @param effectiveDate
	*/
	public Headline(String effectiveDate, int effectiveEpochDate, int severity, String text, String category, String endDate, int endEpochDate, String mobileLink, String link) {
	super();
	this.effectiveDate = effectiveDate;
	this.effectiveEpochDate = effectiveEpochDate;
	this.severity = severity;
	this.text = text;
	this.category = category;
	this.endDate = endDate;
	this.endEpochDate = endEpochDate;
	this.mobileLink = mobileLink;
	this.link = link;
	}

	@JsonProperty("EffectiveDate")
	public String getEffectiveDate() {
	return effectiveDate;
	}

	@JsonProperty("EffectiveDate")
	public void setEffectiveDate(String effectiveDate) {
	this.effectiveDate = effectiveDate;
	}

	@JsonProperty("EffectiveEpochDate")
	public int getEffectiveEpochDate() {
	return effectiveEpochDate;
	}

	@JsonProperty("EffectiveEpochDate")
	public void setEffectiveEpochDate(int effectiveEpochDate) {
	this.effectiveEpochDate = effectiveEpochDate;
	}

	@JsonProperty("Severity")
	public int getSeverity() {
	return severity;
	}

	@JsonProperty("Severity")
	public void setSeverity(int severity) {
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
	public int getEndEpochDate() {
	return endEpochDate;
	}

	@JsonProperty("EndEpochDate")
	public void setEndEpochDate(int endEpochDate) {
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
	this.link = link;
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
	return new ToStringBuilder(this).append("effectiveDate", effectiveDate).append("effectiveEpochDate", effectiveEpochDate).append("severity", severity).append("text", text).append("category", category).append("endDate", endDate).append("endEpochDate", endEpochDate).append("mobileLink", mobileLink).append("link", link).append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
	return new HashCodeBuilder().append(mobileLink).append(category).append(text).append(endEpochDate).append(additionalProperties).append(link).append(effectiveEpochDate).append(endDate).append(severity).append(effectiveDate).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
	if (other == this) {
	return true;
	}
	if ((other instanceof Headline) == false) {
	return false;
	}
	Headline rhs = ((Headline) other);
	return new EqualsBuilder().append(mobileLink, rhs.mobileLink).append(category, rhs.category).append(text, rhs.text).append(endEpochDate, rhs.endEpochDate).append(additionalProperties, rhs.additionalProperties).append(link, rhs.link).append(effectiveEpochDate, rhs.effectiveEpochDate).append(endDate, rhs.endDate).append(severity, rhs.severity).append(effectiveDate, rhs.effectiveDate).isEquals();
	}
}
