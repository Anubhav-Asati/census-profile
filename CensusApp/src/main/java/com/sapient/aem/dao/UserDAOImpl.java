package com.sapient.aem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;
import com.sapient.aem.util.MySQLConnection;

public class UserDAOImpl implements UserDAO {

	@Override
	public User getUserById(Integer userId) throws SQLException {
		
		String sql="select * from user where userId=?";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				User user=new User();
				populateUser(resultSet,user);
				return user;
			}
			else {
				throw new SQLException("No rows Found.. Invalid userId");
			}
		}
		catch(SQLException e) {
			//			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}
		
	private void populateUser(ResultSet resultSet, User user) throws SQLException {
		
		user.setUserId(resultSet.getInt("userId"));
		user.setUserName(resultSet.getString("userName"));
		user.setPassword(resultSet.getString("password"));
		
		
		
	}

	@Override
	public List<User> getUser() throws SQLException {
		String sql="select * from user";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			Statement statement= 
					connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

			
			ResultSet resultSet=statement.executeQuery(sql);
			int rowCount=0;
			if(resultSet.last()) {
				rowCount = resultSet.getRow();
				resultSet.beforeFirst();
			}
			List<User> userList=new ArrayList<>();
			int i=0;
			while(resultSet.next()) {
				User user=new User();
				populateUser(resultSet,user);
				userList.add(user);
				
			}
			return userList;
		}
		catch(SQLException e) {
			//			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}
		
		
		

	@Override
	public String addUser(User user) throws SQLException {
		
		String sql="insert into user(userName,password,role) values(?,?,?)";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getRole().toString());
			
			int n = preparedStatement.executeUpdate();
			if(n>0) {
				return "Added User to database";
			}
			else {
				return "Unable to add User to database";
			}
		}
		catch(SQLException e) {
			//			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}
		

	@Override
	public String updateUser(User user) throws SQLException {
		
		String sql="update user set name=?, password=?,role=? where userId=?";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getRole().toString());
			
			int n = preparedStatement.executeUpdate();
			if(n>0) {
				return "userId: "+ user.getUserId()+" updated";
			}else {
				return "Unable to update userId: "+ user.getUserId();
			}
		}
		catch(SQLException e) {
			//			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}
		


	@Override
	public Boolean isValidUser(String userName, String password, Role role) throws SQLException {
		
		String sql="select * from registered_users where username=? and password=? and role=?";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, role.toString());
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else {
				return false;
			}
		}
		catch(SQLException e) {
			//			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}
}
		
