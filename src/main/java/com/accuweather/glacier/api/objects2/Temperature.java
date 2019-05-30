
package com.accuweather.glacier.api.objects2;

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
    public Temperature(Maximum maximum, Minimum minimum) {
        super();
        this.maximum = maximum;
        this.minimum = minimum;
        
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
    
   

	
	  @Override public String toString() { return new
	  ToStringBuilder(this).append("minimum", minimum).append("maximum",
	  maximum).toString(); }
	  
	  @Override public int hashCode() { return new
	  HashCodeBuilder().append(minimum).append(maximum).toHashCode(); }
	  
	  @Override public boolean equals(Object other) { if (other == this) { return
	  true; } if ((other instanceof Temperature) == false) { return false; }
	  Temperature rhs = ((Temperature) other); return new
	  EqualsBuilder().append(minimum, rhs.minimum).append(maximum,
	  rhs.maximum).isEquals(); }
	 
}
