package org.binar.chapter6.configuration;

import org.binar.chapter6.model.enumerations.ERoles;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/customer/**").hasRole(ERoles.ROLE_CUSTOMER.name())
                    .antMatchers("/admin/**").hasRole(ERoles.ROLE_ADMIN.name())
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login").permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .and()
                .httpBasic();
    }

}
