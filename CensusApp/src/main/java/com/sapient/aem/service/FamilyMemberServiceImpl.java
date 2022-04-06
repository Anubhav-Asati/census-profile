package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.sapient.aem.dao.FamilyMemberDAO;
import com.sapient.aem.dao.FamilyMemberDAOImpl;
import com.sapient.aem.exception.CensusProfileException;
import com.sapient.aem.exception.MemberException;
import com.sapient.aem.model.FamilyMember;

public class FamilyMemberServiceImpl implements FamilyMemberService {
	
	private FamilyMemberDAO familyMemberDao= new FamilyMemberDAOImpl();

	@Override
	public FamilyMember getFamilyMemberById(Integer familyMemberId) throws CensusProfileException {
		
		try {
			FamilyMember familyMember=familyMemberDao.getFamilyMemberById(familyMemberId);
			return familyMember;
			
		}
		catch(SQLException e) {
			throw new CensusProfileException(e.getMessage(),e);
			
		}
	}

	@Override
	public Integer addFamilyMember(FamilyMember member) throws CensusProfileException {
		
		try {
			return familyMemberDao.addFamilyMember(member);
		}
		catch(SQLException e) {
			throw new CensusProfileException(e.getMessage(),e);
			
		}
	}

	@Override
	public FamilyMember updateFamilyMember(FamilyMember member) throws CensusProfileException {
		
		try {
			return familyMemberDao.updateFamilyMember(member);
		}
		catch(SQLException e) {
			throw new CensusProfileException(e.getMessage(),e);
			
		}
	}

	@Override
	public List<FamilyMember> getAllFamilyMembers() throws CensusProfileException {
		
		try {
			List<FamilyMember> familyMemberList=familyMemberDao.getAllFamilyMembers();
			return familyMemberList;
		}
		catch(SQLException e) {
			throw new CensusProfileException(e.getMessage(),e);
			
		}
	}

	@Override
	public Integer deleteFamilyMember(Integer familyMemberId) throws CensusProfileException {
		
		try {
			return familyMemberDao.deleteFamilyMember(familyMemberId);
		}
		catch(SQLException e) {
			throw new CensusProfileException(e.getMessage(),e);
			
		}
	}
}
	