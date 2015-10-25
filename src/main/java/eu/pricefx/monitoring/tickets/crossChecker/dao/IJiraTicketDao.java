package eu.pricefx.monitoring.tickets.crossChecker.dao;

import com.atlassian.jira.rest.client.api.domain.Issue;

public interface IJiraTicketDao {

  public abstract Issue getIssue(String id);

  public abstract String getIssuStateAndSolution(String id);

}