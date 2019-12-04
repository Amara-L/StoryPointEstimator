<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<title> Add member </title>
	<style><%@include file="/WEB-INF/front/jsp/css/style.css"%></style>
</head>
<body>
<div>
	<p align="center"><b><k> Add member </k></b></p>
	<p align="center"><k>${session}</k></p>
	<form name="addMember" method="post" action="/spe/session/{sessionId}/control/addmember">
		<p align="center"><k> E-Mail: </k><input type="email" name="mail"></p>
		<p align="center"> <input type="submit" value="Send"></p>
	</form>
</div>
</body>
</html>
