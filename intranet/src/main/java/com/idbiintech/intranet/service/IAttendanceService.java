package com.idbiintech.intranet.service;

import java.util.List;

import com.idbiintech.intranet.dto.EmployeeDTO;

public interface IAttendanceService {

	EmployeeDTO getUserByAttendance(int empId);

	List<EmployeeDTO> getTeamList(int emp_id, int manager_id, int team_id);

	List<EmployeeDTO> getUserByAttendanceEmpId(int empId);

}
