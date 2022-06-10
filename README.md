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


## Note

### Config

- EntitiyManagerFactoryBean
- TransactionManager

- @SpringBootApplication
  - @Configuration
  - @EnableAutoConfiguration
  - @ComponentScan


### Test

- @DataJpaTest
  - Repository, Entity만을 scan하는 Sliced Test
  - 하지만 MySql을 사용한다면 설정에 의해 오류
  - why? Embedded Db (ex- H2) 를 자동으로 사용하기 때문
  - @AutoConfigureTestDatabase(replace = Replace.NONE) 를 달아줘야 해당 설정을 무시하여 mysql로 테스트할 수 있다.

#### ServiceLayer

- 레포지토리 테스트를 했기 때문에 verify로 행위만 검증하면 된다.

### JPA

- DynamicInsert: default 속성을 사용할 때 사용. jpa는 자체적으로 값이 없으면 null을 보내는데, 이것을 없애기 위함.


도메인이란? : 해결하고자 하는 문제의 영역. 즉, 개발 대상과 범위.

요구사항을 분석해서 핵심 엔티티를 추출하고, 그들간의 관계를 정의하는 것.

Post 와 Put 맵핑의 차이