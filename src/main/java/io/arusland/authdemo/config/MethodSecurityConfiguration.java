package io.arusland.authdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;

import io.arusland.authdemo.auth.PermissionEvaluatorImpl;

/**
 * NOTE: PermissionEvaluator must be exposed in separate configuration class due to prevent exception related with ServletContext (see http://stackoverflow.com/a/23647156)
 * 
 * @author arusland
 *
 */
@Configuration
public class MethodSecurityConfiguration {
	@Bean
	public PermissionEvaluator permissionEvaluator() {
		return new PermissionEvaluatorImpl();
	}
}