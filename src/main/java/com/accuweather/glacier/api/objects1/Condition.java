
package com.accuweather.glacier.api.objects1;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Condition {

    @JsonProperty("LocalObservationDateTime")
    private String localObservationDateTime;
    @JsonProperty("EpochTime")
    private Integer epochTime;
    @JsonProperty("WeatherText")
    private String weatherText;
    @JsonProperty("WeatherIcon")
    private Integer weatherIcon;
    @JsonProperty("LocalSource")
    private LocalSource localSource;
    @JsonProperty("HasPrecipitation")
    private Boolean hasPrecipitation;
    @JsonProperty("PrecipitationType")
    private Object precipitationType;
    @JsonProperty("IsDayTime")
    private Boolean isDayTime;
    @JsonProperty("Temperature")
    private Temperature temperature;
    @JsonProperty("RealFeelTemperature")
    private RealFeelTemperature realFeelTemperature;
    @JsonProperty("RealFeelTemperatureShade")
    private RealFeelTemperatureShade realFeelTemperatureShade;
    @JsonProperty("RelativeHumidity")
    private Integer relativeHumidity;
    @JsonProperty("DewPoint")
    private DewPoint dewPoint;
    @JsonProperty("Wind")
    private Wind wind;
    @JsonProperty("WindGust")
    private WindGust windGust;
    @JsonProperty("UVIndex")
    private Integer uVIndex;
    @JsonProperty("UVIndexText")
    private String uVIndexText;
    @JsonProperty("Visibility")
    private Visibility visibility;
    @JsonProperty("ObstructionsToVisibility")
    private String obstructionsToVisibility;
    @JsonProperty("CloudCover")
    private Integer cloudCover;
    @JsonProperty("Ceiling")
    private Ceiling ceiling;
    @JsonProperty("Pressure")
    private Pressure pressure;
    @JsonProperty("PressureTendency")
    private PressureTendency pressureTendency;
    @JsonProperty("Past24HourTemperatureDeparture")
    private Past24HourTemperatureDeparture past24HourTemperatureDeparture;
    @JsonProperty("ApparentTemperature")
    private ApparentTemperature apparentTemperature;
    @JsonProperty("WindChillTemperature")
    private WindChillTemperature windChillTemperature;
    @JsonProperty("WetBulbTemperature")
    private WetBulbTemperature wetBulbTemperature;
    @JsonProperty("Precip1hr")
    private Precip1hr precip1hr;
    @JsonProperty("PrecipitationSummary")
    private PrecipitationSummary precipitationSummary;
    @JsonProperty("TemperatureSummary")
    private TemperatureSummary temperatureSummary;
    @JsonProperty("MobileLink")
    private String mobileLink;
    @JsonProperty("Link")
    private String link;

    /**
     * No args constructor for use in serialization
     *
     */
    public Condition() {
    }

    /**
     *
     * @param pressureTendency
     * @param visibility
     * @param precipitationSummary
     * @param link
     * @param precip1hr
     * @param apparentTemperature
     * @param localObservationDateTime
     * @param hasPrecipitation
     * @param temperature
     * @param mobileLink
     * @param windChillTemperature
     * @param uVIndex
     * @param epochTime
     * @param temperatureSummary
     * @param wetBulbTemperature
     * @param realFeelTemperatureShade
     * @param obstructionsToVisibility
     * @param wind
     * @param windGust
     * @param realFeelTemperature
     * @param weatherIcon
     * @param relativeHumidity
     * @param pressure
     * @param cloudCover
     * @param past24HourTemperatureDeparture
     * @param precipitationType
     * @param dewPoint
     * @param ceiling
     * @param weatherText
     * @param isDayTime
     * @param uVIndexText
     */
    public Condition(String localObservationDateTime, Integer epochTime, String weatherText, Integer weatherIcon, Boolean hasPrecipitation, Object precipitationType, Boolean isDayTime, Temperature temperature, RealFeelTemperature realFeelTemperature, RealFeelTemperatureShade realFeelTemperatureShade, Integer relativeHumidity, DewPoint dewPoint, Wind wind, WindGust windGust, Integer uVIndex, String uVIndexText, Visibility visibility, String obstructionsToVisibility, Integer cloudCover, Ceiling ceiling, Pressure pressure, PressureTendency pressureTendency, Past24HourTemperatureDeparture past24HourTemperatureDeparture, ApparentTemperature apparentTemperature, WindChillTemperature windChillTemperature, WetBulbTemperature wetBulbTemperature, Precip1hr precip1hr, PrecipitationSummary precipitationSummary, TemperatureSummary temperatureSummary, String mobileLink, String link) {
        super();
        this.localObservationDateTime = localObservationDateTime;
        this.epochTime = epochTime;
        this.weatherText = weatherText;
        this.weatherIcon = weatherIcon;
        this.hasPrecipitation = hasPrecipitation;
        this.precipitationType = precipitationType;
        this.isDayTime = isDayTime;
        this.temperature = temperature;
        this.realFeelTemperature = realFeelTemperature;
        this.realFeelTemperatureShade = realFeelTemperatureShade;
        this.relativeHumidity = relativeHumidity;
        this.dewPoint = dewPoint;
        this.wind = wind;
        this.windGust = windGust;
        this.uVIndex = uVIndex;
        this.uVIndexText = uVIndexText;
        this.visibility = visibility;
        this.obstructionsToVisibility = obstructionsToVisibility;
        this.cloudCover = cloudCover;
        this.ceiling = ceiling;
        this.pressure = pressure;
        this.pressureTendency = pressureTendency;
        this.past24HourTemperatureDeparture = past24HourTemperatureDeparture;
        this.apparentTemperature = apparentTemperature;
        this.windChillTemperature = windChillTemperature;
        this.wetBulbTemperature = wetBulbTemperature;
        this.precip1hr = precip1hr;
        this.precipitationSummary = precipitationSummary;
        this.temperatureSummary = temperatureSummary;
        this.mobileLink = mobileLink;
        this.link = link;
    }

    @JsonProperty("LocalObservationDateTime")
    public String getLocalObservationDateTime() {
        return localObservationDateTime;
    }

    @JsonProperty("LocalObservationDateTime")
    public void setLocalObservationDateTime(String localObservationDateTime) {
        this.localObservationDateTime = localObservationDateTime;
    }

    @JsonProperty("EpochTime")
    public Integer getEpochTime() {
        return epochTime;
    }

    @JsonProperty("EpochTime")
    public void setEpochTime(Integer epochTime) {
        this.epochTime = epochTime;
    }

    @JsonProperty("WeatherText")
    public String getWeatherText() {
        return weatherText;
    }

    @JsonProperty("WeatherText")
    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    @JsonProperty("WeatherIcon")
    public Integer getWeatherIcon() {
        return weatherIcon;
    }

    @JsonProperty("WeatherIcon")
    public void setWeatherIcon(Integer weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    @JsonProperty("HasPrecipitation")
    public Boolean getHasPrecipitation() {
        return hasPrecipitation;
    }

    @JsonProperty("HasPrecipitation")
    public void setHasPrecipitation(Boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    @JsonProperty("PrecipitationType")
    public Object getPrecipitationType() {
        return precipitationType;
    }

    @JsonProperty("PrecipitationType")
    public void setPrecipitationType(Object precipitationType) {
        this.precipitationType = precipitationType;
    }

    @JsonProperty("IsDayTime")
    public Boolean getIsDayTime() {
        return isDayTime;
    }

    @JsonProperty("IsDayTime")
    public void setIsDayTime(Boolean isDayTime) {
        this.isDayTime = isDayTime;
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

    @JsonProperty("RelativeHumidity")
    public Integer getRelativeHumidity() {
        return relativeHumidity;
    }

    @JsonProperty("RelativeHumidity")
    public void setRelativeHumidity(Integer relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    @JsonProperty("DewPoint")
    public DewPoint getDewPoint() {
        return dewPoint;
    }

    @JsonProperty("DewPoint")
    public void setDewPoint(DewPoint dewPoint) {
        this.dewPoint = dewPoint;
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

    @JsonProperty("UVIndex")
    public Integer getUVIndex() {
        return uVIndex;
    }

    @JsonProperty("UVIndex")
    public void setUVIndex(Integer uVIndex) {
        this.uVIndex = uVIndex;
    }

    @JsonProperty("UVIndexText")
    public String getUVIndexText() {
        return uVIndexText;
    }

    @JsonProperty("UVIndexText")
    public void setUVIndexText(String uVIndexText) {
        this.uVIndexText = uVIndexText;
    }

    @JsonProperty("Visibility")
    public Visibility getVisibility() {
        return visibility;
    }

    @JsonProperty("Visibility")
    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("ObstructionsToVisibility")
    public String getObstructionsToVisibility() {
        return obstructionsToVisibility;
    }

    @JsonProperty("ObstructionsToVisibility")
    public void setObstructionsToVisibility(String obstructionsToVisibility) {
        this.obstructionsToVisibility = obstructionsToVisibility;
    }

    @JsonProperty("CloudCover")
    public Integer getCloudCover() {
        return cloudCover;
    }

    @JsonProperty("CloudCover")
    public void setCloudCover(Integer cloudCover) {
        this.cloudCover = cloudCover;
    }

    @JsonProperty("Ceiling")
    public Ceiling getCeiling() {
        return ceiling;
    }

    @JsonProperty("Ceiling")
    public void setCeiling(Ceiling ceiling) {
        this.ceiling = ceiling;
    }

    @JsonProperty("Pressure")
    public Pressure getPressure() {
        return pressure;
    }

    @JsonProperty("Pressure")
    public void setPressure(Pressure pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("PressureTendency")
    public PressureTendency getPressureTendency() {
        return pressureTendency;
    }

    @JsonProperty("PressureTendency")
    public void setPressureTendency(PressureTendency pressureTendency) {
        this.pressureTendency = pressureTendency;
    }

    @JsonProperty("Past24HourTemperatureDeparture")
    public Past24HourTemperatureDeparture getPast24HourTemperatureDeparture() {
        return past24HourTemperatureDeparture;
    }

    @JsonProperty("Past24HourTemperatureDeparture")
    public void setPast24HourTemperatureDeparture(Past24HourTemperatureDeparture past24HourTemperatureDeparture) {
        this.past24HourTemperatureDeparture = past24HourTemperatureDeparture;
    }

    @JsonProperty("ApparentTemperature")
    public ApparentTemperature getApparentTemperature() {
        return apparentTemperature;
    }

    @JsonProperty("ApparentTemperature")
    public void setApparentTemperature(ApparentTemperature apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    @JsonProperty("WindChillTemperature")
    public WindChillTemperature getWindChillTemperature() {
        return windChillTemperature;
    }

    @JsonProperty("WindChillTemperature")
    public void setWindChillTemperature(WindChillTemperature windChillTemperature) {
        this.windChillTemperature = windChillTemperature;
    }

    @JsonProperty("WetBulbTemperature")
    public WetBulbTemperature getWetBulbTemperature() {
        return wetBulbTemperature;
    }

    @JsonProperty("WetBulbTemperature")
    public void setWetBulbTemperature(WetBulbTemperature wetBulbTemperature) {
        this.wetBulbTemperature = wetBulbTemperature;
    }

    @JsonProperty("Precip1hr")
    public Precip1hr getPrecip1hr() {
        return precip1hr;
    }

    @JsonProperty("Precip1hr")
    public void setPrecip1hr(Precip1hr precip1hr) {
        this.precip1hr = precip1hr;
    }

    @JsonProperty("PrecipitationSummary")
    public PrecipitationSummary getPrecipitationSummary() {
        return precipitationSummary;
    }

    @JsonProperty("PrecipitationSummary")
    public void setPrecipitationSummary(PrecipitationSummary precipitationSummary) {
        this.precipitationSummary = precipitationSummary;
    }

    @JsonProperty("TemperatureSummary")
    public TemperatureSummary getTemperatureSummary() {
        return temperatureSummary;
    }

    @JsonProperty("TemperatureSummary")
    public void setTemperatureSummary(TemperatureSummary temperatureSummary) {
        this.temperatureSummary = temperatureSummary;
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

    public LocalSource getLocalSource() {
        return localSource;
    }

    public void setLocalSource(LocalSource localSource) {
        this.localSource = localSource;
    }

    public Integer getuVIndex() {
        return uVIndex;
    }

    public void setuVIndex(Integer uVIndex) {
        this.uVIndex = uVIndex;
    }

    public String getuVIndexText() {
        return uVIndexText;
    }

    public void setuVIndexText(String uVIndexText) {
        this.uVIndexText = uVIndexText;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("localObservationDateTime", localObservationDateTime).append("epochTime", epochTime).append("weatherText", weatherText).append("weatherIcon", weatherIcon).append("hasPrecipitation", hasPrecipitation).append("precipitationType", precipitationType).append("isDayTime", isDayTime).append("temperature", temperature).append("realFeelTemperature", realFeelTemperature).append("realFeelTemperatureShade", realFeelTemperatureShade).append("relativeHumidity", relativeHumidity).append("dewPoint", dewPoint).append("wind", wind).append("windGust", windGust).append("uVIndex", uVIndex).append("uVIndexText", uVIndexText).append("visibility", visibility).append("obstructionsToVisibility", obstructionsToVisibility).append("cloudCover", cloudCover).append("ceiling", ceiling).append("pressure", pressure).append("pressureTendency", pressureTendency).append("past24HourTemperatureDeparture", past24HourTemperatureDeparture)
                .append("apparentTemperature", apparentTemperature).append("windChillTemperature", windChillTemperature).append("wetBulbTemperature", wetBulbTemperature).append("precip1hr", precip1hr).append("precipitationSummary", precipitationSummary).append("temperatureSummary", temperatureSummary).append("mobileLink", mobileLink).append("link", link).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pressureTendency).append(visibility).append(precipitationSummary).append(link).append(precip1hr).append(apparentTemperature).append(localObservationDateTime).append(hasPrecipitation).append(temperature).append(mobileLink).append(windChillTemperature).append(uVIndex).append(epochTime).append(temperatureSummary).append(wetBulbTemperature).append(obstructionsToVisibility).append(realFeelTemperatureShade).append(windGust).append(wind).append(realFeelTemperature).append(weatherIcon).append(pressure).append(relativeHumidity).append(cloudCover).append(past24HourTemperatureDeparture).append(precipitationType).append(dewPoint).append(ceiling).append(weatherText).append(uVIndexText).append(isDayTime).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Condition) == false) {
            return false;
        }
        Condition rhs = ((Condition) other);
        return new EqualsBuilder().append(pressureTendency, rhs.pressureTendency).append(visibility, rhs.visibility).append(precipitationSummary, rhs.precipitationSummary).append(link, rhs.link).append(precip1hr, rhs.precip1hr).append(apparentTemperature, rhs.apparentTemperature).append(localObservationDateTime, rhs.localObservationDateTime).append(hasPrecipitation, rhs.hasPrecipitation).append(temperature, rhs.temperature).append(mobileLink, rhs.mobileLink).append(windChillTemperature, rhs.windChillTemperature).append(uVIndex, rhs.uVIndex).append(epochTime, rhs.epochTime).append(temperatureSummary, rhs.temperatureSummary).append(wetBulbTemperature, rhs.wetBulbTemperature).append(obstructionsToVisibility, rhs.obstructionsToVisibility).append(realFeelTemperatureShade, rhs.realFeelTemperatureShade).append(windGust, rhs.windGust).append(wind, rhs.wind).append(realFeelTemperature, rhs.realFeelTemperature).append(weatherIcon, rhs.weatherIcon).append(pressure, rhs.pressure)
                .append(relativeHumidity, rhs.relativeHumidity).append(cloudCover, rhs.cloudCover).append(past24HourTemperatureDeparture, rhs.past24HourTemperatureDeparture).append(precipitationType, rhs.precipitationType).append(dewPoint, rhs.dewPoint).append(ceiling, rhs.ceiling).append(weatherText, rhs.weatherText).append(uVIndexText, rhs.uVIndexText).append(isDayTime, rhs.isDayTime).isEquals();
    }

}
