package com.alexserden.task.service;

import com.alexserden.task.model.User;
import com.alexserden.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * This class is used by spring controller to authenticate and authorize user
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	private final UserRepository repository;

	@Autowired
	public UserDetailServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	User user = repository.findByUsername(username);
    	
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, user.getPasswordHash(), true,
        		true, true, true, AuthorityUtils.createAuthorityList(user.getRole()));
        
        System.out.println("ROLE: " + user.getRole());
        return userDetails;
    }

    
}