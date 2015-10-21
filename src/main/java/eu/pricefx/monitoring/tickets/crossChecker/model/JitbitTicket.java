package eu.pricefx.monitoring.tickets.crossChecker.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JitbitTicket extends AbstractJitBitTicket {

	public JitbitTicket() {
		// TODO Auto-generated constructor stub
	}

	private String UserName;
	private String Technician;
	private String FirstName;
	private String LastName;
	private String TechFirstName;
	private String TechLastName;
	private String LastUpdated;
	private String CompanyName;
	private int SectionID;

	@JsonCreator
	public JitbitTicket(Map<String,Object> props){
	 super(props);
	  UserName = (String)props.get(UserName);
	  Technician = (String)props.get(Technician);
	  FirstName = (String)props.get(FirstName);
	  LastName = (String)props.get(LastName);
	  TechFirstName= (String)props.get(TechFirstName);
	  TechLastName = (String)props.get(TechLastName);
	  LastUpdated = (String)props.get(LastUpdated);
	  CompanyName = (String)props.get(CompanyName);
	 // SectionID = (int)props.get(SectionID);
	}
	
	
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getTechnician() {
		return Technician;
	}

	public void setTechnician(String technician) {
		Technician = technician;
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

	public String getTechFirstName() {
		return TechFirstName;
	}

	public void setTechFirstName(String techFirstName) {
		TechFirstName = techFirstName;
	}

	public String getTechLastName() {
		return TechLastName;
	}

	public void setTechLastName(String techLastName) {
		TechLastName = techLastName;
	}

	public String getLastUpdated() {
		return LastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		LastUpdated = lastUpdated;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public int getSectionID() {
		return SectionID;
	}

	public void setSectionID(int sectionID) {
		SectionID = sectionID;
	}

}
