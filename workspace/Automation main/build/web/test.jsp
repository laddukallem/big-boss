<%-- 
    Document   : test
    Created on : Mar 1, 2016, 6:50:05 PM
    Author     : sony
--%>

<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examination","root","Project");
            Statement stm = con.createStatement();
            String sql = "select distinct(starting_date),distinct(ending_date) from `examination`.`sitting`";
            ResultSet rs = stm.executeQuery(sql);
            
        %>
        
    </body>
</html>
