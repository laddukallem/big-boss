<%-- 
    Document   : change.jsp
    Created on : Feb 15, 2016, 12:57:33 PM
    Author     : sony
--%>

<%@page import="java.sql.ResultSet"%>
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
        <script type="text/javascript" src="JS/jquery.min.js"></script>        
    </head>
    <body>
        <% 
            String s = (String)session.getAttribute("desc");
            String u = (String)session.getAttribute("empid");
            String p = (String)session.getAttribute("password");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examination","root","Project");
            Statement stm = con.createStatement();
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
                        <li><a href="change.jsp">Change Password</a></li>
                        <li><a href="logout">logout</a></li>
                    </ul>
                </div>
            </div>
            <div class="content-vl">
                <div class="login-form">
                    <%
                        stm.executeUpdate("delete from `examination`.`sitting` where ending_date < CURDATE()");
                        if(s.equals("studt")){
                        String sql = "select `rooms_room_no` from `examination`.`sitting` where users_idusers='"+u+"'";
                        ResultSet rs = stm.executeQuery(sql);
                        if(rs.next()){
                            %><%=rs.getString("rooms_room_no")%><%
                        }else{        
                    %>
                            There is NO Exams Going on rite Now...
                    <%
                        }
                    }else if(s.equals("staff")){
                        String sql = "select `rooms_room_no` from `examination`.`sitting` where users_idusers='"+u+"'";
                        ResultSet rs = stm.executeQuery(sql);
                        %>
                        <form action="request.jsp" method="post">
                        <table>
                                <tr>
                                    <td>Room Number</td>
                                    <td>Date</td>
                                </tr>
                                
                        <%
                        while(rs.next()){
                            %>
                            <tr>
                                <td><input type="text" name="room_no" value='<%=rs.getString("rooms_room_no") %>' readonly/></td>
                                <td><input type="text" name="room_no" value='<%=rs.getString("starting_date") %>' readonly/></td>
                                <td>
                                    <input type="hidden" value='<%=rs.getString("users_idusers") %>' />
                                    <input type="submit" value="Change" />
                                </td>
                            </tr>
                            <%
                        }%>
                        </table>
                        </form>
                        <%
                    }else{
                        %>
                        <form action="FileGenerater" method="post">
                        <table>
                            <tr>
                                <td>Select Room Numbers</td>
                                <td>
                                    <select name="rooms" size="3" multiple>
                                        <% 
                                            String sql = "select * from `examination`.`rooms`";
                                            ResultSet rs = stm.executeQuery(sql);
                                            while(rs.next()){
                                        %>
                                        <option value='<%=rs.getString("room_no") %>,<%=rs.getString("capacity") %>'><%=rs.getString("room_no") %></option>
                                        <%
                                            }
                                            
                                        %>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Exam To</td>
                                <td>
                                    <select class="selection" name="year" id="Select" style="width: 50%;">
                                        <option value="1">I</option>
                                        <option value="2">II</option>
                                        <option value="3">III</option>
                                        <option value="4">IV</option>
                                        <option value="5">I & II</option>
                                        <option value="6">I & III</option>
                                        <option value="7">I & IV</option>
                                        <option value="8">II & III</option>
                                        <option value="9">II & IV</option>
                                        <option value="10">III & IV</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Starting Date:<input type="text" name="start" placeholder="YYYY/MM/DD"/></td>
                                <td>Ending Date:<input type="text" name="end" placeholder="YYYY/MM/DD"/></td>
                            </tr>
                            <tr><td><input type="submit" value="Submit"/></td></tr>
                        </table>
                        </form>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
