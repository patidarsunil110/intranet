package com.idbiintech.intranet.dao;


import com.idbiintech.intranet.dto.UserDTO;

public interface IUserDao {

	public int authentication(UserDTO userDTO);

}
