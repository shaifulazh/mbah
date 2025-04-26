package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;

	@Bean
	@Order(2)
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				// .authorizeHttpRequests((requests) -> requests
				// .requestMatchers("/", "/home").permitAll()
				// .anyRequest().authenticated()
				// )
				// .formLogin((form) -> form
				// .loginPage("/login")
				// .permitAll()
				// )
				// .logout((logout) -> logout.permitAll());
				// .securityMatcher("/")
				.authorizeHttpRequests(authorize -> 
						{authorize.requestMatchers("/", "/home").permitAll();
						authorize.requestMatchers("/endpoint").hasAnyRole("ADMIN");
						authorize.anyRequest().authenticated();})
				.csrf(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults())
				// .authenticationManager(authenticationManagerBean(http))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				;

		return http.build();
	}

	@Bean
	@Order(1)
	protected SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
		return http
				.securityMatcher("/api/**")
				.authorizeHttpRequests(auth -> {
					auth.anyRequest().authenticated();
				})
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.httpBasic(Customizer.withDefaults())
				.authenticationManager(authManager(http))
				.build();
	}
    @Bean
    protected AuthenticationManager authManager(HttpSecurity http) throws Exception {
		// AuthenticationManagerBuilder authenticationManagerBuilder  =  http.getSharedObject(AuthenticationManagerBuilder.class);
		DaoAuthenticationProvider apiAuthProvider = new DaoAuthenticationProvider();
        apiAuthProvider.setUserDetailsService(customUserDetailsService());
        apiAuthProvider.setPasswordEncoder(passwordEncoder());

		// DaoAuthenticationProvider myAuthProvider = new DaoAuthenticationProvider();
		// myAuthProvider.setUserDetailsService(myUserDetailsService());
        // myAuthProvider.setPasswordEncoder(passwordEncoder());
		// authenticationManagerBuilder.authenticationProvider(apiAuthProvider); ///THIS IS WRONG CHANG this!!!
		// authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider);
		// authenticationManagerBuilder.userDetailsService(customUserDetailsService());
		// authenticationManagerBuilder.inMemoryAuthentication()
		// 	.withUser("memuser")
		// 	.password(passwordEncoder().encode("pass"))
		// 	.roles("USER");
		return new ProviderManager(apiAuthProvider);
		// return authenticationManagerBuilder.build();
    }

	// @Bean
	// public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
	// 	 AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
	// 	authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider);
	// 	authenticationManagerBuilder.userDetailsService(customUserDetailsService());
	// 	authenticationManagerBuilder.inMemoryAuthentication()
	// 		.withUser("memuser")
	// 		.password(passwordEncoder().encode("pass"))
	// 		.roles("USER");
	// 	 return authenticationManagerBuilder.build();
	//  }

	@Bean
    protected PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }



	@Bean
	@Order(1)
	protected CustomUserDetailsService customUserDetailsService() {

		return new CustomUserDetailsService();
	}

	// @Bean
	// protected MyUserDetailsService myUserDetailsService(){
	// 	return new MyUserDetailsService();
	// }
}