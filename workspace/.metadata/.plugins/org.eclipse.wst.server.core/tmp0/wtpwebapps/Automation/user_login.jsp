<!DOCTYPE html>
<html>
<head>
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<meta charset="UTF-8">

<title>AOES</title>

<link type="text/css" rel="stylesheet" href="css/user_menu.css" media="screen, projection"></link>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
			<br><br>
<table width="50%" align="center">
<tr>

<td>
<form action="LoginAction" method="post">
<div class="login-block">
    <h1>User Login</h1>
    <input type="text" value="" name="userName" placeholder="Username" id="username" />
    <input type="password" value=""  name="password" placeholder="Password" id="password" />
    <button>Submit</button>
	<%String loginfail=(String)request.getAttribute("loginfail"); %>
    <font color='red'><%if(loginfail!=null){%><%=loginfail%> <%} %></font> 
</div>
</form>
</td>
</tr>
</table>
</body>

</html>