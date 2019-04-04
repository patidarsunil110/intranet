package com.idbiintech.intranet.dao;


import java.util.List;

import com.idbiintech.intranet.dto.UserDTO;

public interface IUserDao {

	public int authentication(UserDTO userDTO);

	public List<UserDTO> loginUser(UserDTO userDTO);

}
