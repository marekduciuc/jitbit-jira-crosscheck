package eu.pricefx.monitoring.tickets.crossChecker;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.pricefx.monitoring.tickets.crossChecker.configuration.Configuartion;
import eu.pricefx.monitoring.tickets.crossChecker.dao.IJiraTicketDao;
import eu.pricefx.monitoring.tickets.crossChecker.dao.JiraTicketDao;
import eu.pricefx.monitoring.tickets.crossChecker.dao.JitbitTicketDao;
import eu.pricefx.monitoring.tickets.crossChecker.model.jitbit.CustomField;
import eu.pricefx.monitoring.tickets.crossChecker.model.jitbit.JitbitTicket;
import eu.pricefx.monitoring.tickets.crossChecker.reports.CrossCheckReport;
import eu.pricefx.monitoring.tickets.crossChecker.reports.ReportRecord;

public class CrossChecker {

  public static void main(String[] args) {

    Logger logger = LoggerFactory
        .getLogger("eu.pricefx.monitoring.tickets.crossChecker.CrossChecker");
    logger.info("Startin");

    Configuartion configuartion = Configuartion.getInstance();
    JitbitTicketDao jitBitTicketDao = new JitbitTicketDao (configuartion);
    IJiraTicketDao jiraTicketDao = new JiraTicketDao(configuartion);
    ArrayList<ReportRecord> records = new ArrayList<ReportRecord>();

    logger.info("Getting JitBit Tickets Start");
    List<JitbitTicket> tickets = jitBitTicketDao.getTickets();
    logger.info("Getting JitBit Tickets Ends");
    logger.info("Getting Jira Information Starts");
   
    for (JitbitTicket t : tickets) {
      List<CustomField> customFieldsList = jitBitTicketDao
          .getCustomFieldsList(t.getTicketID());
      String jiraIDString = jitBitTicketDao.getJiraIdValue(customFieldsList);
      if (jiraIDString == null) {
        records.add(new ReportRecord(t.getTicketID(), t.getSubject(), null,
            null));
      } else {
        String   jiraStatusAndResolution = jiraTicketDao.getIssuStateAndSolution(jiraIDString);
          records.add(new ReportRecord(t.getTicketID(), t.getSubject(),
              jiraIDString, jiraStatusAndResolution));
          if (configuartion.isUpdateJitbitTickes()){
            logger.info("Updating ticket number: "+t.getTicketID()+" starts");
            jitBitTicketDao.updateJiraStatus(t.getTicketID(),jiraStatusAndResolution);
            logger.info("Updating ticket number: "+t.getTicketID()+" ends");
          }
      }
    }
    logger.info("Getting Jira Information Ends");
    if(configuartion.isGenerateOutput()) {
      logger.info("Generating html Report Starts");
      CrossCheckReport crossCheckReport = new CrossCheckReport(configuartion);
      crossCheckReport.run(records);
      logger.info("Generating html Report Ends");
    }
    logger.info("Done");

  }

  public CrossChecker() {
    // TODO Auto-generated constructor stub
  }

}
