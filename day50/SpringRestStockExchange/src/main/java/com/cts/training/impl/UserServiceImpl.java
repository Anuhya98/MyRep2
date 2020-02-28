package com.cts.training.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.training.dto.UserDTO;
import com.cts.training.model.User;
import com.cts.training.repo.UserRepo;
import com.cts.training.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo ur;
	
	@Override
	public UserDTO insert(UserDTO ud) {
		User user=new User();
		BeanUtils.copyProperties(ud, user);
		ur.save(user);
		return ud;
	}
	

}
