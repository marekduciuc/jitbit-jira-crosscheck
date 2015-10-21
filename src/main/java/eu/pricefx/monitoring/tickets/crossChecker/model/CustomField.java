package eu.pricefx.monitoring.tickets.crossChecker.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
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

  private String FieldName;
  private int FieldID;
  private int Type;
  private int UsageType;
  private String Value;
  private String ValueWithOption;
  private boolean Mandatory;
 
  @JsonCreator
  public CustomField(Map<String,Object> props) {
    FieldName = (String) props.get("FieldName");
    FieldID  = (int) props.get("FieldID");
    Type  = (int) props.get("Type");
    UsageType  = (int) props.get("UsageType");
    if  (props.get("Value") instanceof Integer) {
      Value  = String.valueOf( props.get("Value"));
    }
    if  (props.get("Value") instanceof String) {
      Value  = (String) props.get("Value");
    }
    ValueWithOption  = (String) props.get("ValueWithOption");
    Mandatory  = (Boolean) props.get("Mandatory");
  }

	
	public String getFieldName() {
		return FieldName;
	}
	public void setFieldName(String fieldName) {
		FieldName = fieldName;
	}
	public int getFieldID() {
		return FieldID;
	}
	public void setFieldID(int fieldID) {
		FieldID = fieldID;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public int getUsageType() {
		return UsageType;
	}
	public void setUsageType(int usageType) {
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


	
	
	
	
}
