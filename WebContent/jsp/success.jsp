<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <!-- 引入struts的标签库-->
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<style type="text/css">
body{ 

 margin:0px; 

 padding:0px; 

} 

.d1{ 

position:absolute;  

 left:0px; 

 top:0px;  

 width:100%;  

 height:100%; 

 z-index:-1; 

}
</style>
</head>
<body>
<h1>查询成功</h1><div class="d1"><img src="http://p2.so.qhimgs1.com/bdr/_240_/t01e22ce43494fc111e.jpg" width="100%" height="100%"/></div>
 <table border="1" width="50%"  cellspacing="0" cellpadding="0" width="68" height="17"   align="center">    
    <tr>    
      <td>ISBN</td>    
      <td>题目</td>    
      <td>作者ID</td>    
      <td>出版社</td>    
      <td>出版日期</td>    
      <td>价格</td> 
	  <td>详细</td>
	  <td>删除</td>
	  <td>图片</td>
    </tr>   

    <c:forEach items="${bookList}" var="result">
    <tr>    
     <td>${result.ISBN}</td>    
     <td>${result.TITLE}</a></td>    
     <td>${result.AUTHORID}</td>    
     <td>${result.PUBLISHER}</td>   
     <td>${result.PUBLISHDATA}</td>    
     <td>${result.PRICE}</td>   
     <td><a href='detail.action?ISBN=${result.ISBN}'>详细信息</a> </td> 
     <td><a href='delete.action?ISBN=${result.ISBN}'>删除此书</a> </td> 
     <td><img src="${result.tu}" alt="Smiley face" width="130" height="130"></td> 
    </tr>    
    </c:forEach>
 </table>
</body>
</html>