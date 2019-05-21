package com.idbiintech.intranet.service;

import java.util.List;

import com.idbiintech.intranet.dto.EmployeeDTO;

public interface IEmployeeService {

	public EmployeeDTO loginUser(EmployeeDTO userDTO);

	public int saveEmployee(EmployeeDTO userDTO);

	public List<EmployeeDTO> getAllEmployees();

	public List<EmployeeDTO> getUserById(String searchParam);

	public int updateEmployee(EmployeeDTO userDTO);

	public List<EmployeeDTO> getUserByIdForUpdate(int empId);

	public int deleteUser(int i);

	public EmployeeDTO getUserByAttendance(int i);

	/*public List<UserDTO> getUserByAttendance();*/
	
	public List<EmployeeDTO> getTeamList(int emp_id, int manager_id, int team_id);

	public List<EmployeeDTO> getUserByAttendanceEmpId(int empId);

}
