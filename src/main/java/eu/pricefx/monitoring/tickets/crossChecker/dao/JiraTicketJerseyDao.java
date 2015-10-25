package eu.pricefx.monitoring.tickets.crossChecker.dao;


import javax.ws.rs.client.ClientBuilder;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import eu.pricefx.monitoring.tickets.crossChecker.configuration.Configuartion;

public class JiraTicketJerseyDao {
  final Configuartion config;
  final HttpAuthenticationFeature httpAuthenticationFeature;
  final javax.ws.rs.client.Client client;
  final String jiraRestUrl;

  public JiraTicketJerseyDao(Configuartion config) {
    this.config = config;
    httpAuthenticationFeature = HttpAuthenticationFeature.basic(
        config.getJiraUser(), config.getJitbitPassword());
    client = ClientBuilder.newClient();
    jiraRestUrl = config.getJiraBaseUrl() + "/rest/api/latest/issue";
  }
  
  public String getTicketString(String id){
    return null;
  }
  
  
  

}
