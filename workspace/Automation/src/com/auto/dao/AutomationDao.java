package com.auto.dao;

import java.util.List;

import com.auto.bean.AdminLoginTO;
import com.auto.bean.ExaminationTO;
import com.auto.bean.InvigilatorTO;
import com.auto.bean.RegisterTO;
import com.auto.bean.SeatingArangementTO;
import com.auto.exception.ConnectionException;

public interface AutomationDao {
	
	public boolean userRegister(RegisterTO rt)throws ConnectionException;
	public String loginCheck(RegisterTO rt)throws ConnectionException;
	public boolean insertInvigilator(InvigilatorTO iv)throws ConnectionException;
	public String loginCheckInv(InvigilatorTO iv)throws ConnectionException;
	public String loginCheck1(AdminLoginTO lt)throws ConnectionException;
	public boolean examinationSch(ExaminationTO ex)throws ConnectionException;
	public boolean seatingArangeMent(SeatingArangementTO st)throws ConnectionException;
	public List<ExaminationTO> viewExaminationList(ExaminationTO ex)throws ConnectionException;
	public List<SeatingArangementTO> viewSeatingArangementList(
			SeatingArangementTO ex)throws ConnectionException;
	public List<InvigilatorTO> viewInvigilatorStatus(InvigilatorTO ex)throws ConnectionException;
}
