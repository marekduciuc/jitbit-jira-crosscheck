package eu.pricefx.monitoring.tickets.crossChecker.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import eu.pricefx.monitoring.tickets.crossChecker.configuration.Configuartion;
import eu.pricefx.monitoring.tickets.crossChecker.model.jitbit.CustomField;
import eu.pricefx.monitoring.tickets.crossChecker.model.jitbit.JitBitTicketDetail;
import eu.pricefx.monitoring.tickets.crossChecker.model.jitbit.JitbitStatus;
import eu.pricefx.monitoring.tickets.crossChecker.model.jitbit.JitbitTicket;

public class JitbitTicketDao implements IJitbitTicketDao {

  final static int JIRA_STATUS_FIELD_ID = 11705;
  final static int EXTRNAL_REFERENCE_FIELD_ID = 10233;
  final String ticketListurl;
  final String ticketDetetailUrl;
  final String ticketCustomFiledsUrl;
  final Configuartion config;
  final HttpAuthenticationFeature httpAuthenticationFeature;
  final javax.ws.rs.client.Client client;

  public JitbitTicketDao(Configuartion config) {
    this.config = config;
    ticketListurl = config.getJitBitTicketListUrl();
    ticketDetetailUrl = config.getJitBitTicketUrl();
    ticketCustomFiledsUrl = config.getJitBitticketCustomFieldsUrl();
    httpAuthenticationFeature = HttpAuthenticationFeature.basic(
        config.getJiraUser(), config.getJitbitPassword());
    client = ClientBuilder.newClient();
    client.register(httpAuthenticationFeature);

  }

  @Override
  public List<JitbitTicket> getTickets() {
    List<JitbitTicket> tickets = new ArrayList<JitbitTicket>();
    List<JitbitTicket> tickets2 = null;
    int offset = 0;
    int pageSize = 100;
    WebTarget target = null;
    do {
      if (offset == 0) {
        target = client.target(ticketListurl)
            .queryParam("statusId", JitbitStatus.ASSIGNED_TO_ENGENEERING.value)
            .queryParam("count", pageSize);
      } else {
        target = client.target(ticketListurl)
            .queryParam("statusId", JitbitStatus.ASSIGNED_TO_ENGENEERING.value)
            .queryParam("count", pageSize).queryParam("offset", offset);
      }
      offset += pageSize;

      Invocation.Builder invocationBuilder = target
          .request(MediaType.APPLICATION_JSON_TYPE);
      tickets2 = invocationBuilder.get(new GenericType<List<JitbitTicket>>() {
      });
      tickets.addAll(tickets2);
    } while (tickets2.size() == pageSize);

    return tickets;
  }

  @Override
  public String getTicketDetialAsString(String ticketId) {
    WebTarget target = client.target(ticketDetetailUrl).queryParam("id",
        ticketId);
    Invocation.Builder invocationBuilder = target
        .request(MediaType.APPLICATION_JSON_TYPE);
    String response = invocationBuilder.get(String.class);
    return response;
  }

  @Override
  public JitBitTicketDetail getTicketDetial(String ticketId) {
    WebTarget target = client.target(ticketDetetailUrl).queryParam("id",
        ticketId);
    Invocation.Builder invocationBuilder = target
        .request(MediaType.APPLICATION_JSON_TYPE);
    JitBitTicketDetail response = invocationBuilder
        .get(JitBitTicketDetail.class);
    return response;
  }

  @Override
  public String getCustomFieldsAsString(String ticketId) {
    WebTarget target = client.target(ticketCustomFiledsUrl).queryParam("id",
        ticketId);
    Invocation.Builder invocationBuilder = target
        .request(MediaType.APPLICATION_JSON_TYPE);
    String response = invocationBuilder.get(String.class);
    return response;
  }

  @Override
  public List<CustomField> getCustomFieldsList(String ticketId) {
    WebTarget target = client.target(ticketCustomFiledsUrl).queryParam("id",ticketId);
    Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
    List<CustomField> response = invocationBuilder.get(new GenericType<List<CustomField>>(){});
    return response;
  }

  @Override
  public String getJiraIdValue(List<CustomField> customFields) {
    List<CustomField> list = customFields.stream()
        .filter(field -> field.getFieldID()==EXTRNAL_REFERENCE_FIELD_ID)
        .collect(Collectors.toList());
    if ((list.size() != 0) && (list.get(0).getValue() != null)) {
      return list.get(0).getValue().replaceAll("\\s+", "");
    }
    return null;
  }
  
  
//POST https://[helpdesk-url]/api/SetCustomField
 // ticketId int Ticket ID
 // fieldId int Custom field ID
 // value string Value as a string. For checkboxes pass true or false. For
 // dropdowns pass the option ID. For dates pass date as a string in any
 // format.

 public int updateJiraStatus(String ticketId, String jiraStatus) {

   
   WebTarget target = client.target("https://pricefx.jitbit.com/helpdesk/api/SetCustomField")
       .queryParam("ticketId", ticketId)
       .queryParam("fieldId", JIRA_STATUS_FIELD_ID)
       .queryParam("value", jiraStatus);
   
   Invocation.Builder invocationBuilder = target.request();
   Response responce  = invocationBuilder.accept(MediaType.TEXT_PLAIN).post(Entity.text("")) ;
   return responce.getStatus() ;
 }
  
  
  
  

}
