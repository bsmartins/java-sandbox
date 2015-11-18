package org.bmartins.springangularjssecurity;

import org.bmartins.springangularjssecurity.social.DefaultGoogleConnectionFactoryBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

@Configuration
public class SocialConfiguration extends SocialConfigurerAdapter {
	
	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
		connectionFactoryConfigurer.addConnectionFactory(new TwitterConnectionFactory("eJx7Tm41Kt6r8ypxhJZVdMq8P", "D02bFkNuSPPD4hgPIabjK70ClexXuuYRpa7QwjG9kFL9UQ9dsg"));
		connectionFactoryConfigurer.addConnectionFactory(googleConnectionFactory("418404013580-3caoa33d0gq6rtipeglco661ljroa2tc.apps.googleusercontent.com", "YQo1aYbEomAZSth5c6j71H3H"));
	}
	
	private GoogleConnectionFactory googleConnectionFactory(String clientId, String clientSecret) {
		return new DefaultGoogleConnectionFactoryBuilder(clientId, clientSecret)
			.addScopeAttribute("https://www.googleapis.com/auth/userinfo.email")
			.build();
	}
}
