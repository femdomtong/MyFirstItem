<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
<script type="text/javascript" src= /js/jquery-1.8.3.js></script>
<script>
	function login(){
	var uname =	$("#uname").val();
	var pwd = $("#pwd").val();
	$.post(
		"/mc/validation",
		{"uname":uname,"pwd":pwd},
		function(data){
			
			if( data=='' ){
				$("#span").text("用户名或密码错误!");
				/* $("#ip").attr("disabled",true); */
			}else if(data=='ok'){
				$("#span").text("都输对了!");
				/* $("#ip").attr("disabled",false); */
			}
		}
	);	/*返回字符串不要加"json",否则有问题! */
	
	/* $.post(
			"/mc/validation",
			{"uname":uname,"pwd":pwd},
			function(data){
				alert(data);
				if( data==null){
					$("#span").text("用户名或密码错误!");
				}else if(data){
					$("#span").text("都输对了!");
				}
			}
		);  */ /*返回对象一定要加"json",否则有问题!*/
	}
</script>
</head>
<body>
	
	<h3>${registerInfo}</h3>
	请登入:
		<form action="/pc/goShow" method="post">
			用户名:<input id="uname" name="uname" value="zs" onblur="login()" />
			密码:<input id="pwd" name="pwd" value="123" onblur="login()" /><span id="span"></span><br/>
			<input type="submit" value="登入" id="ip" />
			<a href="/pc/goPage">注册</a>
		</form>
		
</body>
</html>
