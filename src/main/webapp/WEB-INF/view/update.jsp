<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
<script type="text/javascript" src= /js/jquery-1.8.3.js></script>
</head>
<body>
	<form action="/mc/updateMaterial" method="post" >
		<input  type="hidden" name="matid" value="${material.matid }" /><br/>
		<input type="hidden" name="befManName" value="${material.manufacturer.manname}"/><br/>
		 物资名称 :<input name="matname" value="${material.matname }"/><br/>
		 物资价格 :<input name="matprice" value="${material.matprice }"/><br/>
		  物资数量 :<input name="matnum" value="${material.matnum }"/><br/>
		  物资厂商  : <select  name="aftManName" >
			  		<c:forEach items="${allManufacturer}" var="manufacturer">
			  			<option>${manufacturer.manname}</option>
			  		</c:forEach>
			  </select><br/>
		<input type="submit" value="修改"/>
	</form>
</body>
</html>
