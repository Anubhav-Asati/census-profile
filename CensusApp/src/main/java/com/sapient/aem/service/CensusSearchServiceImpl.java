package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sapient.aem.dao.FamilyHeadDAO;
import com.sapient.aem.dao.FamilyHeadDAOImpl;
import com.sapient.aem.dao.FamilyMemberDAO;
import com.sapient.aem.dao.FamilyMemberDAOImpl;
import com.sapient.aem.exception.CensusProfileException;
import com.sapient.aem.model.FamilyHead;
import com.sapient.aem.model.FamilyMember;
import com.sapient.aem.model.Person;

public class CensusSearchServiceImpl implements CensusSearchService {
	
	private FamilyHeadDAO familyHeadDAO=new FamilyHeadDAOImpl();
	private FamilyMemberDAO familyMemberDAO=new FamilyMemberDAOImpl();

	@Override
	public List<Person> searchByQualification(String qualification) throws CensusProfileException {
		
		try {
			List<Person> personList = new ArrayList<>();
			List<FamilyHead> familyHeadList=familyHeadDAO.getAllFamilyHeadsByQualification(qualification);
			List<FamilyMember> familyMemberList = familyMemberDAO.getAllFamilyMemberByQualification(qualification);
			Iterator<FamilyHead> iterator = familyHeadList.iterator();
			while(iterator.hasNext()) {
				FamilyHead familyHead=iterator.next();
				Person person=new Person();
				populatePersonFromPersonHead(familyHead,person);
				personList.add(person);
				
			}
			Iterator<FamilyMember> iterator1 = familyMemberList.iterator();
			while(iterator1.hasNext()) {
				FamilyMember familyMember=iterator1.next();
				Person person=new Person();
				populatePersonFromPersonMember(familyMember,person);
				personList.add(person);
			}
			return personList;
			
			
		}catch(SQLException e) {
			throw new CensusProfileException(e.getMessage(),e);
		}
	}

		 

	private void populatePersonFromPersonMember(FamilyMember familyMember, Person person) {
		// TODO Auto-generated method stub
		
	}



	private void populatePersonFromPersonHead(FamilyHead familyHead, Person person) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<Person> searchByHobby(String hobby) throws CensusProfileException {
		
		return null;
		
	}

	@Override
	public List<Person> searchByGender(String gender) throws CensusProfileException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> searchByLocation(String location) throws CensusProfileException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
