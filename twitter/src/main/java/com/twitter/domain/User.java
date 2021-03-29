package com.twitter.domain;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

//@Data
//@NoArgsConstructor(access=AccessLevel.PRIVATE, force= true)
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class User 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name= "id_user")
	private Long id;
	
	@Column(name= "user_name")
	private final String userName;
	
	private final String pass;
	
	@Column(name= "full_name")
	private final String fullName;
	
	private final String email;
	
    // Empty constructor for JSON (de)serialization
    protected User() 
    {
    	userName = null;
    	pass= null;
    	fullName= null;
    	email= null;
    }
    
    public User(Long id, String userName) 
    {
    	this.id= id;
    	this.userName = userName;
		this.pass = "";
		this.fullName = "";
		this.email = "";
    }
	
}
