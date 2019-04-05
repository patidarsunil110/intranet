package com.idbiintech.intranet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.intranet.dao.IUserDao;
import com.idbiintech.intranet.dto.UserDTO;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public int saveEmployee(UserDTO userDTO) {
		return userDao.saveEmployee(userDTO);
	}

	@Override
	public boolean loginUser(UserDTO userDTO) {
		UserDTO validUser=userDao.validUser(userDTO.getEmailId());
		if(validUser!=null) {
			if((validUser.getPassword()).equals(userDTO.getPassword())) {
				return true;
			}
		}
		return false;
				
	}

}
