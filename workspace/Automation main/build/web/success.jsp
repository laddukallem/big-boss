<%-- 
    Document   : home.jsp
    Created on : Feb 11, 2016, 8:07:17 PM
    Author     : Rama Krishna
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Arrays"%>
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
                        <li class="selected"><a href="#">home</a></li>
                        <% if(!s.equals("admin")){%>
                            <li><a href="profile.jsp">profile</a></li>
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
                    String url = (String) request.getAttribute("page");
                    url = url+".pdf";
                    
                %>
                <h1>Created To View</h1><a href="documents/<%=url%>" target="_blank">Click here</a>
            </div>
        </div>
    </body>
</html>
