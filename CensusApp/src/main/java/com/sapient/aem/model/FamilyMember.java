package com.sapient.aem.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;



public class FamilyMember implements Serializable {
	private Integer familyMemberId;
	private String firstName;
	private String lastName ;
	private Gender gender;
	private Suffix suffix;
	private LocalDate birthdate;
	private String[] qualification;
	private String profession;
	private String[] hobbies;
	private Relation relation;
	private String address;
	private String location;
	private String email;
	private Long mobile;
	private Integer familyHeadId;
	
	public FamilyMember() {
		
	}
	
	public FamilyMember(String firstName, String lastName, Gender gender, Suffix suffix,
			LocalDate birthdate, String[] qualification, String profession, String[] hobbies,Relation relation,String address,String location,String email,Long mobile,
			Integer familyHeadId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.suffix = suffix;
		this.birthdate = birthdate;
		this.qualification = qualification;
		this.profession = profession;
		this.hobbies = hobbies;
		this.relation = relation;
		this.address = address;
		this.location = location;
		this.email = email;
		this.mobile = mobile;
		this.familyHeadId = familyHeadId;
	}

	public FamilyMember(Integer familyMemberId, String firstName, String lastName, Gender gender, Suffix suffix,
			LocalDate birthdate, String[] qualification, String profession, String[] hobbies,Relation relation,String address,String location,String email,Long mobile, 
			Integer familyHeadId) {
		super();
		this.familyMemberId = familyMemberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.suffix = suffix;
		this.birthdate = birthdate;
		this.qualification = qualification;
		this.profession = profession;
		this.hobbies = hobbies;
		this.relation = relation;
		this.address = address;
		this.location = location;
		this.email = email;
		this.mobile = mobile;
		this.familyHeadId = familyHeadId;
	}

	public FamilyMember(String firstName2, String lastName2, Gender gender2, Suffix suffix2, LocalDate birthdate2,
			String[] qualification2, String profession2, String[] hobbies2, Relation relation2,String address2,String location2,String email2,Long mobile2) {
		super();
		this.firstName = firstName2;
		this.lastName = lastName2;
		this.gender = gender2;
		this.suffix = suffix2;
		this.birthdate = birthdate2;
		this.qualification = qualification2;
		this.profession = profession2;
		this.hobbies = hobbies2;
		this.relation = relation2;
		this.address = address2;
		this.location = location2;
		this.email = email2;
		this.mobile = mobile2;
	}

	public Integer getFamilyMemberId() {
		return familyMemberId;
	}

	public void setFamilyMemberId(Integer familyMemberId) {
		this.familyMemberId = familyMemberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Suffix getSuffix() {
		return suffix;
	}

	public void setSuffix(Suffix suffix) {
		this.suffix = suffix;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String[] getQualification() {
		return qualification;
	}
	
	public String getQualification1() {
		StringBuilder sb=new StringBuilder();
		for(String s:qualification) {
			sb.append(s).append(",");
			
		}
		return sb.toString();
	}

	public void setQualification(String[] qualification) {
		this.qualification = qualification;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String[] getHobbies() {
		return hobbies;
	}
	
	public String getHobbies1() {
		StringBuilder sb=new StringBuilder();
		for(String s:hobbies) {
			sb.append(s).append(",");
			
		}
		return sb.toString();
	}


	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	
	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}
	
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}


	public Integer getFamilyHeadId() {
		return familyHeadId;
	}

	public void setFamilyHeadId(Integer familyHeadId) {
		this.familyHeadId = familyHeadId;
	}

	@Override
	public String toString() {
		return "FamilyMember [familyMemberId=" + familyMemberId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", suffix=" + suffix + ", birthdate=" + birthdate + ", qualification="
				+ Arrays.toString(qualification) + ", profession=" + profession + ", hobbies="
				+ Arrays.toString(hobbies) + ", address=" + address + ", location=" + location + ", email=" + email
				+ ", mobile=" + mobile + ", relation=" + relation + ", familyHeadId=" + familyHeadId
				+ ", getFamilyMemberId()=" + getFamilyMemberId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getGender()=" + getGender() + ", getSuffix()=" + getSuffix()
				+ ", getBirthdate()=" + getBirthdate() + ", getQualification()=" + Arrays.toString(getQualification())
				+ ", getProfession()=" + getProfession() + ", getHobbies()=" + Arrays.toString(getHobbies())
				+ ", getAddress()=" + getAddress() + ", getLocation()=" + getLocation() + ", getEmail()=" + getEmail()
				+ ", getMobile()=" + getMobile() + ", getRelation()=" + getRelation() + ", getFamilyHeadId()="
				+ getFamilyHeadId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}