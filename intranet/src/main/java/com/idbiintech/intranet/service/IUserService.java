package com.idbiintech.intranet.service;

import com.idbiintech.intranet.dto.UserDTO;

public interface IUserService {

	public UserDTO loginUser(UserDTO userDTO);

	public int saveEmployee(UserDTO userDTO);

}
