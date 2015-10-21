package eu.pricefx.monitoring.tickets.crossChecker.dao;

import java.util.List;

import eu.pricefx.monitoring.tickets.crossChecker.model.AbstractJitBitTicket;
import eu.pricefx.monitoring.tickets.crossChecker.model.CustomField;
import eu.pricefx.monitoring.tickets.crossChecker.model.JitBitTicketDetail;
import eu.pricefx.monitoring.tickets.crossChecker.model.JitbitTicket;

public interface IJitbitTicketDao {

  public abstract List<JitbitTicket> getTickets();

  public abstract String getTicketDetialAsString(String ticketId);

  public abstract JitBitTicketDetail getTicketDetial(String ticketId);

  public abstract String getCustomFieldsString(String ticketId);

  public abstract List<CustomField> getCustomFieldsList(String ticketId);

  public abstract String getJiraIdValue(List<CustomField> customFields);


}