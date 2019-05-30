
package com.accuweather.glacier.api.objects2;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Minimum",
        "Maximum"
})
public class Past6HourRange {

    @JsonProperty("Minimum")
    private Minimum minimum;
    @JsonProperty("Maximum")
    private Maximum maximum;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Past6HourRange() {
    }

    /**
     * 
     * @param minimum
     * @param maximum
     */
    public Past6HourRange(Minimum minimum, Maximum maximum) {
        super();
        this.minimum = minimum;
        this.maximum = maximum;
    }

    @JsonProperty("Minimum")
    public Minimum getMinimum() {
        return minimum;
    }

    @JsonProperty("Minimum")
    public void setMinimum(Minimum minimum) {
        this.minimum = minimum;
    }

    @JsonProperty("Maximum")
    public Maximum getMaximum() {
        return maximum;
    }

    @JsonProperty("Maximum")
    public void setMaximum(Maximum maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("minimum", minimum).append("maximum", maximum).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(minimum).append(maximum).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Past6HourRange) == false) {
            return false;
        }
        Past6HourRange rhs = ((Past6HourRange) other);
        return new EqualsBuilder().append(minimum, rhs.minimum).append(maximum, rhs.maximum).isEquals();
    }

}