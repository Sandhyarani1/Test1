package com.accuweather.glacier.api.objects2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Day {
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
	@JsonProperty("Wind")
	private Wind wind;
	@JsonProperty("WindGust")
	private WindGust windGust;
	@JsonProperty("TotalLiquid")
	private TotalLiquid totalLiquid;
	@JsonProperty("Rain")
	private Rain rain;
	@JsonProperty("Snow")
	private Snow snow;
	@JsonProperty("Ice")
	private Ice ice;
	@JsonProperty("HoursOfPrecipitation")
	private Double hoursOfPrecipitation;
	@JsonProperty("HoursOfRain")
	private Object hoursOfRain;
	@JsonProperty("HoursOfSnow")
	private Double hoursOfSnow;
	@JsonProperty("HoursOfIce")
	private Double hoursOfIce;
	@JsonProperty("CloudCover")
	private Integer cloudCover;
	
	public Day() {}
	public Day(Integer icon,String iconPhrase,String shortPhrase,String longPhrase,Integer precipitationProbability,
			Integer thunderstormProbability,Integer rainProbability,Integer snowProbability,
			Integer iceProbability,Wind wind,WindGust windGust,TotalLiquid totalLiquid,
			Rain rain,Snow snow,Ice ice,Double hoursOfPrecipitation,String hoursOfRain,
			Double hoursOfSnow,Double hoursOfIce,Integer cloudCover)
	{
		super();
		this.cloudCover = cloudCover;
		this.hoursOfIce = hoursOfIce;
		this.hoursOfPrecipitation = hoursOfPrecipitation;
		this.hoursOfRain = hoursOfRain;
		this.hoursOfSnow = hoursOfSnow;
		this.ice = ice;
		this.iceProbability = iceProbability;
		this.icon = icon;
		this.iconPhrase = iconPhrase;
		this.longPhrase = longPhrase;
		this.precipitationProbability = precipitationProbability;
		this.rain = rain;
		this.rainProbability = rainProbability;
		this.shortPhrase = shortPhrase;
		this.snow = snow;
		this.snowProbability = snowProbability;
		this.thunderstormProbability = thunderstormProbability;
		this.totalLiquid = totalLiquid;
		this.wind = wind;
		this.windGust = windGust;
		
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

	@JsonProperty("Wind")
	public Wind getWind() {
	return wind;
	}

	@JsonProperty("Wind")
	public void setWind(Wind wind) {
	this.wind = wind;
	}

	@JsonProperty("WindGust")
	public WindGust getWindGust() {
	return windGust;
	}

	@JsonProperty("WindGust")
	public void setWindGust(WindGust windGust) {
	this.windGust = windGust;
	}

	@JsonProperty("TotalLiquid")
	public TotalLiquid getTotalLiquid() {
	return totalLiquid;
	}

	@JsonProperty("TotalLiquid")
	public void setTotalLiquid(TotalLiquid totalLiquid) {
	this.totalLiquid = totalLiquid;
	}

	@JsonProperty("Rain")
	public Rain getRain() {
	return rain;
	}

	@JsonProperty("Rain")
	public void setRain(Rain rain) {
	this.rain = rain;
	}

	@JsonProperty("Snow")
	public Snow getSnow() {
	return snow;
	}

	@JsonProperty("Snow")
	public void setSnow(Snow snow) {
	this.snow = snow;
	}

	@JsonProperty("Ice")
	public Ice getIce() {
	return ice;
	}

	@JsonProperty("Ice")
	public void setIce(Ice ice) {
	this.ice = ice;
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
	public Object getHoursOfRain() {
	return hoursOfRain;
	}

	@JsonProperty("HoursOfRain")
	public void setHoursOfRain(Object expectedText) {
	this.hoursOfRain = expectedText;
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
	return new ToStringBuilder(this).append("icon", icon).append("iconPhrase", iconPhrase).append("shortPhrase", shortPhrase).append("longPhrase", longPhrase).append("precipitationProbability", precipitationProbability).append("thunderstormProbability", thunderstormProbability).append("rainProbability", rainProbability).append("snowProbability", snowProbability).append("iceProbability", iceProbability).append("wind", wind).append("windGust", windGust).append("totalLiquid", totalLiquid).append("rain", rain).append("snow", snow).append("ice", ice).append("hoursOfPrecipitation", hoursOfPrecipitation).append("hoursOfRain", hoursOfRain).append("hoursOfSnow", hoursOfSnow).append("hoursOfIce", hoursOfIce).append("cloudCover", cloudCover).toString();
	}

	@Override
	public int hashCode() {
	return new HashCodeBuilder().append(hoursOfPrecipitation).append(windGust).append(wind).append(precipitationProbability).append(icon).append(snowProbability).append(iconPhrase).append(cloudCover).append(hoursOfRain).append(shortPhrase).append(hoursOfIce).append(hoursOfSnow).append(thunderstormProbability).append(iceProbability).append(rainProbability).append(ice).append(snow).append(totalLiquid).append(longPhrase).append(rain).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
	if (other == this) {
	return true;
	}
	if ((other instanceof Day) == false) {
	return false;
	}
	Day rhs = ((Day) other);
	return new EqualsBuilder().append(hoursOfPrecipitation, rhs.hoursOfPrecipitation).append(windGust, rhs.windGust).append(wind, rhs.wind).append(precipitationProbability, rhs.precipitationProbability).append(icon, rhs.icon).append(snowProbability, rhs.snowProbability).append(iconPhrase, rhs.iconPhrase).append(cloudCover, rhs.cloudCover).append(hoursOfRain, rhs.hoursOfRain).append(shortPhrase, rhs.shortPhrase).append(hoursOfIce, rhs.hoursOfIce).append(hoursOfSnow, rhs.hoursOfSnow).append(thunderstormProbability, rhs.thunderstormProbability).append(iceProbability, rhs.iceProbability).append(rainProbability, rhs.rainProbability).append(ice, rhs.ice).append(snow, rhs.snow).append(totalLiquid, rhs.totalLiquid).append(longPhrase, rhs.longPhrase).append(rain, rhs.rain).isEquals();
	}


}
