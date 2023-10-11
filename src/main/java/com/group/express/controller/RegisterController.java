package com.group.express.controller;

import com.group.express.DTO.MemberDTO;
import com.group.express.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private MemberService memberservice;
    private PasswordEncoder passwordEncoder;

    @PostMapping("/Register")
    public ResponseEntity<String> registerUser(@RequestBody MemberDTO memberDTO) {
         memberservice.registerUser(memberDTO);
         return ResponseEntity.ok("Register success");
    }

}
