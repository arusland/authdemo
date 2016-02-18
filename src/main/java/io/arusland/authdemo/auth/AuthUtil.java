package io.arusland.authdemo.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtil {
	public static boolean isSessionAuthorized() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication != null && authentication.isAuthenticated();
	}

	public static boolean IsAdmin() {
		return isSessionAuthorized() && hasAuthority("ROLE_ADMIN");
	}

	public static String getUsername() {
		if (!isSessionAuthorized()) {
			return null;
		}
		return getCurrentUser().getName();
	}

	public static User getCurrentUser() {
		if (!isSessionAuthorized()) {
			return null;
		}

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetailsImpl) {
			return ((UserDetailsImpl) principal).getUser();
		} else if (principal instanceof String) {
			return new User((String)principal, "");
		} else {
			return null;
		}
	}

	public static boolean hasAuthority(String authName) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return false;
		}

		for (GrantedAuthority auth : authentication.getAuthorities()) {
			if (auth.getAuthority().equals(authName)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static Collection<GrantedAuthority> getRoles() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (authentication == null) {
			return Collections.emptyList();
		}

		return new ArrayList<>(authentication.getAuthorities());
	}
}
