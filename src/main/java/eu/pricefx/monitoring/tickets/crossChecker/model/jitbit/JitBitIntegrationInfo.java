package eu.pricefx.monitoring.tickets.crossChecker.model.jitbit;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//Integrations": {
//"JiraURL": "https://pricefx.atlassian.net/browse/PFCD-1614"
//},

@JsonIgnoreProperties(ignoreUnknown = true)
public class JitBitIntegrationInfo {
  
  @JsonProperty
  private String jiraUrl;
  
  public JitBitIntegrationInfo() {
  
  }

  public String getJiraUrl() {
    return jiraUrl;
  }

  public void setJiraUrl(String jiraUrl) {
    this.jiraUrl = jiraUrl;
  }
  
  @JsonCreator
  public JitBitIntegrationInfo(Map<String,Object> props){
    jiraUrl = (String) props.get("JiraURL");
  }

}
