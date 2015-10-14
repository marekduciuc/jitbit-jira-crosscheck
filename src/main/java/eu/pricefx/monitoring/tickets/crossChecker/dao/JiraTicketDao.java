package eu.pricefx.monitoring.tickets.crossChecker.dao;

import java.net.URI;
import java.util.concurrent.ExecutionException;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.util.concurrent.Promise;
import eu.pricefx.monitoring.tickets.crossChecker.configuration.Configuartion;

public class JiraTicketDao {

	final HttpHeaders headers = new HttpHeaders();
	final RestTemplate restTemplate = new RestTemplate();
	final URI uri;
	final Configuartion configuartion;
	
	public JiraTicketDao(Configuartion config) {
		configuartion = config;
		this.uri = URI.create(configuartion.getJiraBaseUrl());
	}
	
	public String getIssuState(String id) throws InterruptedException, ExecutionException
	{
		JiraRestClientFactory restClientFactory = new AsynchronousJiraRestClientFactory();
		IssueRestClient issuclient = restClientFactory.createWithBasicHttpAuthentication(uri,
		configuartion.getJiraUser(), configuartion.getJiraPassword()).getIssueClient();
		//* removing blans form issue id
		Promise<Issue> issue =  issuclient.getIssue(id);
		return issue.get().getStatus().getName();
	}
	
}
