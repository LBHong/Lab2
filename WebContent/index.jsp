<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
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
<div class="d1"><img src="http://down.tutu001.com/d/file/20100617/7981d13ba830d7d6eaf2aef593_560.jpg" width="100%" height="100%"/></div>

		<table width="68" height="17"   align="center">
		<caption>查询书籍</caption>
		</table>
		<s:form action="querAction" method="post">
		<table width="288" height="17" align="center">
		<s:textfield name="AUthorNAME" key="作者名称"></s:textfield>
		<s:submit key="查找"></s:submit>	
		</s:form>
		</table> 
		<table width="68" height="17" align="center">
		<caption>添加书籍</caption>
		</table>
		<s:form action="addbook" method="post">
		<table width="288" height="27" align="center">
        <s:textfield name="ISBN" key="ISBN"></s:textfield> 
        <s:textfield name="TITLE" key="标题"></s:textfield>
        <s:textfield name="AUTHORID" key="作者ID"></s:textfield>
        <s:textfield name="PUBLISHER" key="出版社"></s:textfield>
        <s:textfield name="PUBLISHDATA" key="出版日期"></s:textfield>
        <s:textfield name="PRICE" key="价格"></s:textfield>
        <s:submit key="添加"></s:submit>
    </s:form>
    </table> 
    <table width="68" height="17" align="center">
    <caption>更改书籍</caption>
	</table>
    
		<s:form action="gengxin" method="post">
		<table width="288" height="27" align="center">
		<s:textfield name="ISBN" key="ISBN"></s:textfield> 
        <s:textfield name="AUTHORID" key="作者ID"></s:textfield> 
        <s:textfield name="PUBLISHER" key="出版社"></s:textfield>
        <s:textfield name="PUBLISHDATA" key="出版日期"></s:textfield>
        <s:textfield name="PRICE" key="价格"></s:textfield>
        <s:submit key="添加"></s:submit>
    </s:form>
 		</table> 
</body>

</html>
