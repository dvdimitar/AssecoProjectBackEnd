//package com.example.demo.model.config;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//
//
//    private final CustomUsernamePasswordAuthentication customUsernamePasswordAuthentication;
//
//    public SecurityConfiguration(CustomUsernamePasswordAuthentication customUsernamePasswordAuthentication) {
//        this.customUsernamePasswordAuthentication = customUsernamePasswordAuthentication;
//    }
////    private final PasswordEncoder passwordEncoder;
////    private final RoleRepository roleRepository;
//
////    public SecurityConfiguration(PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
////        this.passwordEncoder = passwordEncoder;
////        this.roleRepository = roleRepository;
////    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .withUser("user").password(passwordEncoder.encode("user")).roles("USER")
////                .and()
////                .withUser("admin").password(passwordEncoder.encode("admin")).roles("ADMIN").authorities("ADMIN");
//        auth.authenticationProvider(this.customUsernamePasswordAuthentication);
//    }
////
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/login", "/blogs", "/signup/**","/blogs/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .logout()
//                .clearAuthentication(true)
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .and()
//                .exceptionHandling().accessDeniedPage("/blogs?error=You are not authorized!");
//    }
//}
