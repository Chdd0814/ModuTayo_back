package com.group.express.controller;

import com.group.express.domain.Notice;
import com.group.express.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/notices")
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

    @PostMapping()
    public ResponseEntity<Notice> createNotice ( @RequestParam("title") String title,
                                                 @RequestParam("content") String content,
                                                 @RequestParam("postdate") String postdate,
                                                 @RequestParam("myfile") MultipartFile file,
                                                 @RequestBody Notice notice) throws IOException {

        notice.setTitle(title);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(postdate, formatter);
        notice.setPostdate(localDate);
        notice.setContent(content);
        String projectPath=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\static\\media";
        UUID uuid=UUID.randomUUID();
        String fileName=uuid+"_"+file.getOriginalFilename();

        File savefile=new File(projectPath,fileName);

        file.transferTo(savefile);

        notice.setFileSize((int)file.getSize());
        notice.setFilePath("/static/media/"+fileName);
        notice.setFileName(fileName);


        Notice createdNotice = noticeService.createNotice(notice);
        return ResponseEntity.ok(createdNotice);
    }

    @PutMapping("/{num}")
    public ResponseEntity<Notice> updateNotice(@PathVariable Long num, @RequestParam("title") String title,
                                               @RequestParam("content") String content,
                                               @RequestParam("postdate") String postdate,
                                               @RequestParam("myfile") MultipartFile file,
                                               @RequestParam("visitcount") int count,
                                               @RequestBody Notice notice) throws IOException {


        notice.setTitle(title);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(postdate, formatter);
        notice.setPostdate(localDate);
        notice.setContent(content);
        notice.setVisitcount(count);
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
