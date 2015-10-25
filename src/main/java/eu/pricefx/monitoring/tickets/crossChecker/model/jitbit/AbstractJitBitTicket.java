package eu.pricefx.monitoring.tickets.crossChecker.model.jitbit;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;

public abstract class AbstractJitBitTicket {

	public AbstractJitBitTicket() {
		// TODO Auto-generated constructor stub
	}

	private String TicketID;
	private String IssueID;
	private int Priority;
	private String DueDate;
	private int CategoryID;
	private String CategoryName;
	private String StatusID;
	private String Status;
	private String IssueDate;
	protected String Subject;
	private int UserID;
	private int AssignedToUserID;
	private String ResolvedDate;
	private Boolean UpdatedByUser;
	private Boolean UpdatedByPerformer;
	private Boolean UpdatedForTechView;
	private Boolean IsCurrentUserTechInThisCategory;
	
	
  @JsonCreator
	public AbstractJitBitTicket(Map<String,Object> props){
    if (props.containsKey("TicketID")) {
      TicketID =  String.valueOf(props.get("TicketID"));
      IssueID = TicketID;
    }
     
   else {
      TicketID =   String.valueOf(props.get("IssueID"));
      IssueID = TicketID;
        
    }
      
    Priority = (int) props.get("Priority");
	  DueDate = (String) props.get("DueDate");
	  CategoryID = (int) props.get("CategoryID");
	  CategoryName = (String) props.get("CategoryName");
	  Status = (String) props.get("Status");
	  IssueDate = (String) props.get("IssueDate");
	  Subject = (String) props.get("Subject");
	  UserID = (int) props.get("UserID");
	  AssignedToUserID = (int) props.get("AssignedToUserID");
	  ResolvedDate = (String) props.get("ResolvedDate");
	  UpdatedByUser = (Boolean) props.get("UpdatedByUser");
	  UpdatedByPerformer = (Boolean) props.get("UpdatedByPerformer");
	  UpdatedForTechView = (Boolean) props.get("UpdatedForTechView");
	  IsCurrentUserTechInThisCategory = (Boolean) props.get("IsCurrentUserTechInThisCategory");
	}
  
  
	public String getTicketID() {
		
		if  ((TicketID == null) && (IssueID != null)) {
			TicketID = IssueID;
		}
		return TicketID;
		
	}

	public void setTicketID(String ticletID) {
		TicketID = ticletID;
		IssueID = ticletID;
	}

	public String getIssueID() {
		if ((TicketID == null) && (IssueID != null)){
			TicketID = IssueID;
		}
		
		return TicketID;
	}

	public void setIssueID(String ticletID) {
		TicketID = ticletID;
		IssueID = ticletID;
	}

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public Object getDueDate() {
		return DueDate;
	}

	public void setDueDate(String dueDate) {
		DueDate = dueDate;
	}

	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getCategory() {
		return CategoryName;
	}

	public void setCategory(String categoryName) {
		CategoryName = categoryName;
	}

	public String getStatusID() {
		return StatusID;
	}

	public void setStatusID(String statusID) {
		StatusID = statusID;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getIssueDate() {
		return IssueDate;
	}

	public void setIssueDate(String issueDate) {
		IssueDate = issueDate;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public int getAssignedToUserID() {
		return AssignedToUserID;
	}

	public void setAssignedToUserID(int assignedToUserID) {
		AssignedToUserID = assignedToUserID;
	}

	public String getResolvedDate() {
		return ResolvedDate;
	}

	public void setResolvedDate(String resolvedDate) {
		ResolvedDate = resolvedDate;
	}

	public Boolean getUpdatedByUser() {
		return UpdatedByUser;
	}

	public void setUpdatedByUser(Boolean updatedByUser) {
		UpdatedByUser = updatedByUser;
	}

	public Boolean getUpdatedByPerformer() {
		return UpdatedByPerformer;
	}

	public void setUpdatedByPerformer(Boolean updatedByPerformer) {
		UpdatedByPerformer = updatedByPerformer;
	}

	public Boolean getUpdatedForTechView() {
		return UpdatedForTechView;
	}

	public void setUpdatedForTechView(Boolean updatedForTechView) {
		UpdatedForTechView = updatedForTechView;
	}

	public Boolean getIsCurrentUserTechInThisCategory() {
		return IsCurrentUserTechInThisCategory;
	}

	public void setIsCurrentUserTechInThisCategory(
			Boolean isCurrentUserTechInThisCategory) {
		IsCurrentUserTechInThisCategory = isCurrentUserTechInThisCategory;
	}

}
