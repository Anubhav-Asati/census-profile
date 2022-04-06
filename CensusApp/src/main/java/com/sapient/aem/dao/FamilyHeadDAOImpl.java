package com.sapient.aem.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import com.sapient.aem.model.FamilyHead;
import com.sapient.aem.model.Gender;
import com.sapient.aem.model.Suffix;
import com.sapient.aem.util.MySQLConnection;

public class FamilyHeadDAOImpl implements FamilyHeadDAO {
	
	
	

	
	

	private void populateFamilyHead(ResultSet resultSet, FamilyHead familyHead) throws SQLException {
		
		familyHead.setFamilyHeadId(resultSet.getInt("family_head_id"));
		familyHead.setFirstName(resultSet.getString("first_name"));
		familyHead.setLastName(resultSet.getString("last_name"));
		Gender myGender = null;
		if(resultSet.getString("gender").equals("MALE")) {
		myGender = Gender.MALE;
		}else if(resultSet.getString("gender").equals("FEMALE")) {
		myGender = Gender.FEMALE;
		}else {
		myGender = Gender.OTHER;
		}
		familyHead.setGender(myGender);
		Suffix mySuffix = null;
		if(resultSet.getString("suffix").equals("MR")) {
		mySuffix = Suffix.MR;
		}else if(resultSet.getString("suffix").equals("MRS")) {
		mySuffix = Suffix.MRS;
		}else if(resultSet.getString("suffix").equals("DR")) {
		mySuffix = Suffix.DR;
		}else if(resultSet.getString("suffix").equals("MISS")) {
		mySuffix = Suffix.MISS;
		}
		familyHead.setSuffix(mySuffix);
		familyHead.setBirthdate(resultSet.getDate("birthdate").toLocalDate());
		StringBuilder sb=new StringBuilder();
		String[] qualification1=resultSet.getString("qualification").split(",");
		familyHead.setQualification(qualification1);

		familyHead.setProfession(resultSet.getString("profession"));
		String[] hobbies1 = resultSet.getString("hobbies").split(",");
		familyHead.setHobbies(hobbies1);
		familyHead.setAddress(resultSet.getString("address"));
		familyHead.setLocation(resultSet.getString("location"));
		familyHead.setEmail(resultSet.getString("email"));
		familyHead.setMobile(resultSet.getLong("mobile"));
		
	}

