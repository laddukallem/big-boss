import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author sony
 */
public class ChangePass extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        String p = request.getParameter("pass");
        String u = request.getParameter("username");
        Class.forName("com.mysql.jdbc.Driver");
        PrintWriter pw = response.getWriter();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examination", "root","Project");
        Statement stmt = con.createStatement();
        if(p.equals(request.getParameter("opass"))){
            String sql = "update `examination`.`users` set `password`='"+request.getParameter("npass")+"' where idusers='"+u+"'";
            stmt.executeUpdate(sql);
            request.getRequestDispatcher("change_1.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("change.jsp").include(request, response);
            pw.println("<div class='error'>Current Password doesn't matched</div>");
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
