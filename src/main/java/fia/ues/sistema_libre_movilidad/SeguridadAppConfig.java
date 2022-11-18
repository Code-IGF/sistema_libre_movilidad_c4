package fia.ues.sistema_libre_movilidad;

import javax.annotation.security.PermitAll;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SeguridadAppConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder usuarios= User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
            .withUser(usuarios.username("user").password("password").roles("admin"))
            .withUser(usuarios.username("viajero").password("password").roles("viajero"))
            .withUser(usuarios.username("oficial").password("password").roles("oficial"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/","/public/**", "/resources/**","/resources/public/**")
        .permitAll().anyRequest().authenticated()
        .and().formLogin()
        .loginPage("/iniciarSesion")
        .failureUrl("/login-failed")
        .loginProcessingUrl("/AuthorizeLogin")
        .defaultSuccessUrl("/home")
        .permitAll()
        .and()
        .logout().logoutSuccessUrl("/finalizarSesion").permitAll() ;
    }
    
    
}
