package com.idbiintech.intranet.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.idbiintech.intranet.dto.EmployeeDTO;

@Repository
public class AttendanceDao implements IAttendanceDao {

	private static final Logger logger = LogManager.getLogger(AttendanceDao.class);
	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	static int i = 0;

	@Override
	public EmployeeDTO getUserByAttendance(int empId) {
		List<EmployeeDTO> listst = null;
		try {
			String sql = "select day_name as dayName,day_date as dayDate,check_in as checkIn,"
					+ "check_out as checkOut,status,emp_id as empId,total_hours as totalHours from todayattendance where emp_id =?";
			listst = jdbcTemplate.query(sql, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class));
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
			String sql = "select e.emp_firstname as empFirstName,e.emp_lastname as empLastName,a.day_Name as dayName,a.day_date as dayDate,a.check_in as checkIn,a.check_out as checkOut,a.status ,r.role_name as roleName FROM employees e, team t,todayattendance a,role r WHERE a.emp_id=e.emp_id and e.role_id=r.role_id and t.team_id=e.team_id and e.emp_id != ? AND e.manager_id !=? and t.team_id=?";
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
			String sql = "select day_name as dayName,day_date as dayDate,check_in as checkIn,check_out as checkOut,status,emp_id as empId,total_hours as totalHours from todayattendance where emp_id =?";
			listst = jdbcTemplate.query(sql, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class));
						callStoreFunction();

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

	public boolean callStoreFunction() {
		try {
			
			System.out.println("Test for stored procedure ");
		/*	Integer count= jdbcTemplate.query(attendance_sp, new Object[] { empId },
					new BeanPropertyRowMapper<EmployeeDTO>(EmployeeDTO.class));
		*/	
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;

	}

}
