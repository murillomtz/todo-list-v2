package com.mtz.todolist.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ImplementsUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.GET, "/").hasRole("ADMIN").antMatchers(HttpMethod.POST, "/").hasRole("ADMIN")
                .anyRequest().authenticated().and().formLogin()
                .loginPage("/login").permitAll().and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

        // Removi o loginProcessingUrl("") porque o o processo de login que voces querem é o padrão
        
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.inMemoryAuthentication().withUser("mtz").password("{noop}123").roles("ADMIN");
        // auth.inMemoryAuthentication().withUser("user").password("{noop}123").roles("USER");

        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        // Paginas staticas EX:CSS STYLE
        // web.ignoring().antMatchers("/materialize/**", "/style/**");
    }
}