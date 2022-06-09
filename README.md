# Account API

![](./img/1.png)

## 회원관리
- 등록된 사용자는 ID/PW 인증 및 oauth 인증으로 로그인 할 수 있습니다.
- 회원가입은 회원 가입 버튼을 클릭해서 진행합니다.
- 회원가입시 계정정보(id,email,password)를 입력하여 저장합니다.
- github.com의 이메일과 동일한 경우, github.com의 oauth 인증으로도 로그인 가능합니다.

## Account-api

- 인증처리는 GateWay 에 위임합니다.
- (RestApi)회원 정보를 제공합니다.
- (RestApi)회원의 상태(가입,탈퇴,휴면)를 관리(cud)합니다.

---

## 기술 목록

- Spring Boot
- Spring Data JPA
- MySql
- Spring Security

