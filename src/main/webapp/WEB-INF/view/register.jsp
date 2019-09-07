<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
	请注册:
	<form action="/mc/register" method="post">
		用户名:<input name="uname" value="ww"/></br>
		密码:<input type="password" name="upassword" value="456"/></br>
		真实姓名:<input name="urealName" value="王五"/></br>
		性别:<input type="radio" name="usex" value="女" checked="checked"/>女
			<input type="radio" name="usex" value="男"/>男</br>
		年龄:<input name="uage" value="20"/></br>
		<input type="submit" value="注册"/>
	</form>

</body>
</html>
