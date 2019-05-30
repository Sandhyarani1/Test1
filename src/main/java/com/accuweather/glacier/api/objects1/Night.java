package com.accuweather.glacier.api.objects1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Night {
	
	@JsonProperty("Icon")
	private Integer icon;
	@JsonProperty("IconPhrase")
	private String iconPhrase;
	@JsonProperty("ShortPhrase")
	private String shortPhrase;
	@JsonProperty("LongPhrase")
	private String longPhrase;
	@JsonProperty("PrecipitationProbability")
	private Integer precipitationProbability;
	@JsonProperty("ThunderstormProbability")
	private Integer thunderstormProbability;
	@JsonProperty("RainProbability")
	private Integer rainProbability;
	@JsonProperty("SnowProbability")
	private Integer snowProbability;
	@JsonProperty("IceProbability")
	private Integer iceProbability;
	@JsonProperty("HoursOfPrecipitation")
	private Double hoursOfPrecipitation;
	@JsonProperty("HoursOfRain")
	private Double hoursOfRain;
	@JsonProperty("HoursOfSnow")
	private Double hoursOfSnow;
	@JsonProperty("HoursOfIce")
	private Double hoursOfIce;
	@JsonProperty("CloudCover")
	private Integer cloudCover;
	
public Night() {
		
	}
	
	public Night(Integer icon,String iconPhrase,String shortPhrase,String longPhrase,Integer precipitationProbability,Integer thunderstormProbability,Integer rainProbability,Integer snowProbability,
			Integer iceProbability,Double hoursOfPrecipitation,Double hoursOfRain,Double hoursOfSnow,Double hoursOfIce,Integer cloudCover) 
	{
		super();
	}
	
	@JsonProperty("Icon")
	public Integer getIcon() {
	return icon;
	}

	@JsonProperty("Icon")
	public void setIcon(Integer icon) {
	this.icon = icon;
	}

	@JsonProperty("IconPhrase")
	public String getIconPhrase() {
	return iconPhrase;
	}

	@JsonProperty("IconPhrase")
	public void setIconPhrase(String iconPhrase) {
	this.iconPhrase = iconPhrase;
	}

	@JsonProperty("ShortPhrase")
	public String getShortPhrase() {
	return shortPhrase;
	}

	@JsonProperty("ShortPhrase")
	public void setShortPhrase(String shortPhrase) {
	this.shortPhrase = shortPhrase;
	}

	@JsonProperty("LongPhrase")
	public String getLongPhrase() {
	return longPhrase;
	}

	@JsonProperty("LongPhrase")
	public void setLongPhrase(String longPhrase) {
	this.longPhrase = longPhrase;
	}

	@JsonProperty("PrecipitationProbability")
	public Integer getPrecipitationProbability() {
	return precipitationProbability;
	}

	@JsonProperty("PrecipitationProbability")
	public void setPrecipitationProbability(Integer precipitationProbability) {
	this.precipitationProbability = precipitationProbability;
	}

	@JsonProperty("ThunderstormProbability")
	public Integer getThunderstormProbability() {
	return thunderstormProbability;
	}

	@JsonProperty("ThunderstormProbability")
	public void setThunderstormProbability(Integer thunderstormProbability) {
	this.thunderstormProbability = thunderstormProbability;
	}

	@JsonProperty("RainProbability")
	public Integer getRainProbability() {
	return rainProbability;
	}

	@JsonProperty("RainProbability")
	public void setRainProbability(Integer rainProbability) {
	this.rainProbability = rainProbability;
	}

	@JsonProperty("SnowProbability")
	public Integer getSnowProbability() {
	return snowProbability;
	}

	@JsonProperty("SnowProbability")
	public void setSnowProbability(Integer snowProbability) {
	this.snowProbability = snowProbability;
	}

	@JsonProperty("IceProbability")
	public Integer getIceProbability() {
	return iceProbability;
	}

	@JsonProperty("IceProbability")
	public void setIceProbability(Integer iceProbability) {
	this.iceProbability = iceProbability;
	}
	
	@JsonProperty("HoursOfPrecipitation")
	public Double getHoursOfPrecipitation() {
	return hoursOfPrecipitation;
	}

	@JsonProperty("HoursOfPrecipitation")
	public void setHoursOfPrecipitation(Double hoursOfPrecipitation) {
	this.hoursOfPrecipitation = hoursOfPrecipitation;
	}

	@JsonProperty("HoursOfRain")
	public Double getHoursOfRain() {
	return hoursOfRain;
	}

	@JsonProperty("HoursOfRain")
	public void setHoursOfRain(Double hoursOfRain) {
	this.hoursOfRain = hoursOfRain;
	}

	@JsonProperty("HoursOfSnow")
	public Double getHoursOfSnow() {
	return hoursOfSnow;
	}

	@JsonProperty("HoursOfSnow")
	public void setHoursOfSnow(Double hoursOfSnow) {
	this.hoursOfSnow = hoursOfSnow;
	}

	@JsonProperty("HoursOfIce")
	public Double getHoursOfIce() {
	return hoursOfIce;
	}

	@JsonProperty("HoursOfIce")
	public void setHoursOfIce(Double hoursOfIce) {
	this.hoursOfIce = hoursOfIce;
	}

	@JsonProperty("CloudCover")
	public Integer getCloudCover() {
	return cloudCover;
	}

	@JsonProperty("CloudCover")
	public void setCloudCover(Integer cloudCover) {
	this.cloudCover = cloudCover;
	}

	@Override
	public String toString() {
	return new ToStringBuilder(this).append("icon", icon).append("iconPhrase", iconPhrase).append("shortPhrase", shortPhrase).append("longPhrase", longPhrase).append("precipitationProbability", precipitationProbability).append("thunderstormProbability", thunderstormProbability).append("rainProbability", rainProbability).append("snowProbability", snowProbability).append("iceProbability", iceProbability).append("hoursOfPrecipitation", hoursOfPrecipitation).append("hoursOfRain", hoursOfRain).append("hoursOfSnow", hoursOfSnow).append("hoursOfIce", hoursOfIce).append("cloudCover", cloudCover).toString();
	}

	@Override
	public int hashCode() {
	return new HashCodeBuilder().append(hoursOfPrecipitation).append(precipitationProbability).append(icon).append(snowProbability).append(iconPhrase).append(cloudCover).append(hoursOfRain).append(shortPhrase).append(hoursOfIce).append(hoursOfSnow).append(thunderstormProbability).append(iceProbability).append(rainProbability).append(longPhrase).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
	if (other == this) {
	return true;
	}
	if ((other instanceof Night) == false) {
	return false;
	}
	Night rhs = ((Night) other);
	return new EqualsBuilder().append(hoursOfPrecipitation, rhs.hoursOfPrecipitation).append(precipitationProbability, rhs.precipitationProbability).append(icon, rhs.icon).append(snowProbability, rhs.snowProbability).append(iconPhrase, rhs.iconPhrase).append(cloudCover, rhs.cloudCover).append(hoursOfRain, rhs.hoursOfRain).append(shortPhrase, rhs.shortPhrase).append(hoursOfIce, rhs.hoursOfIce).append(hoursOfSnow, rhs.hoursOfSnow).append(thunderstormProbability, rhs.thunderstormProbability).append(iceProbability, rhs.iceProbability).append(rainProbability, rhs.rainProbability).append(longPhrase, rhs.longPhrase).isEquals();
	}
}
