package com.accuweather.glacier.api.objects1;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country {

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("LocalizedName")
    private String localizedName;
    @JsonProperty("EnglishName")
    private String englishName;

    /**
     * No args constructor for use in serialization
     *
     */
    public Country() {
    }

    /**
     *
     * @param englishName
     * @param localizedName
     * @param iD
     */
    public Country(String iD, String localizedName, String englishName) {
        super();
        this.iD = iD;
        this.localizedName = localizedName;
        this.englishName = englishName;
    }

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    @JsonProperty("LocalizedName")
    public String getLocalizedName() {
        return localizedName;
    }

    @JsonProperty("LocalizedName")
    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    @JsonProperty("EnglishName")
    public String getEnglishName() {
        return englishName;
    }

    @JsonProperty("EnglishName")
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("iD", iD).append("localizedName", localizedName).append("englishName", englishName).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(englishName).append(localizedName).append(iD).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Country) == false) {
            return false;
        }
        Country rhs = ((Country) other);
        return new EqualsBuilder().append(englishName, rhs.englishName).append(localizedName, rhs.localizedName).append(iD, rhs.iD).isEquals();
    }

}