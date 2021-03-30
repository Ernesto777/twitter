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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
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
	
	/*@Column(name= "id_user")
	private final Long useId;*/
	
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
    
    protected Post()
    {
     this.user = null;
     this.descriptionPost= null;
     this.imagePath= null;
     this.createdAt= null;
    }

	public Post(User user, String descriptionPost, String imagePath, Date createdAt) 
	{
		this.user = user;
		this.descriptionPost= descriptionPost;
	    this.imagePath= imagePath;
	    this.createdAt= createdAt;
	}

	public Post(User user, String descriptionPost, Date createdAt) 
	{
		this.user= user;
		this.descriptionPost= descriptionPost;
	    this.createdAt= createdAt;
	}

}
