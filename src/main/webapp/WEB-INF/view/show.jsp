<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
<script type="text/javascript" src= /js/jquery-1.8.3.js></script>
<script type="text/javascript">

	
	function goPage(data){
		foo.cp.value = data;
		foo.submit();
	};
	function deleteMaterias(){
		foo.action = "/mc/deleteMaterials";
		foo.submit();
	};
	
</script>
</head>
<body>
<h3>欢迎${manager.urealName}登入成功!</h3>
<h3>${deleteInfo}</h3>
<h3>${updateInfo}</h3>
	<form action="/mc/showMaterial" method="post">
	请选择厂商:<select name="manname">
				<option>==请选择==</option>
				<c:forEach items="${allManufacturer}" var="manufacturer">
				  			<option>${manufacturer.manname}</option>
				 </c:forEach>
		</select></br>
		请输入物资名称:<input value="${term}" name="term"/>
		请输入物资价格:<input value="${losal }" name="losal"/>到
				  <input value="${hisal}" name="hisal"/>
				  <input type="submit" value="搜索"/>	
	</form>
<a href="javascript:;" onclick="deleteMaterias()">批量删除</a><br/>
	<form action="/mc/showMaterial" id="foo" name="foo">
	<input type="hidden" name="cp"  value="${cp}"/>
	<input type="hidden" name="term" value="${term}"/>
	<input type="hidden" name="losal" value="${losal }"/>
	<input type="hidden" name="hisal" value="${hisal }"/>
	<input type="hidden" name="manname" value="${manname}"/>
	
		<table border="1">
			<th>选择</th>
			<th>物资编号</th>
			<th>物资名称</th>
			<th>物资数量</th>
			<th>物资单价</th>
			<th>生产厂商</th>
			<th>操作</th>
			<c:forEach items="${materialList}" var="materia">
				<tr>
					<td><input type="checkbox" name="matIds" value="${materia.matid}"/></td>
					<td>${materia.matid}</td>
					<td>${materia.matname}</td>
					<td>${materia.matnum}</td>
					<td>${materia.matprice}</td>
					<td>${materia.manufacturer.manname}</td>
					<td><a href="/mc/queryMaterialById?id=${materia.matid}">修改</a></td>
				</tr>
				
			
			</c:forEach>
		
		
		</table>
	<input type="button" value="首页" ${cp==1?'disabled':''} onclick="goPage('1')"/>
	<input type="button" value="上一页" ${cp==1?'disabled':''} onclick="goPage('${cp-1}')"/>
		<c:if test="${cp>3}">
		 		<a href="javascript:gopage('${cp-3}')" class="page_off">...</a>
		 </c:if>
	 	<c:if test="${cp>2}">
	 		<a href="javascript:gopage('${cp-2}')" class="page_off">${cp-2}</a>
	 	</c:if>
	 	<c:if test="${cp>1}">
	 		<a href="javascript:gopage('${cp-1}')" class="page_off">${cp-1}</a>
	 	</c:if>
	 	<!-- 当前页  -->
	 	<a href="javascript:;" class="page_on">${cp}</a>
	 	
	 	<c:if test="${cp<totalPages}">
	 		<a href="javascript:gopage('${cp+1}')" class="page_off">${cp+1}</a>
	 	</c:if>
	 	<c:if test="${cp+2<totalPages}">
	 		<a href="javascript:gopage('${cp+2}')" class="page_off">${cp+2}</a>
	 	</c:if>
	 	<c:if test="${cp+3<totalPages}">
	 		<a href="javascript:gopage('${cp+3}')" class="page_off">...</a>
	 	</c:if>
	<input type="button" value="下一页" ${cp==totalPages?'disabled':''} onclick="goPage('${cp+1}')"/>
	<input type="button" value="尾页" ${cp==totalPages?'disabled':''} onclick="goPage('${totalPages}')"/>
	请输入每页显示多少条数据:<input name="ps" value="${ps}"/>
					 <input type="button" value="提交" onclick="goPage('1')"/>
	<br/>当前满足条件的总数据量为${totalCount}条,共分为${totalPages}页,当前页为${cp}
	</form>
                                        
</body>
</html>
