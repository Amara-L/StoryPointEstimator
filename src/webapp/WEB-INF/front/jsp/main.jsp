<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title> Main page </title>
    <style><%@include file="/WEB-INF/front/jsp/css/style.css"%></style>
</head>
<body>
<div>
    <p><b><k> Hello ${userName} ! </k></b></p>
    <p>You can:</p>
    <p><a href="/spe/session/create"><k> Create estimate session </k></a></p>
    <p><a href="/spe/session/join"><k> Join to estimate session </k></a></p>
    <p><a href="/spe/authorization/exit"><k> Go out </k></a></p>
</div>
</body>
</html>
