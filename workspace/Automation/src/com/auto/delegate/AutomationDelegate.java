package com.auto.delegate;

import java.util.List;

import com.auto.bean.AdminLoginTO;
import com.auto.bean.ExaminationTO;
import com.auto.bean.InvigilatorTO;
import com.auto.bean.RegisterTO;
import com.auto.bean.SeatingArangementTO;
import com.auto.exception.ConnectionException;
import com.auto.service.AutomationService;
import com.auto.serviceimpl.AutomationServiceImpl;

public class AutomationDelegate {
	AutomationService service=new AutomationServiceImpl();

	public boolean userRegister(RegisterTO rt)throws ConnectionException {
		// TODO Auto-generated method stub
		return service.userRegister(rt);
	}

	public String loginCheck(RegisterTO rt)throws ConnectionException {
		// TODO Auto-generated method stub
		return service.loginCheck(rt);
		
	}

	public boolean insertInvigilator(InvigilatorTO iv)throws ConnectionException {
		// TODO Auto-generated method stub
		return service.insertInvigilator(iv);
	}

	public String loginCheckInv(InvigilatorTO iv)throws ConnectionException {
		// TODO Auto-generated method stub
		return service.loginCheckInv(iv);
	}

	public String loginCheck1(AdminLoginTO lt)throws ConnectionException {
		// TODO Auto-generated method stub
		return service.loginCheck1(lt);
	}

	public boolean examinationSch(ExaminationTO ex)throws ConnectionException {
		// TODO Auto-generated method stub
		return service.examinationSch(ex);
	}

	public boolean seatingArangeMent(SeatingArangementTO st)throws ConnectionException {
		// TODO Auto-generated method stub
		return service.seatingArangeMent(st);
	}

	public List<ExaminationTO> viewExaminationList(ExaminationTO ex)throws ConnectionException {
		// TODO Auto-generated method stub
		return service.viewExaminationList(ex);
	}

	public List<SeatingArangementTO> viewSeatingArangementList(
			SeatingArangementTO ex)throws ConnectionException {
		// TODO Auto-generated method stub
		return service.viewSeatingArangementList(ex);
	}

	public List<InvigilatorTO> viewInvigilatorStatus(InvigilatorTO ex)throws ConnectionException {
		// TODO Auto-generated method stub
		return service.viewInvigilatorStatus(ex);
	}

}
