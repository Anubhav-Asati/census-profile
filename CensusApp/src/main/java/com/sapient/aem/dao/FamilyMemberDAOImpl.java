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

import com.sapient.aem.exception.MemberException;
import com.sapient.aem.model.FamilyHead;
import com.sapient.aem.model.FamilyMember;
import com.sapient.aem.model.Gender;
import com.sapient.aem.model.Relation;
import com.sapient.aem.model.Suffix;
import com.sapient.aem.util.MySQLConnection;

public class FamilyMemberDAOImpl implements FamilyMemberDAO {

	
	
	
	@Override
	public FamilyMember getFamilyMemberById(Integer familyMemberId) throws SQLException {
		
		String sql="select * from family_member where family_member_id =?";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, familyMemberId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				FamilyMember familyMember=new FamilyMember();
				populateFamilyMember(resultSet,familyMember);
				return familyMember;
			}
			else {
				throw new SQLException("No rows Found.. Invalid familyMemberId");
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
		
	    private void populateFamilyMember(ResultSet resultSet, FamilyMember familyMember) throws SQLException {
	
	    	
	    	familyMember.setFamilyMemberId(resultSet.getInt("family_member_id"));
	    	familyMember.setFirstName(resultSet.getString("first_name"));
	    	familyMember.setLastName(resultSet.getString("last_name"));
	    	Gender myGender = null;
	    	if(resultSet.getString("gender").equals("MALE")) {
	    		myGender = Gender.MALE;
	    	}else if(resultSet.getString("gender").equals("FEMALE")) {
	    		myGender = Gender.FEMALE;
	    	}else {
	    		myGender = Gender.OTHER;
	    	}
	    	familyMember.setGender(myGender);

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
	    	familyMember.setSuffix(mySuffix);
	    	familyMember.setBirthdate(resultSet.getDate("birthdate").toLocalDate());
	    	String[] qualification1 = resultSet.getString("qualification").split(",");
	    	familyMember.setQualification(qualification1);
	    	familyMember.setProfession(resultSet.getString("profession"));
	    	String[] hobbies1 = resultSet.getString("hobbies").split(",");
	    	familyMember.setHobbies(hobbies1);

	    	String myRelation = resultSet.getString("relation");
	    	Relation relation=null;
	    	if(myRelation.equals("DAUGHTER")) {
	    		relation=Relation.DAUGHTER;
	    	}else if(myRelation.equals("SON")) {
	    		relation=Relation.SON;
	    	}else if(myRelation.equals("WIFE")) {
	    		relation=Relation.WIFE;
	    	}
	    	familyMember.setRelation(relation);

	    	familyMember.setAddress(resultSet.getString("address"));
	    	familyMember.setLocation(resultSet.getString("location"));
	    	familyMember.setEmail(resultSet.getString("email"));
	    	familyMember.setMobile(resultSet.getLong("mobile"));
	    	familyMember.setFamilyHeadId(resultSet.getInt("family_Head_id"));



	    }

	@Override
	public Integer addFamilyMember(FamilyMember member) throws SQLException {
		
		//String sql= "insert into family_member(first_name,last_name,gender,suffix,birthdate,qualification,profession,hobbies,relation,address,location,email,mobile,family_head_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql= "insert into family_member(first_name,last_name,gender,suffix,birthdate,qualification,profession,hobbies,address,location,email,mobile,relation,family_head_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);



			preparedStatement.setString(1, member.getFirstName());
			preparedStatement.setString(2, member.getLastName());
			preparedStatement.setString(3, member.getGender().toString());
			preparedStatement.setString(4, member.getSuffix().toString());
			preparedStatement.setDate(5, java.sql.Date.valueOf(member.getBirthdate()));
			preparedStatement.setString(6, member.getQualification1().toString());
			preparedStatement.setString(7, member.getProfession());
			preparedStatement.setString(8, member.getHobbies1().toString());
			preparedStatement.setString(9, member.getRelation().toString());
			preparedStatement.setString(10, member.getAddress());
			preparedStatement.setString(11, member.getLocation());
			preparedStatement.setString(12, member.getEmail());
			preparedStatement.setString(13, member.getMobile().toString());
			preparedStatement.setInt(14, member.getFamilyHeadId());
			int n= preparedStatement.executeUpdate();
			if(n>0) {
				return this.getMaxId();
			}else {
				throw new SQLException();
			}



		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	private Integer getMaxId() throws SQLException {
		
		String sql="select max(family_member_id) from family_member";
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
	public FamilyMember updateFamilyMember(FamilyMember member) throws SQLException {
		
		String sql="update family_member set first_name=?,last_name=?,gender=?,suffix=?,birthdate=?,qualification=?,profession=?,hobbies=?,relation=?,address=?,location=?,email=?,mobile=?,family_head_id=? where family_member_id=?";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, member.getFirstName());
			preparedStatement.setString(2, member.getLastName());
			preparedStatement.setString(3, member.getGender().toString());
			preparedStatement.setString(4, member.getSuffix().toString());
			preparedStatement.setString(5, member.getBirthdate().toString());
			preparedStatement.setString(6, member.getQualification1().toString());
			preparedStatement.setString(7, member.getProfession());
			preparedStatement.setString(8, member.getHobbies1().toString());
			preparedStatement.setString(9, member.getRelation().toString());
			preparedStatement.setString(10, member.getAddress());
			preparedStatement.setString(11, member.getLocation());
			preparedStatement.setString(12, member.getEmail());
			preparedStatement.setString(13, member.getMobile().toString());
			preparedStatement.setInt(14, member.getFamilyHeadId());
			int n=preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				FamilyMember familyMember=new FamilyMember();
				populateFamilyMember(resultSet,familyMember);
				return familyMember;
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
	public List<FamilyMember> getAllFamilyMembers() throws SQLException {
		
		String sql="select * from family_member";
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
			List<FamilyMember> familyList=new ArrayList<>();			
			while(resultSet.next()) {
				FamilyMember familyMember= new FamilyMember();
				populateFamilyMember(resultSet,familyMember);
				familyList.add(familyMember);				
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
	public Integer deleteFamilyMember(Integer familyMemberId) throws SQLException {
		String sql="delete from family_member where family_member_id=?";
		Connection connection=null;
		
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, familyMemberId);
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

	@Override
	public List<FamilyMember> getAllFamilyMembersByHobbies(String hobbies) throws SQLException {
		
		String sql= "select * from family_member where hobbies = ?";
		Connection connection=null;
		FamilyMember familyMember = new FamilyMember();
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/census_serverDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, familyMember.getHobbies1() );
			ResultSet resultSet= preparedStatement.executeQuery(sql);
			List<FamilyMember> familyMemberList=new ArrayList<>();
			while(resultSet.next()) {
				populateFamilyMember(resultSet,familyMember);
				familyMemberList.add(familyMember);
			}
			return familyMemberList;



		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	@Override
	public List<FamilyMember> getAllFamilyMemberByLocation(String location) throws SQLException {
		
		String sql= "select * from family_member where location = ?";
		Connection connection=null;
		FamilyMember familyMember = new FamilyMember();
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, familyMember.getLocation());
			ResultSet resultSet= preparedStatement.executeQuery(sql);
			List<FamilyMember> familyMemberList=new ArrayList<>();
			while(resultSet.next()) {
				populateFamilyMember(resultSet,familyMember);
				familyMemberList.add(familyMember);
			}
			return familyMemberList;



		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	@Override
	public List<FamilyMember> getAllFamilyMemberByQualification(String qualification) throws SQLException {
		
		String sql= "select * from family_member where qualification = ?";
		Connection connection=null;
		FamilyMember familyMember = new FamilyMember();
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, familyMember.getQualification1());
			ResultSet resultSet= preparedStatement.executeQuery(sql);
			List<FamilyMember> familyMemberList=new ArrayList<>();
			while(resultSet.next()) {
				populateFamilyMember(resultSet,familyMember);
				familyMemberList.add(familyMember);
			}
			return familyMemberList;



		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
		
		
	}

	@Override
	public List<FamilyMember> getAllFamilyMemberByGender(String gender) throws SQLException {
		
		String sql= "select * from family_member where gender = ?";
		Connection connection=null;
		FamilyMember familyMember = new FamilyMember();
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/censusDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, familyMember.getGender().toString());
			ResultSet resultSet= preparedStatement.executeQuery(sql);
			List<FamilyMember> familyMemberList=new ArrayList<>();
			while(resultSet.next()) {
				populateFamilyMember(resultSet,familyMember);
				familyMemberList.add(familyMember);
			}
			return familyMemberList;



		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
		
		
	}
}