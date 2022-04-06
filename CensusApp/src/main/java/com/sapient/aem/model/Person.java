package com.sapient.aem.model;

import java.time.LocalDate;
import java.util.Arrays;

public class Person {
	//either family headid or family memberid
	private Integer id;
	private String type;// head or member
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
	private Integer familyHeadId;
	
	public Person() {
		
	}

	public Person(Integer id, String type, String firstName, String lastName, Gender gender, Suffix suffix,
			LocalDate birthdate, String[] qualification, String profession, String[] hobbies, String address,
			String location, String email, Long mobile, Integer familyHeadId) {
		super();
		this.id = id;
		this.type = type;
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
		this.familyHeadId = familyHeadId;
	}

	public Person(String type, String firstName, String lastName, Gender gender, Suffix suffix, LocalDate birthdate,
			String[] qualification, String profession, String[] hobbies, String address, String location, String email,
			Long mobile, Integer familyHeadId) {
		super();
		this.type = type;
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
		this.familyHeadId = familyHeadId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Integer getFamilyHeadId() {
		return familyHeadId;
	}

	public void setFamilyHeadId(Integer familyHeadId) {
		this.familyHeadId = familyHeadId;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", type=" + type + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", suffix=" + suffix + ", birthdate=" + birthdate + ", qualification="
				+ Arrays.toString(qualification) + ", profession=" + profession + ", hobbies="
				+ Arrays.toString(hobbies) + ", address=" + address + ", location=" + location + ", email=" + email
				+ ", mobile=" + mobile + ", familyHeadId=" + familyHeadId + "]";
	}
}

	