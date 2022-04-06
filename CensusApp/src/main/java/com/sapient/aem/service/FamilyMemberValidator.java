package com.sapient.aem.service;

import java.time.LocalDate;

import com.sapient.aem.model.FamilyHead;
import com.sapient.aem.model.FamilyMember;

public class FamilyMemberValidator {

	public Boolean isValidName(FamilyMember familyMember) {
		String pattern= "^[a-zA-Z\\s.]+$";
		if(familyMember.getFirstName().matches(pattern)) {
			return true;
		}
		return false;
	}

	public Boolean isValidGender(FamilyMember familyMember) {
		String myGender = familyMember.getGender().toString();
		if(myGender.equals("male")||myGender.equals("female")||myGender.equals("others")) {
			return true;
		}
		return false;
	}

	FamilyHead familyHead;
	public Boolean isValidBirthdate(FamilyMember familyMember ,FamilyHead familyHead) {
		if(familyMember.getBirthdate().isBefore(LocalDate.now())&&
				familyHead.getBirthdate().isBefore(familyMember.getBirthdate())) {
			return true;
		}
		return false;
	}

	public Boolean isValidRelation(FamilyMember familyMember) {
		String myRelation = familyMember.getRelation().toString();
		if(myRelation.equals("father")||myRelation.equals("mother")||myRelation.equals("husband")||myRelation.equals("wife")||myRelation.equals("son")||myRelation.equals("daughter")) {
			return true;
		}
		return false;
	}

	public Boolean isValidMember(FamilyMember familyMember) {
		if(isValidName(familyMember)&&isValidGender(familyMember)&&isValidBirthdate(familyMember,familyHead)&&isValidRelation(familyMember)) {
			return true;
		}
		return false;
	}

}


