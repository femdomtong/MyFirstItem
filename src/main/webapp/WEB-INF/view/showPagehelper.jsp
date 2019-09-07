<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
<script type="text/javascript" src= /js/jquery-1.8.3.js></script>
<style type="text/css">
	.page_on{
		font-size: 20px;
		font-weight: blod;
		color:black;
	 }
	 .page_off{
	 	display:inline-block;
	 	width:20px;
	 	margin-left: 5px;
	 }
</style>
<script type="text/javascript">

	function goPage(data){
		alert(data);
		foo.cp.value = data;
		foo.submit();
	}

	function pagesss(){
		alert($("#wo").val());
		var wo = foo.wo.value;
		foo.cp.value = wo;
		foo.submit();
	}
	
	function deleteMaterias(){
		foo.action = "/mc/deleteMaterials";
		foo.submit();
	};
	
</script>
</head>
<body>
	<form action="/mc/queryPagehelper" method="post">
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
	<form action="/mc/queryPagehelper" method="post" id="foo" name="foo">
	<input type="hidden" id="cp" name="cp"/>
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
			<c:forEach items="${page.list}" var="materia">
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
	<!-- 是首页显示灰色 -->
	<c:if test="${page.isFirstPage}">
		<input type="button" value="首页" disabled="disabled" onclick="goPage(${page.firstPage})"/>
		<input type="button" value="上一页"  disabled="disabled" onclick="goPage(${page.prePage})"/>
	</c:if>
	<!-- 不是首页正常显示 -->
	<c:if test="${!page.isFirstPage}">
		<input type="button" value="首页"  onclick="goPage(${page.firstPage})"/>
		<input type="button" value="上一页"   onclick="goPage(${page.prePage})"/>
	</c:if>
	
	<c:if test="${page.pageNum>3}">
		 		<a href="javascript:gopage('${page.pageNum-3}')" class="page_off">...</a>
		 </c:if>
	 	<c:if test="${page.pageNum>2}">
	 		<a href="javascript:gopage('${page.pageNum-2}')" class="page_off">${page.pageNum-2}</a>
	 	</c:if>
	 	<c:if test="${page.pageNum>1}">
	 		<a href="javascript:gopage('${page.pageNum-1}')" class="page_off">${page.pageNum-1}</a>
	 	</c:if>
	 	<!-- 当前页  -->
	 	<a href="javascript:;" class="page_on">${page.pageNum}</a>
	 	
	 	<c:if test="${page.pageNum<page.pages}">
	 		<a href="javascript:gopage('${page.pageNum+1}')" class="page_off">${page.pageNum+1}</a>
	 	</c:if>
	 	<c:if test="${page.pageNum+2<page.pages}">
	 		<a href="javascript:gopage('${page.pageNum+2}')" class="page_off">${page.pageNum+2}</a>
	 	</c:if>
	 	<c:if test="${page.pageNum+3<page.pages}">
	 		<a href="javascript:gopage('${page.pageNum+3}')" class="page_off">...</a>
	 	</c:if>
	<!-- 是尾页显示灰色 -->
	<c:if test="${page.isLastPage}">
		<input type="button" value="下一页" disabled="disabled" onclick="goPage(${page.nextPage})"/>
		<input type="button" value="尾页" disabled="disabled" onclick="goPage(${page.lastPage})"/>
	</c:if>
	<!-- 不是尾页正常显示 -->
	<c:if test="${!page.isLastPage}">
		<input type="button" value="下一页"  onclick="goPage(${page.nextPage})"/>
		<input type="button" value="尾页"  onclick="goPage(${page.lastPage})"/>
	</c:if><br/>
	请输入每页显示多少条数据:<input name="ps" value="${page.pageSize }"/>
					 <input type="button" value="提交" onclick="goPage('1')"/>
					<br/>共有${page.total}条数据,共分为${page.pages}页,当前页为${page.pageNum}<br/>
					跳转到第<input name="wo" id="wo" value=""/>页
					<input type="button" value="提交" onclick="pagesss()"/>
</form>
</body>
</html>
