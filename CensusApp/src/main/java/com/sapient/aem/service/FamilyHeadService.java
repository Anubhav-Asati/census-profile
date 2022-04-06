package com.sapient.aem.service;

import java.util.List;

import com.sapient.aem.exception.CensusProfileException;
import com.sapient.aem.model.FamilyHead;

public interface FamilyHeadService {
	
	public abstract FamilyHead getFamilyHeadById(Integer familyHeadId) throws CensusProfileException;
	public abstract Integer addFamilyHead(FamilyHead head)  throws CensusProfileException;
	public abstract FamilyHead updateFamilyHead(FamilyHead head) throws CensusProfileException;
    public abstract List<FamilyHead> getAllFamilyHeads() throws CensusProfileException;
    public abstract Integer deleteFamilyHead(Integer familyHeadId) throws CensusProfileException;

}
