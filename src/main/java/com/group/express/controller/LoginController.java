package com.group.express.controller;

import com.group.express.domain.Member;
import com.group.express.repository.MemberRepository;
import com.group.express.service.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // 아이디로 사용자 정보를 데이터베이스에서 조회합니다.
        Optional<Member> memberOpt = memberRepository.findById(username);
        if (memberOpt.isPresent()) {
            Member member = memberOpt.get();
            // 데이터베이스의 비밀번호와 입력한 비밀번호를 비교합니다.
            if (password.equals(member.getPass())) {
                return ResponseEntity.ok("success");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("비밀번호가 일치하지 않습니다.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("사용자를 찾을 수 없습니다.");
        }
    }
}
