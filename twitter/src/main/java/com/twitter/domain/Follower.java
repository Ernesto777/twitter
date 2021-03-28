package com.twitter.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Follower 
{
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name= "id_user")
    private final User user;
	    
    @Column(name= "id_follewer")
    private String idFollewer;
}
