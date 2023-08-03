package cl.Awakelab.Restaurante.Web.security;


import cl.Awakelab.Restaurante.Model.Persistence.repository.LoginRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

    LoginRepository repository;
    public SecurityConfig(LoginRepository repository){
        this.repository = repository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/js/**", "/css/**").permitAll()
                .requestMatchers("/api/**").permitAll()
                .requestMatchers(request -> true).hasAuthority("SUPER")
                .and()
                .httpBasic(Customizer.withDefaults())
                .formLogin()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl(repository);
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}





