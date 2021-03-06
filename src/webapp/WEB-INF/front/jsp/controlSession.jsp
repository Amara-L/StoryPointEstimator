<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title> Story Point Estimator </title>
    <style><%@include file="/WEB-INF/front/jsp/css/style.css"%></style>
</head>
<body>
<div>
    <p><b><k> Session id: ${sessionId} </k></b></p>
    <p>You can:</p>
    <form name="control" method="get" action="/spe/session/${sessionId}">
        <p align="center"> <input type="submit" value="Open session page"></p>
    </form>
    <form name="control" method="post" action="/spe/session/${sessionId}/control">
        <p align="center"> <input type="submit" value="Close estimate session"></p>
    </form>
    <form name="control" method="get" action="/spe/authorization/exit">
        <p align="center"> <input type="submit" value=" Go out"></p>
    </form>
    </br>

    <p align="center"><b><k> Add member </k></b></p>
    <form name="addMember" method="post" action="/spe/session/${sessionId}/control/addmember">
        <p align="center"><k> E-Mail: </k><input type="email" name="mail"></p>
        <p align="center"> <input type="submit" value="Send"></p>
    </form>
    </br>
    <p> Team members: ${teamMembers} </p>
</div>
</body>
</html>
