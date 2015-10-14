package eu.pricefx.monitoring.tickets.crossChecker.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JitBitTicketDetail extends AbstractJitBitTicket {

	private List<Attachment> Attachments = new ArrayList<Attachment>();
	private List<Tag> Tags = new ArrayList<Tag>();
	private String OnBehalfUserName;
	private List<JitBitUser> SubmitterUserInfo = new ArrayList<JitBitUser>();
	private JitBitUser AssigneeUserInfo = new JitBitUser();
	private String Url;
	private List<Object> ViewingTechNames = new ArrayList<Object>();
	private String Body;
	private String StartDate;
	private Integer TimeSpentInSeconds;
	private Boolean SubmittedByCurrentUser;
	private Boolean IsInKb;
	
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

	public List<JitBitUser> getSubmitterUserInfo() {
		return SubmitterUserInfo;
	}

	public void setSubmitterUserInfo(List<JitBitUser> submitterUserInfo) {
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

}
