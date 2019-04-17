package com.idbiintech.intranet.dao;

import java.util.ArrayList;

import com.idbiintech.intranet.dto.UserDTO;

public interface IUserDao {

	public int saveEmployee(UserDTO userDTO);

	public UserDTO validUser(String emailId);

	public ArrayList<UserDTO> getAllEmployees();

}
