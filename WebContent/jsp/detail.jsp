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
<h1>详询</h1>
<div class="d1"><img src="http://down.tutu001.com/d/file/20110622/7b06dd591c61bf65dccd2a203c_560.jpg" width="100%" height="100%"/></div>
	<table border="1" width="50%"  cellspacing="0" cellpadding="0">
	 <c:forEach items="${detailMap}" var="result">
	 <tr>
	 <td>${result.key}:${result.value}<br></td>
</tr>
	 
	 </c:forEach>
</table>
 
</body>
</html>