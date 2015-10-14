package eu.pricefx.monitoring.tickets.crossChecker.reports;

public class ReportRecord {

	private String jitBitID;
	private	String jitBitSubject;
	private	String jiraID;
	private	String jiraStatus;
		
		
	public ReportRecord() {
		// TODO Auto-generated constructor stub
	}


	public ReportRecord(String jitBitID, String jitBitSubject, String jiraID,
			String jiraStatus) {
		super();
		this.jitBitID = jitBitID;
		this.jitBitSubject = jitBitSubject;
		this.jiraID = jiraID;
		this.jiraStatus = jiraStatus;
	}


	public String getJitBitID() {
		return jitBitID;
	}


	public void setJitBitID(String jitBitID) {
		this.jitBitID = jitBitID;
	}


	public String getJitBitSubject() {
		return jitBitSubject;
	}


	public void setJitBitSubject(String jitBitSubject) {
		this.jitBitSubject = jitBitSubject;
	}


	public String getJiraID() {
		return jiraID;
	}


	public void setJiraID(String jiraID) {
		this.jiraID = jiraID;
	}


	public String getJiraStatus() {
		return jiraStatus;
	}


	public void setJiraStatus(String jiraStatus) {
		this.jiraStatus = jiraStatus;
	}

}
