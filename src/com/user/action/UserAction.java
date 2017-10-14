package com.user.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.user.mysql.mysqlOperate;
import com.user.userbook.BOOK;
import com.user.userauthor.author;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;
public class UserAction extends ActionSupport {
    private String authorNAME;
    private mysqlOperate sqlOprate=new mysqlOperate();
    private List<BOOK> bookList;//按ID查询
    private String ISBN;private String TITLE;private String PUBLISHDATA;private String AUTHORID;private String PRICE;
    private String PUBLISHER;private String NAME;private String AGE;private String COUNTRY;
    private Map<String,String> detailMap;
    //private List<String> bookDetail;

	public String queryBook() {
    	String authorNAME=getAUthorNAME();
    	//System.out.println("authorNAME: " +authorNAME);
    	List<BOOK> bList=sqlOprate.userQuery(authorNAME);
    	this.bookList=bList;
    	if(null == bList || bList.size() ==0 )
    		{return "failure";}
    	/*ActionContext.getContext().getSession()
        .put("bList", bList);*/
    	System.out.println("success");
    	return "success";
    }
    public String deleteBook() {
    	System.out.println("进入deleteBook函数，ISBN："+this.ISBN);
    	boolean deleteResult=sqlOprate.userDelete(this.ISBN);
    	if (deleteResult) {
			return "success";
		}
        return "failure";
    }
    public String showDetail() {
    	System.out.println("进入showDetail函数，ISBN："+this.ISBN);
    	this.detailMap=sqlOprate.showDetail(this.ISBN);
        return "detailPage";
    }
    public String addDetail()
    {	System.out.println("进入addDetail函数，作者ID："+this.AUTHORID);
    	this.detailMap=sqlOprate.addDetail(this.ISBN,this.TITLE,this.AUTHORID,this.PUBLISHER,this.PUBLISHDATA,this.PRICE);
    	if(detailMap==null)
    	{
    		return "addbook";
    	}
    	else{return "detailPage";}
    }
    public String addauthor()
    {
    	System.out.println("进入addauthor函数，ISBN："+this.ISBN);
    	this.detailMap=sqlOprate.addauthor(this.AUTHORID,this.NAME,this.AGE,this.COUNTRY);
        return "detailPage";
    }
    public String gengxin()
    {
    	System.out.println("进入gengxin函数，ISBN："+this.ISBN);
    	this.detailMap=sqlOprate.gengxin(this.ISBN,this.AUTHORID,this.PUBLISHER,this.PUBLISHDATA,this.PRICE);
        return "detailPage";
    }
    /***********************************************/
    public Map<String,String> getDetailMap() {
		return detailMap;
	}
	public void setDetailMap(Map<String,String> detailMap) {
		this.detailMap = detailMap;
	}

    public String getAUthorNAME() {
        return authorNAME;
    }
    public void setAUthorNAME(String authorNAME) {
        this.authorNAME = authorNAME;
    }
    public List<BOOK> getBookList() {
        return bookList;
    }
    public void setBookList(List<BOOK> bList) {
        this.bookList = bList;
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
	   public String getNAME(){
	    	return NAME;
	    }
	    public void setNAME(String name){
			NAME=name;
	    }
	    public String getAGE(){
	    	return AGE;
	    }
	    public void setAGE(String age){
			AGE=age;
	    }
	    public String getCOUNTRY(){
	    	return COUNTRY;
	    }
	    public void setCOUNTRY(String country){
			COUNTRY=country;
	    }
}