	@Override
	public FamilyHead getFamilyHeadById(Integer familyHeadId) throws SQLException {
		
		
		String sql="select * from family_head where family_head_id =?";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, familyHeadId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				FamilyHead familyHead=new FamilyHead();
				populateFamilyHead(resultSet,familyHead);
				return familyHead;
			}
			else {
				throw new SQLException("No rows Found.. Invalid familyHeadId");
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
	public Integer addFamilyHead(FamilyHead head) throws SQLException {
	    
		String sql = "insert into family_head(first_name,last_name,gender,suffix,birthdate,qualification,profession,hobbies,address,location,email,mobile) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, head.getFirstName());
			preparedStatement.setString(2, head.getLastName());
			preparedStatement.setString(3, head.getGender().toString());
			preparedStatement.setString(4, head.getSuffix().toString());
			preparedStatement.setDate(5, java.sql.Date.valueOf(head.getBirthdate()));
			preparedStatement.setString(6, head.getQualification1());
			preparedStatement.setString(7, head.getProfession());
			preparedStatement.setString(8, head.getHobbies1());
			preparedStatement.setString(9, head.getAddress());
			preparedStatement.setString(10, head.getLocation());
			preparedStatement.setString(11, head.getEmail());
			preparedStatement.setString(12, head.getMobile().toString());
			
			int n=preparedStatement.executeUpdate();
			if(n>0) {
				return this.getMaxId();
			}
			else {
				throw new SQLException("Unable to add familyHead..");
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
	public FamilyHead updateFamilyHead(FamilyHead head) throws SQLException {
		
		String sql="update family_head set first_name=?,last_name=?,gender=?,suffix=?,birthdate=?,qualification=?,profession=?,hobbies=?,address=?,location=?,email=?,mobile=? where family_head_id=?)";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, head.getFirstName());
			preparedStatement.setString(2, head.getLastName());
			preparedStatement.setString(3, head.getGender().toString());
			preparedStatement.setString(4, head.getSuffix().toString());
			preparedStatement.setDate(5, java.sql.Date.valueOf(head.getBirthdate()));
			preparedStatement.setString(6, head.getQualification1());
			preparedStatement.setString(7, head.getProfession());
			preparedStatement.setString(8, head.getHobbies1());
			preparedStatement.setString(9, head.getAddress());
			preparedStatement.setString(10, head.getLocation());
			preparedStatement.setString(11, head.getEmail());
			preparedStatement.setString(12, head.getMobile().toString());
			preparedStatement.setInt(13, head.getFamilyHeadId());
			
			
			int n = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				FamilyHead familyHead=new FamilyHead();
				populateFamilyHead(resultSet,familyHead);
				return familyHead;
			}
			else {
				throw new SQLException("No rows Found.. Invalid familyHeadId");
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
	public List<FamilyHead> getAllFamilyHeads() throws SQLException {
		

		String sql="select * from family_head";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();	
			Statement statement= 
					connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

			ResultSet resultSet= statement.executeQuery(sql);
			int rowcount=0;
			if ( resultSet.last()) {
				rowcount =  resultSet.getRow();
				resultSet.beforeFirst(); // not  resultSet.first() because the  resultSet.next() below will move on, missing the first element
			}
			List<FamilyHead> familyList=new ArrayList<>();			
			while(resultSet.next()) {
				FamilyHead familyHead= new FamilyHead();
				populateFamilyHead(resultSet,familyHead);
				familyList.add(familyHead);				
			}

			return familyList;
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
	public Integer deleteFamilyHead(Integer familyHeadId) throws SQLException {
		
		String sql="delete from family_head where family_head_id=?";
		Connection connection=null;
		
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, familyHeadId);
			int n=preparedStatement.executeUpdate();
			if(n>0) {
				return this.getMaxId();
			}
		}
		catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
		return 0;
	}
	private Integer getMaxId() throws SQLException {
		String sql="select max(family_head_id) from family_head";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
			else {
				throw new SQLException("No rows Found..");
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
	public List<FamilyHead> getAllFamilyHeadsByHobbies(String hobbies) throws SQLException {
		
		String sql= "select * from family_head where hobbies = ?";
		Connection connection=null;
		FamilyHead familyHead = new FamilyHead();
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, familyHead.getHobbies1());
			ResultSet resultSet= preparedStatement.executeQuery(sql);
			List<FamilyHead> familyHeadList=new ArrayList<>();
			while(resultSet.next()) {
				populateFamilyHead(resultSet,familyHead);
				familyHeadList.add(familyHead);
			}
			return familyHeadList;



		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	@Override
	public List<FamilyHead> getAllFamilyHeadsByLocation(String location) throws SQLException {
		
		String sql= "select * from family_head where location = ?";
		Connection connection=null;
		FamilyHead familyHead = new FamilyHead();
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, familyHead.getLocation());
			ResultSet resultSet= preparedStatement.executeQuery(sql);
			List<FamilyHead> familyHeadList=new ArrayList<>();
			while(resultSet.next()) {
				populateFamilyHead(resultSet,familyHead);
				familyHeadList.add(familyHead);
			}
			return familyHeadList;



		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	@Override
	public List<FamilyHead> getAllFamilyHeadsByQualification(String qualification) throws SQLException {
		
		String sql= "select * from family_head where qualification = ?";
		Connection connection=null;
		FamilyHead familyHead = new FamilyHead();
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, familyHead.getQualification1());
			ResultSet resultSet= preparedStatement.executeQuery(sql);
			List<FamilyHead> familyHeadList=new ArrayList<>();
			while(resultSet.next()) {
				populateFamilyHead(resultSet,familyHead);
				familyHeadList.add(familyHead);
			}
			return familyHeadList;



		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	@Override
	public List<FamilyHead> getAllFamilyHeadsByGender(String gender) throws SQLException {
		
		String sql= "select * from family_head where gender = ?";
		Connection connection=null;
		FamilyHead familyHead = new FamilyHead();
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, familyHead.getGender().toString());
			ResultSet resultSet= preparedStatement.executeQuery(sql);
			List<FamilyHead> familyHeadList=new ArrayList<>();
			while(resultSet.next()) {
				populateFamilyHead(resultSet,familyHead);
				familyHeadList.add(familyHead);
			}
			return familyHeadList;



		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
		
		
	}
}