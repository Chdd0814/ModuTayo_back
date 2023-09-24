package com.group.express.controller;

import com.group.express.DTO.TokenDTO;
import com.group.express.domain.Member;
import com.group.express.repository.MemberRepository;
import com.group.express.service.JWTProvider;
import com.group.express.service.LoginRequest;
import com.group.express.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final MemberRepository memberRepository;
    private final JWTProvider jwtProvider;
    private final BCryptPasswordEncoder passwordEncoder;
    private final LoginService loginService;




    @Autowired
        public LoginController(MemberRepository memberRepository, JWTProvider jwtProvider, PasswordEncoder passwordEncoder, LoginService loginService) {
        this.memberRepository = memberRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = (BCryptPasswordEncoder) passwordEncoder;
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        TokenDTO tk = loginService.login(loginRequest);
        Member member = memberRepository.findById(loginRequest.getUsername()).orElse(null);

        return ResponseEntity.ok(tk);
        }

    }
