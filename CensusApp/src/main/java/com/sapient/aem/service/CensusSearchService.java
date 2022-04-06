package com.sapient.aem.service;

import java.util.List;

import com.sapient.aem.exception.CensusProfileException;
import com.sapient.aem.model.Person;

public interface CensusSearchService {
	
	public abstract List<Person> searchByQualification(String qualification) throws CensusProfileException;
	public abstract List<Person> searchByHobby(String hobby) throws CensusProfileException;
	public abstract List<Person> searchByGender(String gender) throws CensusProfileException;
	public abstract List<Person> searchByLocation(String location) throws CensusProfileException;

}
