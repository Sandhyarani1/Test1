
package com.accuweather.glacier.api.objects1;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.accuweather.glacier.api.objects.Imperial;
import com.accuweather.glacier.api.objects.Metric;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Temperature {

	@JsonProperty("Minimum")
	private Minimum minimum;
	@JsonProperty("Maximum")
	private Maximum maximum;
	@JsonProperty("Metric")
    private Metric metric;
    @JsonProperty("Imperial")
    private Imperial imperial;

	
    /**
     * No args constructor for use in serialization
     *
     */
    public Temperature() {
    }

    /**
     *
     * @param imperial
     * @param metric
     */
    public Temperature(Maximum maximum, Minimum minimum,Metric metric,Imperial imperial) {
        super();
        this.maximum = maximum;
        this.minimum = minimum;
        this.metric = metric;
        this.imperial = imperial;
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

	
	  @Override public String toString() { return new
	  ToStringBuilder(this).append("minimum", minimum).append("maximum",
	  maximum).append("metric", metric).append("imperial", imperial).toString(); }
	  
	  @Override public int hashCode() { return new
	  HashCodeBuilder().append(minimum).append(maximum).append(imperial).append(metric).toHashCode(); }
	  
	  @Override public boolean equals(Object other) { if (other == this) { return
	  true; } if ((other instanceof Temperature) == false) { return false; }
	  Temperature rhs = ((Temperature) other); return new
	  EqualsBuilder().append(minimum, rhs.minimum).append(maximum,
	  rhs.maximum).append(imperial, rhs.imperial).append(metric, rhs.metric).isEquals(); }
	 
}
