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

import com.idbiintech.intranet.dao.IEmployeeDao;
import com.idbiintech.intranet.dto.EmployeeDTO;

@Repository
public class EmployeeDao implements IEmployeeDao {

	private static final Logger logger = LogManager.getLogger(EmployeeDao.class);
	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	static int i = 0;

	@Override
	public int saveEmployee(EmployeeDTO userDTO) {
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
	public EmployeeDTO validUser(String email) {
		List<EmployeeDTO> lists = null;
		logger.info("Entering to loginUser() in UserDAO Class :: ");
		try {

			String sql = " select emp_id as empId, emp_firstname as empFirstName,emp_lastname as empLastName,email,password,manager_id,"
					+ "team_id,r.role_name as roleName,desgn_id as desgnId from employees e left join role r on e.role_id=r.role_id where email=?";
			lists = jdbcTemplate.query(sql, new Object[] { email }, new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class));
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
	public ArrayList<EmployeeDTO> getAllEmployees() {
		ArrayList<EmployeeDTO> userList = null;
		try {
			String sql = "select employees.emp_id as empId , emp_firstname as empFirstName,emp_lastname as empLastName,mobile,email,password,"
					+ "department.department_name as departmentName , manager.manager_name as managerName ,dateofjoining,role.role_name as roleName from employees,department,manager,role "
					+ "where employees.manager_id =manager.manager_id and employees.department_id=department.department_id and employees.role_id=role.role_id";
			userList = (ArrayList<EmployeeDTO>) jdbcTemplate.query(sql, new Object[] {},
					new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class));
		} catch (Exception e) {
			logger.error(e);
		}
		return userList;
	}

	@Override
	public List<EmployeeDTO> getUserById(String searchParam) {
		searchParam = "%" + searchParam + "%";
		List<EmployeeDTO> list = null;
		try {
			String sql = "select emp_id as empId , emp_firstname as empFirstName,emp_lastname as empLastName,mobile,email,password,"
					+ "department.department_name as departmentName , manager.manager_name as managerName ,dateofjoining,role.role_name as roleName from employees e,department,manager,role where emp_id like (?) "
					+ "or emp_firstname like (?) or emp_lastname like(?) or mobile like (?) or email like (?) or department.department_name like(?)"
					+ " or manager.manager_name like(?) or role.role_name like (?)";
			list = jdbcTemplate.query(sql, new Object[] { searchParam, searchParam, searchParam, searchParam,
					searchParam, searchParam, searchParam, searchParam },
					new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class));
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}

	@Override
	public int updateEmployee(EmployeeDTO userDTO) {
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
	public List<EmployeeDTO> getUserByIdForUpdate(int empId) {
		List<EmployeeDTO> lists = null;
		try {
			String sql = "select emp_id as empId , emp_firstname as empFirstName,emp_lastname as empLastName,mobile,email,password,"
					+ "department_id as departmentId , manager_id as managerId ,dateofjoining,role_id as roleId from employees where emp_id = ?";
			lists = jdbcTemplate.query(sql, new Object[] { empId }, new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class));

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
	public EmployeeDTO getUserByAttendance(EmployeeDTO userDTO) {
		List<EmployeeDTO> lists = null;

		try {
			String sql = "select day_name as dayName,day_date as dayDate,check_in as checkIn,check_out as checkOut,status,emp_id as empId from attendance";
			lists = jdbcTemplate.query(sql, new Object[] {}, new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class));
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
	public List<EmployeeDTO> getUserByAttendance() {
		List<EmployeeDTO> listss = null;
		try {
			String sql = "select * from attendance";
			listss = jdbcTemplate.query(sql, new Object[] {}, new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class));
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error Exception " + e);
		}

		return listss;
	}

	@Override
	public EmployeeDTO getUserByAttendance(int empId) {
		List<EmployeeDTO> listst = null;
		try {
			String sql = "select day_name as dayName,day_date as dayDate,check_in as checkIn,"
					+ "check_out as checkOut,status,emp_id as empId,total_hours as totalHours from attendance where emp_id =?";
			listst = jdbcTemplate.query(sql, new Object[] { empId }, new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class));
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
	public List<EmployeeDTO> getTeamList(int emp_id, int manager_id, int team_id) {

		List<EmployeeDTO> teamlist = null;
		logger.info("Entering getTeamList Method in ManagerDao Class:-- ");
		try {
			String sql = "select e.emp_firstname as empFirstName,e.emp_lastname as empLastName,a.day_Name as dayName,a.day_date as dayDate,a.check_in as checkIn,a.check_out as checkOut,a.status ,r.role_name as roleName FROM employees e, team t,attendance a,role r WHERE a.emp_id=e.emp_id and e.role_id=r.role_id and t.team_id=e.team_id and e.emp_id != ? AND e.manager_id !=? and t.team_id=?";
			teamlist = jdbcTemplate.query(sql, new Object[] { emp_id, manager_id, team_id },
					new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class));
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
	public List<EmployeeDTO> getUserByAttendanceEmpId(int empId) {

		List<EmployeeDTO> listst = null;
		try {
			String sql = "select day_name as dayName,day_date as dayDate,check_in as checkIn,check_out as checkOut,status,emp_id as empId,total_hours as totalHours from attendance where emp_id =?";
			listst = jdbcTemplate.query(sql, new Object[] { empId }, new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class));
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