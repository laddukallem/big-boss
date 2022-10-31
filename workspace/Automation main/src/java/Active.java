import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Rama Krishna
 */
public class Active extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examination","root","Project");
            Statement stm = con.createStatement();
            String ac = request.getParameter("id");
            String sql = "UPDATE `examination`.`users` SET `active` = 'active' WHERE `idusers` = \""+ac+"\";";
            stm.executeUpdate(sql);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        pw.close();
    }
}
