package eu.pricefx.monitoring.tickets.crossChecker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JitBitTicketDetail extends AbstractJitBitTicket {

  @JsonProperty
	private List<Attachment> Attachments = new ArrayList<Attachment>();
  @JsonProperty
  private List<Tag> Tags = new ArrayList<Tag>();
  @JsonProperty
	private String OnBehalfUserName;
  @JsonProperty
	private JitBitUser SubmitterUserInfo = new JitBitUser();
  @JsonProperty
	private JitBitUser AssigneeUserInfo = new JitBitUser();
  @JsonProperty
	private String Url;
  @JsonProperty
	private List<Object> ViewingTechNames = new ArrayList<Object>();
  @JsonProperty
	private String Body;
  @JsonProperty
	private String StartDate;
  @JsonProperty
	private Integer TimeSpentInSeconds;
  @JsonProperty
	private Boolean SubmittedByCurrentUser;
  @JsonProperty
	private Boolean IsInKb;
  @JsonProperty
	private JitBitIntegrationInfo Integrations;
	
  
  @JsonCreator
  public JitBitTicketDetail(Map<String,Object> props) {
    super(props);
    OnBehalfUserName = (String) props.get("OnBehalfUserName");
    Url = (String) props.get("Url");
    StartDate = (String) props.get("StartDate");
    TimeSpentInSeconds = (int) props.get("TimeSpentInSeconds");
    SubmittedByCurrentUser = (Boolean) props.get("SubmittedByCurrentUser");
    IsInKb = (Boolean) props.get("IsInKb");
    Integrations = new JitBitIntegrationInfo( (Map<String,Object>)props.get("Integrations"));
    
  }
  
  
  
	public List<Attachment> getAttachments() {
		return Attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		Attachments = attachments;
	}

	public List<Tag> getTags() {
		return Tags;
	}

	public void setTags(List<Tag> tags) {
		Tags = tags;
	}

	public String getOnBehalfUserName() {
		return OnBehalfUserName;
	}

	public void setOnBehalfUserName(String onBehalfUserName) {
		OnBehalfUserName = onBehalfUserName;
	}

	public JitBitUser getSubmitterUserInfo() {
		return SubmitterUserInfo;
	}

	public void setSubmitterUserInfo(JitBitUser submitterUserInfo) {
		SubmitterUserInfo = submitterUserInfo;
	}

	public JitBitUser getAssigneeUserInfo() {
		return AssigneeUserInfo;
	}

	public void setAssigneeUserInfo(JitBitUser assigneeUserInfo) {
		AssigneeUserInfo = assigneeUserInfo;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public List<Object> getViewingTechNames() {
		return ViewingTechNames;
	}

	public void setViewingTechNames(List<Object> viewingTechNames) {
		ViewingTechNames = viewingTechNames;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public Integer getTimeSpentInSeconds() {
		return TimeSpentInSeconds;
	}

	public void setTimeSpentInSeconds(Integer timeSpentInSeconds) {
		TimeSpentInSeconds = timeSpentInSeconds;
	}

	public Boolean getSubmittedByCurrentUser() {
		return SubmittedByCurrentUser;
	}

	public void setSubmittedByCurrentUser(Boolean submittedByCurrentUser) {
		SubmittedByCurrentUser = submittedByCurrentUser;
	}

	public Boolean getIsInKb() {
		return IsInKb;
	}

	public void setIsInKb(Boolean isInKb) {
		IsInKb = isInKb;
	}

  public JitBitIntegrationInfo getIntegrations() {
    return Integrations;
  }

  public void setIntegrations(JitBitIntegrationInfo integrations) {
    Integrations = integrations;
  }
 

}
