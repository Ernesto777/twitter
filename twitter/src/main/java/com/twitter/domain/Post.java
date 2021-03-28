package com.twitter.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import lombok.Data;

@Data
@Entity
public class Post 
{
	@Id
	@GeneratedValue
	@Column(name= "id_post")
	private Long id;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name= "id_user")
	private final User user;
	
	@Column(name= "description_post")
    private String descriptionPost;
	
	@Column(name= "image_path")
    private String imagePath;
	
	@Column(name= "created_at")
    private Date createdAt;
    
    @PrePersist
    void createdAt() 
    {
    	this.createdAt= new Date();
    }


}
