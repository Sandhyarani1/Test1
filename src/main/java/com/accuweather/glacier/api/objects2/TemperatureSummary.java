
package com.accuweather.glacier.api.objects2;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TemperatureSummary {

    @JsonProperty("Past6HourRange")
    private Past6HourRange past6HourRange;
    @JsonProperty("Past12HourRange")
    private Past12HourRange past12HourRange;
    @JsonProperty("Past24HourRange")
    private Past24HourRange past24HourRange;

    /**
     * No args constructor for use in serialization
     *
     */
    public TemperatureSummary() {
    }

    /**
     *
     * @param past12HourRange
     * @param past24HourRange
     * @param past6HourRange
     */
    public TemperatureSummary(Past6HourRange past6HourRange, Past12HourRange past12HourRange, Past24HourRange past24HourRange) {
        super();
        this.past6HourRange = past6HourRange;
        this.past12HourRange = past12HourRange;
        this.past24HourRange = past24HourRange;
    }

    @JsonProperty("Past6HourRange")
    public Past6HourRange getPast6HourRange() {
        return past6HourRange;
    }

    @JsonProperty("Past6HourRange")
    public void setPast6HourRange(Past6HourRange past6HourRange) {
        this.past6HourRange = past6HourRange;
    }

    @JsonProperty("Past12HourRange")
    public Past12HourRange getPast12HourRange() {
        return past12HourRange;
    }

    @JsonProperty("Past12HourRange")
    public void setPast12HourRange(Past12HourRange past12HourRange) {
        this.past12HourRange = past12HourRange;
    }

    @JsonProperty("Past24HourRange")
    public Past24HourRange getPast24HourRange() {
        return past24HourRange;
    }

    @JsonProperty("Past24HourRange")
    public void setPast24HourRange(Past24HourRange past24HourRange) {
        this.past24HourRange = past24HourRange;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("past6HourRange", past6HourRange).append("past12HourRange", past12HourRange).append("past24HourRange", past24HourRange).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(past12HourRange).append(past24HourRange).append(past6HourRange).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TemperatureSummary) == false) {
            return false;
        }
        TemperatureSummary rhs = ((TemperatureSummary) other);
        return new EqualsBuilder().append(past12HourRange, rhs.past12HourRange).append(past24HourRange, rhs.past24HourRange).append(past6HourRange, rhs.past6HourRange).isEquals();
    }

}