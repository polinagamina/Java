package org.kurs.beans;

public class Request {
	
	    
	   private String FIO;
	   private String usluga;
	   private String telephone;
	   private String Email;
	   private String idr;
	    
	 
	   public Request() {
	        
	   }
	    public Request(String FIO,String usluga,String telephone,String Email,String idr) {
	    	this.FIO=FIO;
	    	this.Email=Email;
	    	this.usluga=usluga;
	    	this.telephone=telephone;
	    	this.idr=idr;
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
	 
	   public String getEmail() {
	       return Email;
	   }
	 
	   public void setEmail(String Email) {
	       this.Email = Email;
	   }
	   public String gettelephone() {
	       return telephone;
	   }
	 
	   public void settelephone(String telephone) {
	       this.telephone = telephone;
	   }
	   public String getidr() {
	       return idr;
	   }
	 
	   public void setidr(String idr) {
	       this.idr = idr;
	   }
}
