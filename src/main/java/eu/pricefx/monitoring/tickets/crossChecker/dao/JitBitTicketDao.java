package eu.pricefx.monitoring.tickets.crossChecker.dao;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

public class JitBitTicketDao  implements IJitbitTicketDao {
	
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
		 headers.add("Authorization", "Basic " +   Base64Wrapper.encode(config.getJitBitUser()+":"+config.getJitbitPassword()));
		 this.entity = new HttpEntity<String>("parameters", headers);
	}
	
	public  List<JitbitTicket> getTickets( ){
		String targetUrl= UriComponentsBuilder.fromUriString(ticketListurl)
				 			.queryParam("statusId", JitbitStatus.ASSIGNED_TO_ENGENEERING.value)
				 			.build().toString();
		ResponseEntity<String> ticketsString =  restTemplate.exchange( targetUrl,HttpMethod.GET,entity,String.class);
		List<JitbitTicket> tickets = gson.fromJson(ticketsString.getBody(), new TypeToken<List<JitbitTicket>>(){}.getType());
		return tickets;
	}
	
	public   String getTicketDetialAsString(String ticketId){
		String targetUrl= UriComponentsBuilder.fromUriString(ticketDetetailUrl)
	 			.queryParam("id", ticketId)
	 			.build().toString();
		ResponseEntity<String> ticketsString =  restTemplate.exchange( targetUrl,HttpMethod.GET,entity,String.class);
		//String ticket = gson.fromJson(ticketsString.getBody(), new TypeToken<JitbitTicket>(){}.getType());
		return ticketsString.getBody();
	}
	
	public   JitBitTicketDetail getTicketDetial(String ticketId){
		String ticketsString = getTicketDetialAsString(ticketId);
		JitBitTicketDetail ticket = gson.fromJson(ticketsString, new TypeToken<JitBitTicketDetail>(){}.getType());
		return ticket;
	}
	
	public   HashMap[] getTicketDetailAsMap(int ticketId){
		String targetUrl= UriComponentsBuilder.fromUriString(ticketDetetailUrl)
				.queryParam("id", ticketId)
				.build().toString();
		ResponseEntity<HashMap[]> ticketAsMap =  restTemplate.exchange( targetUrl,HttpMethod.GET,entity,HashMap[].class);
		return ticketAsMap.getBody();
	}
	
	
	public   String getCustomFieldsString(String ticketId){
		String targetUrl= UriComponentsBuilder.fromUriString(ticketCustomFiledsUrl)
				.queryParam("id", ticketId)
				.build().toString();
		ResponseEntity<String> ticketsString =  restTemplate.exchange( targetUrl,HttpMethod.GET,entity,String.class);
		//String ticket = gson.fromJson(ticketsString.getBody(), new TypeToken<JitbitTicket>(){}.getType());
		return ticketsString.getBody();
	}
	
	public List<CustomField> getCustomFieldsList(String ticketId){
		String ticketsString = getCustomFieldsString(ticketId);
		CustomField[] fields = gson.fromJson(ticketsString, new TypeToken<CustomField[]>(){}.getType());
		return Arrays.asList(fields);
	}
	
	public String getJiraIdValue( List<CustomField> customFields ){
		List<CustomField> list = customFields.stream()            
			.filter(field -> field.getFieldID().equals("10233")).collect(Collectors.toList());	
		if ((list.size()!=0 ) &&  (list.get(0).getValue() != null)) {
			return list.get(0).getValue().replaceAll("\\s+","");
			}
		return null;
	}



}
