
package com.accuweather.glacier.api.objects2;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PressureTendency {

    @JsonProperty("LocalizedText")
    private String localizedText;
    @JsonProperty("Code")
    private String code;

    /**
     * No args constructor for use in serialization
     *
     */
    public PressureTendency() {
    }

    /**
     *
     * @param localizedText
     * @param code
     */
    public PressureTendency(String localizedText, String code) {
        super();
        this.localizedText = localizedText;
        this.code = code;
    }

    @JsonProperty("LocalizedText")
    public String getLocalizedText() {
        return localizedText;
    }

    @JsonProperty("LocalizedText")
    public void setLocalizedText(String localizedText) {
        this.localizedText = localizedText;
    }

    @JsonProperty("Code")
    public String getCode() {
        return code;
    }

    @JsonProperty("Code")
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("localizedText", localizedText).append("code", code).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(localizedText).append(code).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PressureTendency) == false) {
            return false;
        }
        PressureTendency rhs = ((PressureTendency) other);
        return new EqualsBuilder().append(localizedText, rhs.localizedText).append(code, rhs.code).isEquals();
    }

}
