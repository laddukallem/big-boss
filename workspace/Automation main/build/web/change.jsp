<%-- 
    Document   : change.jsp
    Created on : Feb 15, 2016, 12:57:33 PM
    Author     : sony
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <title>Automation of Examination</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Hello Help All" />
        <meta name="author" content="Rama Krishna" />
        <link rel="stylesheet" type="text/css" href="css/main.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link rel="stylesheet" type="text/css" href="css/home.css" />
	<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:700,300,300italic' rel='stylesheet' type='text/css'>
        <script type="text/javascript">
            function validate(){
                var pass = document.getElementsByName("npass");
                var cpass = document.getElementsByName("cpass");
                if(pass != cpass){
                    document.getElementById("error").innerHTML="Password doesn't Macth, New and Conform Password should be similar";
                }        
            }
        </script>        
    </head>
    <body>
        <% 
            String s = (String)session.getAttribute("desc");
            String u = (String)session.getAttribute("empid");
            String p = (String)session.getAttribute("password");
            
        %>
        <div class="header-content">
            <div class="header">
                <div class="logo">
                    <img src="" alt="College" width="50px" height="50px" />
                </div>
                <div class="menu">
                    <ul>
                        <li><a href="home.jsp">home</a></li>
                        <% if(!s.equals("admin")){%>
                            <li><a href="profile.jsp">profile</a></li>
                        <% } %>
                        <% if(!s.equals("staff")){%>
                            <li><a href="invigilation.jsp">Sitting</a></li>
                        <% } %>
                        <% if(!s.equals("studt")){%>
                            <li><a href="invigilation.jsp">invigilation</a></li>
                        <% } %>
                        <li class="selected"><a href="change.jsp">Change Password</a></li>
                        <li><a href="logout">logout</a></li>
                    </ul>
                </div>
            </div>
            <div class="content-vl">
                <div class="login-form">
                    <p id="error">
                       
                    </p>
                        <form action="ChangePass" method="post">
                            <input type="hidden" name="pass" value="<%=p%>"/>
                            <input type="hidden" name="username" value="<%=u%>"/>
                            <table>
                                <tr class="user">
                                    <td>Old Password</td>
                                    <td><input type="password" name="opass" placeholder="Old Password" /></td>
                                </tr>
                                <tr>
                                    <td>New Password</td>
                                    <td><input type="password" name="npass" placeholder="New Password" /></td>
                                </tr>
                                <tr>
                                    <td>Conform Password</td>
                                    <td><input type="password" name="cpass" placeholder="Password" /></td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center"><input type="submit" value="SignIn" /></td>
                                </tr>
                            </table>
                        </form>
                    </div>
            </div>
        </div>
    </body>
</html>
