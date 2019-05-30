package com.accuweather.glacier.api.objects2;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Headline",
"DailyForecasts"
})
public class DailyForeCast3 {

@JsonProperty("Headline")
private Headline2 headline;
@JsonProperty("DailyForecasts")
private List<DailyForecast4> dailyForecasts = new ArrayList<DailyForecast4>();

@JsonProperty("Headline")
public Headline2 getHeadline() {
return headline;
}

@JsonProperty("Headline")
public void setHeadline(Headline2 headline) {
this.headline = headline;
}

public DailyForeCast3 withHeadline(Headline2 headline) {
this.headline = headline;
return this;
}

@JsonProperty("DailyForecasts")
public List<DailyForecast4> getDailyForecasts() {
return dailyForecasts;
}

@JsonProperty("DailyForecasts")
public void setDailyForecasts(List<DailyForecast4> dailyForecasts) {
this.dailyForecasts = dailyForecasts;
}

public DailyForeCast3 withDailyForecasts(List<DailyForecast4> dailyForecasts) {
this.dailyForecasts = dailyForecasts;
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("headline", headline).append("dailyForecasts", dailyForecasts).toString();
}

@Override
public int hashCode() {
return new HashCodeBuilder().append(headline).append(dailyForecasts).toHashCode();
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof DailyForeCast3) == false) {
return false;
}
DailyForeCast3 rhs = ((DailyForeCast3) other);
return new EqualsBuilder().append(headline, rhs.headline).append(dailyForecasts, rhs.dailyForecasts).isEquals();
}

}
