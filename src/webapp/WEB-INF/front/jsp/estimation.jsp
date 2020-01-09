<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<title> Estimation </title>
	<style><%@include file="/WEB-INF/front/jsp/css/style.css"%></style>
</head>
<body>
	<header>	
		<table>
    		<tr>
			<td><b><m> Story point estimation </m></b></td>
			<td><a href="/spe/authorization/login"><b><m> Main page </m></b></a></td>
			<td><a href="/spe/authorization/exit"><b><m> Go out </m></b></a></td>
    		</tr>
		</table>
	</header>
<div>
	<p align="center"><b><k> Estimation </k></b></p>
	<p align="center"><k>${userStoryName}</k></p>
	<p align="center"><k>${userStoryDescription}</k></p>

	<form name="estimation" method="post" action="/spe/session/${sessionId}">
		<name="userStoryName" value = ${userStoryName}>
		<name="session" value = ${session}>
		<p align="center"> <input type="submit" name="estimate" value="1">
			<input type="submit" name="estimate" value="2">
			<input type="submit" name="estimate" value="3">
			<input type="submit" name="estimate" value="4">
			<input type="submit" name="estimate" value="5"> </p>
		<p align="center"> <input type="submit" name="estimate" value="8">
			<input type="submit" name="estimate" value="13">
			<input type="submit" name="estimate" value="20">
			<input type="submit" name="estimate" value="40">
			<input type="submit" name="estimate" value="100"> </p>
	</form>
</div>
</body>
</html>
