package eu.pricefx.monitoring.tickets.crossChecker;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import eu.pricefx.monitoring.tickets.crossChecker.configuration.Configuartion;
import eu.pricefx.monitoring.tickets.crossChecker.dao.JiraTicketDao;
import eu.pricefx.monitoring.tickets.crossChecker.dao.JitBitTicketDao;
import eu.pricefx.monitoring.tickets.crossChecker.model.CustomField;
import eu.pricefx.monitoring.tickets.crossChecker.model.JitbitTicket;
import eu.pricefx.monitoring.tickets.crossChecker.reports.CrossCheckReport;
import eu.pricefx.monitoring.tickets.crossChecker.reports.ReportRecord;



public class CrossChecker {

	
	public static void main(String[] args) {

		 
		 Configuartion configuartion = Configuartion.getInstance();
		 JitBitTicketDao jitBitTicketDao = new JitBitTicketDao(configuartion);
		 JiraTicketDao jiraTicketDao = new JiraTicketDao(configuartion); 
		 ArrayList <ReportRecord> records = new ArrayList<ReportRecord>();
		 
		
		 List <JitbitTicket> tickets  = jitBitTicketDao.getTickets();
		for (JitbitTicket t : tickets) {
			List<CustomField> customFieldsList = jitBitTicketDao.getCustomFieldsList(Integer.parseInt(t.getTicketID()));
			String jiraIDString = jitBitTicketDao.getJiraIdValue(customFieldsList);
			if (jiraIDString == null) {
				records.add(new ReportRecord(t.getTicketID(),t.getSubject(), null, null));
			}
			else{
				String jiraStatus = "";
				try {
					jiraStatus = jiraTicketDao.getIssuState(jiraIDString);
					records.add(new ReportRecord(t.getTicketID(),t.getSubject(), jiraIDString,jiraStatus));
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		
		} 
		
		CrossCheckReport crossCheckReport = new CrossCheckReport();
		
		crossCheckReport.run(records);
		System.out.println("Done!");
		
	}
	
	
	public CrossChecker() {
		// TODO Auto-generated constructor stub
	}
	

}
