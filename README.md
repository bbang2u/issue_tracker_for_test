# Issue Tracker API

Spring Boot 기반의 간단한 이슈 관리 API 프로젝트입니다.  
이슈 생성, 전체 조회, 단건 조회, 상태 변경 기능을 제공합니다.  
단순 기능 구현에 그치지 않고, Postman·H2·Jira를 활용해 QA 관점에서 정상/비정상 API 테스트와 결함 등록까지 수행한 프로젝트입니다.

---

## 1. 프로젝트 목적

이 프로젝트는 백엔드 API 구현 연습과 함께,  
QA 실무에서 중요한 다음 흐름을 직접 수행해보기 위해 만들었습니다.

- API 기능 구현
- 입력값 검증 및 예외 처리
- Postman 기반 정상/비정상 테스트
- H2 DB 직접 검증
- Jira 기반 결함 등록 및 추적

즉, **개발 + QA 사이클을 함께 연습하기 위한 미니 프로젝트**입니다.

---

## 2. 주요 기능

- 이슈 생성
- 전체 이슈 조회
- 특정 이슈 조회
- 이슈 상태 변경
- 제목 필수값 검증
- Enum 기반 상태값 제한
- 전역 예외 처리(JSON 에러 응답)

---

## 3. 기술 스택

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (In-Memory)
- Jakarta Validation
- PowerShell
- Postman
- Jira

---

## 4. 이슈 상태값

현재 지원하는 상태값은 아래 4가지입니다.

- `TO_DO`
- `IN_PROGRESS`
- `IN_REVIEW`
- `DONE`

---

## 5. API 목록

| Method | Endpoint | 설명 |
|---|---|---|
| POST | `/issues` | 이슈 생성 |
| GET | `/issues` | 전체 이슈 조회 |
| GET | `/issues/{id}` | 특정 이슈 조회 |
| PATCH | `/issues/{id}/status` | 이슈 상태 변경 |

---

## 6. 요청 예시

### 6-1. 이슈 생성

**POST** `/issues`

```json
{
  "title": "QA Cycle Test Issue 1",
  "description": "정상 생성 테스트",
  "status": "TO_DO"
}
