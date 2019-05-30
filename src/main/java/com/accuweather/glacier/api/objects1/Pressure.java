
package com.accuweather.glacier.api.objects1;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pressure {

    @JsonProperty("Metric")
    private Metric metric;
    @JsonProperty("Imperial")
    private Imperial imperial;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pressure() {
    }

    /**
     *
     * @param imperial
     * @param metric
     */
    public Pressure(Metric metric, Imperial imperial) {
        super();
        this.metric = metric;
        this.imperial = imperial;
    }

    @JsonProperty("Metric")
    public Metric getMetric() {
        return metric;
    }

    @JsonProperty("Metric")
    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    @JsonProperty("Imperial")
    public Imperial getImperial() {
        return imperial;
    }

    @JsonProperty("Imperial")
    public void setImperial(Imperial imperial) {
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
        if ((other instanceof Pressure) == false) {
            return false;
        }
        Pressure rhs = ((Pressure) other);
        return new EqualsBuilder().append(imperial, rhs.imperial).append(metric, rhs.metric).isEquals();
    }

}
