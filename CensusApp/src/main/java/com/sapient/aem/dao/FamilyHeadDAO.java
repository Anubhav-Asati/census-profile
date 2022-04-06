package com.sapient.aem.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.sapient.aem.model.FamilyHead;

public interface FamilyHeadDAO {
	
	public abstract FamilyHead getFamilyHeadById(Integer familyHeadId) throws SQLException;
	public abstract Integer addFamilyHead(FamilyHead head)  throws SQLException;
	public abstract FamilyHead updateFamilyHead(FamilyHead head) throws SQLException;
    public abstract List<FamilyHead> getAllFamilyHeads() throws SQLException;
    public abstract Integer deleteFamilyHead(Integer familyHeadId) throws SQLException;
    public abstract List<FamilyHead> getAllFamilyHeadsByHobbies(String hobbies) throws SQLException;
    public abstract List<FamilyHead> getAllFamilyHeadsByLocation(String location) throws SQLException;
    public abstract List<FamilyHead> getAllFamilyHeadsByQualification(String qualification) throws SQLException;
    public abstract List<FamilyHead> getAllFamilyHeadsByGender(String gender) throws SQLException;
    
	
	
	
	

}
