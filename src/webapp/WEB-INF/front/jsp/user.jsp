<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Get Name</title>
</head>
<body>
	<header>	
		<table>
    		<tr>
			<td><b><m> Story point estimation </m></b></td>
			<td></td>
			<td><a href="/spe/authorization/exit"><b><m> Go out </m></b></a></td>
    		</tr>
		</table>
	</header>
<p>Name user: ${name}</p>
<br>

<form name="getUser" method="post" action="/spe/test/user">

    <p>User id:<Br>
        <input type="number" name="id">

    <p><input type="submit" value="Отправить">
        <input type="reset" value="Очистить"></p>
</form>


</body>
</html>