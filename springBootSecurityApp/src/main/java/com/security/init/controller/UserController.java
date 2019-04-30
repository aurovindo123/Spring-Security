package com.security.init.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.security.init.bo.User;
import com.security.init.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path="/user", method=RequestMethod.GET)
	public ResponseEntity listUser(){
		return new ResponseEntity(userService.getUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(path="/user/{id}", method = RequestMethod.GET)
	public ResponseEntity  listUser(@PathVariable(value = "id") int id){
		return new ResponseEntity(userService.getUsers().stream().filter(user -> user.getId()==id).findFirst().orElse(null), HttpStatus.OK);

	}
	
	@RequestMapping(path="/user", method = RequestMethod.POST)
	public ResponseEntity  listUser(@RequestBody User user){
		userService.addUser(user);
		return new ResponseEntity(userService.getUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(path="/signup", method = RequestMethod.GET)
	public ResponseEntity startPage() {
		return new ResponseEntity("success", HttpStatus.OK);
	}
}
