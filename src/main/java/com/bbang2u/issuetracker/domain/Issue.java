package com.bbang2u.issuetracker.domain;

import com.bbang2u.issuetracker.service.IssueService;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "제목은 필수 입력 항목입니다.")
    private String title;

    @Column(length = 1000)
    private String description;

    // 정석 님의 핵심 아이디어: 재현 절차를 독립된 컬럼으로!
    @Column(length = 1000)
    private String reproductionSteps;

    // 시작 전, 진행중, 검토중, 완료
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IssueStatus status = IssueStatus.TO_DO;

    private String reporter;
    private String assignee;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }


}