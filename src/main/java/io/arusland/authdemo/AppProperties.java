package io.arusland.authdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("io.arusland")
@Data
public class AppProperties {
	private boolean enableApp;
}
