package com.accuweather.glacier.api.objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WindGust {

    @JsonProperty("Speed")
    private Speed speed;

    /**
     * No args constructor for use in serialization
     *
     */
    public WindGust() {
    }

    /**
     *
     * @param speed
     */
    public WindGust(Speed speed) {
        super();
        this.speed = speed;
    }

    @JsonProperty("Speed")
    public Speed getSpeed() {
        return speed;
    }

    @JsonProperty("Speed")
    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("speed", speed).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(speed).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WindGust) == false) {
            return false;
        }
        WindGust rhs = ((WindGust) other);
        return new EqualsBuilder().append(speed, rhs.speed).isEquals();
    }

}