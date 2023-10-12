package com.group.express.repository;

import com.group.express.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findByContentContaining(String content);
    List<Notice> findByTitleContaining(String title);
}
