<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<title> I forgot my password </title>
	<style><%@include file="/WEB-INF/front/jsp/css/style.css"%></style>
</head>
<body>
	<header>	
		<table>
    		<tr>
			<td><b><m> Story point estimation </m></b></td>
			<td></td>
			<td><a href="/spe/authorization/login"><b><m> I remembered it </m></b></a></td>
    		</tr>
		</table>
	</header>
<div>
	<p align="center"><b><k> I forgot my password </k></b></p>
	<form name="iForgotMyPassword" method="post" action="/spe/authorization/restorepass">
		<p align="center"><k> E-Mail: </k><input type="email" name="mail"></p>
		<p align="center"> <input type="submit" value="Send"></p>
	</form>
</div>
</body>
</html>
