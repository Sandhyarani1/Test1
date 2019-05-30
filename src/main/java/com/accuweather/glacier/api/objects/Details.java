package com.accuweather.glacier.api.objects;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Details {

    @JsonProperty("Key")
    private String key;
    @JsonProperty("StationCode")
    private String stationCode;
    @JsonProperty("StationGmtOffset")
    private Double stationGmtOffset;
    @JsonProperty("BandMap")
    private String bandMap;
    @JsonProperty("Climo")
    private String climo;
    @JsonProperty("LocalRadar")
    private String localRadar;
    @JsonProperty("MediaRegion")
    private String mediaRegion;
    @JsonProperty("Metar")
    private String metar;
    @JsonProperty("NXMetro")
    private String nXMetro;
    @JsonProperty("NXState")
    private String nXState;
    @JsonProperty("Population")
    private Integer population;
    @JsonProperty("PrimaryWarningCountyCode")
    private String primaryWarningCountyCode;
    @JsonProperty("PrimaryWarningZoneCode")
    private String primaryWarningZoneCode;
    @JsonProperty("Satellite")
    private String satellite;
    @JsonProperty("Synoptic")
    private String synoptic;
    @JsonProperty("MarineStation")
    private String marineStation;
    @JsonProperty("MarineStationGMTOffset")
    private Object marineStationGMTOffset;
    @JsonProperty("VideoCode")
    private String videoCode;
    @JsonProperty("LocationStem")
    private String locationStem;
    @JsonProperty("DMA")
    private DMA dMA;
    @JsonProperty("PartnerID")
    private Object partnerID;
    @JsonProperty("Sources")
    private List<Source> sources = new ArrayList<Source>();
    @JsonProperty("CanonicalPostalCode")
    private String canonicalPostalCode;
    @JsonProperty("CanonicalLocationKey")
    private String canonicalLocationKey;

    /**
     * No args constructor for use in serialization
     *
     */
    public Details() {
    }

    /**
     *
     * @param satellite
     * @param stationCode
     * @param stationGmtOffset
     * @param primaryWarningZoneCode
     * @param canonicalPostalCode
     * @param marineStationGMTOffset
     * @param marineStation
     * @param sources
     * @param primaryWarningCountyCode
     * @param canonicalLocationKey
     * @param dMA
     * @param nXState
     * @param locationStem
     * @param climo
     * @param localRadar
     * @param bandMap
     * @param videoCode
     * @param mediaRegion
     * @param partnerID
     * @param synoptic
     * @param nXMetro
     * @param key
     * @param metar
     * @param population
     */
    public Details(String key, String stationCode, Double stationGmtOffset, String bandMap, String climo, String localRadar, String mediaRegion, String metar, String nXMetro, String nXState, Integer population, String primaryWarningCountyCode, String primaryWarningZoneCode, String satellite, String synoptic, String marineStation, Object marineStationGMTOffset, String videoCode, String locationStem, DMA dMA, Object partnerID, List<Source> sources, String canonicalPostalCode, String canonicalLocationKey) {
        super();
        this.key = key;
        this.stationCode = stationCode;
        this.stationGmtOffset = stationGmtOffset;
        this.bandMap = bandMap;
        this.climo = climo;
        this.localRadar = localRadar;
        this.mediaRegion = mediaRegion;
        this.metar = metar;
        this.nXMetro = nXMetro;
        this.nXState = nXState;
        this.population = population;
        this.primaryWarningCountyCode = primaryWarningCountyCode;
        this.primaryWarningZoneCode = primaryWarningZoneCode;
        this.satellite = satellite;
        this.synoptic = synoptic;
        this.marineStation = marineStation;
        this.marineStationGMTOffset = marineStationGMTOffset;
        this.videoCode = videoCode;
        this.locationStem = locationStem;
        this.dMA = dMA;
        this.partnerID = partnerID;
        this.sources = sources;
        this.canonicalPostalCode = canonicalPostalCode;
        this.canonicalLocationKey = canonicalLocationKey;
    }

    @JsonProperty("Key")
    public String getKey() {
        return key;
    }

    @JsonProperty("Key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("StationCode")
    public String getStationCode() {
        return stationCode;
    }

    @JsonProperty("StationCode")
    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    @JsonProperty("StationGmtOffset")
    public Double getStationGmtOffset() {
        return stationGmtOffset;
    }

    @JsonProperty("StationGmtOffset")
    public void setStationGmtOffset(Double stationGmtOffset) {
        this.stationGmtOffset = stationGmtOffset;
    }

    @JsonProperty("BandMap")
    public String getBandMap() {
        return bandMap;
    }

    @JsonProperty("BandMap")
    public void setBandMap(String bandMap) {
        this.bandMap = bandMap;
    }

    @JsonProperty("Climo")
    public String getClimo() {
        return climo;
    }

    @JsonProperty("Climo")
    public void setClimo(String climo) {
        this.climo = climo;
    }

    @JsonProperty("LocalRadar")
    public String getLocalRadar() {
        return localRadar;
    }

    @JsonProperty("LocalRadar")
    public void setLocalRadar(String localRadar) {
        this.localRadar = localRadar;
    }

    @JsonProperty("MediaRegion")
    public String getMediaRegion() {
        return mediaRegion;
    }

    @JsonProperty("MediaRegion")
    public void setMediaRegion(String mediaRegion) {
        this.mediaRegion = mediaRegion;
    }

    @JsonProperty("Metar")
    public String getMetar() {
        return metar;
    }

    @JsonProperty("Metar")
    public void setMetar(String metar) {
        this.metar = metar;
    }

    @JsonProperty("NXMetro")
    public String getNXMetro() {
        return nXMetro;
    }

    @JsonProperty("NXMetro")
    public void setNXMetro(String nXMetro) {
        this.nXMetro = nXMetro;
    }

    @JsonProperty("NXState")
    public String getNXState() {
        return nXState;
    }

    @JsonProperty("NXState")
    public void setNXState(String nXState) {
        this.nXState = nXState;
    }

    @JsonProperty("Population")
    public Integer getPopulation() {
        return population;
    }

    @JsonProperty("Population")
    public void setPopulation(Integer population) {
        this.population = population;
    }

    @JsonProperty("PrimaryWarningCountyCode")
    public String getPrimaryWarningCountyCode() {
        return primaryWarningCountyCode;
    }

    @JsonProperty("PrimaryWarningCountyCode")
    public void setPrimaryWarningCountyCode(String primaryWarningCountyCode) {
        this.primaryWarningCountyCode = primaryWarningCountyCode;
    }

    @JsonProperty("PrimaryWarningZoneCode")
    public String getPrimaryWarningZoneCode() {
        return primaryWarningZoneCode;
    }

    @JsonProperty("PrimaryWarningZoneCode")
    public void setPrimaryWarningZoneCode(String primaryWarningZoneCode) {
        this.primaryWarningZoneCode = primaryWarningZoneCode;
    }

    @JsonProperty("Satellite")
    public String getSatellite() {
        return satellite;
    }

    @JsonProperty("Satellite")
    public void setSatellite(String satellite) {
        this.satellite = satellite;
    }

    @JsonProperty("Synoptic")
    public String getSynoptic() {
        return synoptic;
    }

    @JsonProperty("Synoptic")
    public void setSynoptic(String synoptic) {
        this.synoptic = synoptic;
    }

    @JsonProperty("MarineStation")
    public String getMarineStation() {
        return marineStation;
    }

    @JsonProperty("MarineStation")
    public void setMarineStation(String marineStation) {
        this.marineStation = marineStation;
    }

    @JsonProperty("MarineStationGMTOffset")
    public Object getMarineStationGMTOffset() {
        return marineStationGMTOffset;
    }

    @JsonProperty("MarineStationGMTOffset")
    public void setMarineStationGMTOffset(Object marineStationGMTOffset) {
        this.marineStationGMTOffset = marineStationGMTOffset;
    }

    @JsonProperty("VideoCode")
    public String getVideoCode() {
        return videoCode;
    }

    @JsonProperty("VideoCode")
    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }

    @JsonProperty("LocationStem")
    public String getLocationStem() {
        return locationStem;
    }

    @JsonProperty("LocationStem")
    public void setLocationStem(String locationStem) {
        this.locationStem = locationStem;
    }

    @JsonProperty("DMA")
    public DMA getDMA() {
        return dMA;
    }

    @JsonProperty("DMA")
    public void setDMA(DMA dMA) {
        this.dMA = dMA;
    }

    @JsonProperty("PartnerID")
    public Object getPartnerID() {
        return partnerID;
    }

    @JsonProperty("PartnerID")
    public void setPartnerID(Object partnerID) {
        this.partnerID = partnerID;
    }

    @JsonProperty("Sources")
    public List<Source> getSources() {
        return sources;
    }

    @JsonProperty("Sources")
    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    @JsonProperty("CanonicalPostalCode")
    public String getCanonicalPostalCode() {
        return canonicalPostalCode;
    }

    @JsonProperty("CanonicalPostalCode")
    public void setCanonicalPostalCode(String canonicalPostalCode) {
        this.canonicalPostalCode = canonicalPostalCode;
    }

    @JsonProperty("CanonicalLocationKey")
    public String getCanonicalLocationKey() {
        return canonicalLocationKey;
    }

    @JsonProperty("CanonicalLocationKey")
    public void setCanonicalLocationKey(String canonicalLocationKey) {
        this.canonicalLocationKey = canonicalLocationKey;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("key", key).append("stationCode", stationCode).append("stationGmtOffset", stationGmtOffset).append("bandMap", bandMap).append("climo", climo).append("localRadar", localRadar).append("mediaRegion", mediaRegion).append("metar", metar).append("nXMetro", nXMetro).append("nXState", nXState).append("population", population).append("primaryWarningCountyCode", primaryWarningCountyCode).append("primaryWarningZoneCode", primaryWarningZoneCode).append("satellite", satellite).append("synoptic", synoptic).append("marineStation", marineStation).append("marineStationGMTOffset", marineStationGMTOffset).append("videoCode", videoCode).append("locationStem", locationStem).append("dMA", dMA).append("partnerID", partnerID).append("sources", sources).append("canonicalPostalCode", canonicalPostalCode).append("canonicalLocationKey", canonicalLocationKey).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(satellite).append(primaryWarningZoneCode).append(canonicalPostalCode).append(marineStation).append(sources).append(canonicalLocationKey).append(nXState).append(localRadar).append(videoCode).append(partnerID).append(synoptic).append(key).append(population).append(metar).append(stationCode).append(stationGmtOffset).append(marineStationGMTOffset).append(primaryWarningCountyCode).append(dMA).append(locationStem).append(climo).append(bandMap).append(mediaRegion).append(nXMetro).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Details) == false) {
            return false;
        }
        Details rhs = ((Details) other);
        return new EqualsBuilder().append(satellite, rhs.satellite).append(primaryWarningZoneCode, rhs.primaryWarningZoneCode).append(canonicalPostalCode, rhs.canonicalPostalCode).append(marineStation, rhs.marineStation).append(sources, rhs.sources).append(canonicalLocationKey, rhs.canonicalLocationKey).append(nXState, rhs.nXState).append(localRadar, rhs.localRadar).append(videoCode, rhs.videoCode).append(partnerID, rhs.partnerID).append(synoptic, rhs.synoptic).append(key, rhs.key).append(population, rhs.population).append(metar, rhs.metar).append(stationCode, rhs.stationCode).append(stationGmtOffset, rhs.stationGmtOffset).append(marineStationGMTOffset, rhs.marineStationGMTOffset).append(primaryWarningCountyCode, rhs.primaryWarningCountyCode).append(dMA, rhs.dMA).append(locationStem, rhs.locationStem).append(climo, rhs.climo).append(bandMap, rhs.bandMap).append(mediaRegion, rhs.mediaRegion).append(nXMetro, rhs.nXMetro).isEquals();
    }

}