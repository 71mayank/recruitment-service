package za.co.bookstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BookStoreSecurityConfig extends WebSecurityConfigurerAdapter {

    // Allowing unrestricted access to all endpoints.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/js/**", "/css/**").permitAll()
                .anyRequest()
                .permitAll()
                .and().csrf().disable();
    }
}
