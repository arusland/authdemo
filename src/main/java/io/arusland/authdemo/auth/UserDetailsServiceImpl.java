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
		return new UserDetailsImpl(new User("admin", "500b750ce9c1cd843b8df9b9731faab43965d1939aaf3aa23b0d028f51e54c5bc420612454cd288a"), null);
	}

}
