package com.idbiintech.intranet.service;

import java.util.List;
import com.idbiintech.intranet.dto.UserDTO;

public interface IUserService {

	public int authentication(UserDTO userDTO);

	public List<UserDTO> loginUser(UserDTO userDTO);
}
