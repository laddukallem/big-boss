<%-- 
    Document   : home.jsp
    Created on : Feb 11, 2016, 8:07:17 PM
    Author     : Rama Krishna
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <title>Automation of Examination</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Hello Help All" />
        <meta name="author" content="Rama Krishna" />
        <link rel="stylesheet" type="text/css" href="css/main.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link rel="stylesheet" type="text/css" href="css/home.css" />
	<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:700,300,300italic' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <% 
            String s = (String)session.getAttribute("desc");
            String u = (String)session.getAttribute("empid");
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
                            <li class="selected"><a href="profile.jsp">profile</a></li>
                        <% } %>
                        <% if(!s.equals("staff")){%>
                            <li><a href="invigilation.jsp">Sitting</a></li>
                        <% } %>
                        <% if(!s.equals("studt")){%>
                            <li><a href="invigilation.jsp">invigilation</a></li>
                        <% } %>
                        <li><a href="change.jsp">Change Password</a></li>
                        <li><a href="logout">logout</a></li>
                    </ul>
                </div>
            </div>
            <div class="content-vl">
                <%
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examination","root","Project");
                Statement stm = con.createStatement();
                %>
                <div class="content-div">
                <%
                    String sql = "SELECT * FROM `examination`.`users` WHERE `idusers`=\""+u+"\";";
                    ResultSet rs = stm.executeQuery(sql);
                    if(rs.next()){
                %>
                <form action="change.jsp" method="post">
                    <table>
                        <tr>
                            <td>Name</td>
                            <td><%=rs.getString("name") %></td>
                        </tr>
                        <tr>
                            <td>Roll Number</td>
                            <td><%=rs.getString("idusers") %></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><%=rs.getString("password") %></td>
                            <td><input type="submit" value="Change Password" /></td>
                        </tr>
                        <tr>
                            <td>Year</td>
                            <td><%=rs.getString("year") %></td>
                        </tr>
                        <tr>
                            <td>Section</td>
                            <td><%=rs.getString("section") %></td>
                        </tr>
                    </table>
                </form>
                <%
                    }
                %>
                </div>
        </div>
    </body>
</html>
