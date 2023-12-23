## SpringDataJPA

## 상품 엔티티 설계
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/b3283b05-813a-4ee3-b325-c83c3e249488)   
#### 생성된 상품 엔티티 테이블
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/619cdd5c-e5e4-4bcf-a619-9f9b12759cb3)    
```
com.shop 패키지 아래에 entity를 모아두는 entity 패키지를 생성하고 그 아래에 Item 자바 클래스를 생성합니다.
마찬가지로 com.shop 패키지 아래에 constant 패키지를 생성하고 enum 타입을 모아두는 ItemSellStatus를 작성합니다.

Item 클래스에는 상품의 정보들로 상품코드, 상품명, 가격, 재고수량, 상품상세설명, 상품 판매 상태와 등록 시간, 수정 시간
멤버변수들을 선언하였습니다.

Item 클래스를 엔티티로 매핑하기 위해서 엔티티 매핑 관련 어노테이션들을 사용하였습니다.

@Entity, @Table(name="item") : Item 클래스를 엔티티로 선언하고 item 테이블과 매팽되도록 설정하였습니다.

@Id, @Column(name="item_id"), @GeneratedValue(strategy = GenerationType.Auto : 엔티티로 선언한 클래스는 반드시 기본키를
가져야하며 기본키가 되는 멤버 변수에 @Id를 붙여줍니다.

@Lob : CLOB / BLOB 타입 매핑 : 상품 상세 설명과 같이 대용량 문자형 데이터를 저장하기 위한 어노테이션을 사용

@Enumerated(EnumType.STRING) : enum 클래스 타입 매핑을 하기 위함
```

## 상품 Repository 작성 및 테스트
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/02a2ef74-02d9-4195-a428-c3d707b07f9f)
```
com.shop 패키지 아래에 repository 패키지를 만들고 ItemRepository 인터페이스를 작성합니다.
ItemRepository 인터페이스는 엔티티와 엔티티의 기본 타입을 속성으로 가지는 제너릭 타입의 JpaRepository를 상속받아서
JpaRepository에서 지원하는 엔티티를 관리하는 매니징 메소드들을 사용할 수 있습니다.

이 메소드를 사용하면 엔티티의 저장 및 수정(<S extends T> save (S entity)), 엔티티의 삭제(void delete(T entity)
엔티티의 총 개수 반환(count()), 모든 엔티티 조회(Iterable<T> findAll())을 사용할 수 있습니다.
```

## JUnit 테스트 파일 작성
#### application-test.properites 작성
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/7fab6a86-fc39-4b1c-a355-59e276cde3d1)
#### ItemRepositoryTest 파일 작성
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/a784b0fe-d9a8-4d8d-95bd-592b44ecaa74)
#### Repository 인터페이스를 사용하여 상품 데이터 저장
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/ff08a1d7-dc5b-4edd-ba0c-5fe183540461)
```
먼저 테스트용 Database인 H2 데이터베이스를 사용하기 위해서 이를 위한 properties 파일을 별도로 작성합니다.
resources 아래에 application-test.properties를 작성합니다.

테스트 파일을 생성하기 위해 repository 아래의 ItemRepository -> Go To -> Test를 클릭합니다.

테스트파일에 작성된 어노테이션은 다음과 같습니다.
@SpringBoot : 모든 Bean을 Ioc 컨테이너에 등록하기 위함
@TestPropertySource(location="classpath:경로") <- 상위 적용할 파일의 경로를 지정(application.properties < application-test.properties)

@Autowired : ItemRepository를 사용하기 위해 Bean 주입
@Test, @DisplayName <- JUnit 테스트 이름 지정

인터페이스를 사용하면 따로 insert query를 작성하지 않아도 메서드(createItemTest())를 통해서
객체를 동적으로 생성하여 상품 데이블에 데이터를 insert 할 수 있습니다.
```

