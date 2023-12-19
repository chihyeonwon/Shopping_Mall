# Shopping_Mall
스프링부트 쇼핑몰 프로젝트 with JPA

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
