package com.indice.gezgin.security.config;

import com.indice.gezgin.auth.entrypoint.JwtAuthenticationEntryPoint;
import com.indice.gezgin.security.jwt.JwtAccessDeniedHandler;
import com.indice.gezgin.security.jwt.JwtFilter;
import com.indice.gezgin.security.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private JwtFilter jwtAuthorizationFilter;
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserDetailsServiceImpl userDetailsService;
    public SecurityConfig(JwtAccessDeniedHandler jwtAccessDeniedHandler, JwtFilter jwtAuthorizationFilter,
                          JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, UserDetailsServiceImpl userDetailsService,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


//    // Re Code it
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/api/**");
//    }




    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Create a Log for here.
        // Log must keep all data which authenticate someone.
        http.cors(withDefaults());
        http.csrf((csrf) -> csrf
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).disable());
        http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/45/40/merkez/login").permitAll();
                    auth.requestMatchers("/45/40/merkez/admin").permitAll();
                    auth.requestMatchers("/teklif/**").permitAll();
                    auth.requestMatchers("/bildiris/**").permitAll();
                    auth.requestMatchers("/mekanlar/**").permitAll();
                    auth.requestMatchers("/sikayet/**").permitAll();
                    auth.requestMatchers("/bildiris/**").permitAll();
                    auth.requestMatchers("/ads/user/**").permitAll();
                    auth.requestMatchers("/user/**").hasAnyAuthority("USER");
                    auth.requestMatchers("/admin/**").hasAnyAuthority("ADMIN");
                    auth.requestMatchers("/ads/admin/**").hasAnyAuthority("ADMIN");
                    auth.requestMatchers("/mekan/**").hasAnyAuthority("ADMIN");
                    auth.requestMatchers("/administration/**").hasAnyAuthority("ADMIN");
                    auth.anyRequest().authenticated();
                })
                .formLogin(withDefaults())
                .logout((logout) ->
                        logout.deleteCookies("remove")
                                .invalidateHttpSession(false)
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/logout-success")
                )
                .exceptionHandling((ex) -> ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .exceptionHandling((ex) -> ex.accessDeniedHandler(jwtAccessDeniedHandler));
        http
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider(){
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return authenticationProvider;
    }



    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}


