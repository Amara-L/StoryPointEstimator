<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title> Create story estimator </title>
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
    <p align="center"><b><k> Create story estimator </k></b></p>
    <form name="addMember" method="post" action="/spe/session/create">

        <p>Your story points : </p> ${radioStoryPoints}

        <p align="center"><input type="submit" value="Create story estimator"></p>

    </form>
</div>
</body>
</html>
