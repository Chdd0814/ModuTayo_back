package com.group.express.config;
import com.group.express.config.Exception.ExceptionHandlerFilter;
import com.group.express.config.JWT.JWTSecurityConfig;
import com.group.express.service.JWTProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.List;
import java.util.stream.Stream;
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig   {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private final JWTProvider jwtTokenProvider;

    // 권한 확인을 하지 않는 URI
    private static final String[] PERMIT_ALL_PATTERNS = new String[]{
           "/index.html", "/login", "/Register", "/notices", "/publicApi"
    };
    private static final String[] PERMIT_ADMIN_PATTERNS = new String[]{
            "notices/write", "notices/{num}/"
    };


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .addFilterBefore(new ExceptionHandlerFilter(), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable().cors().and()  // CSRF 보호를 비활성화

//                .authorizeRequests(authorize -> {
//                    authorize
//                            anyReuqest().permitAll();
////                            .antMatchers(HttpMethod.POST, "/login").permitAll()
//////                            .anyRequest().authenticated().and();
//                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .apply(new JWTSecurityConfig(jwtTokenProvider));

        return http.build();
    }




    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:3000");
        // config.setAllowCredentials(true): 요청올시 사용자의 인증 정보를 포함할 수있도록 허용
        config.setAllowedOriginPatterns(List.of("*"));
        // 모든 원본(*)에서의 요청을 허용하도록 설정되어 있으므로 모든 도메인에서의 요청이 허용됩니다.
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        //GET, POST, PUT, DELETE, PATCH, OPTIONS 메서드가 모두 허용됩니다.
        config.setAllowedHeaders(List.of("*"));
        // 여기서는 모든 헤더(*)를 허용하도록 설정되어 있으므로 모든 헤더가 허용됩니다.
        config.setExposedHeaders(List.of("*"));
        // 모든 헤더(*)를 브라우저에 노출하도록 설정되어 있으므로 모든 헤더가 브라우저에 노출됩니다.
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        // 모든 경로에 대해 위에서 설정한 config에 정의된 CORS 규칙이 적용됩니다.
        return source;
    }

}
