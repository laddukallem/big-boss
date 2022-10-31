package com.auto.serviceimpl;

import java.util.List;

import com.auto.bean.AdminLoginTO;
import com.auto.bean.ExaminationTO;
import com.auto.bean.InvigilatorTO;
import com.auto.bean.RegisterTO;
import com.auto.bean.SeatingArangementTO;
import com.auto.dao.AutomationDao;
import com.auto.daoimpl.AutomationDaoImpl;
import com.auto.exception.ConnectionException;
import com.auto.service.AutomationService;

public class AutomationServiceImpl implements AutomationService {
	AutomationDao dao=new AutomationDaoImpl();

	@Override
	public boolean userRegister(RegisterTO rt) throws ConnectionException {
		// TODO Auto-generated method stub
		return dao.userRegister(rt);
	}

	@Override
	public String loginCheck(RegisterTO rt) throws ConnectionException {
		// TODO Auto-generated method stub
		return dao.loginCheck(rt);
	}

	@Override
	public boolean insertInvigilator(InvigilatorTO iv)
			throws ConnectionException {
		// TODO Auto-generated method stub
		return dao.insertInvigilator(iv);
	}

	@Override
	public String loginCheckInv(InvigilatorTO iv) throws ConnectionException {
		// TODO Auto-generated method stub
		return dao.loginCheckInv(iv);
	}

	@Override
	public String loginCheck1(AdminLoginTO lt) throws ConnectionException {
		// TODO Auto-generated method stub
		return dao.loginCheck1(lt);
	}

	@Override
	public boolean examinationSch(ExaminationTO ex) throws ConnectionException {
		// TODO Auto-generated method stub
		return dao.examinationSch(ex);
	}

	@Override
	public boolean seatingArangeMent(SeatingArangementTO st)
			throws ConnectionException {
		// TODO Auto-generated method stub
		return dao.seatingArangeMent(st);
	}

	@Override
	public List<ExaminationTO> viewExaminationList(ExaminationTO ex)
			throws ConnectionException {
		// TODO Auto-generated method stub
		return dao.viewExaminationList(ex);
	}

	@Override
	public List<SeatingArangementTO> viewSeatingArangementList(
			SeatingArangementTO ex) throws ConnectionException {
		// TODO Auto-generated method stub
		return dao.viewSeatingArangementList(ex);
	}

	@Override
	public List<InvigilatorTO> viewInvigilatorStatus(InvigilatorTO ex)
			throws ConnectionException {
		// TODO Auto-generated method stub
		return dao.viewInvigilatorStatus(ex);
	}

}
