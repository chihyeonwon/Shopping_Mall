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
