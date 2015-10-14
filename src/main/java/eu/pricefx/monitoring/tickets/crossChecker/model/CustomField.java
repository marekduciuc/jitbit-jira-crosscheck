package eu.pricefx.monitoring.tickets.crossChecker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Example of json responce
 * {"FieldName":"External Reference",
 * "FieldID":10233,
 * "Type":1,
 * "UsageType":0,
 * "Value":"PFCD-1599",
 * "ValueWithOption":"PFCD-1599",
 * "Mandatory":false},
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomField {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FieldID == null) ? 0 : FieldID.hashCode());
		result = prime * result + ((Value == null) ? 0 : Value.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomField other = (CustomField) obj;
		if (FieldID == null) {
			if (other.FieldID != null)
				return false;
		} else if (!FieldID.equals(other.FieldID))
			return false;
		if (Value == null) {
			if (other.Value != null)
				return false;
		} else if (!Value.equals(other.Value))
			return false;
		return true;
	}
	public String getFieldName() {
		return FieldName;
	}
	public void setFieldName(String fieldName) {
		FieldName = fieldName;
	}
	public String getFieldID() {
		return FieldID;
	}
	public void setFieldID(String fieldID) {
		FieldID = fieldID;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getUsageType() {
		return UsageType;
	}
	public void setUsageType(String usageType) {
		UsageType = usageType;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	public String getValueWithOption() {
		return ValueWithOption;
	}
	public void setValueWithOption(String valueWithOption) {
		ValueWithOption = valueWithOption;
	}
	public boolean isMandatory() {
		return Mandatory;
	}
	public void setMandatory(boolean mandatory) {
		Mandatory = mandatory;
	}


	
	public CustomField() {
		// TODO Auto-generated constructor stub
	}

	 private String FieldName;
	 private String FieldID;
	 private String Type;
	 private String UsageType;
	 private String Value;
	 private String ValueWithOption;
	 private boolean Mandatory;
	
	
}
