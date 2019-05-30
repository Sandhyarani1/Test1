package com.accuweather.glacier.api.objects1;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocalSource {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("WeatherCode")
    private String weatherCode;

    /**
     * No args constructor for use in serialization
     *
     */
    public LocalSource() {
    }

    /**
     *
     * @param englishName
     * @param localizedName
     * @param iD
     */
    public LocalSource(String id, String name, String weatherCode) {
        super();
        this.id = id;
        this.name = name;
        this.weatherCode = weatherCode;
    }

    @JsonProperty("Id")
    public String getID() {
        return id;
    }

    @JsonProperty("Id")
    public void setID(String id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setLocalizedName(String name) {
        this.name = name;
    }

    @JsonProperty("WeatherCode")
    public String getWeatherCode() {
        return weatherCode;
    }

    @JsonProperty("WeatherCode")
    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("weatherCode", weatherCode).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(weatherCode).append(id).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LocalSource) == false) {
            return false;
        }
        LocalSource rhs = ((LocalSource) other);
        return new EqualsBuilder().append(name, rhs.name).append(weatherCode, rhs.weatherCode).append(id, rhs.id).isEquals();
    }

}