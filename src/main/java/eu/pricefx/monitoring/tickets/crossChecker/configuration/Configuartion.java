package eu.pricefx.monitoring.tickets.crossChecker.configuration;

import org.apache.commons.configuration.*; 

public class Configuartion {
	
	private String jiraUser;
	private String jiraPassword;
	private String jiraBaseUrl;
	private String jitBitUser;
	private String jitbitPassword;
	private String jitBitTicketListUrl;
	private String jitBitTicketUrl;
	private String jitBitticketCustomFieldsUrl;
	private String outputFile;
	private boolean updateJitbitTickes;
	
	
	static Configuartion configuartion = null;
	
		
	public Configuartion() {
			
	}
	
	public static Configuartion getInstance() {
		  if(configuartion == null) {
		     synchronized(Configuartion.class) {
		       if(configuartion == null) {
		    	   configuartion = new Configuartion();
					PropertiesConfiguration config;
					try {
						config = new PropertiesConfiguration("config.properties");
						configuartion.jiraUser = config.getString("jira.user");
						configuartion.jiraPassword = config.getString("jira.password");
						configuartion.jiraBaseUrl = config.getString("jira.baseUrl");
						configuartion.jitBitUser = config.getString("jitBit.user");
						configuartion.jitbitPassword = config.getString("jitBit.password");
						String basUrlString = config.getString("jitBit.baseUrl");
						configuartion.jitBitTicketListUrl = basUrlString + config.getString("jitBit.ticketList.path");
						configuartion.jitBitTicketUrl = basUrlString + config.getString("jitBit.ticket.path");
						configuartion.jitBitticketCustomFieldsUrl = basUrlString + config.getString("jitBit.ticketCustomFields.path");
						configuartion.outputFile = config.getString("output.file");
						configuartion.updateJitbitTickes = config.getBoolean("update.JitbitTickes", false);
					
					} catch (ConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		       }
		     }
		  }
		   return configuartion;
		  }
	
	
	
	public String getJiraUser() {
		return jiraUser;
	}

	public void setJiraUser(String jiraUser) {
		this.jiraUser = jiraUser;
	}

	public String getJiraPassword() {
		return jiraPassword;
	}

	public void setJiraPassword(String jiraPassword) {
		this.jiraPassword = jiraPassword;
	}

	public String getJitBitUser() {
		return jitBitUser;
	}

	public void setJitBitUser(String jitBitUser) {
		this.jitBitUser = jitBitUser;
	}

	public String getJitbitPassword() {
		return jitbitPassword;
	}

	public void setJitbitPassword(String jitbitPassword) {
		this.jitbitPassword = jitbitPassword;
	}

	public String getJiraBaseUrl() {
		return jiraBaseUrl;
	}


	public void setJiraBaseUrl(String jiraBaseUrl) {
		this.jiraBaseUrl = jiraBaseUrl;
	}


	public String getJitBitTicketListUrl() {
		return jitBitTicketListUrl;
	}


	public void setJitBitTicketListUrl(String jitBitTicketListUrl) {
		this.jitBitTicketListUrl = jitBitTicketListUrl;
	}


	public String getJitBitTicketUrl() {
		return jitBitTicketUrl;
	}


	public void setJitBitTicketUrl(String jitBitTicketUrl) {
		this.jitBitTicketUrl = jitBitTicketUrl;
	}


	public String getJitBitticketCustomFieldsUrl() {
		return jitBitticketCustomFieldsUrl;
	}


	public void setJitBitticketCustomFieldsUrl(String jitBitticketCustomFieldsUrl) {
		this.jitBitticketCustomFieldsUrl = jitBitticketCustomFieldsUrl;
	}

  public String getOutputFile() {
    return outputFile;
  }

  public void setOutputFile(String outputFile) {
    this.outputFile = outputFile;
  }

  public boolean isUpdateJitbitTickes() {
    return updateJitbitTickes;
  }

  public void setUpdateJitbitTickes(boolean updateJitbitTickes) {
    this.updateJitbitTickes = updateJitbitTickes;
  }
	
	

}
