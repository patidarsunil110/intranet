package com.idbiintech.intranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.intranet.dao.IAttendanceDao;
import com.idbiintech.intranet.dto.EmployeeDTO;
@Service
public class AttendanceService implements IAttendanceService{
	
	@Autowired
	private IAttendanceDao attendanceDao;
	
	@Override
	public EmployeeDTO getUserByAttendance(int empId) {
		return attendanceDao.getUserByAttendance(empId);
	}
	@Override
	public List<EmployeeDTO> getTeamList(int emp_id, int manager_id , int team_id) {
		// TODO Auto-generated method stub
		return attendanceDao.getTeamList(emp_id,manager_id,team_id);
	}

	@Override
	public List<EmployeeDTO> getUserByAttendanceEmpId(int empId) {
		return attendanceDao.getUserByAttendanceEmpId(empId);
	}
}
