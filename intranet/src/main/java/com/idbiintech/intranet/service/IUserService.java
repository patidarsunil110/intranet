package com.idbiintech.intranet.service;

import java.util.List;

import com.idbiintech.intranet.dto.UserDTO;

public interface IUserService {

	public UserDTO loginUser(UserDTO userDTO);

	public int saveEmployee(UserDTO userDTO);

	public List<UserDTO> getAllEmployees();

}
