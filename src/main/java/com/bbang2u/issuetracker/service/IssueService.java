package com.bbang2u.issuetracker.service;

import com.bbang2u.issuetracker.domain.Issue;
import com.bbang2u.issuetracker.domain.IssueStatus;
import com.bbang2u.issuetracker.repository.IssueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class IssueService {

    private final IssueRepository issueRepository;

    // 의존성 주입 (Repository 연결)
    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    // 1. 이슈 생성
    @Transactional
    public Issue createIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    // 2. 전체 이슈 조회
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    // 3. 특정 이슈 상세 조회
    public Issue getIssueById(Long id) {
        return issueRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 이슈입니다. ID: " + id));
    }

    // 4. 이슈 상태 수정 (PATCH 로직)
    @Transactional
    public Issue updateStatus(Long id, IssueStatus newStatus) {
        Issue issue = getIssueById(id);
        issue.setStatus(newStatus);

        // @Transactional 애노테이션 덕분에 DB에 명시적으로 save()를 호출하지 않아도,
        // 상태가 변경된 것을 감지하고 자동으로 UPDATE 쿼리가 날아갑니다. (더티 체킹)
        return issue;
    }
}