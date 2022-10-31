package com.auto.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.auto.bean.InvigilatorTO;
import com.auto.delegate.AutomationDelegate;
import com.auto.exception.ConnectionException;

public class ViewInvigilatorStatusAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

doPost(request, response);
}

public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

HttpSession session = request.getSession();
RequestDispatcher rd = null;
String id1=request.getParameter("id");

boolean flag = false;
String path = "";
List<InvigilatorTO> list=null;


  
InvigilatorTO  ex=new InvigilatorTO ();

Map map = request.getParameterMap();
try {
	BeanUtils.populate(ex, map);

} catch (IllegalAccessException e1) {

	e1.printStackTrace();
} catch (InvocationTargetException e1) {

	e1.printStackTrace();

}

try {
	String path1=request.getRealPath("/images");
	list =new AutomationDelegate().viewInvigilatorStatus(ex);
	
	

	if (!list.isEmpty()) {

		path = "./view_invigilator_status.jsp";

		request.setAttribute("exmlist",list);
		
		


	} else {

		path = "./view_invigilator_status.jsp";

		request.setAttribute("status200", "Registeration is Failed");
		request.setAttribute("exmlist",list);
		
		
	}
} catch (ConnectionException e) {
	request.setAttribute("status200", e.getMessage());
	path = "./index.jsp";

}

rd = request.getRequestDispatcher(path);
rd.forward(request, response);

}

}


