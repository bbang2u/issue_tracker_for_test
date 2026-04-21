package com.bbang2u.issuetracker.controller;

import com.bbang2u.issuetracker.domain.Issue;
import com.bbang2u.issuetracker.domain.IssueStatus;
import com.bbang2u.issuetracker.service.IssueService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssueController {

    private final IssueService issueService;

    // Service 의존성 주입
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    // 1. 이슈 생성
    @PostMapping
    public Issue createIssue(@Valid @RequestBody Issue issue) {
        return issueService.createIssue(issue);
    }

    // 2. 전체 이슈 조회
    @GetMapping
    public List<Issue> getAllIssues() {
        return issueService.getAllIssues();
    }

    // 3. 특정 이슈 조회
    @GetMapping("/{id}")
    public Issue getIssue(@PathVariable Long id) {
        return issueService.getIssueById(id);
    }

    // 4. 이슈 상태 수정 (PATCH)
    @PatchMapping("/{id}/status")
    public Issue updateIssueStatus(@PathVariable Long id, @RequestBody IssueStatus newStatus) {
        // 상태값 문자열을 받아 업데이트를 수행합니다.
        return issueService.updateStatus(id, newStatus);
    }
}