package com.hlt.tshust.config;

import com.hlt.tshust.security.JwtAuthenticationEntryPoint;
import com.hlt.tshust.security.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@AllArgsConstructor
public class SpringSecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationEntryPoint authenticationEntryPoint;
    private final JwtAuthenticationFilter authenticationFilter;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> {
                    // Các endpoint mở, không yêu cầu xác thực
                    authorize.requestMatchers("/api/accounts/**").permitAll(); // Cho phép tất cả
                    authorize.requestMatchers("/api/files/**").permitAll(); // Cho phép tất cả
                    authorize.requestMatchers("/check-redis").permitAll(); // Mở endpoint kiểm tra Redis
                    authorize.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll(); // Cho phép tất cả với phương thức OPTIONS

                    // Các endpoint yêu cầu quyền ADMIN
                    authorize.requestMatchers("/api/admin/**").hasRole("ADMIN");

                    // Các endpoint còn lại yêu cầu xác thực
                    authorize.anyRequest().permitAll();
                })
                .httpBasic(Customizer.withDefaults());

        // Cấu hình xử lý lỗi xác thực
        http.exceptionHandling(exception -> exception
                .authenticationEntryPoint(authenticationEntryPoint));

        // Thêm JwtAuthenticationFilter trước UsernamePasswordAuthenticationFilter
        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService); // Sử dụng UserDetailsService
        authProvider.setPasswordEncoder(passwordEncoder()); // Mã hóa mật khẩu với BCrypt
        return authProvider;
    }
}
