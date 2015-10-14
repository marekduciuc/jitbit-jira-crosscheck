package eu.pricefx.monitoring.tickets.crossChecker;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import eu.pricefx.monitoring.tickets.crossChecker.configuration.Configuartion;
import eu.pricefx.monitoring.tickets.crossChecker.dao.JiraTicketDao;
import eu.pricefx.monitoring.tickets.crossChecker.dao.JitBitTicketDao;
import eu.pricefx.monitoring.tickets.crossChecker.model.CustomField;
import eu.pricefx.monitoring.tickets.crossChecker.model.JitbitTicket;
import eu.pricefx.monitoring.tickets.crossChecker.reports.CrossCheckReport;
import eu.pricefx.monitoring.tickets.crossChecker.reports.ReportRecord;

public class CrossChecker {

  public static void main(String[] args) {

    Logger logger = LoggerFactory
        .getLogger("eu.pricefx.monitoring.tickets.crossChecker.CrossChecker");
    logger.info("Startin");

    Configuartion configuartion = Configuartion.getInstance();
    JitBitTicketDao jitBitTicketDao = new JitBitTicketDao(configuartion);
    JiraTicketDao jiraTicketDao = new JiraTicketDao(configuartion);
    ArrayList<ReportRecord> records = new ArrayList<ReportRecord>();

    logger.info("Getting JitBit Tickets Start");
    List<JitbitTicket> tickets = jitBitTicketDao.getTickets();
    logger.info("Getting JitBit Tickets Ends");
    logger.info("Getting Jira Information Starts");
    for (JitbitTicket t : tickets) {
      List<CustomField> customFieldsList = jitBitTicketDao
          .getCustomFieldsList(Integer.parseInt(t.getTicketID()));
      String jiraIDString = jitBitTicketDao.getJiraIdValue(customFieldsList);
      if (jiraIDString == null) {
        records.add(new ReportRecord(t.getTicketID(), t.getSubject(), null,
            null));
      } else {
        String jiraStatus = "";
        
          jiraStatus = jiraTicketDao.getIssuState(jiraIDString);
          records.add(new ReportRecord(t.getTicketID(), t.getSubject(),
              jiraIDString, jiraStatus));
      }

    }
    logger.info("Getting Jira Information Ends");

    CrossCheckReport crossCheckReport = new CrossCheckReport();

    logger.info("Generating html Report Starts");
    crossCheckReport.run(records);
    logger.info("Generating html Report Ends");
    logger.info("Done");

  }

  public CrossChecker() {
    // TODO Auto-generated constructor stub
  }

}
