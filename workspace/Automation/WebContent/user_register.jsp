<!DOCTYPE html>
<html>
<head>
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<meta charset="UTF-8">

<title>AOES</title>

<link type="text/css" rel="stylesheet" href="css/user_menu.css" media="screen, projection"></link>
</head>
<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("pass1").value;
        var confirmPassword = document.getElementById("pass2").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script>
<% int i=0,j=0,productid=0;
 	if ((String) request.getAttribute("status200") != null) {
 %><font color='red'> <%=request.getAttribute("status200")%></font> <%
 	}
 %> 
<body>
<jsp:include page="header.jsp"></jsp:include>
			
<br><br>
<form action="RegisterAction" method="post">
<table width="50%" align="center">
<tr>

<td>
<div class="login-block">
    <h1>User Register</h1>
    <input type="text" value="" placeholder="Username" name="userName" id="username" />
	<input type="text" value="" placeholder="E-mail" name="email" id="username" />
    <input type="password" value="" placeholder="Password" name="password" id="pass1"/>
	<input type="password" value="" placeholder="confirm password" name="confirmPassword" id="pass2"/>
    <button>Submit</button>
	<%String loginfail=(String)request.getAttribute("loginfail"); %>
    <font color='red'><%if(loginfail!=null){%><%=loginfail%> <%} %></font> 
</div>
</td>
</tr>
</table>
</form>
</body>

</html>