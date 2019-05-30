
package com.accuweather.glacier.api.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Degrees",
    "Localized",
    "English"
})
public class Direction {

    @JsonProperty("Degrees")
    private Integer degrees;
    @JsonProperty("Localized")
    private String localized;
    @JsonProperty("English")
    private String english;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Direction() {
    }

    /**
     * 
     * @param degrees
     * @param english
     * @param localized
     */
    public Direction(Integer degrees, String localized, String english) {
        super();
        this.degrees = degrees;
        this.localized = localized;
        this.english = english;
    }

    @JsonProperty("Degrees")
    public Integer getDegrees() {
        return degrees;
    }

    @JsonProperty("Degrees")
    public void setDegrees(Integer degrees) {
        this.degrees = degrees;
    }

    @JsonProperty("Localized")
    public String getLocalized() {
        return localized;
    }

    @JsonProperty("Localized")
    public void setLocalized(String localized) {
        this.localized = localized;
    }

    @JsonProperty("English")
    public String getEnglish() {
        return english;
    }

    @JsonProperty("English")
    public void setEnglish(String english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("degrees", degrees).append("localized", localized).append("english", english).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(degrees).append(english).append(localized).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Direction) == false) {
            return false;
        }
        Direction rhs = ((Direction) other);
        return new EqualsBuilder().append(degrees, rhs.degrees).append(english, rhs.english).append(localized, rhs.localized).isEquals();
    }

}
