package com.accuweather.glacier.api.objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdministrativeArea {

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("LocalizedName")
    private String localizedName;
    @JsonProperty("EnglishName")
    private String englishName;
    @JsonProperty("Level")
    private Integer level;
    @JsonProperty("LocalizedType")
    private String localizedType;
    @JsonProperty("EnglishType")
    private String englishType;
    @JsonProperty("CountryID")
    private String countryID;

    /**
     * No args constructor for use in serialization
     *
     */
    public AdministrativeArea() {
    }

    /**
     *
     * @param englishName
     * @param englishType
     * @param localizedName
     * @param level
     * @param countryID
     * @param localizedType
     * @param iD
     */
    public AdministrativeArea(String iD, String localizedName, String englishName, Integer level, String localizedType, String englishType, String countryID) {
        super();
        this.iD = iD;
        this.localizedName = localizedName;
        this.englishName = englishName;
        this.level = level;
        this.localizedType = localizedType;
        this.englishType = englishType;
        this.countryID = countryID;
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

    @JsonProperty("Level")
    public Integer getLevel() {
        return level;
    }

    @JsonProperty("Level")
    public void setLevel(Integer level) {
        this.level = level;
    }

    @JsonProperty("LocalizedType")
    public String getLocalizedType() {
        return localizedType;
    }

    @JsonProperty("LocalizedType")
    public void setLocalizedType(String localizedType) {
        this.localizedType = localizedType;
    }

    @JsonProperty("EnglishType")
    public String getEnglishType() {
        return englishType;
    }

    @JsonProperty("EnglishType")
    public void setEnglishType(String englishType) {
        this.englishType = englishType;
    }

    @JsonProperty("CountryID")
    public String getCountryID() {
        return countryID;
    }

    @JsonProperty("CountryID")
    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("iD", iD).append("localizedName", localizedName).append("englishName", englishName).append("level", level).append("localizedType", localizedType).append("englishType", englishType).append("countryID", countryID).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(englishName).append(englishType).append(localizedName).append(level).append(countryID).append(localizedType).append(iD).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AdministrativeArea) == false) {
            return false;
        }
        AdministrativeArea rhs = ((AdministrativeArea) other);
        return new EqualsBuilder().append(englishName, rhs.englishName).append(englishType, rhs.englishType).append(localizedName, rhs.localizedName).append(level, rhs.level).append(countryID, rhs.countryID).append(localizedType, rhs.localizedType).append(iD, rhs.iD).isEquals();
    }

}