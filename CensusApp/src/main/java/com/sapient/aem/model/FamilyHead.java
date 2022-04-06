package com.sapient.aem.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;





public class FamilyHead implements Serializable {
	
	private Integer familyHeadId;
	private String firstName;
	private String lastName ;
	private Gender gender;
	private Suffix suffix;
	private LocalDate birthdate;
	private String[] qualification;
	private String profession;
	private String[] hobbies;
	private String address;
	private String location;
	private String email;
	private Long mobile;
	
	
	public FamilyHead() {
		
	}
	

	public FamilyHead( String firstName, String lastName, Gender gender, Suffix suffix,
			LocalDate birthdate, String[] qualification, String profession, String[] hobbies,String address,String location,String email,Long mobile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.suffix = suffix;
		this.birthdate = birthdate;
		this.qualification = qualification;
		this.profession = profession;
		this.hobbies = hobbies;
		this.address = address;
		this.location = location;
		this.email = email;
		this.mobile = mobile;
	}
	
	


	public FamilyHead(Integer familyHeadId, String firstName, String lastName, Gender gender, Suffix suffix,
			LocalDate birthdate, String[] qualification, String profession, String[] hobbies,String address,String location,String email,Long mobile) {
		super();
		this.familyHeadId=familyHeadId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.suffix = suffix;
		this.birthdate = birthdate;
		this.qualification = qualification;
		this.profession = profession;
		this.hobbies = hobbies;
		this.address = address;
		this.location = location;
		this.email = email;
		this.mobile = mobile;
	}



	public Integer getFamilyHeadId() {
		return familyHeadId;
	}


	public void setFamilyHeadId(Integer familyHeadId) {
		this.familyHeadId = familyHeadId;
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

	public void setQualification1(String[] qualification1) {
		this.qualification = qualification1;
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


	@Override
	public String toString() {
		return "FamilyHead [familyHeadId=" + familyHeadId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", suffix=" + suffix + ", birthdate=" + birthdate + ", qualification="
				+ Arrays.toString(qualification) + ", profession=" + profession + ", hobbies="
				+ Arrays.toString(hobbies) + ", address=" + address + ", location=" + location + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}
}
	
	




		
	
	
