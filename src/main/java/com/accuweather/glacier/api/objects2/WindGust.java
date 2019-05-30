package com.accuweather.glacier.api.objects2;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WindGust {

    @JsonProperty("Speed")
    private Speed speed;
    @JsonProperty("Direction")
    private Direction direction;
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
    public WindGust(Speed speed, Direction direction) {
        super();
        this.speed = speed;
        this.direction = direction;
    }

    @JsonProperty("Speed")
    public Speed getSpeed() {
        return speed;
    }

    @JsonProperty("Speed")
    public void setSpeed(Speed speed) {
        this.speed = speed;
    }
    
    @JsonProperty("Direction")
    public Direction getDirection() {
    return direction;
    }

    @JsonProperty("Direction")
    public void setDirection(Direction direction) {
    this.direction = direction;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("speed", speed).append("direction", direction).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(speed).append(direction).toHashCode();
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
        return new EqualsBuilder().append(speed, rhs.speed).append(direction, rhs.direction).isEquals();
    }

}