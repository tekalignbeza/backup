package com.mybot.domain.user;

import com.mybot.domain.base.CoreEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by tekalign.bezawork on 12/28/16.
 */


public class User extends CoreEntity {
   
    String id;
    String firstName;
    String lastName;
    String gender;
    int yearOfbirth;
    String cellPhone;
    String email;  
    List<String> preference;
    Date regstrationDate;    
    Address currentAddress;    
    String userName;
    String password;
    List<String> roles;
    List<Map<String,String>> securityQuestionsAndAnswers;
   

    public User() {
    }

    public User(String username, String password, List<String> roles) {
		// TODO Auto-generated constructor stub
    	this.userName=username;
    	this.email=username;
    	this.password=password;
    	this.roles=roles;
	}

	public List<String> getPreference() {
        return preference;
    }

    public void setPreference(List<String>preference) {
        this.preference = preference;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }
    
    public Date getRegstrationDate() {
        return regstrationDate;
    }

    public void setRegstrationDate(Date regstrationDate) {
        this.regstrationDate = regstrationDate;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYearOfbirth() {
        return yearOfbirth;
    }

    public void setYearOfbirth(int yearOfbirth) {
        this.yearOfbirth = yearOfbirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<Map<String, String>> getSecurityQuestionsAndAnswers() {
        return securityQuestionsAndAnswers;
    }

    public void setSecurityQuestionsAndAnswers(List<Map<String, String>> securityQuestionsAndAnswers) {
        this.securityQuestionsAndAnswers = securityQuestionsAndAnswers;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", yearOfbirth=" + yearOfbirth + ", cellPhone=" + cellPhone + ", email=" + email + ", preference=" + preference + ", regstrationDate=" + regstrationDate + ", currentAddress=" + currentAddress + ", userName=" + userName + ", password=" + password + ", roles=" + roles + ", securityQuestionsAndAnswers=" + securityQuestionsAndAnswers + '}';
    }
   
    
    
}
