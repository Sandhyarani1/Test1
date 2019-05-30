package com.accuweather.glacier.api.objects2;

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
"Icon",
"IconPhrase",
"ShortPhrase",
"LongPhrase",
"PrecipitationProbability",
"ThunderstormProbability",
"RainProbability",
"SnowProbability",
"IceProbability",
"Wind",
"WindGust",
"TotalLiquid",
"Rain",
"Snow",
"Ice",
"HoursOfPrecipitation",
"HoursOfRain",
"HoursOfSnow",
"HoursOfIce",
"CloudCover"
})

public class Night {
	
	@JsonProperty("Icon")
	private int icon;
	@JsonProperty("IconPhrase")
	private String iconPhrase;
	@JsonProperty("ShortPhrase")
	private String shortPhrase;
	@JsonProperty("LongPhrase")
	private String longPhrase;
	@JsonProperty("PrecipitationProbability")
	private int precipitationProbability;
	@JsonProperty("ThunderstormProbability")
	private int thunderstormProbability;
	@JsonProperty("RainProbability")
	private int rainProbability;
	@JsonProperty("SnowProbability")
	private int snowProbability;
	@JsonProperty("IceProbability")
	private int iceProbability;
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
	private double hoursOfPrecipitation;
	@JsonProperty("HoursOfRain")
	private double hoursOfRain;
	@JsonProperty("HoursOfSnow")
	private double hoursOfSnow;
	@JsonProperty("HoursOfIce")
	private double hoursOfIce;
	@JsonProperty("CloudCover")
	private int cloudCover;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	* No args constructor for use in serialization
	* 
	*/
	public Night() {
	}

	/**
	* 
	* @param hoursOfPrecipitation
	* @param icon
	* @param precipitationProbability
	* @param wind
	* @param windGust
	* @param snowProbability
	* @param iconPhrase
	* @param cloudCover
	* @param hoursOfRain
	* @param shortPhrase
	* @param hoursOfIce
	* @param hoursOfSnow
	* @param thunderstormProbability
	* @param iceProbability
	* @param rainProbability
	* @param ice
	* @param snow
	* @param totalLiquid
	* @param longPhrase
	* @param rain
	*/
	public Night(int icon, String iconPhrase, String shortPhrase, String longPhrase, int precipitationProbability, int thunderstormProbability, int rainProbability, int snowProbability, int iceProbability, Wind wind, WindGust windGust, TotalLiquid totalLiquid, Rain rain, Snow snow, Ice ice, double hoursOfPrecipitation, double hoursOfRain, double hoursOfSnow, double hoursOfIce, int cloudCover) {
	super();
	this.icon = icon;
	this.iconPhrase = iconPhrase;
	this.shortPhrase = shortPhrase;
	this.longPhrase = longPhrase;
	this.precipitationProbability = precipitationProbability;
	this.thunderstormProbability = thunderstormProbability;
	this.rainProbability = rainProbability;
	this.snowProbability = snowProbability;
	this.iceProbability = iceProbability;
	this.wind = wind;
	this.windGust = windGust;
	this.totalLiquid = totalLiquid;
	this.rain = rain;
	this.snow = snow;
	this.ice = ice;
	this.hoursOfPrecipitation = hoursOfPrecipitation;
	this.hoursOfRain = hoursOfRain;
	this.hoursOfSnow = hoursOfSnow;
	this.hoursOfIce = hoursOfIce;
	this.cloudCover = cloudCover;
	}

	@JsonProperty("Icon")
	public int getIcon() {
	return icon;
	}

