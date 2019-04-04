package com.idbiintech.intranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.intranet.dao.IUserDao;
import com.idbiintech.intranet.dto.UserDTO;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public int authentication(UserDTO userDTO) {
		return userDao.authentication(userDTO);
	}

	@Override
	public List<UserDTO> loginUser(UserDTO userDTO) {

		return userDao.loginUser(userDTO);
				
	}

}
