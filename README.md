# Shopping_Mall
스프링부트 쇼핑몰 프로젝트 with JPA

## Branch Description

```
스프링 쇼핑몰 프로젝트 개발을 진행하면서 학습한 내용을 Branch로 구분하여 정리하였습니다.
총 8개의 Branch로 구성되어 있습니다.
1. Info&Setting (개발환경구축)
2. SpringDataJPA (Spring Data ORM인 JPA)
3. Thymeleaf (Thymeleaf 템플릿 엔진의 사용) 
4. SpringSecurity (스프링 시큐리티를 이용한 회원 가입 및 로그인)
5. Mapping (연관 관계 매핑)
6. Enroll&Search (상품 등록 및 조회하기)
7. Order (주문)
8. Basket (장바구니)
```

## 개발환경
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/71b39261-c9e6-4718-afd0-bd74a763ef55)
```
OS : Window 10 +
IDE : IntelliJ
JDK : JDK 21
Spring Boot version : 3.2.0
  Database : MySQL
  Build Tool : Maven
```

## Spring Boot Project 생성
[Spring Initializer](https://start.spring.io/)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/07367f3c-63f9-40fc-ab74-54c6d24ce5df)   
```
스프링 프로젝트를 생성할 때마다 프로젝트 설정을 쉽게 추가할 수 있는 방법을 제공해주는 Spring Initializer 사이트를 사용합니다.

Project Build Tool : Maven
Language : Java
Spring Boot version : 3.2.0
Group : com.shop
Artifact: shop
Name : shop
Description : Shop Project for Spring Boot
Package name : com.shop
Packaging : Jar
Java version : 21
```
```
프로젝트에서 사용한 의존성은 총 6가지로 다음과 같습니다.

Thymeleaf: 서버에서 가공한 데이터를 뷰에 보여주기 위한 템플릿 엔진으로 타임리프 의존성을 추가합니다.
Spring Data JPA : Spring Data JPA는 JPA를 쉽게 구현할 수 있도록 도와주는 모듈입니다.
MySQL Driver : 프로젝트에서 사용하는 데이터베이스는 MySQL 이므로 MySQL 데이터베이스를 사용하기 위해 추가합니다.
H2 Database : H2 Database는 자바 기반의 관계형 데이터베이스로 매우 가볍고 빠른 데이터베이스입니다.
디스크 기반의 데이터 저장뿐만 아니라 메모리 내의 데이터를 저장하는 인메모리 데이터베이스 기능을 지원합니다
데이터를 영구적으로 저장하는 데 권장되는 데이터베이스는 아니지만 위의 장점들 때문에 테스트용 데이터베이스로 많이 사용합니다.
```

## MySQL 설정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/1631c80d-b3f1-4a4e-a614-b2f81805a7ef)       
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/92b13cbf-da67-40a5-a5ad-7f09f8861fc1)    
```
MySQL 초기 설정은 컴퓨터공학과 학부 데이터베이스 수업 때 사용한 설정을 그대로 사용하였습니다.
username:root, password=root port=3306 
root 계정에 접속하고 프로젝트에서 사용할 shop이라는 데이터베이스를 생성하였습니다.
```

## application.properties 설정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/f1569e4b-9092-4e9a-8993-23a795b8d7a8)
```
데이터베이스에 연결하기 위해 mysql jdbc driver 설정하고 연결할 데이터베이스의 url, port, db name을 입력합니다.
db를 설치할 때 입력한 아이디와 비밀번호를 입력하고, 데이터베이스 초기화전략을 create로 설정합니다.
sql 벤더중 MySQL 데이터베이스를 사용하라고 지시합니다. MySQL8Dialect 만약 오라클의 Dialect를 설정한다면 이 부분을
수정해주면 됩니다.

초기화전략에는 5가지의 옵션이 있습니다.
none : 사용하지 않음
validate: 엔티티와 테이블 정상 매핑 확인

create : 기존 테이블 삭제 후 테이블 생성
create-drop: 기존 테이블 삭제 후 테이블 생성, 종료 시점에 테이블 삭제
update : 변경된 스키마 적용 -> 삭제x, 컬럼 추가만 반영

실제 운영환경에서는 none, validate를 사용하고 현재 운영환경이 아니므로 개발 편의상 create로 설정하였습니다. 
```
