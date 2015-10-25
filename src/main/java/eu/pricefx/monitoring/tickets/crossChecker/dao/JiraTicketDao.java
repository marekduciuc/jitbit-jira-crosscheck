package eu.pricefx.monitoring.tickets.crossChecker.dao;

import java.io.IOException;
import java.net.URI;

import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.auth.BasicHttpAuthenticationHandler;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.sal.api.net.ReturningResponseHandler;

import eu.pricefx.monitoring.tickets.crossChecker.configuration.Configuartion;

public class JiraTicketDao implements IJiraTicketDao {

  final URI uri;
  final Configuartion configuartion;
  final JiraRestClientFactory restClientFactory;
  final BasicHttpAuthenticationHandler myHandler;

  public JiraTicketDao(Configuartion config) {
    configuartion = config;
    this.uri = URI.create(configuartion.getJiraBaseUrl());
    restClientFactory = new AsynchronousJiraRestClientFactory();
    myHandler = new BasicHttpAuthenticationHandler(configuartion.getJiraUser(),
        configuartion.getJiraPassword());
  }

  /* (non-Javadoc)
   * @see eu.pricefx.monitoring.tickets.crossChecker.dao.IJiraTicketDao#getIssue(java.lang.String)
   */
  @Override
  public Issue getIssue(String id) {
    final JiraRestClient restClient = restClientFactory.create(uri, myHandler);
    final IssueRestClient issuclient = restClient.getIssueClient();
    final Issue issue = issuclient.getIssue(id).claim();

    try {
      restClient.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return issue;
  }

  /* (non-Javadoc)
   * @see eu.pricefx.monitoring.tickets.crossChecker.dao.IJiraTicketDao#getIssuStateAndSolution(java.lang.String)
   */
  @Override
  public String getIssuStateAndSolution(String id) {
    final StringBuilder statusAndSolution = new StringBuilder();
    final Issue issue = getIssue(id);
    statusAndSolution.append(issue.getStatus().getName());
    if (issue.getResolution() != null) {
      statusAndSolution.append(" \"")
          .append(issue.getResolution().getName())
          .append("\"");
    }
    return statusAndSolution.toString();
  }

}
