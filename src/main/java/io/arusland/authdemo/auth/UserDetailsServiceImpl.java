package io.arusland.authdemo.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return new UserDetailsImpl(new User("admin", "af9c28b8b57169f5996d61e26577bb57a323e0d1e22956204be12fb042bfb189137df466fdcb4166"), null);
	}

}
