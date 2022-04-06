package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.dao.UserDAO;
import com.sapient.aem.dao.UserDAOImpl;
import com.sapient.aem.exception.UserException;
import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO=new UserDAOImpl();

	@Override
	public User getUserById(Integer userId) throws UserException {
		
		try {
			User user=userDAO.getUserById(userId);
			return user;
		}
		catch(SQLException e) {
			throw new UserException(e.getMessage(),e);
		}
	}

	@Override
	public List<User> getUser() throws UserException {
		
		try {
			List<User> userList=userDAO.getUser();
			return userList;
		}
		catch(SQLException e) {
			throw new UserException(e.getMessage(),e);
		}
	}

	@Override
	public String addUser(User user) throws UserException {
		
		try {
			String res=userDAO.addUser(user);
			return res;
		}
		catch(SQLException e) {
			throw new UserException(e.getMessage(),e);
		}
		
	}

	@Override
	public String updateUser(User user) throws UserException {
		
		try {
			String res=userDAO.updateUser(user);
			return res;
		}
		catch(SQLException e) {
			throw new UserException(e.getMessage(),e);
		}
	}

	@Override
	public Boolean isValidUser(String userName, String password, Role role) throws UserException {
		
		try {
			return userDAO.isValidUser(userName, password, role);
		}catch(Exception e){
			throw new UserException(e.getMessage(),e);
		} 
	}
}
