import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Rama Krishna
 */
public class Logout extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession();
        session.invalidate();
        pw.print("You are successfully logged out!");
        request.getRequestDispatcher("index.html").forward(request, response);
        pw.close();
    }
}
