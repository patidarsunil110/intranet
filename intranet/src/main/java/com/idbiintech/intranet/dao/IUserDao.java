package com.idbiintech.intranet.dao;

import java.util.ArrayList;
import java.util.List;

import com.idbiintech.intranet.dto.UserDTO;

public interface IUserDao {

	public int saveEmployee(UserDTO userDTO);

	public UserDTO validUser(String emailId);

	public ArrayList<UserDTO> getAllEmployees();

	public List<UserDTO> getUserById(String searchParam);

	public int updateEmployee(UserDTO userDTO);

	public List<UserDTO> getUserByIdForUpdate(int empId);

	public int deleteUser(int i);

	public UserDTO getUserByAttendance(UserDTO userDTO);

	public List<UserDTO> getUserByAttendance();

	public UserDTO getUserByAttendance(int empId);

	public List<UserDTO> getTeamList(int emp_id, int manager_id, int team_id);

	public List<UserDTO> getUserByAttendanceEmpId(int empId);

}
