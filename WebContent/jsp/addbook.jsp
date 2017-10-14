<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <!-- 引入struts的标签库-->
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
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
<div class="d1"><img src="http://p4.so.qhimgs1.com/bdr/_240_/t017a99382ff4efac24.jpg" width="100%" height="100%"/></div>
</table>
	<s:form action="addauthor" method="post">
	<s:textfield name="AUTHORID" key="作者ID"></s:textfield>
	<s:textfield name="NAME" key="作者"></s:textfield>
    <s:textfield name="AGE" key="年龄"></s:textfield>
    <s:textfield name="COUNTRY" key="国家"></s:textfield>
    <s:submit key="添加"></s:submit>
    </s:form>

</body>
</html>