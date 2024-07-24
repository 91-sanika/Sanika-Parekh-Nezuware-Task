package com.Task3.bookingapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Task3.bookingapp.Entity.User1;
import com.Task3.bookingapp.Repository.UserRepository;

@Service
public class UserService {

	 @Autowired
	    private UserRepository userRepository;

	    public User1 saveUser(User1 user) {
	        return userRepository.save(user);
	    }
}
