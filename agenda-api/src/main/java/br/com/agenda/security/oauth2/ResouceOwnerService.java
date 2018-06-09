package br.com.agenda.security.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.agenda.core.user.UserService;

@Service("userDetailsService")
public class ResouceOwnerService implements UserDetailsService{

	@Autowired
	private UserService userService;

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		return new ResourceOwner(userService.findUserByUsername(userId));
	}

}