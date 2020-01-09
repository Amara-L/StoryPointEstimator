<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<title> LOGIN </title>
	<style><%@include file="/WEB-INF/front/jsp/css/style.css"%></style>
</head>
<body>
	<header>	
		<table>
    		<tr>
			<td><b><m> Story point estimation </m></b></td>
			<td></td>
			<td></td>
    		</tr>
		</table>
	</header>
<div>
	<p><b><k> Login </k></b></p>
	<form name="authorization" method="post" action="/spe/authorization/login">
		<p><k> Login: </k><input type="text" name="login"></p>
		<p><k> Password: </k><input type="password" name="password"></p>
		<p><input type="submit" value="Send"></p>
	</form>
	<p><a href="/spe/authorization/restorepass"><k> Forgot my password </k></a></p>
</div>
</body>
</html>
