package com.idbiintech.intranet.dao;

import com.idbiintech.intranet.dto.UserDTO;

public interface IUserDao {


	public int saveEmployee(UserDTO userDTO);

	public UserDTO validUser(String emailId);

	
}
