package com.accuweather.glacier.api.objects1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class AirAndPollen {
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Value")
	private Integer value;
	@JsonProperty("Category")
	private String category;
	@JsonProperty("CategoryValue")
	private Integer categoryValue;
	@JsonProperty("Type")
	private String type;
	
	public AirAndPollen() {}
	
	public AirAndPollen(String name,Integer value,String category,Integer categoryValue,String type) {
		super();
		this.category = category;
		this.categoryValue = categoryValue;
		this.name = name;
		this.type = type;
		this.value = value;
		
	}
	@JsonProperty("Name")
	public String getName() {
	return name;
	}

	@JsonProperty("Name")
	public void setName(String name) {
	this.name = name;
	}

	@JsonProperty("Value")
	public Integer getValue() {
	return value;
	}

	@JsonProperty("Value")
	public void setValue(Integer value) {
	this.value = value;
	}

	@JsonProperty("Category")
	public String getCategory() {
	return category;
	}

	@JsonProperty("Category")
	public void setCategory(String category) {
	this.category = category;
	}

	@JsonProperty("CategoryValue")
	public Integer getCategoryValue() {
	return categoryValue;
	}

	@JsonProperty("CategoryValue")
	public void setCategoryValue(Integer categoryValue) {
	this.categoryValue = categoryValue;
	}

	@JsonProperty("Type")
	public String getType() {
	return type;
	}

	@JsonProperty("Type")
	public void setType(String type) {
	this.type = type;
	}

	@Override
	public String toString() {
	return new ToStringBuilder(this).append("name", name).append("value", value).append("category", category).append("categoryValue", categoryValue).append("type", type).toString();
	}

	@Override
	public int hashCode() {
	return new HashCodeBuilder().append(category).append(categoryValue).append(name).append(value).append(type).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
	if (other == this) {
	return true;
	}
	if ((other instanceof AirAndPollen) == false) {
	return false;
	}
	AirAndPollen rhs = ((AirAndPollen) other);
	return new EqualsBuilder().append(category, rhs.category).append(categoryValue, rhs.categoryValue).append(name, rhs.name).append(value, rhs.value).append(type, rhs.type).isEquals();
	}
}
