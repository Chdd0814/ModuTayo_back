package com.group.express.controller;

import com.group.express.domain.Member;
import com.group.express.service.MemberService;
import com.group.express.service.MileageService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Mileage")
public class mileageController {
    private final MemberService memberService;
    private final MileageService mileageService;

    private mileageController(MemberService service, MileageService mileage) {
        this.memberService = service;
        this.mileageService = mileage;
    }

@PutMapping("/UpdateMileage")
public ResponseEntity<?> updateMileage(@RequestParam String id, @RequestParam int mileage, @RequestParam int paidAmount) {
    Member member = memberService.getMemberById(id);

    if (member != null) {
    try {
        int totalMileage = mileageService.insertMileage(mileage, paidAmount);
        member.setMileage((totalMileage));
        memberService.updateMember(member);
        return ResponseEntity.ok().build();
    } catch (Exception e) {
        System.out.println("마일리지 업데이트 작업 실패");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Mileage update failed.");
    }
} else {
        System.out.println("관련 id가 없음.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 id가 존재하지 않음.");
    }

}

}
