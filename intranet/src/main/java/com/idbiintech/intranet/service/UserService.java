package com.idbiintech.intranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.intranet.dao.IUserDao;
import com.idbiintech.intranet.dto.UserDTO;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public int saveEmployee(UserDTO userDTO) {
		return userDao.saveEmployee(userDTO);
	}

	@Override
	public UserDTO loginUser(UserDTO userDTO) {
		UserDTO validUser = userDao.validUser(userDTO.getEmail());
		if (validUser != null && (validUser.getPassword().equals(userDTO.getPassword()))
				&& (validUser.getEmail().equals(userDTO.getEmail()))) {
			
			return validUser;

		} else {
			return null;

		}
	}

	@Override
	public List<UserDTO> getAllEmployees() {

		return userDao.getAllEmployees();
	}

	@Override
	public List<UserDTO> getUserById(String searchParam) {
		return userDao.getUserById(searchParam);
	}

	@Override
	public int updateEmployee(UserDTO userDTO) {
		return userDao.updateEmployee(userDTO);
	}

	@Override
	public List<UserDTO> getUserByIdForUpdate(int empId) {
		return userDao.getUserByIdForUpdate(empId);
	}

	@Override
	public int deleteUser(int i) {
		return userDao.deleteUser(i);
	}

/*	@Override
	public UserDTO getUserByAttendance(int empId) {
		// TODO Auto-generated method stub
		return userDao.getUserByAttendance(empId);
	}

	@Override
	public List<UserDTO> getUserByAttendance() {
		// TODO Auto-generated method stub
		return userDao.getUserByAttendance();
	}
*/
	@Override
	public UserDTO getUserByAttendance(int empId) {
		return userDao.getUserByAttendance(empId);
	}
	@Override
	public List<UserDTO> getTeamList(int emp_id, int manager_id , int team_id) {
		// TODO Auto-generated method stub
		return userDao.getTeamList(emp_id,manager_id,team_id);
	}

	@Override
	public List<UserDTO> getUserByAttendanceEmpId(int empId) {
		return userDao.getUserByAttendanceEmpId(empId);
	}
}
