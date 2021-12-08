package co.kr.study.security.config;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	public void configure(WebSecurity web)throws Exception{
		/*기본적인 Static resource에 대한 접근설정 static 은 보안 필터를 거치치 않음*/
		web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/", "/user").hasRole("USER")  /*자원에대한 설정을 이렇게 넣을수 있음*/
				.antMatchers("/").hasRole("MANAGER")
				.antMatchers("/").hasRole("ADMIN")
				.anyRequest().authenticated()
		.and()
				.formLogin()
		;
	}
	
	
}
