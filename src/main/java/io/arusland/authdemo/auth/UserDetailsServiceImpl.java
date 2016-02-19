package io.arusland.authdemo.auth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		if ("admin".equals(userName)) {
			return new UserDetailsImpl(new User("admin", "af9c28b8b57169f5996d61e26577bb57a323e0d1e22956204be12fb042bfb189137df466fdcb4166"),
					getAuthoritiesByUser(userName));
		}

		throw new UsernameNotFoundException(userName);
	}

	private static Collection<GrantedAuthority> getAuthoritiesByUser(String userName) {
		if ("admin".equals(userName)) {
			return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}

		return new ArrayList<GrantedAuthority>();
	}
}
