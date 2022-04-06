package com.sapient.aem.service;
import java.time.LocalDate;
import com.sapient.aem.model.Person;


public class Validator {
	public Boolean isValidName(Person person) {
		String pattern= "^[a-zA-Z\\s.]+$";
		if(person.getFirstName().matches(pattern)) {
			return true;
		}
		return false;
	}
	public Boolean isValidGender(Person person) {
		String myGender = person.getGender().toString();
		if(myGender.equals("male")||myGender.equals("female")||myGender.equals("others")) {
			return true;
		}
		return false;
	}
	public Boolean isValidBirthdate(Person person) {
		if(person.getBirthdate().isBefore(LocalDate.now())) {
			return true;
		}
		return false;
	}
	public Boolean isValidEmail(Person person) {
		String pattern="^[a-zA-Z0-9.]+@[a-zA-Z0-9]+.[a-zA-Z]{2,3}$";
		if(person.getEmail().matches(pattern)) {
			return true;
		}
		return false;
	}
	public Boolean isValidMobile(Person person) {
		String pattern="^[//d]{10}$";
		if(person.getMobile().toString().matches(pattern)) {
			return true;
		}
		return false;
	}
	public Boolean isValid(Person person) {
		if(isValidName(person)&&isValidGender(person)&&isValidBirthdate(person)&&isValidEmail(person)&&isValidMobile(person)) {
			return true;
		}
		return false;
	}
}

