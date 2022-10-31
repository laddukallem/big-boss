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
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examination","root","Project");
                Statement stm = con.createStatement();
                String val = "inactive";
                String sql = "SELECT * FROM `examination`.`users`;";
                ResultSet rs = stm.executeQuery(sql);
                if(s.equals("admin")){
                    %>
                        <table>
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Designation</th>
                                        <th>Year</th>
                                        <th>Section</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                        <%
                        while(rs.next()){
                            String ac = rs.getString("active");
                            if(ac.equals("inactive")){
                            %>
                                <tr>
                                    <td><%=rs.getString("name") %></td>
                                    <td><%=rs.getString("designation") %></td>
                                    <td><%=rs.getString("year") %></td>
                                    <td><%=rs.getString("section") %></td>
                                    <td>
                                        <form method="post" action="Active">
                                            <input type="hidden" name="id" value='<%=rs.getString("idusers") %>' />
                                            <input type="submit" name="active" value="Activate" />
                                        </form>
                                        <form method="post" action="Delete">
                                            <input type="hidden" name="id" value='<%=rs.getString("idusers") %>' />
                                            <input type="submit" name="delete" value="Delete" />
                                        </form>
                                    </td>
                                </tr>
                            <%
                            }
                        }
                            %>
                        </table>
                <%
                } 
                else if(s.equals("staff")){
                    sql = "SELECT * FROM `examination`.`schedule` WHERE `users_idusers`=\""+u+"\";";
                    rs = stm.executeQuery(sql);
                %>
                    <table>
                                <thead>
                                    <tr>
                                        <th>Subject</th>
                                        <th>Day</th>
                                        <th>Time</th>
                                        <th>Section</th>
                                    </tr>
                                </thead>
                <%
                    while(rs.next()){
                %>
                <tr>
                    <td><%=rs.getString("subject_idsubject") %></td>
                    <td><%=rs.getString("day") %></td>
                    <td><%=rs.getString("time") %></td>
                    <td><%=rs.getString("section") %></td>
                </tr>
                <%
                    }%>
                    </table>
                    <%
                }
                else{
                    sql = "SELECT * FROM `examination`.`absent` WHERE `users_idusers`=\""+u+"\";";
                    rs = stm.executeQuery(sql);
                    if(rs.next()){
                %>
                <form action="change.jsp" method="post">
                    <table>
                        <tr>
                            <td>Exam Type</td>
                            <td><%=rs.getString("exam") %></td>
                        </tr>
                        <tr>
                            <td>Roll Number</td>
                            <td><%=rs.getString("subject_idsubject") %></td>
                        </tr>
                    </table>
                </form>
                <%
                    }
                }
                %>
            </div>
        </div>
    </body>
</html>
