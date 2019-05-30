package com.accuweather.glacier.api.objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeoPosition {

    @JsonProperty("Latitude")
    private Double latitude;
    @JsonProperty("Longitude")
    private Double longitude;
    @JsonProperty("Elevation")
    private Elevation elevation;

    /**
     * No args constructor for use in serialization
     *
     */
    public GeoPosition() {
    }

    /**
     *
     * @param elevation
     * @param longitude
     * @param latitude
     */
    public GeoPosition(Double latitude, Double longitude, Elevation elevation) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }

    @JsonProperty("Latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("Latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("Longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("Longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("Elevation")
    public Elevation getElevation() {
        return elevation;
    }

    @JsonProperty("Elevation")
    public void setElevation(Elevation elevation) {
        this.elevation = elevation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("latitude", latitude).append("longitude", longitude).append("elevation", elevation).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(elevation).append(longitude).append(latitude).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GeoPosition) == false) {
            return false;
        }
        GeoPosition rhs = ((GeoPosition) other);
        return new EqualsBuilder().append(elevation, rhs.elevation).append(longitude, rhs.longitude).append(latitude, rhs.latitude).isEquals();
    }

}