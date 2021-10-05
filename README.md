# 회원가입, 로그인, 댓글 작성/수정/삭제 기능이 추가된 나만의 항해 블로그 만들기
spring과 jpa를 이용하여 간단한 게시판 프로젝트를 진행하였습니다.

## 1. 제작기간 & 프로젝트 규모
- 2021/10/03 ~ 2021/10/04
- 소규모 개인 프로젝트

## 2. 사용 기술
- `Backend`
  - JPA
  - Spring Boot
  - Spring web
  - Lombok
  - spring security
  - oauth kakao login api
- `Frontend`
  -  Thymeleaf
- `DB`
  - h2
  - mysql
  
  
## 3. 실행 화면
#### 1. 로그인 화면
![image](https://user-images.githubusercontent.com/23234577/135990963-004f2776-df98-4d0d-9880-cff74e78f91a.png)

#### 2. 회원가입 화면
![image](https://user-images.githubusercontent.com/23234577/136010089-e23b2d69-a045-4951-879b-79c129f75216.png)

#### 3. 게시글 목록 화면
![image](https://user-images.githubusercontent.com/23234577/136010138-cae9a400-674c-429d-8b2b-e002123bc79c.png)

#### 4-1. 다른 사람의 게시글 자세히 보기 화면
![image](https://user-images.githubusercontent.com/23234577/136010216-45bec74d-b513-4998-adb4-cf3cba859048.png)
#### 4-2. 자신의 게시글 자세히 보기 화면
![image](https://user-images.githubusercontent.com/23234577/136010339-263e1ec9-eb77-41d5-9608-b7dd49d376bf.png)
#### 5. 게시글 수정 화면
![image](https://user-images.githubusercontent.com/23234577/136010385-5332e77d-35e7-40c4-abdd-6c391d79726c.png)
#### 6. 게시글 등록 화면
![image](https://user-images.githubusercontent.com/23234577/136010418-8bdeb1c5-462f-4959-bd10-278ec7645a93.png)
#### 7-1. 댓글 리스트
![image](https://user-images.githubusercontent.com/23234577/136010512-5f9e1e62-4d31-4582-b7d3-e76bca32b4f7.png)


## 4. 핵심 기술
- 로그인
  - Spring security를 이용한 로그인
  - 카카오 로그인 api를 이용한 카카오 로그인 구현
- 회원가입
  - 일반 회원가입 구현
  - 카카오 자동 회원가입 구현
- 간단한 게시글 CRUD
  - 게시글 추가가 가능하며, 이 때 작성이 이름은 로그인한 이메일 값으로 고정됩니다.
  - 자신의 게시글만 삭제가 가능합니다.
  - 자신의 게시글만 수정이 가능합니다.
  - 게시글 목록보기가 가능합니다.
  - 게시글 1개 자세히 보기가 가능합니다.
- 간단한 댓글 CRUD
  - 댓글 추가가 가능하며, 이 때 작성이 이름은 로그인한 이메일 값으로 고정됩니다.
  - 자신의 댓글만 삭제가 가능합니다.
  - 자신의 댓글만 수정이 가능합니다.
  - 댓글 목록보기가 가능합니다.
 

## 5. 해결한 문제 정리해보기


  