	@JsonProperty("Icon")
	public void setIcon(int icon) {
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
	public int getPrecipitationProbability() {
	return precipitationProbability;
	}

	@JsonProperty("PrecipitationProbability")
	public void setPrecipitationProbability(int precipitationProbability) {
	this.precipitationProbability = precipitationProbability;
	}

	@JsonProperty("ThunderstormProbability")
	public int getThunderstormProbability() {
	return thunderstormProbability;
	}

	@JsonProperty("ThunderstormProbability")
	public void setThunderstormProbability(int thunderstormProbability) {
	this.thunderstormProbability = thunderstormProbability;
	}

	@JsonProperty("RainProbability")
	public int getRainProbability() {
	return rainProbability;
	}

	@JsonProperty("RainProbability")
	public void setRainProbability(int rainProbability) {
	this.rainProbability = rainProbability;
	}

	@JsonProperty("SnowProbability")
	public int getSnowProbability() {
	return snowProbability;
	}

	@JsonProperty("SnowProbability")
	public void setSnowProbability(int snowProbability) {
	this.snowProbability = snowProbability;
	}

	@JsonProperty("IceProbability")
	public int getIceProbability() {
	return iceProbability;
	}

	@JsonProperty("IceProbability")
	public void setIceProbability(int iceProbability) {
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
	public double getHoursOfPrecipitation() {
	return hoursOfPrecipitation;
	}

	@JsonProperty("HoursOfPrecipitation")
	public void setHoursOfPrecipitation(double hoursOfPrecipitation) {
	this.hoursOfPrecipitation = hoursOfPrecipitation;
	}

	@JsonProperty("HoursOfRain")
	public double getHoursOfRain() {
	return hoursOfRain;
	}

	@JsonProperty("HoursOfRain")
	public void setHoursOfRain(double hoursOfRain) {
	this.hoursOfRain = hoursOfRain;
	}

	@JsonProperty("HoursOfSnow")
	public double getHoursOfSnow() {
	return hoursOfSnow;
	}

	@JsonProperty("HoursOfSnow")
	public void setHoursOfSnow(double hoursOfSnow) {
	this.hoursOfSnow = hoursOfSnow;
	}

	@JsonProperty("HoursOfIce")
	public double getHoursOfIce() {
	return hoursOfIce;
	}

	@JsonProperty("HoursOfIce")
	public void setHoursOfIce(double hoursOfIce) {
	this.hoursOfIce = hoursOfIce;
	}

	@JsonProperty("CloudCover")
	public int getCloudCover() {
	return cloudCover;
	}

	@JsonProperty("CloudCover")
	public void setCloudCover(int cloudCover) {
	this.cloudCover = cloudCover;
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
	return new ToStringBuilder(this).append("icon", icon).append("iconPhrase", iconPhrase).append("shortPhrase", shortPhrase).append("longPhrase", longPhrase).append("precipitationProbability", precipitationProbability).append("thunderstormProbability", thunderstormProbability).append("rainProbability", rainProbability).append("snowProbability", snowProbability).append("iceProbability", iceProbability).append("wind", wind).append("windGust", windGust).append("totalLiquid", totalLiquid).append("rain", rain).append("snow", snow).append("ice", ice).append("hoursOfPrecipitation", hoursOfPrecipitation).append("hoursOfRain", hoursOfRain).append("hoursOfSnow", hoursOfSnow).append("hoursOfIce", hoursOfIce).append("cloudCover", cloudCover).append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
	return new HashCodeBuilder().append(hoursOfPrecipitation).append(windGust).append(wind).append(precipitationProbability).append(icon).append(snowProbability).append(iconPhrase).append(cloudCover).append(hoursOfRain).append(shortPhrase).append(hoursOfIce).append(hoursOfSnow).append(thunderstormProbability).append(iceProbability).append(rainProbability).append(additionalProperties).append(ice).append(snow).append(totalLiquid).append(longPhrase).append(rain).toHashCode();
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
	return new EqualsBuilder().append(hoursOfPrecipitation, rhs.hoursOfPrecipitation).append(windGust, rhs.windGust).append(wind, rhs.wind).append(precipitationProbability, rhs.precipitationProbability).append(icon, rhs.icon).append(snowProbability, rhs.snowProbability).append(iconPhrase, rhs.iconPhrase).append(cloudCover, rhs.cloudCover).append(hoursOfRain, rhs.hoursOfRain).append(shortPhrase, rhs.shortPhrase).append(hoursOfIce, rhs.hoursOfIce).append(hoursOfSnow, rhs.hoursOfSnow).append(thunderstormProbability, rhs.thunderstormProbability).append(iceProbability, rhs.iceProbability).append(rainProbability, rhs.rainProbability).append(additionalProperties, rhs.additionalProperties).append(ice, rhs.ice).append(snow, rhs.snow).append(totalLiquid, rhs.totalLiquid).append(longPhrase, rhs.longPhrase).append(rain, rhs.rain).isEquals();
	}
}
