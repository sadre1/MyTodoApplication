package com.example.Sadrealam.Springboot.MyexcersirePartOne.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityPasswordConfig {
	
	
//	InMemoryUserDetailsManager
//	InMemoryUserDetailsManager(UserDetails... users)
	@Bean
	public InMemoryUserDetailsManager  creatreInMemory() {
		 UserDetails userDetails = extracted("sadrealam", "Sadre@123");
		 UserDetails userDetails2 = extracted("kamni", "Ks2#123");
		return new InMemoryUserDetailsManager(userDetails,userDetails2);
	}

    private UserDetails extracted(String username, String password) {
	UserDetails  userDetails =  User.withDefaultPasswordEncoder()
	.username(username)
	.password(password)
	.roles("USER","ADMIN")
	.build();
	return userDetails;
   }
    
    @Bean
    public SecurityFilterChain  filterchain (HttpSecurity http) throws Exception {
    	http.authorizeHttpRequests(
    			auth -> auth.anyRequest().authenticated());
    	http.formLogin(withDefaults());
    	http.csrf().disable();
    	http.headers().frameOptions().disable();
    	
    	
    	return http.build();
    	
    	
    }

}
