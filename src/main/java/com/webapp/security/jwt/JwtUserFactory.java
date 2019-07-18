package com.webapp.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.webapp.domain.User;
import com.webapp.enums.ProfileEnum;

public class JwtUserFactory {

	private JwtUserFactory() {
		
	}
	
	public static JwtUser create(User user) {
		return new JwtUser(
				user.getId(),
				user.getEmail(),
				user.getPassword(),
				matTOGrantedAuthorities(user.getProfile()));
	}
	
	private static List<GrantedAuthority> matTOGrantedAuthorities(ProfileEnum profileEnum){
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}
}
