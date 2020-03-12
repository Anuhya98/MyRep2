package com.cts.training.userservice;

import java.util.List;



public interface UserService {
//	public UserDTO insert(UserDTO ud);
//	public void delete(int id);
//	public UserDTO update(UserDTO ud);
//	public UserDTO getUserById(int id);
//	public List<UserDTO> getAllUsers();
	
	public UserDTO insert(UserDTO ud);
	public void delete(int id);
	public UserDTO update(UserDTO ud);
	public UserDTO getUserById(int id);
	public List<UserDTO> getAllUsers();
	public UserDTO getUserByUsernameAndPassword(String username, String password);
}
