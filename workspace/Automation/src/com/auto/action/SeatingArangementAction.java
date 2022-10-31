package com.auto.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.auto.bean.SeatingArangementTO;
import com.auto.delegate.AutomationDelegate;
import com.auto.exception.ConnectionException;

public class SeatingArangementAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

doPost(request, response);
}

public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

HttpSession session = request.getSession();
RequestDispatcher rd = null;

boolean flag = false;
String path = "";


SeatingArangementTO  st= new SeatingArangementTO();

Map map = request.getParameterMap();
try {
	BeanUtils.populate(st, map);

} catch (IllegalAccessException e1) {

	e1.printStackTrace();
} catch (InvocationTargetException e1) {

	e1.printStackTrace();

}

try {

	flag = new AutomationDelegate().seatingArangeMent(st);

	if (flag) {

		path = "./admin_seat_arrangement.jsp";

		request.setAttribute("status200",
				"  Register is successfull created");
	} else {

		path = "./admin_seat_arrangement.jsp";

		request.setAttribute("status200", " Register is Failed");
	}
} catch (ConnectionException e) {
	request.setAttribute("status200", e.getMessage());
	path = "./user_register.jsp";

}

rd = request.getRequestDispatcher(path);
rd.forward(request, response);



}
}

