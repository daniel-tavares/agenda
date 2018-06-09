package br.com.agenda.security.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.agenda.security.CustomAuthenticationEntryPoint;
import br.com.agenda.security.CustomLogoutSuccessHandler;
import br.com.agenda.security.SecurityConstants;


@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Oauth2ResourceServer extends ResourceServerConfigurerAdapter {

	@Autowired
	private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
	
	@Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;



	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(SecurityConstants.RESOURCE_ID);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		  http.
		  	headers()
		  		.frameOptions().disable()
		  .and()
          .exceptionHandling()
          	.authenticationEntryPoint(customAuthenticationEntryPoint)
          	.and()
          .logout()
          	.logoutUrl("/oauth/logout")
          	.logoutSuccessHandler(customLogoutSuccessHandler)
          .and()
          	.csrf()
          	.requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
          	.disable()
          .sessionManagement()
          	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
          	.and()
           .authorizeRequests()
            .antMatchers("/api/v1/contacts/**").authenticated()
           .antMatchers("/h2/**").permitAll()
            .antMatchers("/api/v1/users/**").permitAll();
     }
	

}
