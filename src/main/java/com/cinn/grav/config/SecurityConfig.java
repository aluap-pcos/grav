package com.cinn.grav.config;

import com.cinn.grav.entidades.Usuario;
import com.cinn.grav.repositorios.UsuarioGestanteRepository;
import com.cinn.grav.repositorios.UsuarioRepository;
import com.cinn.grav.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenservice;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .antMatchers(HttpMethod.POST, "/cadastro/*").permitAll()
                .antMatchers("/anotacao/*").hasAnyRole("GESTANTE")
                .antMatchers("/consultas/*").hasAnyRole("GESTANTE")
                .antMatchers("/sintomas/*").hasAnyRole("GESTANTE")
                .antMatchers("/exame").hasAnyRole("GESTANTE")
                .antMatchers("/auth/*").permitAll()
                .antMatchers("/auth/*/*").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenservice, usuarioRepository), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
