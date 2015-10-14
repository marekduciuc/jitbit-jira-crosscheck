package eu.pricefx.monitoring.tickets.crossChecker.model;

public enum JitbitStatus {
	 ASSIGNED_TO_COLSUNTING (4346),
	 ASSIGNED_TO_ENGENEERING (4345)
	 ;
	 public final int value;
	
	 JitbitStatus(int value){
		 this.value=value;
	 }
	 
}
