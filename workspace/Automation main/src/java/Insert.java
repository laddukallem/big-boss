/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sony
 */
public class Insert extends HttpServlet {
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            OutputStream file = new FileOutputStream(new File("C:\\Users\\sony\\Documents\\NetBeansProjects\\Automation\\web\\documents\\invig.pdf"));
 
            Document document = new Document();
            PdfWriter.getInstance(document, file);
 
            document.open();
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examination","root","Project");
            Statement stm = con.createStatement();
            PrintWriter pw = response.getWriter();
            String strtdate = request.getParameter("start");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date date = formatter.parse(strtdate);
            String start = date.toString();
            String[] stval = start.split(" ");
            pw.println(stval[0]);
            ArrayList<String> staff = new ArrayList<String>();
            ArrayList<String> room = new ArrayList<String>();
            ArrayList<Integer> year = new ArrayList<Integer>();
            String sql = "select distinct(year) from `examination`.`sitting`";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                if(year.contains(rs.getInt("year"))){
                    
                }else{
                    year.add(rs.getInt("year"));
                }
            }
            sql = "select distinct(rooms_room_no) from `examination`.`sitting`";
            rs = stm.executeQuery(sql);
            while(rs.next()){
                room.add(rs.getString("rooms_room_no"));
            }
            for(int i=0;i<year.size();i++){
                int y = year.get(i);
                sql = "select * from `examination`.`schedule` where (`day`!='"+stval[0]+"' AND `year`!="+y+" ) OR (`day`='"+stval[0]+"' AND `year`="+y+" )";
                rs = stm.executeQuery(sql);
                while(rs.next()){
                    if(staff.contains(rs.getString("users"))){
                    
                    }else{
                        staff.add(rs.getString("users"));
                    }
                }
            }
            Collections.shuffle(staff);
            String[] rooms = new String[room.size()];
            String[] staffs = new String[staff.size()];
            for(int i=0;i<room.size();i++){
                rooms[i] = room.get(i);
            }
            for(int i=0;i<staff.size();i++){
                staffs[i] = staff.get(i);
            }
            for(int i=0;i<rooms.length;i++){
                document.add(new Paragraph("Room Number : "+rooms[i]+"   "+staffs[i]));
            }
            
            document.close();
            file.close();
            request.setAttribute("page", "invig");
            request.getRequestDispatcher("/success.jsp").forward(request, response);
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static boolean useList(String[] arr, String targetValue) {
	return Arrays.asList(arr).contains(targetValue);
    }

    private boolean uselist(int[] year, int aInt) {
        return Arrays.asList(year).contains(aInt);
    }
}

