package com.sapient.aem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.model.Person;

public interface CensusSearchDAO {
	
	public abstract List<Person> searchByQualification(String qualification) throws SQLException;
	public abstract List<Person> searchByHobby(String hobby) throws SQLException;
	public abstract List<Person> searchByGender(String gender) throws SQLException;
	public abstract List<Person> searchByLocation(String location) throws SQLException;

}
