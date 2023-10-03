package com.group.express.service;


import com.group.express.DTO.TokenDTO;
import com.group.express.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder managerBuilder;
    private final JWTProvider jwtTokenProvider;
    private final RestTemplate restTemplate;
    private final PasswordEncoder passwordEncoder;

    public TokenDTO login(LoginRequest loginRequest) {
        // 사용자 아이디와 비밀번호를 포함한 UsernamePasswordAuthenticationToken 객체 생성
        UsernamePasswordAuthenticationToken authenticationToken = loginRequest.toAuthentication();
        // authenticationToken 인증, 인증 성공 시 authentication 객체 반환(사용자 정보, 권한정보 포함)
        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);


        // 로그인 시 토큰 생성해서 반환
        return jwtTokenProvider.generateAccessTokenDto(authentication);
    }
}
