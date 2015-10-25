package eu.pricefx.monitoring.tickets.crossChecker.model.jitbit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * "AssigneeUserInfo": { "UserID": 606019, "InstanceID": 17217, "Username":
 * "marek.duciuc", "Password": null, "Email": "marek.duciuc@pricefx.eu",
 * "FirstName": "Marek", "LastName": "Duciuc", "Notes": "", "Location": "",
 * "Phone": "00420608556401", "Department": null, "CompanyName": "Price f(x)",
 * "IPAddress": "46.174.56.18", "HostName": "46.174.56.18", "Lang": "en-US",
 * "UserAgent":
 * "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:41.0) Gecko/20100101 Firefox/41.0"
 * , "AvatarURL": null, "Signature": "", "Greeting": "", "CompanyId": 34509,
 * "CRMID": null, "CompanyNotes": null, "TicketsHandled": null,
 * "TicketsSubmitted": null, "IsAdmin": true, "Disabled": false, "SendEmail":
 * true, "IsTech": false, "TicketsAssigned": 0, "LastSeen":
 * "/Date(1444753896013)/", "RecentTickets": null, "IsManager": false,
 * "TechTutorialShown": true, "AdminTutorialShown": true, "PushToken": null,
 * "FullNameAndLogin": "marek.duciuc, Marek Duciuc", "FullName": "Marek Duciuc"
 * }
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class JitBitUser {

	private String UserID;
	private String InstanceID;
	private String Username;
	private String Password;
	private String Email;
	private String FirstName;
	private String LastName;
	private String Notes;
	private String Location;
	private String Phone;
	private String Department;
	private String CompanyName;
	private String IPAddress;
	private String HostName;
	private String Lang;
	private String UserAgent;
	private String AvatarURL;
	private String Signature;
	private String Greeting;
	private String CompanyId;
	private String CRMID;
	private String CompanyNotes;
	private String TicketsHandled;
	private String TicketsSubmitted;
	private Boolean IsAdmin;
	private Boolean Disabled;
	private Boolean SendEmail;
	private Boolean IsTech;
	private String TicketsAssigned;
	private String LastSeen;
	private String RecentTickets;
	private Boolean IsManager;
	private Boolean TechTutorialShown;
	private Boolean AdminTutorialShown;
	private String PushToken;
	private String FullNameAndLogin;
	private String FullName;
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getInstanceID() {
		return InstanceID;
	}
	public void setInstanceID(String instanceID) {
		InstanceID = instanceID;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getIPAddress() {
		return IPAddress;
	}
	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}
	public String getHostName() {
		return HostName;
	}
	public void setHostName(String hostName) {
		HostName = hostName;
	}
	public String getLang() {
		return Lang;
	}
	public void setLang(String lang) {
		Lang = lang;
	}
	public String getUserAgent() {
		return UserAgent;
	}
	public void setUserAgent(String userAgent) {
		UserAgent = userAgent;
	}
	public String getAvatarURL() {
		return AvatarURL;
	}
	public void setAvatarURL(String avatarURL) {
		AvatarURL = avatarURL;
	}
	public String getSignature() {
		return Signature;
	}
	public void setSignature(String signature) {
		Signature = signature;
	}
	public String getGreeting() {
		return Greeting;
	}
	public void setGreeting(String greeting) {
		Greeting = greeting;
	}
	public String getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId(String companyId) {
		CompanyId = companyId;
	}
	public String getCRMID() {
		return CRMID;
	}
	public void setCRMID(String cRMID) {
		CRMID = cRMID;
	}
	public String getCompanyNotes() {
		return CompanyNotes;
	}
	public void setCompanyNotes(String companyNotes) {
		CompanyNotes = companyNotes;
	}
	public String getTicketsHandled() {
		return TicketsHandled;
	}
	public void setTicketsHandled(String ticketsHandled) {
		TicketsHandled = ticketsHandled;
	}
	public String getTicketsSubmitted() {
		return TicketsSubmitted;
	}
	public void setTicketsSubmitted(String ticketsSubmitted) {
		TicketsSubmitted = ticketsSubmitted;
	}
	public Boolean getIsAdmin() {
		return IsAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		IsAdmin = isAdmin;
	}
	public Boolean getDisabled() {
		return Disabled;
	}
	public void setDisabled(Boolean disabled) {
		Disabled = disabled;
	}
	public Boolean getSendEmail() {
		return SendEmail;
	}
	public void setSendEmail(Boolean sendEmail) {
		SendEmail = sendEmail;
	}
	public Boolean getIsTech() {
		return IsTech;
	}
	public void setIsTech(Boolean isTech) {
		IsTech = isTech;
	}
	public String getTicketsAssigned() {
		return TicketsAssigned;
	}
	public void setTicketsAssigned(String ticketsAssigned) {
		TicketsAssigned = ticketsAssigned;
	}
	public String getLastSeen() {
		return LastSeen;
	}
	public void setLastSeen(String lastSeen) {
		LastSeen = lastSeen;
	}
	public String getRecentTickets() {
		return RecentTickets;
	}
	public void setRecentTickets(String recentTickets) {
		RecentTickets = recentTickets;
	}
	public Boolean getIsManager() {
		return IsManager;
	}
	public void setIsManager(Boolean isManager) {
		IsManager = isManager;
	}
	public Boolean getTechTutorialShown() {
		return TechTutorialShown;
	}
	public void setTechTutorialShown(Boolean techTutorialShown) {
		TechTutorialShown = techTutorialShown;
	}
	public Boolean getAdminTutorialShown() {
		return AdminTutorialShown;
	}
	public void setAdminTutorialShown(Boolean adminTutorialShown) {
		AdminTutorialShown = adminTutorialShown;
	}
	public String getPushToken() {
		return PushToken;
	}
	public void setPushToken(String pushToken) {
		PushToken = pushToken;
	}
	public String getFullNameAndLogin() {
		return FullNameAndLogin;
	}
	public void setFullNameAndLogin(String fullNameAndLogin) {
		FullNameAndLogin = fullNameAndLogin;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}

	
}