## 쿼리 메소드
#### ItemRepository
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/0f53eca2-0ea2-4837-9c2c-bf05bd16860b)
#### ItemRepositoryTest
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/13905e63-0bbf-4399-8d22-59539b4904c6)
#### 테스트 실행 결과
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/c0341914-43e9-46a4-968e-c4f42d78cb7c)
```
쿼리 메소드 문법 : find + (엔티티이름 생략가능) + By + 변수이름
itemNm(상품명)으로 데이터를 조회하기 위해서 findByItemNm으로 메소드명을 만들어줍니다.
기존 ItemRepository 인터페이스에 이 메소드를 추가합니다.

테스트 파일에서 createItem 메소드에서 상품 10개를 추가하고 테스트 상품1을 findByItemNm 메소드의 매개변수로
넘겨주었습니다.

조회 결과 얻은 item 객체들을 출력하도록 함수를 생성하였습니다.

테스트 실행 결과 Select 쿼리문이 실행되는 것을 알 수 있습니다. where 절에 item_nm이 조건으로 걸려있는 것을 확인할 수 있습니다.
```
#### OR 조건 처리하기
#### ItemRepository
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/96b6ef3d-8e26-489e-a859-1cfb4c49123c)
#### ItemRepository Test
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/cad582f4-8c63-4cab-be5a-4ccb58d1a138)
#### OR 테스트 실행 결과
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/d3ef2c4b-6fe5-4e94-9f39-eeec1a0c5c6c)
```
상품을 상품명과 상품 상세 설명을 OR 조건을 이용하여 조회하는 쿼리메소드입니다.

테스트 실행 결과 상품명과 상품 상세 설명 매개변수로 넘겨준 데이터를 Select 쿼리로 찾습니다.
```
#### LessThan 조건 처리하기
#### ItemRepository
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/a31510bb-2e80-4135-9214-ad5e27c50d54)
#### ItemRepository Test
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/683e0813-ca9c-419d-b38d-e9d213dd5620)
#### LessThan 테스트 실행 결과
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/8aa4a6e8-3595-444c-8165-f1b613a7ee35)
```
매개변수로 넘어온 price 변수보다 값이 작은 상품 데이터를 조회하는 쿼리 메소드입니다.

상품가격 데이터는 10001~10010입니다. 10005 보다 작은 10001, 10002, 10003, 10004 4개의 상품이 출력되는 것을 알 수 있습니다. 
```
#### OrderBy로 정렬 처리하기
#### ItemRepository
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/b3618b1e-cb16-4a40-acc1-fc206fc789bc)
#### ItemRepository Test
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/4a4268f5-f3b1-4f22-9b3e-69e667ad6504)
#### OrderBy 테스트 실행 결과
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/d8936a9a-4c4d-4afc-810f-142baa0adc48)
```
상품의 가격이 높은 순으로 조회하는(Desc 내림차순) 쿼리 메소드입니다.
문법 : findByPriceLessThanOrderByPriceDesc

테스트 실해 결과 상품가격이 높은 순으로 출력되는 것을 확인할 수 있습니다.
```
#### @Query를 이용한 검색 처리하기
#### ItemRepository
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/581c1850-661f-4b7f-b0dd-4e72f039a6fc)
#### ItemRepository Test
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/754f5bba-6a03-4291-9ee3-da1fa6241303)
#### @Query 테스트 실행 결과
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/1bb99c03-2c6f-4785-83ab-7ab27902e101)
```
조건이 많아질 때 쿼리 메소드를 선언하면 이름이 길어집니다. 이때 @Query 어노테이션을 사용하여 SQL과 유사한
JPQL이라는 언어를 통해서 복잡한 쿼리를 처리할 수 있습니다.

파라미터로 테스트 상품 상세 설명을 전달하고 itemDetail 속성에 테스트 상품 상세 설명이라는 문자가 포함되면
가격을 기준으로 내림차순하여 결과를 표시합니다.
```
#### @Query -nativeQuery 속성 사용
#### ItemRepository
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/e189ed33-d60f-49f4-abfa-2403e2fb9b72)
#### ItemRepository Test
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/554dec22-7d36-4be7-9a11-4a86a607dc8b)
#### @Query -nativeQuery 테스트 실행 결과
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/3763a88b-daa0-4b7c-8f30-b90e2b707dc9)
```
@Query의 nativeQuery = true 속성을 사용하면 기존 데이터베이스에서 사용하던 쿼리를 그대로 사용할 수 있습니다.
하지만 특정 데이터베이스에 종속되는 쿼리문을 이용하기 때문에 데이터베이스에 독립적이라는 장점은 잃어버립니다.
기존에 작성한 통계용 쿼리처럼 복잡한 쿼리를 그대로 사용해야 하는 경우에 활용할 수 있습니다.

문법은 value 안에 네이티브 쿼리문을 작성하고 "nativeQuery=ture"를 지정합니다.
```

## Spring DATA JPA Querydsl
#### Querydsl setting error 해결
(Querydsl setting error solve)[https://gallery-k.tistory.com/297]
#### pom.xml
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/59ec0012-d96e-4e6d-92dd-bdfa7de6f389)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/27203f61-d470-4b0a-af87-5ee471bbd797)
#### Maven Build
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/ab6cedfe-6f7a-4971-a010-4c15944dff71)    
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/7d660a17-d40c-4e73-b420-8efda48446c6)    
```
@Query 어노테이션 안에 JPQL 문법으로 문자열을 입력하기 때문에 잘못 입력하면 컴파일 시점에 오류를 찾기 어렵습니다.
이를 보완할 수 있는 방법인 QUerydsl을 사용합니다.

Querydsl은 소스코드로 SQL문을 문자열이 아닌 코드로 작성하기 때문에 컴파일러의 도움을 받을 수 있습니다.
고정된 SQL문이 아닌 조건에 맞는 쿼리를 동적으로 생성할 수 있습니다.

Querydsl을 사용하기 위해 pom.xml파일에서 몇가지 의존성을 추가해줍니다.

또한 Qdomain이라는 자바코드를 생성해주는 플러그인을 추가해줍니다.
엔티티를 기반으로 접두사 Q가 붙는 클래스들을 자동으로 생성해주는 플러그인입니다.
예를 들어 Item 테이블의 경우 QItem.java 클래스가 자동으로 생성됩니다.
Querydsl을 통해서 쿼리를 생성할 때는 이러한 Qdomain 객체를 사용합니다.

Querydsl 사용을 위한 의존성과 플러그인을 추가하고 maven - reload all maven projects를 눌러서 동기화를 진행한 후
compile을 눌러서 target/generated-sources/java 

오류 해결 : Querydsl 의존성 주입 중 오류가 발생했는데 버전을 주석처리하면 Qdomain 클래스가 build된다.

QItem 엔티티가 새로 생성되었음을 확인할 수 있다.
```









