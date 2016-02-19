package io.arusland.authdemo.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.NonNull;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = -5258390169806611782L;

	private final Collection<GrantedAuthority> authorities;
	private final User user;

	public UserDetailsImpl(@NonNull User user, @NonNull Collection<GrantedAuthority> authorities) {
		super();
		this.authorities = authorities;
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getName();
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

	public User getUser() {
		return user;
	}
}
