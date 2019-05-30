package com.accuweather.glacier.api.objects;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

    @JsonProperty("Version")
    private Integer version;
    @JsonProperty("Key")
    private String key;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Rank")
    private Integer rank;
    @JsonProperty("LocalizedName")
    private String localizedName;
    @JsonProperty("EnglishName")
    private String englishName;
    @JsonProperty("PrimaryPostalCode")
    private String primaryPostalCode;
    @JsonProperty("Region")
    private Region region;
    @JsonProperty("Country")
    private Country country;
    @JsonProperty("AdministrativeArea")
    private AdministrativeArea administrativeArea;
    @JsonProperty("TimeZone")
    private TimeZone timeZone;
    @JsonProperty("GeoPosition")
    private GeoPosition geoPosition;
    @JsonProperty("IsAlias")
    private Boolean isAlias;
    @JsonProperty("ParentCity")
    private ParentCity parentCity;
    @JsonProperty("SupplementalAdminAreas")
    private List<SupplementalAdminArea> supplementalAdminAreas = new ArrayList<SupplementalAdminArea>();
    @JsonProperty("DataSets")
    private List<String> dataSets = new ArrayList<String>();
    @JsonProperty("Details")
    private Details details;

    /**
     * No args constructor for use in serialization
     *
     */
    public Location() {
    }

    /**
     *
     * @param region
     * @param geoPosition
     * @param administrativeArea
     * @param timeZone
     * @param dataSets
     * @param type
     * @param supplementalAdminAreas
     * @param version
     * @param country
     * @param englishName
     * @param rank
     * @param localizedName
     * @param primaryPostalCode
     * @param details
     * @param isAlias
     * @param key
     */
    public Location(Integer version, String key, String type, Integer rank, String localizedName, String englishName, String primaryPostalCode, Region region, Country country, AdministrativeArea administrativeArea, TimeZone timeZone, GeoPosition geoPosition, Boolean isAlias, List<SupplementalAdminArea> supplementalAdminAreas, List<String> dataSets, Details details) {
        super();
        this.version = version;
        this.key = key;
        this.type = type;
        this.rank = rank;
        this.localizedName = localizedName;
        this.englishName = englishName;
        this.primaryPostalCode = primaryPostalCode;
        this.region = region;
        this.country = country;
        this.administrativeArea = administrativeArea;
        this.timeZone = timeZone;
        this.geoPosition = geoPosition;
        this.isAlias = isAlias;
        this.supplementalAdminAreas = supplementalAdminAreas;
        this.dataSets = dataSets;
        this.details = details;
    }

    @JsonProperty("Version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("Version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    @JsonProperty("Key")
    public String getKey() {
        return key;
    }

    @JsonProperty("Key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("Rank")
    public Integer getRank() {
        return rank;
    }

    @JsonProperty("Rank")
    public void setRank(Integer rank) {
        this.rank = rank;
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

    @JsonProperty("PrimaryPostalCode")
    public String getPrimaryPostalCode() {
        return primaryPostalCode;
    }

    @JsonProperty("PrimaryPostalCode")
    public void setPrimaryPostalCode(String primaryPostalCode) {
        this.primaryPostalCode = primaryPostalCode;
    }

    @JsonProperty("Region")
    public Region getRegion() {
        return region;
    }

    @JsonProperty("Region")
    public void setRegion(Region region) {
        this.region = region;
    }

    @JsonProperty("Country")
    public Country getCountry() {
        return country;
    }

    @JsonProperty("Country")
    public void setCountry(Country country) {
        this.country = country;
    }

    @JsonProperty("AdministrativeArea")
    public AdministrativeArea getAdministrativeArea() {
        return administrativeArea;
    }

    @JsonProperty("AdministrativeArea")
    public void setAdministrativeArea(AdministrativeArea administrativeArea) {
        this.administrativeArea = administrativeArea;
    }

    @JsonProperty("TimeZone")
    public TimeZone getTimeZone() {
        return timeZone;
    }

    @JsonProperty("TimeZone")
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    @JsonProperty("GeoPosition")
    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    @JsonProperty("GeoPosition")
    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    @JsonProperty("IsAlias")
    public Boolean getIsAlias() {
        return isAlias;
    }

    @JsonProperty("IsAlias")
    public void setIsAlias(Boolean isAlias) {
        this.isAlias = isAlias;
    }

    public ParentCity getParentCity() {
        return parentCity;
    }

    public void setParentCity(ParentCity parentCity) {
        this.parentCity = parentCity;
    }

    @JsonProperty("SupplementalAdminAreas")
    public List<SupplementalAdminArea> getSupplementalAdminAreas() {
        return supplementalAdminAreas;
    }

    @JsonProperty("SupplementalAdminAreas")
    public void setSupplementalAdminAreas(List<SupplementalAdminArea> supplementalAdminAreas) {
        this.supplementalAdminAreas = supplementalAdminAreas;
    }

    @JsonProperty("DataSets")
    public List<String> getDataSets() {
        return dataSets;
    }

    @JsonProperty("DataSets")
    public void setDataSets(List<String> dataSets) {
        this.dataSets = dataSets;
    }

    @JsonProperty("Details")
    public Details getDetails() {
        return details;
    }

    @JsonProperty("Details")
    public void setDetails(Details details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("version", version).append("key", key).append("type", type).append("rank", rank).append("localizedName", localizedName).append("englishName", englishName).append("primaryPostalCode", primaryPostalCode).append("region", region).append("country", country).append("administrativeArea", administrativeArea).append("timeZone", timeZone).append("geoPosition", geoPosition).append("isAlias", isAlias).append("parentCity", parentCity).append("supplementalAdminAreas", supplementalAdminAreas).append("dataSets", dataSets).append("details", details).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(geoPosition).append(region).append(administrativeArea).append(timeZone).append(dataSets).append(type).append(supplementalAdminAreas).append(country).append(version).append(englishName).append(localizedName).append(rank).append(primaryPostalCode).append(details).append(isAlias).append(parentCity).append(key).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Location) == false) {
            return false;
        }
        Location rhs = ((Location) other);
        return new EqualsBuilder().append(geoPosition, rhs.geoPosition).append(region, rhs.region).append(administrativeArea, rhs.administrativeArea).append(timeZone, rhs.timeZone).append(dataSets, rhs.dataSets).append(type, rhs.type).append(supplementalAdminAreas, rhs.supplementalAdminAreas).append(country, rhs.country).append(version, rhs.version).append(englishName, rhs.englishName).append(localizedName, rhs.localizedName).append(rank, rhs.rank).append(primaryPostalCode, rhs.primaryPostalCode).append(details, rhs.details).append(isAlias, rhs.isAlias).append(parentCity, rhs.parentCity).append(key, rhs.key).isEquals();
    }

}