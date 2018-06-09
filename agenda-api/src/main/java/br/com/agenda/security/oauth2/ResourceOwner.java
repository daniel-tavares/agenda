package br.com.agenda.security.oauth2;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.agenda.core.user.User;

public class ResourceOwner implements UserDetails, Serializable{

	private static final long serialVersionUID = 1L;
	
	private User user;

	public ResourceOwner(User user) {
		this.user=user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.user.getProfiles().stream().map(p -> new SimpleGrantedAuthority(p.getName().name())).collect(Collectors.toList());
	}
	
	public long getId() {
		return user.getId();
	}
	

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
