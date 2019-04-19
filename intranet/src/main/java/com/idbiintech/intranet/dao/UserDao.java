package com.idbiintech.intranet.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.idbiintech.intranet.dao.IUserDao;
import com.idbiintech.intranet.dto.UserDTO;

@Repository
public class UserDao implements IUserDao {

	private static final Logger logger = LogManager.getLogger(UserDao.class);
	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	static int i = 0;

	@Override
	public int saveEmployee(UserDTO userDTO) {
		logger.info("Entering to authentication() in UserDAO Class :: ");
		try {

			String sqls = "insert into employees(emp_firstname,emp_lastname,mobile,email,password,department_id,manager_id,dateofjoining,role_id) values (?,?,?,?,?,?,?,?,?)";
			i = jdbcTemplate.update(sqls,
					new Object[] { userDTO.getEmpFirstName(), userDTO.getEmpLastName(), userDTO.getMobile(),
							userDTO.getEmail(), userDTO.getPassword(), userDTO.getDepartmentId(),
							userDTO.getManagerId(), userDTO.getDateOfJoining(), userDTO.getRoleId() });
			return i;
		} catch (Exception e) {
			logger.error(e);
			return i;
		}
	}

	@Override
	public UserDTO validUser(String email) {
		List<UserDTO> lists = null;
		logger.info("Entering to loginUser() in UserDAO Class :: ");
		try {

			String sql = " select emp_firstname as empFirstName,emp_lastname as empLastName,email,password from employees where email=?";
			lists = jdbcTemplate.query(sql, new Object[] { email }, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		} catch (Exception e) {
			logger.error(e);
		}
		if (CollectionUtils.isEmpty(lists)) {
			return null;
		} else {
			return lists.get(0);
		}
	}

	@Override
	public ArrayList<UserDTO> getAllEmployees() {
		ArrayList<UserDTO> userList = null;
		try {
			String sql = "select emp_id as empId , emp_firstname as empFirstName,emp_lastname as empLastName,mobile,email,password,"
					+ "department_id as departmentId , manager_id as managerId ,dateofjoining,role_id as roleId from employees";
			userList = (ArrayList<UserDTO>) jdbcTemplate.query(sql, new Object[] {},
					new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		} catch (Exception e) {
			logger.error(e);
		}
		return userList;
	}

	@Override
	public List<UserDTO> getUserById(String searchParam) {
		searchParam = "%" + searchParam + "%";
		List<UserDTO> list = null;
		try {
			String sql = "select emp_id as empId , emp_firstname as empFirstName,emp_lastname as empLastName,mobile,email,password,"
					+ "department_id as departmentId , manager_id as managerId ,dateofjoining,role_id as roleId from employees where emp_id like (?) "
					+ "or emp_firstname like (?) or emp_lastname like(?) or mobile like (?) or email like (?) or department_id like(?)"
					+ " or manager_id like(?)";
			list = jdbcTemplate.query(sql, new Object[] { searchParam, searchParam, searchParam, searchParam,
					searchParam, searchParam, searchParam }, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}

	@Override
	public int updateEmployee(UserDTO userDTO) {
		logger.info("Accessing of UpdateEmployee Method:-- ");
		try {
			String sql = "update employees set emp_firstname =?, emp_lastname=?,mobile=?, email=?,department_id=?,manager_id=?,dateofjoining=?,role_id=? where emp_id =?";
			i = jdbcTemplate.update(sql,
					new Object[] { userDTO.getEmpFirstName(), userDTO.getEmpLastName(), userDTO.getMobile(),
							userDTO.getEmail(), userDTO.getDepartmentId(), userDTO.getManagerId(),
							userDTO.getDateOfJoining(), userDTO.getRoleId(), userDTO.getEmpId() });
			return i;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
		}
		return i;
	}

	@Override
	public List<UserDTO> getUserByIdForUpdate(int empId) {
		List<UserDTO> lists = null;
		try {
			String sql = "select emp_id as empId , emp_firstname as empFirstName,emp_lastname as empLastName,mobile,email,password,"
					+ "department_id as departmentId , manager_id as managerId ,dateofjoining,role_id as roleId from employees where emp_id = ?";
			lists = jdbcTemplate.query(sql, new Object[] { empId }, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));

		} catch (Exception e) {
			logger.error(e);
		}
		if (CollectionUtils.isEmpty(lists)) {
			return null;
		} else {
			return lists;
		}
	}

	@Override
	public int deleteUser(int empId) {
		try {
			String sql = "delete from employees where emp_id=?";
			i = jdbcTemplate.update(sql, new Object[] { empId });
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
		}
		return i;
	}
}