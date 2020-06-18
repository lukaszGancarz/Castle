package com.clockworkjava.castle.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user1")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin1")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/knights").permitAll()
                .anyRequest().hasRole("ADMIN")
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll() //możliwość logowania dla wszystkich
                .and()
                .csrf()
                .disable(); //wyłącza sprawdzania ciasteczek w przypadku zmiany przeglądarki
        ;
    }

}
