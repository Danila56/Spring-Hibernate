package com.config;

import com.dao.UserDAO;
import com.service.impl.MyUserServiceDeteilsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@ComponentScan(basePackageClasses = MyUserServiceDeteilsImpl.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("UserDeteilsService")
    private UserDetailsService userServiceDeteils;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceDeteils);
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests().antMatchers("/").permitAll()
//                .access("hasRole('ROLE_USER')")
            .and().formLogin().loginPage("/login").failureUrl("/login?error")
                .usernameParameter("username").passwordParameter("password")
            .and().csrf();
    }
}