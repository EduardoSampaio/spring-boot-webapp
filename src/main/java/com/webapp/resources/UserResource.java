package com.webapp.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.domain.User;
import com.webapp.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserResource {

	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private PasswordEncoder passwordEncoder;
	 
	 
	 @PostMapping
	 @PreAuthorize("hasAnyRole('ADMIN')")
	 public ResponseEntity<Response<User>> create(@RequestBody User user,BindingResult result) {	 
		 Response<User> response = new Response<>();
		 
		 user.setPassword(passwordEncoder.encode(user.getPassword()));
		 User userPersisted  = userService.createOrUpdate(user);
		 response.setData(userPersisted);
		 
		 return ResponseEntity.ok(response);
	 }
	 
	 @PutMapping
	 @PreAuthorize("hasAnyRole('ADMIN')")
	 public ResponseEntity<Response<User>> update(@RequestBody User user,BindingResult result) {	 
		 Response<User> response = new Response<>();
		 
		 user.setPassword(passwordEncoder.encode(user.getPassword()));
		 User userPersisted  = userService.createOrUpdate(user);
		 response.setData(userPersisted);
		 
		 return ResponseEntity.ok(response);
	 } 
	 
	 
	 @GetMapping(value = "{id}")
	 @PreAuthorize("hasAnyRole('ADMIN')")
	 public ResponseEntity<Response<User>> findById(@PathVariable("id") String id) {	 
		 Response<User> response = new Response<>();
		 
		 User user = userService.findById(id).get();
		 
		 if(user == null) {
			 response.getErrors().add("Register not found id: " + id);
			 return ResponseEntity.badRequest().body(response);
		 }
		 response.setData(user);
		 	 
		 return ResponseEntity.ok(response);
	 } 
	 
	 @DeleteMapping(value = "{id}")
	 @PreAuthorize("hasAnyRole('ADMIN')")
	 public ResponseEntity<Response<String>> delete(@PathVariable("id") String id) {	 
		 Response<String> response = new Response<>();
		 
		 User user = userService.findById(id).get();
		 
		 if(user == null) {
			 response.getErrors().add("Register not found id: " + id);
		 }
		 userService.delete(id);
		 return ResponseEntity.ok(response);
	 } 
	 
	 @GetMapping(value = "{page}/{count}")
	 @PreAuthorize("hasAnyRole('ADMIN')")
	 public ResponseEntity<Response<Page<User>>> findAll(@PathVariable int page,@PathVariable int count) {	 
		 Response<Page<User>> response = new Response<>();
		 Page<User> users = userService.findAll(page, count);
		 response.setData(users);
		 
		 return ResponseEntity.ok(response); 
	 } 
}
