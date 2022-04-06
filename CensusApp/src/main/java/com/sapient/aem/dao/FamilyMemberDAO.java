package com.sapient.aem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.sapient.aem.model.FamilyHead;
import com.sapient.aem.model.FamilyMember;
import com.sapient.aem.model.User;

public interface FamilyMemberDAO {
	
	public abstract FamilyMember getFamilyMemberById(Integer familyMemberId) throws SQLException;
	public abstract Integer addFamilyMember(FamilyMember member)  throws SQLException;
	public abstract FamilyMember updateFamilyMember(FamilyMember member) throws SQLException;
    public abstract List<FamilyMember> getAllFamilyMembers() throws SQLException;
    public abstract Integer deleteFamilyMember(Integer familyMemberId) throws SQLException;
    public abstract List<FamilyMember> getAllFamilyMembersByHobbies(String hobbies) throws SQLException;
    public abstract List<FamilyMember> getAllFamilyMemberByLocation(String location) throws SQLException;
    public abstract List<FamilyMember> getAllFamilyMemberByQualification(String qualification) throws SQLException;
    public abstract List<FamilyMember> getAllFamilyMemberByGender(String gender) throws SQLException;
    
    

}
