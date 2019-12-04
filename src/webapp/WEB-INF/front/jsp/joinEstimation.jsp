<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<title> Join Estimation </title>
	<style><%@include file="/WEB-INF/front/jsp/css/style.css"%></style>
</head>
<body>
<div>
	<p align="center"><b><k> Join Estimation </k></b></p>
	<form name="joinEstimation" method="post" action="/spe/session/join">
		<p align="center"><k> Login: </k><input type="text" name="login"></p>
		<p align="center"><k> Session ID: </k><input type="text" name="sessionId"></p>
		<p align="center"><input type="submit" value="Send"></p>
	</form>
</div>
</body>
</html>
