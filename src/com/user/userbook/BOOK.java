package com.user.userbook;

public class BOOK {
    public String ISBN;
    public String TITLE;
    public String AUTHORID;
    public String PUBLISHER;
    public String PUBLISHDATA;
    public String PRICE;
    public String tu;
    /*public book()
	{
    	this.ISBN="";
    	this.Title="";
    	this.AuthorID="";
    	this.Publisher="";
    	this.PublishData="";
    	this.Price="";
	}*/
    public String gettu(){
    	return tu;
    }
    public void settu(String Tu){
		tu=Tu;    	
    }
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String title) {
		TITLE = title;
	}
	public String getAUTHORID() {
		return AUTHORID;
	}
	public void setAUTHORID(String authorID) {
		AUTHORID = authorID;
	}
	public String getPUBLISHER() {
		return PUBLISHER;
	}
	public void setPUBLISHER(String pUBLISHER) {
		PUBLISHER = pUBLISHER;
	}
	public String getPUBLISHDATA() {
		return PUBLISHDATA;
	}
	public void setPUBLISHDATA(String pUBLISHData) {
		PUBLISHDATA = pUBLISHData;
	}
	public String getPRICE() {
		return PRICE;
	}
	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}

}