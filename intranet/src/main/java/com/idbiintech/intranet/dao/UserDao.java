package com.idbiintech.intranet.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.idbiintech.intranet.dao.IUserDao;
import com.idbiintech.intranet.dto.UserDTO;

@Repository
public class UserDao implements IUserDao {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	int i = 0;

	@Override
	public int authentication(UserDTO userDTO) {
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

}
