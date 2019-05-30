
package com.accuweather.glacier.api.objects2;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrecipitationSummary {

    @JsonProperty("Precipitation")
    private Precipitation precipitation;
    @JsonProperty("PastHour")
    private PastHour pastHour;
    @JsonProperty("Past3Hours")
    private Past3Hours past3Hours;
    @JsonProperty("Past6Hours")
    private Past6Hours past6Hours;
    @JsonProperty("Past9Hours")
    private Past9Hours past9Hours;
    @JsonProperty("Past12Hours")
    private Past12Hours past12Hours;
    @JsonProperty("Past18Hours")
    private Past18Hours past18Hours;
    @JsonProperty("Past24Hours")
    private Past24Hours past24Hours;

    /**
     * No args constructor for use in serialization
     *
     */
    public PrecipitationSummary() {
    }

    /**
     *
     * @param past12Hours
     * @param pastHour
     * @param past9Hours
     * @param past3Hours
     * @param precipitation
     * @param past6Hours
     * @param past24Hours
     * @param past18Hours
     */
    public PrecipitationSummary(Precipitation precipitation, PastHour pastHour, Past3Hours past3Hours, Past6Hours past6Hours, Past9Hours past9Hours, Past12Hours past12Hours, Past18Hours past18Hours, Past24Hours past24Hours) {
        super();
        this.precipitation = precipitation;
        this.pastHour = pastHour;
        this.past3Hours = past3Hours;
        this.past6Hours = past6Hours;
        this.past9Hours = past9Hours;
        this.past12Hours = past12Hours;
        this.past18Hours = past18Hours;
        this.past24Hours = past24Hours;
    }

    @JsonProperty("Precipitation")
    public Precipitation getPrecipitation() {
        return precipitation;
    }

    @JsonProperty("Precipitation")
    public void setPrecipitation(Precipitation precipitation) {
        this.precipitation = precipitation;
    }

    @JsonProperty("PastHour")
    public PastHour getPastHour() {
        return pastHour;
    }

    @JsonProperty("PastHour")
    public void setPastHour(PastHour pastHour) {
        this.pastHour = pastHour;
    }

    @JsonProperty("Past3Hours")
    public Past3Hours getPast3Hours() {
        return past3Hours;
    }

    @JsonProperty("Past3Hours")
    public void setPast3Hours(Past3Hours past3Hours) {
        this.past3Hours = past3Hours;
    }

    @JsonProperty("Past6Hours")
    public Past6Hours getPast6Hours() {
        return past6Hours;
    }

    @JsonProperty("Past6Hours")
    public void setPast6Hours(Past6Hours past6Hours) {
        this.past6Hours = past6Hours;
    }

    @JsonProperty("Past9Hours")
    public Past9Hours getPast9Hours() {
        return past9Hours;
    }

    @JsonProperty("Past9Hours")
    public void setPast9Hours(Past9Hours past9Hours) {
        this.past9Hours = past9Hours;
    }

    @JsonProperty("Past12Hours")
    public Past12Hours getPast12Hours() {
        return past12Hours;
    }

    @JsonProperty("Past12Hours")
    public void setPast12Hours(Past12Hours past12Hours) {
        this.past12Hours = past12Hours;
    }

    @JsonProperty("Past18Hours")
    public Past18Hours getPast18Hours() {
        return past18Hours;
    }

    @JsonProperty("Past18Hours")
    public void setPast18Hours(Past18Hours past18Hours) {
        this.past18Hours = past18Hours;
    }

    @JsonProperty("Past24Hours")
    public Past24Hours getPast24Hours() {
        return past24Hours;
    }

    @JsonProperty("Past24Hours")
    public void setPast24Hours(Past24Hours past24Hours) {
        this.past24Hours = past24Hours;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("precipitation", precipitation).append("pastHour", pastHour).append("past3Hours", past3Hours).append("past6Hours", past6Hours).append("past9Hours", past9Hours).append("past12Hours", past12Hours).append("past18Hours", past18Hours).append("past24Hours", past24Hours).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(past12Hours).append(pastHour).append(past9Hours).append(past3Hours).append(precipitation).append(past6Hours).append(past24Hours).append(past18Hours).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PrecipitationSummary) == false) {
            return false;
        }
        PrecipitationSummary rhs = ((PrecipitationSummary) other);
        return new EqualsBuilder().append(past12Hours, rhs.past12Hours).append(pastHour, rhs.pastHour).append(past9Hours, rhs.past9Hours).append(past3Hours, rhs.past3Hours).append(precipitation, rhs.precipitation).append(past6Hours, rhs.past6Hours).append(past24Hours, rhs.past24Hours).append(past18Hours, rhs.past18Hours).isEquals();
    }

}
