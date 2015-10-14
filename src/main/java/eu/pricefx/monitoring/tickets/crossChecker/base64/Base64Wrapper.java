package eu.pricefx.monitoring.tickets.crossChecker.base64;

import org.apache.commons.codec.binary.Base64;

public class Base64Wrapper {

	public Base64Wrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	static public String encode(String string){
		 return new String(Base64.encodeBase64(string.getBytes()));
	}
	
	static public String decode(String string)
	{
		return new String(Base64.decodeBase64(string.getBytes()));
	}

}
