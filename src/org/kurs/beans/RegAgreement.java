package org.kurs.beans;

public class RegAgreement {
	private String FIO;
	   private String data;
	   private String OI;
	   private String type;
	   private String kind;
	   private String id;
	    
	 
	   public RegAgreement () {
	        
	   }
	    public RegAgreement(String FIO,String data,String OI,String type,String kind,String id) {
	    	this.FIO=FIO;
	    	this.data=data;
	    	this.kind=kind;
	    	this.OI=OI;
	    	this.type=type;
	    	this.id=id;
	    }
	   public String getFIO() {
	       return FIO;
	   }
	 
	   public void setFIO(String FIO) {
	       this.FIO = FIO;
	   }
	 
	   public String getdata() {
	       return data;
	   }
	 
	   public void setdata(String data) {
	       this.data = data;
	   }
	 
	   public String getOI() {
	       return OI;
	   }
	 
	   public void setOI(String OI) {
	       this.OI = OI;
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
	   public String getid() {
	       return id;
	   }
	 
	   public void setid(String id) {
	       this.id = id;
	   }
}
