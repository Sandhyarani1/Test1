package com.accuweather.glacier.api.objects2;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeZone {

    @JsonProperty("Code")
    private String code;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("GmtOffset")
    private Double gmtOffset;
    @JsonProperty("IsDaylightSaving")
    private Boolean isDaylightSaving;
    @JsonProperty("NextOffsetChange")
    private String nextOffsetChange;

    /**
     * No args constructor for use in serialization
     *
     */
    public TimeZone() {
    }

    /**
     *
     * @param isDaylightSaving
     * @param nextOffsetChange
     * @param name
     * @param gmtOffset
     * @param code
     */
    public TimeZone(String code, String name, Double gmtOffset, Boolean isDaylightSaving, String nextOffsetChange) {
        super();
        this.code = code;
        this.name = name;
        this.gmtOffset = gmtOffset;
        this.isDaylightSaving = isDaylightSaving;
        this.nextOffsetChange = nextOffsetChange;
    }

    @JsonProperty("Code")
    public String getCode() {
        return code;
    }

    @JsonProperty("Code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("GmtOffset")
    public Double getGmtOffset() {
        return gmtOffset;
    }

    @JsonProperty("GmtOffset")
    public void setGmtOffset(Double gmtOffset) {
        this.gmtOffset = gmtOffset;
    }

    @JsonProperty("IsDaylightSaving")
    public Boolean getIsDaylightSaving() {
        return isDaylightSaving;
    }

    @JsonProperty("IsDaylightSaving")
    public void setIsDaylightSaving(Boolean isDaylightSaving) {
        this.isDaylightSaving = isDaylightSaving;
    }

    @JsonProperty("NextOffsetChange")
    public String getNextOffsetChange() {
        return nextOffsetChange;
    }

    @JsonProperty("NextOffsetChange")
    public void setNextOffsetChange(String nextOffsetChange) {
        this.nextOffsetChange = nextOffsetChange;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("code", code).append("name", name).append("gmtOffset", gmtOffset).append("isDaylightSaving", isDaylightSaving).append("nextOffsetChange", nextOffsetChange).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(isDaylightSaving).append(nextOffsetChange).append(name).append(gmtOffset).append(code).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TimeZone) == false) {
            return false;
        }
        TimeZone rhs = ((TimeZone) other);
        return new EqualsBuilder().append(isDaylightSaving, rhs.isDaylightSaving).append(nextOffsetChange, rhs.nextOffsetChange).append(name, rhs.name).append(gmtOffset, rhs.gmtOffset).append(code, rhs.code).isEquals();
    }

}