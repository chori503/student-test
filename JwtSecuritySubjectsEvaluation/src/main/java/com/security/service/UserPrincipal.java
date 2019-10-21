package com.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.entities.Users;

public class UserPrincipal implements UserDetails {
	private Users users;

	public UserPrincipal(Users users) {
		this.users = users;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> granthedList = new ArrayList<GrantedAuthority>();
		//Se le pone "ROLE_" para que grantedAuthority Lo reconozca como un rol, 
		// de lo contrario, lo reconocerá como un authority
		granthedList.add(new SimpleGrantedAuthority("ROLE_"+this.users.getIdRole().getRol()));
		return granthedList;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.users.getPass();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.users.getUser();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.users.getState() == true;
	}

}
