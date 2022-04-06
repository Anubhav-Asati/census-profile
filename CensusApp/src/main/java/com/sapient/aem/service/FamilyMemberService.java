package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.exception.CensusProfileException;
import com.sapient.aem.exception.MemberException;
import com.sapient.aem.model.FamilyMember;

public interface FamilyMemberService {
	
	public abstract FamilyMember getFamilyMemberById(Integer familyMemberId) throws CensusProfileException;
	public abstract Integer addFamilyMember(FamilyMember member)  throws CensusProfileException;
	public abstract FamilyMember updateFamilyMember(FamilyMember member) throws CensusProfileException;
    public abstract List<FamilyMember> getAllFamilyMembers() throws  CensusProfileException;
    public abstract Integer deleteFamilyMember(Integer familyMemberId) throws CensusProfileException;
	
	

}
