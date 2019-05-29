package com.idbiintech.intranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.intranet.dao.IEmployeeDao;
import com.idbiintech.intranet.dto.EmployeeDTO;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeDao userDao;

	@Override
	public int saveEmployee(EmployeeDTO userDTO) {
		return userDao.saveEmployee(userDTO);
	}

	@Override
	public EmployeeDTO loginUser(EmployeeDTO userDTO) {
		EmployeeDTO validUser = userDao.validUser(userDTO.getEmail());
		if (validUser != null && (validUser.getPassword().equals(userDTO.getPassword()))
				&& (validUser.getEmail().equals(userDTO.getEmail()))) {
			
			return validUser;

		} else {
			return null;

		}
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {

		return userDao.getAllEmployees();
	}

	@Override
	public List<EmployeeDTO> getUserById(String searchParam) {
		return userDao.getUserById(searchParam);
	}

	@Override
	public int updateEmployee(EmployeeDTO userDTO) {
		return userDao.updateEmployee(userDTO);
	}

	@Override
	public List<EmployeeDTO> getUserByIdForUpdate(int empId) {
		return userDao.getUserByIdForUpdate(empId);
	}

	@Override
	public int deleteUser(int i) {
		return userDao.deleteUser(i);
	}

	/*@Override
	public EmployeeDTO getUserByAttendance(int empId) {
		return userDao.getUserByAttendance(empId);
	}
	@Override
	public List<EmployeeDTO> getTeamList(int emp_id, int manager_id , int team_id) {
		// TODO Auto-generated method stub
		return userDao.getTeamList(emp_id,manager_id,team_id);
	}

	@Override
	public List<EmployeeDTO> getUserByAttendanceEmpId(int empId) {
		return userDao.getUserByAttendanceEmpId(empId);
	}*/
}
