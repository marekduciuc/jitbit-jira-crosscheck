package eu.pricefx.monitoring.tickets.crossChecker.dao;

import java.util.List;

import eu.pricefx.monitoring.tickets.crossChecker.model.jitbit.AbstractJitBitTicket;
import eu.pricefx.monitoring.tickets.crossChecker.model.jitbit.CustomField;
import eu.pricefx.monitoring.tickets.crossChecker.model.jitbit.JitBitTicketDetail;
import eu.pricefx.monitoring.tickets.crossChecker.model.jitbit.JitbitTicket;

public interface IJitbitTicketDao {

  public abstract List<JitbitTicket> getTickets();

  public abstract String getTicketDetialAsString(String ticketId);

  public abstract JitBitTicketDetail getTicketDetial(String ticketId);

  public abstract String getCustomFieldsAsString(String ticketId);

  public abstract List<CustomField> getCustomFieldsList(String ticketId);

  public abstract String getJiraIdValue(List<CustomField> customFields);
  
  public abstract int updateJiraStatus(String ticketId, String jiraStatus);


}