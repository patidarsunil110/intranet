package com.idbiintech.intranet.service;

import java.util.List;

import com.idbiintech.intranet.dto.UserDTO;

public interface IUserService {

	public UserDTO loginUser(UserDTO userDTO);

	public int saveEmployee(UserDTO userDTO);

	public List<UserDTO> getAllEmployees();

	public List<UserDTO> getUserById(String searchParam);

	public int updateEmployee(UserDTO userDTO);

	public List<UserDTO> getUserByIdForUpdate(int empId);

	public int deleteUser(int i);

	public UserDTO getUserByAttendance(UserDTO userDTO);

	public List<UserDTO> getUserByAttendance();

}
