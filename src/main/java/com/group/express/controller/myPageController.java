package com.group.express.controller;

import com.group.express.domain.Member;
import com.group.express.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class myPageController {
    private final MemberService memberService;
    @Autowired
    private myPageController(MemberService memberService) {this.memberService=memberService;}

    @GetMapping("/EditMember/{id}")
    public ResponseEntity<Member> getMember(@PathVariable String id){
        Member member=memberService.getMemberById(id);
        return ResponseEntity.ok(member);
    }
    @PutMapping("/EditMember/{id}")
    public ResponseEntity<Member> putMember(@PathVariable String id,@RequestBody Member Newmember){
        Member Oldmember=memberService.getMemberById(id);
        Oldmember.setAddress(Newmember.getAddress());
        Oldmember.setPhonenumber(Newmember.getPhonenumber());
        Oldmember.setEmail(Newmember.getEmail());
        memberService.updateMember(Oldmember);
        return ResponseEntity.ok(Oldmember);
    }
    @DeleteMapping("/DeleteMember/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable String id){
        memberService.deleteMember(id);
        return ResponseEntity.ok().build();
    }
}
