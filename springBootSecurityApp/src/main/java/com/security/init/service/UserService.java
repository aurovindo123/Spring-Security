package com.security.init.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.security.init.bo.User;

@Service
public class UserService {
	
	List<User> userList = new ArrayList<>(Arrays.asList(new User[] {new User(1,"arbind"),new User(2,"krishna")}));

	public List<User> getUsers(){
		return userList;
	}
	
	public void addUser(User user) {
		userList.add(user);
	}
}
