package com.user.mysql;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.user.userbook.BOOK;
import com.user.userauthor.author;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
public class mysqlOperate {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_tianchen1016";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "z5omyo340o";
    static final String PASS = "j520jylh02zl30jxki4w0zj31k15xj023kj5534y";
	public List<BOOK> userQuery(String authorNAME)
	{
		System.out.println("进入函数，key："+authorNAME);

        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;  
        PreparedStatement pstm=null;
        //List<book> bookList;
        List<BOOK> bookList=new LinkedList<BOOK>();
        //book b=new book();
        try{
            // 注册 JDBC 驱动
        	System.out.println("注册 JDBC 驱动");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动注册成功");
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 实例化Statement对...");
            stmt = conn.createStatement();
            String sql;String sq;
            //sql = "SELECT ISBN, Title, AuthorID,Publisher,PublishData,Price FROM book where Name=?";
            sql = "SELECT AuthorID, Name, Age,Country FROM author where Name=?";
            pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, authorNAME);
            
            ResultSet rs = pstmt.executeQuery();
            
            List<String> AuthorIDList=new ArrayList<String>();
            // 展开结果集数据库 	
            while(rs.next()){
                // 通过字段检索
            	
            	AuthorIDList.add(rs.getString("AuthorID"));
            	
            }
            for(int i=0;i<AuthorIDList.size();i++){
            	
            	sql = "SELECT ISBN, Title, AuthorID,Publisher,PublishData,Price FROM book where AuthorID=?";
            	pstmt = conn.prepareStatement(sql);  
                pstmt.setString(1, AuthorIDList.get(i));
                sq="SELECT tu,AuthorID from tupian where AuthorID=?";
                pstm = conn.prepareStatement(sq);  
                pstm.setString(1, AuthorIDList.get(i));
                rs = pstmt.executeQuery();ResultSet r=pstm.executeQuery();
                while(rs.next()){
                	System.out.println("1");
                	BOOK b=new BOOK();
                    b.ISBN  = rs.getString("ISBN");
                    b.TITLE = rs.getString("Title");
                    b.AUTHORID = rs.getString("AuthorID");
                    b.PUBLISHER  = rs.getString("Publisher");
                    b.PUBLISHDATA = rs.getString("PublishData");
                    b.PRICE = rs.getString("Price");
                    if(r.next())
                   {b.tu=r.getString("tu");}
                    else{b.tu=null;}
                    bookList.add(b);
                    
                    
                    // 输出数据
                    System.out.print("ISBN: " + b.ISBN);
                    System.out.print(", Title: " + b.TITLE);
                    System.out.print(", AuthorID: " + b.AUTHORID);
                    System.out.print("Publisher: " + b.PUBLISHER);
                    System.out.print(", PublishData: " + b.PUBLISHDATA);
                    System.out.print(", Price: " + b.PRICE);
                    System.out.print("\n");
                }
            }
            // 完成后关闭
            rs.close();
            pstmt.close();
            pstm.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
		return bookList;
	}
	public boolean userDelete(String ISBN){
		Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;  
        List<BOOK> bookList=new LinkedList<BOOK>();
        try{
            // 注册 JDBC 驱动
        	System.out.println("注册 JDBC 驱动");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动注册成功");
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 实例化Statement对...");
            stmt = conn.createStatement();
            String sql;
            //sql = "SELECT ISBN, Title, AuthorID,Publisher,PublishData,Price FROM book where AuthorID=?";
            sql = "DELETE FROM book WHERE ISBN = ?";

            pstmt = (PreparedStatement)conn.prepareStatement(sql);  
            pstmt.setString(1, ISBN);
            
            int i = pstmt.executeUpdate();
            System.out.println("删除的BOOK: " + i);
            if(i==0)
            {
            	System.out.println("该书已经删除!");
            	return false;
            }
            //sql = "DELETE FROM book WHERE ISBN='"+ISBN+ "'";
            //ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库 	
            /*while(rs.next()){
                // 通过字段检索
            	
            	
                
                
                // 输出数据
                System.out.print("删除的ISBN: " + b.ISBN);
                System.out.print(", Title: " + b.TITLE);
                System.out.print(", AuthorID: " + b.AUTHORID);
                System.out.print("Publisher: " + b.PUBLISHER);
                System.out.print(", PublishData: " + b.PUBLISHDATA);
                System.out.print(", Price: " + b.PRICE);
                System.out.print("\n");
            }*/
            // 完成后关闭
            //rs.close();
            pstmt.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
		return true;
	}
	public Map<String,String> showDetail(String ISBN){
		
		Map<String,String> detailMap=new HashMap<String,String>();
		Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null; 
        PreparedStatement pstm = null;
        try{
            // 注册 JDBC 驱动
        	System.out.println("注册 JDBC 驱动");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动注册成功");
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 实例化Statement对...");
            stmt = conn.createStatement();
            String sql;String sq;
            String AuthorID;
           
            sql = "SELECT ISBN, Title, AuthorID,Publisher,PublishData,Price FROM book where ISBN=?";
            sq="SELECT tu,AuthorID FROM tupian where ISBN=?";
            //sql = "DELETE FROM book WHERE ISBN = ?";
            pstmt = (PreparedStatement)conn.prepareStatement(sql);  
            pstm = (PreparedStatement)conn.prepareStatement(sq);  
            pstmt.setString(1, ISBN);
            pstm.setString(1, ISBN);
            ResultSet rs = pstmt.executeQuery(); ResultSet r = pstm.executeQuery();
         // 展开结果集数据库 	
            while(rs.next()){
                // 通过字段检索
            	detailMap.put("ISBN", rs.getString("ISBN"));
            	detailMap.put("题目", rs.getString("Title"));
            	detailMap.put("作者ID", rs.getString("AuthorID"));
            	detailMap.put("出版社", rs.getString("Publisher"));
            	detailMap.put("出版日期", rs.getString("PublishData"));
            	detailMap.put("价格", rs.getString("Price"));
            	r.next();
            	detailMap.put("图片",r.getString("tu"));
             
            }
            AuthorID=detailMap.get("作者ID");
            sql="SELECT AuthorID, Name, Age,Country FROM author where AuthorID=?";
            pstmt = (PreparedStatement)conn.prepareStatement(sql);  
            pstmt.setString(1, AuthorID);
           
            System.out.println(pstmt.toString());
            ResultSet rs2 = pstmt.executeQuery();
            while(rs2.next()){
                // 通过字段检索
            	detailMap.put("作者名字", rs2.getString("Name"));
            	detailMap.put("年龄", rs2.getString("Age"));
            	detailMap.put("国家", rs2.getString("Country"));
            }
            
            // 完成后关闭
            rs.close();
            pstm.close();
            pstmt.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!"); 
		return detailMap;
	}
	public  Map<String,String> addDetail(String ISBN,String Title,String AuthorID,String Publisher,String PublishData,String Price){
		Map<String,String> detailMap=new HashMap<String,String>();
		BOOK book=new BOOK();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_tianchen1016";
			String username="z5omyo340o";
			String password="j520jylh02zl30jxki4w0zj31k15xj023kj5534y";
			Connection conn=DriverManager.getConnection(url,username,password);
			String sql="insert into book(ISBN,Title,AuthorID,Publisher,PublishData,Price) values(?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			book.setISBN(ISBN);
			book.setTITLE(Title);
			book.setAUTHORID(AuthorID);
			book.setPUBLISHER(Publisher);
			book.setPUBLISHDATA(PublishData);
			book.setPRICE(Price);
			ps.setString(1,book.getISBN());
			detailMap.put("ISBN",ISBN);
			ps.setString(2,book.getTITLE());
			detailMap.put("题目",Title);
			ps.setString(3,book.getAUTHORID());
			detailMap.put("作者ID",AuthorID);
			ps.setString(4,book.getPUBLISHER());
			detailMap.put("出版社",Publisher);
			ps.setString(5,book.getPUBLISHDATA());
			detailMap.put("出版日期",PublishData);
			ps.setString(6,book.getPRICE());
			detailMap.put("价格",Price);
	         // 展开结果集数据库 	
	           
	                // 通过字段检索
	         int row=ps.executeUpdate();
	         if(row>0){
	        	 System.out.println("成功添加数据！");
	         }
	         sql = "SELECT AuthorID, Name, Age,Country FROM author where AuthorID=?";
	         PreparedStatement pst = null; 
	         pst=conn.prepareStatement(sql);
	         pst.setString(1, AuthorID);
	         ResultSet r = pst.executeQuery();		
			 if(!r.next())
	         {
				 System.out.println("!!!!!!!!!!!!!!!!!");
	        	 return null;
	         }
			 ps.close();
			conn.close();
		}catch(Exception e){
			System.out.print("图书信息添加失败！");
			e.printStackTrace();
		}
		
		
		return detailMap;
	}
	public  Map<String,String> addauthor(String AuthorID,String name,String age,String country){
		Map<String,String> detailMap=new HashMap<String,String>();
		author a=new author();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_tianchen1016";
			String username="z5omyo340o";
			String password="j520jylh02zl30jxki4w0zj31k15xj023kj5534y";
			Connection conn=DriverManager.getConnection(url,username,password);
			String sql="insert into author(AuthorID,Name,Age,Country) values(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			a.setAUTHORID(AuthorID);
			a.setNAME(name);
			a.setAGE(age);
			a.setCOUNTRY(country);
			ps.setString(1,a.getAUTHORID());
			detailMap.put("作者ID",AuthorID);
			 System.out.println(AuthorID);
			ps.setString(2,a.getNAME());
			detailMap.put("名字",name);
			System.out.println(name);
			ps.setString(3,a.getAGE());
			detailMap.put("年龄",age);
			ps.setString(4,a.getCOUNTRY());
			detailMap.put("国家",country);
	         // 展开结果集数据库 	
	           
	                // 通过字段检索
	         int row=ps.executeUpdate();
	         if(row>0){
	        	 System.out.println("成功添加数据！");
	         }
			ps.close();
			conn.close();
			 
		}catch(Exception e){
			System.out.print("图书信息添加失败！");
			e.printStackTrace();
		}
		
		
		return detailMap;
	}
	public  Map<String,String> gengxin(String ISBN,String AuthorID,String Publisher,String Publishdata,String Price)
	{
		Map<String,String> detailMap=new HashMap<String,String>();
		BOOK book=new BOOK();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_tianchen1016";
			String username="z5omyo340o";
			String password="j520jylh02zl30jxki4w0zj31k15xj023kj5534y";
			Connection conn=DriverManager.getConnection(url,username,password);
			String sql="update book set AuthorID=?,Publisher=?,PublishData=?,Price=? where ISBN=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			book.setISBN(ISBN);
			book.setAUTHORID(AuthorID);
			book.setPUBLISHER(Publisher);
			book.setPUBLISHDATA(Publishdata);
			book.setPRICE(Price);
			ps.setString(1,book.getAUTHORID());
			detailMap.put("作者ID",AuthorID);			
			ps.setString(2,book.getPUBLISHER());
			detailMap.put("出版社",Publisher);
			ps.setString(3,book.getPUBLISHDATA());
			detailMap.put("出版日期",Publishdata);
			ps.setString(4,book.getPRICE());
			detailMap.put("价格",Price);
			ps.setString(5,book.getISBN());
			detailMap.put("ISBN",ISBN);
	         // 展开结果集数据库 	
			ps.executeUpdate();
	                // 通过字段检索
	         int row=ps.executeUpdate();
	         if(row>0){
	        	 System.out.println("成功添加数据！");
	         }
			 ps.close();
			conn.close();
		}catch(Exception e){
			System.out.print("图书信息添加失败！");
			e.printStackTrace();
		}
		
		
		return detailMap;
	}
		
	
	
}
