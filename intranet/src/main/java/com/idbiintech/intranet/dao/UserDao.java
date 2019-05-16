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

			String sql = " select emp_id as empId, emp_firstname as empFirstName,emp_lastname as empLastName,email,password,manager_id,team_id from employees where email=?";
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
			String sql = "select employees.emp_id as empId , emp_firstname as empFirstName,emp_lastname as empLastName,mobile,email,password,"
					+ "department.department_name as departmentName , manager.manager_name as managerName ,dateofjoining,role.role_name as roleName from employees,department,manager,role "
					+ "where employees.manager_id =manager.manager_id and employees.department_id=department.department_id and employees.role_id=role.role_id";
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
					+ "department.department_name as departmentName , manager.manager_name as managerName ,dateofjoining,role.role_name as roleName from employees e,department,manager,role where emp_id like (?) "
					+ "or emp_firstname like (?) or emp_lastname like(?) or mobile like (?) or email like (?) or department.department_name like(?)"
					+ " or manager.manager_name like(?) or role.role_name like (?)";
			list = jdbcTemplate.query(sql, new Object[] { searchParam, searchParam, searchParam, searchParam,
					searchParam, searchParam, searchParam, searchParam },
					new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
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

	@Override
	public UserDTO getUserByAttendance(UserDTO userDTO) {
		List<UserDTO> lists = null;

		try {
			String sql = "select day_name as dayName,day_date as dayDate,check_in as checkIn,check_out as checkOut,status,emp_id as empId from attendance";
			lists = jdbcTemplate.query(sql, new Object[] {}, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(" Attendance list issue " + e);
		}
		if (CollectionUtils.isEmpty(lists)) {
			return null;
		} else {
			return lists.get(0);
		}
	}

	@Override
	public List<UserDTO> getUserByAttendance() {
		List<UserDTO> listss = null;
		try {
			String sql = "select * from attendance";
			listss = jdbcTemplate.query(sql, new Object[] {}, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error Exception " + e);
		}

		return listss;
	}

	@Override
	public UserDTO getUserByAttendance(int empId) {
		List<UserDTO> listst = null;
		try {
			String sql = "select day_name as dayName,day_date as dayDate,check_in as checkIn,check_out as checkOut,status,emp_id as empId from attendance where emp_id =?";
			listst = jdbcTemplate.query(sql, new Object[] { empId }, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Check Exception " + e);
		}
		if (CollectionUtils.isEmpty(listst)) {
			return null;
		} else {
			return listst.get(0);
		} /*
			 * return (UserDTO) listst;
			 */
	}

	@Override
	public List<UserDTO> getTeamList(int emp_id, int manager_id, int team_id) {

		List<UserDTO> teamlist = null;
		logger.info("Entering getTeamList Method in ManagerDao Class:-- ");
		try {
			String sql = "select e.emp_firstname as empFirstName,e.emp_lastname as empLastName,a.day_Name as dayName,a.day_date as dayDate,a.check_in as checkIn,a.check_out as checkOut,a.status ,r.role_name as roleName FROM employees e, team t,attendance a,role r WHERE a.emp_id=e.emp_id and e.role_id=r.role_id and t.team_id=e.team_id and e.emp_id != ? AND e.manager_id !=? and t.team_id=?";
			teamlist = jdbcTemplate.query(sql, new Object[] { emp_id, manager_id, team_id },
					new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Get Team List Issue!!!!!!! " + e);
		}
		if (CollectionUtils.isEmpty(teamlist)) {
			return null;
		} else {
			return teamlist;
		}
	}

	@Override
	public List<UserDTO> getUserByAttendanceEmpId(int empId) {

		List<UserDTO> listst = null;
		try {
			String sql = "select day_name as dayName,day_date as dayDate,check_in as checkIn,check_out as checkOut,status,emp_id as empId from attendance where emp_id =?";
			listst = jdbcTemplate.query(sql, new Object[] { empId }, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Check Exception " + e);
		}
		if (CollectionUtils.isEmpty(listst)) {
			return null;
		} else {
			return listst;
		}

	}
}