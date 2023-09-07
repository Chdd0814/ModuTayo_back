package com.group.express.service;

import com.group.express.DTO.MemberDTO;
import com.group.express.domain.Member;
import com.group.express.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void registerUser(MemberDTO memberDto) {
        Member member = new Member();
        member.setId(memberDto.getId());
        member.setPass(memberDto.getPass());
        member.setName(memberDto.getName());
        member.setPhoneNumber(memberDto.getPhonenumber());
        member.setMileage(memberDto.getMileage());
        member.setEmail(memberDto.getEmail());
        member.setAddress(memberDto.getAddress());
        member.setRole(memberDto.getRole());
        // Set other user properties and validation if needed

        memberRepository.save(member);
    }

}
