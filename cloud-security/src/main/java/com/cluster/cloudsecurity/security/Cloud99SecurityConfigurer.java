package com.cluster.cloudsecurity.security;


import com.cluster.cloudsecurity.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
    @EnableWebSecurity
    public class Cloud99SecurityConfigurer extends WebSecurityConfigurerAdapter {
        @Autowired
        private UsersService usersService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .userDetailsService(usersService);
                    // enable in memory based authentication with a user named "user" and "admin"
//                    .inMemoryAuthentication().withUser("user").password("pw").roles("USER")
//                    .and().withUser("admin").password("pw").roles("USER", "ADMIN");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable();
            http
                    .headers().frameOptions().disable()
                    .and()
                    .formLogin().permitAll(); // enable form based log in, set permitAll for all URLs associated with Form Login
            http
                    .authorizeRequests().anyRequest().authenticated();
        }

//        @Override
//        public void configure(WebSecurity web) throws Exception {
//            web.ignoring()
//                    // Spring Security should completely ignore URLs starting with /resources/
//                    .antMatchers("/resources/**");
//        }

    }

