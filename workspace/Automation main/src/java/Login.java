import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Rama Krishna
 */
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = "";
        String pass = request.getParameter("pass");
        String opt = request.getParameter("opt");
        if("admin".equals(opt)){
            user = opt;
        }else{
            user = request.getParameter("user");
        }
        Object obj1 = null;
        String log = "no";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examination","root","Project");
            Statement stm = con.createStatement();
            String sql= "SELECT * FROM `examination`.`users` WHERE(`idusers` = \""+user+"\" and `password` = \""+pass+"\" and `active`='active');";
            ResultSet rs = stm.executeQuery(sql);
            PrintWriter pw = response.getWriter();
            if(rs.next()){
                log = "yes";
                HttpSession session = request.getSession();
                request.setAttribute("designation", opt);
                session.setAttribute("empid", user);
                session.setAttribute("password",pass);
                session.setAttribute("desc",opt);
                session.setAttribute("logged",log);
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            }else{
                pw.print("Sorry, id or password error!");
                request.getRequestDispatcher("index.html").forward(request, response);
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
