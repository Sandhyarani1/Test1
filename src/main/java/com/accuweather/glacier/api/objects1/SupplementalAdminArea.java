package com.accuweather.glacier.api.objects1;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplementalAdminArea {

    @JsonProperty("Level")
    private Integer level;
    @JsonProperty("LocalizedName")
    private String localizedName;
    @JsonProperty("EnglishName")
    private String englishName;

    /**
     * No args constructor for use in serialization
     *
     */
    public SupplementalAdminArea() {
    }

    /**
     *
     * @param englishName
     * @param localizedName
     * @param level
     */
    public SupplementalAdminArea(Integer level, String localizedName, String englishName) {
        super();
        this.level = level;
        this.localizedName = localizedName;
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
        return new ToStringBuilder(this).append("level", level).append("localizedName", localizedName).append("englishName", englishName).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(englishName).append(localizedName).append(level).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SupplementalAdminArea) == false) {
            return false;
        }
        SupplementalAdminArea rhs = ((SupplementalAdminArea) other);
        return new EqualsBuilder().append(englishName, rhs.englishName).append(localizedName, rhs.localizedName).append(level, rhs.level).isEquals();
    }

}