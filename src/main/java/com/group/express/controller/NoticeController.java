package com.group.express.controller;

import com.group.express.domain.Notice;
import com.group.express.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
@CrossOrigin(origins = "http://localhost:3000")
public class NoticeController {
    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping
    public ResponseEntity<List<Notice>> getAllNotices() {
        List<Notice> notices = noticeService.getAllNotices();
        return ResponseEntity.ok(notices);
    }

    @GetMapping("/{num}")
    public ResponseEntity<Notice> getNotice(@PathVariable Long num) {
        Notice notice = noticeService.getNoticeById(num);
        if (notice == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notice);
    }

    @PostMapping
    public ResponseEntity<Notice> createNotice(@RequestBody Notice notice) {
        Notice createdNotice = noticeService.createNotice(notice);
        return ResponseEntity.ok(createdNotice);
    }

    @PutMapping("/{num}")
    public ResponseEntity<Notice> updateNotice(@PathVariable Long num, @RequestBody Notice notice) {
        notice.setNum(num); // 업데이트할 공지사항의 번호를 설정
        Notice updatedNotice = noticeService.updateNotice(notice);
        if (updatedNotice == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedNotice);
    }

    @DeleteMapping("/{num}")
    public ResponseEntity<?> deleteNotice(@PathVariable Long num) {
        noticeService.deleteNotice(num);
        return ResponseEntity.ok().build();
    }
}
