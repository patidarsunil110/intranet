package com.idbiintech.intranet.dao;

import java.util.List;

import com.idbiintech.intranet.dto.EmployeeDTO;

public interface IAttendanceDao{

	public EmployeeDTO getUserByAttendance(int empId);

	public List<EmployeeDTO> getTeamList(int emp_id, int manager_id, int team_id);

	public List<EmployeeDTO> getUserByAttendanceEmpId(int empId);

}
