package com.accuweather.glacier.api.objects2;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApparentTemperature {

    @JsonProperty("Metric")
    private Metric1 metric;
    @JsonProperty("Imperial")
    private Imperial1 imperial;

    /**
     * No args constructor for use in serialization
     *
     */
    public ApparentTemperature() {
    }

    /**
     *
     * @param imperial
     * @param metric
     */
    public ApparentTemperature(Metric1 metric, Imperial1 imperial) {
        super();
        this.metric = metric;
        this.imperial = imperial;
    }

    @JsonProperty("Metric")
    public Metric1 getMetric() {
        return metric;
    }

    @JsonProperty("Metric")
    public void setMetric(Metric1 metric) {
        this.metric = metric;
    }

    @JsonProperty("Imperial")
    public Imperial1 getImperial() {
        return imperial;
    }

    @JsonProperty("Imperial")
    public void setImperial(Imperial1 imperial) {
        this.imperial = imperial;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("metric", metric).append("imperial", imperial).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(imperial).append(metric).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ApparentTemperature) == false) {
            return false;
        }
        ApparentTemperature rhs = ((ApparentTemperature) other);
        return new EqualsBuilder().append(imperial, rhs.imperial).append(metric, rhs.metric).isEquals();
    }

}
