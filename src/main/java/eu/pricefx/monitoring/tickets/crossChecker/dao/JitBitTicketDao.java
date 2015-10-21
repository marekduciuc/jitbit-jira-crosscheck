package eu.pricefx.monitoring.tickets.crossChecker.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import eu.pricefx.monitoring.tickets.crossChecker.base64.Base64Wrapper;
import eu.pricefx.monitoring.tickets.crossChecker.configuration.Configuartion;
import eu.pricefx.monitoring.tickets.crossChecker.model.CustomField;
import eu.pricefx.monitoring.tickets.crossChecker.model.JitBitTicketDetail;
import eu.pricefx.monitoring.tickets.crossChecker.model.JitbitTicket;
import eu.pricefx.monitoring.tickets.crossChecker.model.JitbitStatus;

public class JitBitTicketDao implements IJitbitTicketDao {

  final String ticketListurl;
  final String ticketDetetailUrl;
  final String ticketCustomFiledsUrl;
  final RestTemplate restTemplate = new RestTemplate();
  final HttpHeaders headers = new HttpHeaders();
  final HttpEntity<String> entity;
  final Gson gson = new Gson();
  final Configuartion config;

  public JitBitTicketDao(Configuartion conf) {
    config = conf;
    ticketListurl = config.getJitBitTicketListUrl();
    ticketDetetailUrl = config.getJitBitTicketUrl();
    ticketCustomFiledsUrl = config.getJitBitticketCustomFieldsUrl();
    headers.add(
        "Authorization",
        "Basic "
            + Base64Wrapper.encode(config.getJitBitUser() + ":"
                + config.getJitbitPassword()));
    this.entity = new HttpEntity<String>("parameters", headers);
  }

  public List<JitbitTicket> getTickets() {
    List<JitbitTicket> tickets = new ArrayList<JitbitTicket>();
    ResponseEntity<List<JitbitTicket>> tickets2 = null;
    String targetUrl = null;
    int offset = 0;
    do {

      if (offset > 0) {
        targetUrl = UriComponentsBuilder.fromUriString(ticketListurl)
            .queryParam("statusId", JitbitStatus.ASSIGNED_TO_ENGENEERING.value)
            .queryParam("count", 100).queryParam("offset", offset).build()
            .toString();
      } else {
        targetUrl = UriComponentsBuilder.fromUriString(ticketListurl)
            .queryParam("statusId", JitbitStatus.ASSIGNED_TO_ENGENEERING.value)
            .queryParam("count", 100).build().toString();
      }
      offset += 100;
      tickets2 = restTemplate.exchange(targetUrl, HttpMethod.GET, entity,
          new ParameterizedTypeReference<List<JitbitTicket>>() {
          });
      tickets.addAll(tickets2.getBody());
    } while (tickets2.getBody().size() == 100);
    return tickets;
  }

  public String getTicketDetialAsString(String ticketId) {
    String targetUrl = UriComponentsBuilder.fromUriString(ticketDetetailUrl)
        .queryParam("id", ticketId).build().toString();
    ResponseEntity<String> ticketsString = restTemplate.exchange(targetUrl,
        HttpMethod.GET, entity, String.class);
    return ticketsString.getBody();
  }

  public JitBitTicketDetail getTicketDetial(String ticketId) {
    String targetUrl = UriComponentsBuilder.fromUriString(ticketDetetailUrl)
        .queryParam("id", ticketId).build().toString();
    ResponseEntity<JitBitTicketDetail> ticketsString = restTemplate.exchange(
        targetUrl, HttpMethod.GET, entity, JitBitTicketDetail.class);
    return ticketsString.getBody();
  }

  public String getCustomFieldsString(String ticketId) {
    String targetUrl = UriComponentsBuilder
        .fromUriString(ticketCustomFiledsUrl).queryParam("id", ticketId)
        .build().toString();
    ResponseEntity<String> ticketsString = restTemplate.exchange(targetUrl,
        HttpMethod.GET, entity, String.class);
    // String ticket = gson.fromJson(ticketsString.getBody(), new
    // TypeToken<JitbitTicket>(){}.getType());
    return ticketsString.getBody();
  }

  public List<CustomField> getCustomFieldsList(String ticketId) {
    String targetUrl = UriComponentsBuilder
        .fromUriString(ticketCustomFiledsUrl).queryParam("id", ticketId)
        .build().toString();
    ResponseEntity<List<CustomField>> customFields = restTemplate.exchange(
        targetUrl, HttpMethod.GET, entity,
        new ParameterizedTypeReference<List<CustomField>>() {
        });

    return customFields.getBody();
  }

  public String getJiraIdValue(List<CustomField> customFields) {
    List<CustomField> list = customFields.stream()
        .filter(field -> field.getFieldID()==10233)
        .collect(Collectors.toList());
    if ((list.size() != 0) && (list.get(0).getValue() != null)) {
      return list.get(0).getValue().replaceAll("\\s+", "");
    }
    return null;
  }

  // POST https://[helpdesk-url]/api/SetCustomField
  // ticketId int Ticket ID
  // fieldId int Custom field ID
  // value string Value as a string. For checkboxes pass true or false. For
  // dropdowns pass the option ID. For dates pass date as a string in any
  // format.

  public String updateJiraStatus(String ticketId, String jiraStatus) {

    String targetUrl = UriComponentsBuilder
        .fromUriString("https://pricefx.jitbit.com/helpdesk/api/SetCustomField")
        .queryParam("ticketId", ticketId).queryParam("fieldId", "11705")
        .queryParam("value", jiraStatus).build().toString();
    ResponseEntity<String> reponceString = restTemplate.exchange(targetUrl,
        HttpMethod.POST, entity, String.class);
    return reponceString.getBody();
  }

}
