package eu.pricefx.monitoring.tickets.crossChecker.reports;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import eu.pricefx.monitoring.tickets.crossChecker.configuration.Configuartion;

public class CrossCheckReport {

	final static String basicURL = "https://pricefx.jitbit.com/helpdesk/";
	final static String JIRABASICURL = "https://pricefx.atlassian.net/";
	final Configuartion config;

	public void run(List<ReportRecord> reportView) {
		
		Velocity.init();

        /* lets make a Context and put data into it */

        VelocityContext context = new VelocityContext();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        context.put("time",dateFormat.format(new Date()));
        context.put("tickets", reportView);

        /* lets render a template */
        
			PrintWriter writer = null;
      try {
        writer = new PrintWriter(config.getOutputFile(), "UTF-8");
        Velocity.mergeTemplate("template.html", context, writer );
        writer.flush();
      } catch (FileNotFoundException | UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }  finally{
         if (writer != null) writer.close();
      }
        


      
	
		
	}

	public CrossCheckReport(Configuartion conf) {
	  super();
		config = conf;
		// TODO Auto-generated constructor stub
	}

}
