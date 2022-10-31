import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 *
 * @author sony
 */
public class FileGenerater extends HttpServlet {
    
    public static final long MILLISECS_PER_MINUTE = 60*1000;
    
    public static final long MILLISECS_PER_HOUR   = 60*MILLISECS_PER_MINUTE;
    
    protected static final long MILLISECS_PER_DAY = 24*MILLISECS_PER_HOUR;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Upload</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Upload at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ///sitting order and inviglation
        try {
            //PDF file Create 
            //Location where the PDF file to Store
            OutputStream file = new FileOutputStream(new File("C:\\Users\\sony\\Documents\\NetBeansProjects\\Automation\\web\\documents\\sitting.pdf"));
 
            Document document = new Document();
            PdfWriter.getInstance(document, file);
 
            document.open();
            
            //response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examination","root","Project");
            Statement stm = con.createStatement();
            String sql = null;
            String[] room = request.getParameterValues("rooms");
            int year = Integer.parseInt(request.getParameter("year"));
            String[] room_no = new String[room.length];
            int[] capacity = new int[room.length];
            int total = 0;
            String strtdate = request.getParameter("start");
            String enddate = request.getParameter("end");
            for(int i=0;i<room.length;i++){
                String[] val = room[i].split(",");
                room_no[i] = val[0];
                capacity[i] = Integer.parseInt(val[1]);
                total = total+capacity[i];
            }
            if(year == 1 || year == 2 || year == 3 || year == 4){
                sql = "select * from `examination`.`users` where `year`='"+year+"'";
            }
            if(year == 5){
                sql = "select * from `examination`.`users` where `year`=1 AND `year`=2";
            }
            if(year == 6){
                sql = "select * from `examination`.`users` where `year`=1 AND `year`=3";
            }
            if(year == 7){
                sql = "select * from `examination`.`users` where `year`=1 AND `year`=4";
            }
            if(year == 8){
                sql = "select * from `examination`.`users` where `year`=2 AND `year`=3";
            }
            if(year == 9){
                sql = "select * from `examination`.`users` where `year`=2 AND `year`=4";
            }
            if(year == 10){
                sql = "select * from `examination`.`users` where `year`=3 AND `year`=4";
            }
            ResultSet rs = stm.executeQuery(sql);
            int numCols = 1;
            List<String> teamList = new LinkedList<String>();
            while(rs.next()){
                teamList.add(rs.getString("idusers"));
                numCols++;
            }
            String[] student = new String[numCols];
            Collections.shuffle(teamList);
            for(int i=0;i<teamList.size();i++){
                student[i] = teamList.get(i);
            }
            int cap;
            if(total != numCols){
                cap = 0;
                int val=numCols/capacity.length;
                for(int i=0;i<capacity.length;i++){
                    document.add(new Paragraph("Room Number : "+room_no[i]));
                    for(int j=0;j<val;j++){
                        document.add(new Paragraph(student[cap]+"  "+student[cap+1]));
                        String s = "select * from `examination`.`users` where idusers='"+student[cap]+"'";
                        ResultSet r = stm.executeQuery(s);
                        if(r.next()){
                            sql = "insert into `examination`.`sitting` values('"+student[cap]+"','"+room_no[i]+"','"+strtdate+"','"+enddate+"',"+r.getInt("year")+")";
                            stm.executeUpdate(sql);
                        }
                        String st = "select * from `examination`.`users` where idusers='"+student[cap+1]+"'";
                        ResultSet rt = stm.executeQuery(s);
                        if(rt.next()){
                            sql = "insert into `examination`.`sitting` values('"+student[cap+1]+"','"+room_no[i]+"','"+strtdate+"','"+enddate+"',"+rt.getInt("year")+")";
                            stm.executeUpdate(sql);
                        }
                        cap = cap + 1;
                        j++;
                    }
                }
            }else{
                cap = 0;
                for(int i=0;i<capacity.length;i++){
                    document.add(new Paragraph("Room Number : "+room_no[i]));
                    //pw.println("Room Number : "+room_no[i]);
                    for(int j = 0;j<capacity[i];j++){
                        document.add(new Paragraph(student[cap]+"  "+student[cap+1]));
                        String s = "select * from `examination`.`users` where idusers='"+student[cap]+"'";
                        ResultSet r = stm.executeQuery(s);
                        if(r.next()){
                            sql = "insert into `examination`.`sitting` values('"+student[cap]+"','"+room_no[i]+"','"+strtdate+"','"+enddate+"',"+r.getInt("year")+")";
                            stm.executeUpdate(sql);
                        }
                        String st = "select * from `examination`.`users` where idusers='"+student[cap+1]+"'";
                        ResultSet rt = stm.executeQuery(s);
                        if(rt.next()){
                            sql = "insert into `examination`.`sitting` values('"+student[cap+1]+"','"+room_no[i]+"','"+strtdate+"','"+enddate+"',"+rt.getInt("year")+")";
                            stm.executeUpdate(sql);
                        }
                        cap = cap + 1;
                        j++;
                    }
                }
            }
            document.add(new Paragraph("   "));
            document.add(new Paragraph(new Date().toString()));
            document.close();
            file.close();
            request.setAttribute("page", "sitting");
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}