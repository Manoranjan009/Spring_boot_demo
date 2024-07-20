//package com.cglia.securityconfig;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig  {
//
//
////    public void configure(HttpSecurity http) throws Exception {
////        http
////            .authorizeRequests()
////                .requestMatchers("/products/all").permitAll()
////                .requestMatchers("/products/getbyid/**").hasRole("USER")
////                .requestMatchers("/products/create").hasRole("ADMIN")
////                .requestMatchers("/products/update/**").hasRole("ADMIN")
////                .requestMatchers("/products/delete/**").hasRole("ADMIN")
////                .anyRequest().authenticated()
////                .and()
////            .formLogin()
////                .loginPage("/login")
////                .permitAll()
////                .and()
////            .logout()
////                .permitAll();
////    }
//
////    public void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth
////            .inMemoryAuthentication()
////                .withUser("user").password("12345").roles("USER")
////                .and()
////                .withUser("admin").password("7777").roles("ADMIN");   }
//
//    @Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		UserDetails user =User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("12345")
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(user);
//	}
//    @Bean
//    public SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception{
//    	http.authorizeHttpRequests((authz) -> authz
//    	.requestMatchers("/products/all").permitAll()		
//    	.anyRequest()
//    	.authenticated())
//    	.httpBasic();
//    
//    	return http.build();
//    }
//}


