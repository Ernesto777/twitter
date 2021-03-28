package com.twitter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.domain.User;
import com.twitter.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{

	UserRepository userRepo;
	
	@Autowired
	public UserServiceImpl(final UserRepository userRepo)
	{
		this.userRepo= userRepo;
	}
	
	@Override
	public String userRegistration(User user) 
	{
		Optional<String> userExist= userRepo.findByUserName(user.getUserName());
		Optional<String> emailExist= userRepo.findByEmail(user.getEmail());

		
		if(userExist.isPresent())
			return "User name alredy exist, try another";
		
		else if (emailExist.isPresent())
			return "Email alredy regitered";

		userRepo.save(user);

		/*if(userRepo.findByUserName(user.getUserName()))
		{
			return "User name alredy exist, try another";
		}
		
		else if(userRepo.findByEmail(user.getEmail()))
		{
			return "Email alredy regitered";
		}*/
		
		//userRepo.save(user);
		return "1";
	}
	
}
