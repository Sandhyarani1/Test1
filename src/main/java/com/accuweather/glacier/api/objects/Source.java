package com.accuweather.glacier.api.objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Source {

    @JsonProperty("DataType")
    private String dataType;
    @JsonProperty("Source")
    private String source;
    @JsonProperty("SourceId")
    private Integer sourceId;

    /**
     * No args constructor for use in serialization
     *
     */
    public Source() {
    }

    /**
     *
     * @param dataType
     * @param source
     * @param sourceId
     */
    public Source(String dataType, String source, Integer sourceId) {
        super();
        this.dataType = dataType;
        this.source = source;
        this.sourceId = sourceId;
    }

    @JsonProperty("DataType")
    public String getDataType() {
        return dataType;
    }

    @JsonProperty("DataType")
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @JsonProperty("Source")
    public String getSource() {
        return source;
    }

    @JsonProperty("Source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("SourceId")
    public Integer getSourceId() {
        return sourceId;
    }

    @JsonProperty("SourceId")
    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dataType", dataType).append("source", source).append("sourceId", sourceId).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dataType).append(source).append(sourceId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Source) == false) {
            return false;
        }
        Source rhs = ((Source) other);
        return new EqualsBuilder().append(dataType, rhs.dataType).append(source, rhs.source).append(sourceId, rhs.sourceId).isEquals();
    }

}