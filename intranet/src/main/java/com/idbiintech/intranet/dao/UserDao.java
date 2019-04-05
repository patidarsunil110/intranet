package com.idbiintech.intranet.dao;

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
	UserDTO userDTO;
	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	int i = 0;

	@Override
	public int saveEmployee(UserDTO userDTO) {
		logger.info("Entering to authentication() in UserDAO Class :: ");
		try {

			String sqls = "insert into employees(empname,emplastname,mobile,manager,email,password,department,"
					+ "dateofjoining,designation) values (?,?,?,?,?,?,?,?,?)";
			i = jdbcTemplate.update(sqls,
					new Object[] { userDTO.getEmpName(), userDTO.getEmpLastName(), userDTO.getMobile(),
							userDTO.getManager(), userDTO.getEmailId(), userDTO.getPassword(), userDTO.getDepartment(),
							userDTO.getDateOfJoining(), userDTO.getDesignation() });
			return i;
		} catch (Exception e) {
			System.out.println(e.getMessage());

			return i;
		}
	}

	@Override
	public UserDTO validUser(String emailId) {
		
		logger.info("Entering to loginUser() in UserDAO Class :: ");
				try {

			String sql = " select email,password from employees where email=?";
			UserDTO lists = jdbcTemplate.queryForObject(sql, new Object[] {emailId},
					new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
			return lists;
		} catch (Exception e) {
			logger.error(e);

		}
				return null;
				
		
	}

	
}