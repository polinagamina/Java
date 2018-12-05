package org.kurs.beans;

public class Agreement {
	private String FIO;
	   private String usluga;
	   private String price;
	   private String type;
	   private String kind;
	   private String idd;
	    
	 
	   public Agreement () {
	        
	   }
	    public Agreement(String FIO,String usluga,String price,String type,String kind,String idd) {
	    	this.FIO=FIO;
	    	this.usluga=usluga;
	    	this.kind=kind;
	    	this.price=price;
	    	this.type=type;
	    	this.idd=idd;
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
	 
	   public String getPrice() {
	       return price;
	   }
	 
	   public void setPrice(String price) {
	       this.price = price;
	   }
	   public String gettype() {
	       return type;
	   }
	 
	   public void settype(String type) {
	       this.type = type;
	   }
	   public String getkind() {
	       return kind;
	   }
	 
	   public void setkind(String kind) {
	       this.kind = kind;
	   }
	   public String getidd() {
	       return idd;
	   }
	 
	   public void setidd(String idd) {
	       this.idd = idd;
	   }
}
