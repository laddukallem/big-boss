package com.auto.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.auto.bean.AdminLoginTO;
import com.auto.bean.ExaminationTO;
import com.auto.bean.InvigilatorTO;
import com.auto.bean.RegisterTO;
import com.auto.bean.SeatingArangementTO;
import com.auto.dao.AutomationDao;
import com.auto.dbutil.DBConnectionFactory;
import com.auto.exception.ConnectionException;

public class AutomationDaoImpl  implements AutomationDao {
	 private int noOfRecords;
		Connection con;
		PreparedStatement pstmt, pstmt1, pstmt2, pstmt3;
		Statement st, stmt;
		ResultSet rs, rs1, rs2, rs3;
		public void closeConnection() throws ConnectionException {
			try {

				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				throw new ConnectionException(
						"Some Problem Occured during the closing connections");
			}
		
		}

	@Override
	public boolean userRegister(RegisterTO rt) throws ConnectionException {
		boolean flag = false;
		int userId=rt.getUserId();
		String username=rt.getUserName();
		String email=rt.getEmail();
		String password=rt.getPassword();
		String confirmpassword=rt.getConfirmPassword();
	
		
		System.out.println("user:"+username);
int j=0;

		try {
			con = DBConnectionFactory.getConnection();
			DBConnectionFactory db=new DBConnectionFactory();

			pstmt = con.prepareStatement("insert into USERDETAILS values(?,?,?,?,?)");
					//.prepareCall("{ call userinformation (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			pstmt.setInt(1,db.getSequenceID("USERDETAILS", "0") );
			
			pstmt.setString(2,username);
			System.out.println("hai");
           pstmt.setString(3,email);
           pstmt.setString(4,password);
           pstmt.setString(5, confirmpassword);
          
			int i = pstmt.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {
				flag = false;

			}
			con.close();
		} catch (SQLException e) {
			flag = false;

			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			throw new ConnectionException("problem occure during Registration");

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public String loginCheck(RegisterTO rt) throws ConnectionException {
		String ltype = null;

		try {
System.out.println("hai");
			con = DBConnectionFactory.getConnection();

			System.out.println("con value is " + con);

			System.out.println("in DAo impl is..con is....." + con);
			String uname = rt.getUserName();
			String pwd = rt.getPassword();
			System.out.println("sree:;;"+uname);
			
			 Statement st = con.createStatement();  
             String query = "SELECT * from USERDETAILS where USERNAME='" + uname + "'"+" and password='"+pwd+ "'";  
             System.out.println("quey is "+query);
             System.out.printf(query);  
             ResultSet rs = st.executeQuery(query);  

			/* pstmt = con.prepareStatement(SqlConstants._LOGINCHECK);

			
			System.out.println("in Security DAO class.....uname is" + uname);
			
			System.out.println("in Security DAO class.....password is" + pwd);

			pstmt.setString(1, uname);
			pstmt.setString(2, pwd);*/

			
        
			
			
			
			
			while (rs.next()) {
				ltype = rs.getString(2);
				System.out.println("in result set login type is..." + ltype);
			}
			

		} catch (SQLException e) {

			throw new ConnectionException(
					"sorry! some internal problems occure in login check please visit later");

		}
		return ltype;
	}

	@Override
	public boolean insertInvigilator(InvigilatorTO iv)
			throws ConnectionException {
		boolean flag = false;
		
		int id=iv.getId();
		int invgid=iv.getInvgid();
		String invgcls=iv.getInvgcls();
		String time=iv.getTime();
		String invgname=iv.getInvgname();
		String invgpass=iv.getInvgpass();
		
int j=0;

		try {
			con = DBConnectionFactory.getConnection();
			DBConnectionFactory db=new DBConnectionFactory();

			pstmt = con.prepareStatement("insert into invigilator values(?,?,?,?,?,?)");
					//.prepareCall("{ call userinformation (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			pstmt.setInt(1,db.getSequenceID("invigilator", "0") );
			
			pstmt.setInt(2,invgid);
			System.out.println("hai");
           pstmt.setString(3,invgcls);
           pstmt.setString(4,time);
           pstmt.setString(5, invgname);
           pstmt.setString(6, invgpass);
          
			int i = pstmt.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {
				flag = false;

			}
			con.close();
		} catch (SQLException e) {
			flag = false;

			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			throw new ConnectionException("problem occure during Registration");

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public String loginCheckInv(InvigilatorTO iv) throws ConnectionException {
		String ltype = null;

		try {
System.out.println("hai");
			con = DBConnectionFactory.getConnection();

			System.out.println("con value is " + con);

			System.out.println("in DAo impl is..con is....." + con);
			String uname = iv.getInvgname();
		String pwd = iv.getInvgpass();
		System.out.println("sree:;;"+uname);
			
			 Statement st = con.createStatement();  
			
            String query = "SELECT * from INVIGILATOR where INVGNAME='" + uname + "'"+" and INVGPASS='"+pwd+ "'";  
             System.out.println("quey is "+query);
             System.out.printf(query);  
             ResultSet rs = st.executeQuery(query);  

			/* pstmt = con.prepareStatement(SqlConstants._LOGINCHECK);

			
			System.out.println("in Security DAO class.....uname is" + uname);
			
			System.out.println("in Security DAO class.....password is" + pwd);

			pstmt.setString(1, uname);
			pstmt.setString(2, pwd);*/

			
        
			
			
			
			
			while (rs.next()) {
				ltype = rs.getString(2);
				System.out.println("in result set login type is..." + ltype);
			}
			

		} catch (SQLException e) {

			throw new ConnectionException(
					"sorry! some internal problems occure in login check please visit later");

		}
		return ltype;
	}

	@Override
	public String loginCheck1(AdminLoginTO lt) throws ConnectionException {
		String ltype = null;

		try {
System.out.println("hai");
			con = DBConnectionFactory.getConnection();

			System.out.println("con value is " + con);

			System.out.println("in DAo impl is..con is....." + con);
			String uname = lt.getUserName();
			String pwd = lt.getPassWord();
			System.out.println("sree:;;"+uname);
			
			 Statement st = con.createStatement();  
             String query = "SELECT * from admin where username='" + uname + "'"+" and password='"+pwd+ "'";  
             System.out.println("quey is "+query);
             System.out.printf(query);  
             ResultSet rs = st.executeQuery(query);  

			/* pstmt = con.prepareStatement(SqlConstants._LOGINCHECK);

			
			System.out.println("in Security DAO class.....uname is" + uname);
			
			System.out.println("in Security DAO class.....password is" + pwd);

			pstmt.setString(1, uname);
			pstmt.setString(2, pwd);*/

			
        
			
			
			
			
			while (rs.next()) {
				ltype = rs.getString(2);
				System.out.println("in result set login type is..." + ltype);
			}
			

		} catch (SQLException e) {
			System.out.println("test:"+e.getMessage());

			throw new ConnectionException(
					"sorry! some internal problems occure in login check please visit later");

		}
		return ltype;
	}

	@Override
	public boolean examinationSch(ExaminationTO ex) throws ConnectionException {
		boolean flag = false;
		
		int id=ex.getId();
		String subject=ex.getSubject();
		String date=ex.getDate();
		String duration=ex.getDuration();
		
		int j=0;

				try {
					con = DBConnectionFactory.getConnection();
					DBConnectionFactory db=new DBConnectionFactory();

					pstmt = con.prepareStatement("insert into examinationsch values(?,?,?,?)");
							//.prepareCall("{ call userinformation (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					pstmt.setInt(1,db.getSequenceID("examinationsch", "0") );
					
					pstmt.setString(2,subject);
					System.out.println("hai");
		           pstmt.setString(3,date);
		           pstmt.setString(4,duration);
		           
		          
					int i = pstmt.executeUpdate();
					if (i == 1) {
						flag = true;
					} else {
						flag = false;

					}
					con.close();
				} catch (SQLException e) {
					flag = false;

					try {
						con.rollback();
					} catch (SQLException se) {
						se.printStackTrace();
					}
					throw new ConnectionException("problem occure during Registration");

				} catch (Exception e) {
					e.printStackTrace();
					flag = false;
					try {
						con.rollback();
					} catch (SQLException se) {
						se.printStackTrace();
					}
				}
				return flag;
	}

	@Override
	public boolean seatingArangeMent(SeatingArangementTO st)
			throws ConnectionException {
		boolean flag = false;
		int j=0;
int id=st.getId();
String fromroll=st.getFromroll();
String toroll=st.getToroll();
String clsrmno=st.getClsroomno();
		try {
			con = DBConnectionFactory.getConnection();
			DBConnectionFactory db=new DBConnectionFactory();

			pstmt = con.prepareStatement("insert into starangement values(?,?,?,?)");
					//.prepareCall("{ call userinformation (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			pstmt.setInt(1,db.getSequenceID("starangement", "0") );
			
			pstmt.setString(2,fromroll);
			System.out.println("hai");
           pstmt.setString(3,toroll);
           pstmt.setString(4,clsrmno);
          
          
			int i = pstmt.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {
				flag = false;

			}
			con.close();
		} catch (SQLException e) {
			flag = false;

			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			throw new ConnectionException("problem occure during Registration");

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public List<ExaminationTO> viewExaminationList(ExaminationTO ex)
			throws ConnectionException {
		List list=new ArrayList();
		try {

			con = DBConnectionFactory.getConnection();

			
			
			   
			 Statement st1 = con.createStatement(); 
              

			

             ResultSet rs1 =null;  
        
			
			//int id=app.getAppid();
			
			
			
			 String query1="select * from EXAMINATIONSCH ";
			 rs1 = st1.executeQuery(query1);  
			 System.out.println("hai");
			while(rs1.next())
			{ 
				ExaminationTO   ex1=new ExaminationTO ();
				ex1.setId(rs1.getInt(1));
				ex1.setSubject(rs1.getString(2));
				ex1.setDate(rs1.getString(3));
				ex1.setDuration(rs1.getString(4));
				//per.setAppPermission(rs1.getString(2));
				//.setAppImage(appImage);
								
				
					
					
				
	                  
			
				
		
					list.add(ex1);
				}
			
			
			
			
			
		} catch (Exception e) {

			throw new ConnectionException(
					"sorry! some internal problems occure in login check please visit later");

		}
		return list;
	}

	@Override
	public List<SeatingArangementTO> viewSeatingArangementList(
			SeatingArangementTO ex) throws ConnectionException {
		List list=new ArrayList();
		try {

			con = DBConnectionFactory.getConnection();

			
			
			   
			 Statement st1 = con.createStatement(); 
              

			

             ResultSet rs1 =null;  
        
			
			//int id=app.getAppid();
			
			
			
			 String query1="select * from STARANGEMENT ";
			 rs1 = st1.executeQuery(query1);  
			 System.out.println("hai");
			while(rs1.next())
			{ 
				SeatingArangementTO   st=new SeatingArangementTO ();
				st.setId(rs1.getInt(1));
				st.setFromroll(rs1.getString(2));
				st.setToroll(rs1.getString(3));
				st.setClsroomno(rs1.getString(4));
				//per.setAppPermission(rs1.getString(2));
				//.setAppImage(appImage);
								
				
					
					
				
	                  
			
				
		
					list.add(st);
				}
			
			
			
			
			
		} catch (Exception e) {
System.out.println(e.getMessage());
			throw new ConnectionException(
					"sorry! some internal problems occure in login check please visit later");

		}
		return list;
	}

	@Override
	public List<InvigilatorTO> viewInvigilatorStatus(InvigilatorTO ex)
			throws ConnectionException {
		List list=new ArrayList();
		try {

			con = DBConnectionFactory.getConnection();

			
			
			   
			 Statement st1 = con.createStatement(); 
              

			

             ResultSet rs1 =null;  
        
			
			//int id=app.getAppid();
			
			
			
			 String query1="select * from INVIGILATOR ";
			 rs1 = st1.executeQuery(query1);  
			 System.out.println("hai");
			while(rs1.next())
			{ 
				InvigilatorTO   iv=new InvigilatorTO();
				iv.setId(rs1.getInt(1));
				iv.setInvgid(rs1.getInt(2));
				iv.setInvgcls(rs1.getString(3));
				iv.setTime(rs1.getString(4));
				iv.setInvgname(rs1.getString(5));
				
				
				
				//.setAppImage(appImage);
								
				
					
					
				
	                  
			
				
		
					list.add(iv);
				}
			
			
			
			
			
		} catch (Exception e) {
System.out.println(e.getMessage());
			throw new ConnectionException(
					"sorry! some internal problems occure in login check please visit later");

		}
		return list;
	}
}
