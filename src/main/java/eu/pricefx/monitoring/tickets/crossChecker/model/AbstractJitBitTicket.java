package eu.pricefx.monitoring.tickets.crossChecker.model;

public abstract class AbstractJitBitTicket {

	public AbstractJitBitTicket() {
		// TODO Auto-generated constructor stub
	}

	private String TicketID;
	private String IssueID;
	private String Priority;
	private String DueDate;
	private String CategoryID;
	private String CategoryName;
	private String StatusID;
	private String Status;
	private String IssueDate;
	private String Subject;
	private String UserID;
	private String AssignedToUserID;
	private String ResolvedDate;
	private Boolean UpdatedByUser;
	private Boolean UpdatedByPerformer;
	private Boolean UpdatedForTechView;
	private Boolean IsCurrentUserTechInThisCategory;
	

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

	public String getPriority() {
		return Priority;
	}

	public void setPriority(String priority) {
		Priority = priority;
	}

	public Object getDueDate() {
		return DueDate;
	}

	public void setDueDate(String dueDate) {
		DueDate = dueDate;
	}

	public String getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(String categoryID) {
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

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getAssignedToUserID() {
		return AssignedToUserID;
	}

	public void setAssignedToUserID(String assignedToUserID) {
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
