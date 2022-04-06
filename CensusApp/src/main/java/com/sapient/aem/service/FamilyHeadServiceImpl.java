package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.dao.FamilyHeadDAO;
import com.sapient.aem.dao.FamilyHeadDAOImpl;
import com.sapient.aem.exception.CensusProfileException;
import com.sapient.aem.model.FamilyHead;

public class FamilyHeadServiceImpl implements FamilyHeadService {
	
	private FamilyHeadDAO familyHeadDao=new FamilyHeadDAOImpl();

	@Override
	public FamilyHead getFamilyHeadById(Integer familyHeadId) throws CensusProfileException {
		
		try {
			FamilyHead familyHead=familyHeadDao.getFamilyHeadById(familyHeadId);
			return familyHead;
		}
		catch(SQLException e) {
			throw new CensusProfileException(e.getMessage(),e);
			
		}
	}

	@Override
	public Integer addFamilyHead(FamilyHead head) throws CensusProfileException {
		
		try {
			return familyHeadDao.addFamilyHead(head);
			
		}catch(SQLException e) {
			throw new CensusProfileException(e.getMessage(),e);
			
		}

	}

	@Override
	public FamilyHead updateFamilyHead(FamilyHead head) throws CensusProfileException {
		try {
			return familyHeadDao.updateFamilyHead(head);
			
		}catch(SQLException e) {
			throw new CensusProfileException(e.getMessage(),e);
			
		}
	}

	@Override
	public List<FamilyHead> getAllFamilyHeads() throws CensusProfileException {
		
		try {
			List<FamilyHead> familyHeadList=familyHeadDao.getAllFamilyHeads();
			return familyHeadList;
		}
		catch(SQLException e) {
			throw new CensusProfileException(e.getMessage(),e);
			
		}
	}

	@Override
	public Integer deleteFamilyHead(Integer familyHeadId) throws CensusProfileException {
		
		try {
			Integer familyHead=familyHeadDao.deleteFamilyHead(familyHeadId);
			return familyHead;
		}
		catch(SQLException e) {
			throw new CensusProfileException(e.getMessage(),e);
			
		}
		
	}

}