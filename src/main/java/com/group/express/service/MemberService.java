package com.group.express.service;

import com.group.express.DTO.MemberDTO;
import com.group.express.domain.Authority;
import com.group.express.domain.Member;
import com.group.express.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder;
    public void registerUser(MemberDTO memberDto) {

        Member member = new Member();
        String encodedPassword = passwordEncoder.encode(member.getPass()); // 비밀번호 암호화
        member.setId(memberDto.getId());
        member.setPass(encodedPassword);
        member.setName(memberDto.getName());
        member.setPhonenumber(memberDto.getPhonenumber());
        member.setMileage(memberDto.getMileage());
        member.setEmail(memberDto.getEmail());
        member.setAddress(memberDto.getAddress());
        member.setRole(Authority.ROLE_USER);
        // Set other user properties and validation if needed

        memberRepository.save(member);
    }

    public Member getMemberById(String id){
        return memberRepository.findById(id).orElse(null);
    }
    public Member updateMember(Member member){return memberRepository.save(member);}
    public void deleteMember(String id){memberRepository.deleteById(id);}

}


