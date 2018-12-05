package org.kurs.beans;

public class RegRequest {
	private String FIO;
	   private String usluga;
	   private String data;
	   private String state;
	   private String id;
	    
	 
	   public RegRequest() {
	        
	   }
	    public RegRequest(String FIO,String usluga,String data,String state,String id) {
	    	this.FIO=FIO;
	    	this.data=data;
	    	this.state=state;
	    	this.id=id;
	    	this.usluga=usluga;
	    }
	   public String getFIO() {
	       return FIO;
	   }
	 
	   public void setFIO(String FIO) {
	       this.FIO = FIO;
	   }
	 
	   public String getusluga() {
	       return usluga;
	   }
	 
	   public void setusluga(String usluga) {
	       this.usluga = usluga;
	   }
	 
	   public String getdata() {
	       return data;
	   }
	 
	   public void setdata(String data) {
	       this.data = data;
	   }
	   public String getstate() {
	       return state;
	   }
	   public void setstate(String state) {
	       this.state = state;
	   }
	   
	   
	   public String getid() {
	       return id;
	   }
	 
	   public void setid(String id) {
	       this.id = id;
	   }
}
