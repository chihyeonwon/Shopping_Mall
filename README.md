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
