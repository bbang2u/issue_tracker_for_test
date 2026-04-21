package com.bbang2u.issuetracker.domain;

public enum IssueStatus {
    TO_DO("시작 전"),
    IN_PROGRESS("진행중"),
    IN_REVIEW("검토중"),
    DONE("완료");

    private final String description;
    IssueStatus(String description) { this.description = description; }
}
