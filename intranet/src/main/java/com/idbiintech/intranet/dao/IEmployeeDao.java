package com.idbiintech.intranet.dao;

import java.util.ArrayList;
import java.util.List;

import com.idbiintech.intranet.dto.EmployeeDTO;

public interface IEmployeeDao {

	public int saveEmployee(EmployeeDTO userDTO);

	public EmployeeDTO validUser(String emailId);

	public ArrayList<EmployeeDTO> getAllEmployees();

	public List<EmployeeDTO> getUserById(String searchParam);

	public int updateEmployee(EmployeeDTO userDTO);

	public List<EmployeeDTO> getUserByIdForUpdate(int empId);

	public int deleteUser(int i);

	public EmployeeDTO getUserByAttendance(EmployeeDTO userDTO);

	public List<EmployeeDTO> getUserByAttendance();

/*	public EmployeeDTO getUserByAttendance(int empId);

	public List<EmployeeDTO> getTeamList(int emp_id, int manager_id, int team_id);

	public List<EmployeeDTO> getUserByAttendanceEmpId(int empId);*/

}
