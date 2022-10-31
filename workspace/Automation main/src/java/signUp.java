import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Rama Krishna
 */
public class signUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String desc = request.getParameter("desc");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String year = request.getParameter("y");
        String section = request.getParameter("s");
        String active = "inactive";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examination","root","Project");
            Statement stm = con.createStatement();
            String sql= "INSERT INTO `examination`.`users` VALUES(\""+id+"\",\""+name+"\",\""+pass+"\",\""+desc+"\",\""+year+"\",\""+section+"\",\""+active+"\");";
            PrintWriter pw = response.getWriter();
            pw.print(sql);
            stm.executeUpdate(sql);
            response.sendRedirect("/");
        }catch (ClassNotFoundException | SQLException | IOException e) {
            
        }
    }
}
