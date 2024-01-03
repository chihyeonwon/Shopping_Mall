## RelationMapping
```
앞서서 단일 엔티티를 조회하거나 데이터를 수정하는 작업을 했다면 연관 관계를 매핑을 설정하고
매핑된 엔티티의 조회 시 즉시 로딩과 지연 로딩의 차이점을 이해하면서 개발을 진행하였습니다.

첫 번째로 중요한 개념 연관 관계 매핑의 종류

연관 관계 매핑의 종류
@OneToOne : 일대일(1:1)
@OneToMany : 일대다(1:N)
@ManyToOne : 다대일(N:1)
@ManyToMany : 다대다(N:M)

예를 들어 Member(회원) 엔티티와 Cart(장바구니) 엔티티는 일대일 매핑을 한다.
회원의 입장에서 하나의 장바구니를 갖고 장바구니의 입장에서도 자신과 매핑되는 한 명의 회원을 갖는다.
반면 장바구니와 장바구니 상품은 일대다 매핑을 합니다.
장바구니 안에는 여러개의 상품이 들어갈 수 있지만 각 상품의 입장에서는 하나의 장바구니와 매핑합니다.

두 번째로 중요한 개념 엔티티 매핑의 방향성

테이블 : 항상 양방향 , 객체 : 단방향, 양방향으로 존재한다.

스프링은 객체 엔티티이므로 단방향, 양방향, 즉 방향성을 이해해야할 필요성이 있다.
```
## 일대일 단방향 매핑
#### 장바구니 엔티티 설계
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/03193c54-cbef-4e3c-a723-0e3575c50175)    
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/1e973504-5c38-460b-b7c2-4ffb2abde148)     
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/ca707da3-ec3a-454a-9903-ddb2ec2ebf7e)
```
@OneToOne 어노테이션을 이용하여 member 엔티티와 일대일로 매핑합니다.
cart 테이블이 생성되고 member_id 속성을 외래키로 갖습니다.

cart 엔티티를 조회할 때 매핑된 member 엔티티도 한 번에 조회하는 데 이를 즉시로딩이라고 합니다.
일대일, 다대일에서 기본적으로 fetch 전략으로 설정하는데 따로 옵션을 주지 않으면
즉시로딩 @OneToOne(fetch = FetchType.EAGER)로 설정하는 것과 같습니다.
```
## 다대일 단방향 매핑
#### 장바구니 아이템 엔티티 설계
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/e504003b-1cb0-45b6-8ef8-e37910a92529)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/4a6cff3b-573d-4a92-a4f8-20ba8ad43d40)     
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/ca75d2e6-341b-47ed-87cd-b5093f72847c)
```
@ManyToOne 어노테이션을 이용하여 cart 장바구니 엔티티와 item 상품정보 엔티티와 다대일 매핑합니다.

하나의 장바구니에 여러 개의 장바구니 아이템이 담길 수 있으므로 장바구니 아이템 테이블(cart_item) 입장에서
N:1의 관계를 가지고

하나의 상품(item)이 장바구님 아이템에 여러개 담길 수 잇으므로 장바구니 아이템 테이블 입장에서 N:1의 관계를 가집니다.

장바구니(1) <- 장바구니아이템(N)
상품(1) -> 장바구니아이템(N) 즉 방향성이 다를 뿐 장바구니아이템의 입장에서는 다대일 관계입니다.
```
## 다대일/일대다 양방향 매핑
#### 주문 엔티티 설계
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/7c7b53c5-c36e-4cbf-a018-fba1d7bea7f6)
```
주문 엔티티(Order N)은 회원 엔티티(member 1)와 다대일 단방향 매핑합니다.
(한 회원은 여러 개의 주문을 할 수 있다)
```
#### 주문 상품 엔티티 설계
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/836b1166-99aa-465d-936a-40a901a3d0a0)
```
주문 상품 엔티티(OrderItem N)은 상품 엔티티(item 1)와 다대일 단방향 매핑합니다.
(하나의 상품은 여러 개의 주문 상품으로 들어갈 수 있다)
주문 상품 엔티티(OrderItem N)은 주문 엔티티(Order 1)와 다대일 단방향 매핑합니다.
(한번의 주문에 여러 개의 주문 상품을 주문할 수 있다)

주문 상품 엔티티와 주문 엔티티의 양방향 매핑을 위해 먼저 주문 상품 엔티티에서 주문 엔티티로 ManyToOne 단방향 매핑을
한 후에 주문 엔티티에서 주문 상품 엔티티로 OneToMany 단방향 매핑을 하면 양방향 매핑관계가 성립됩니다.

양방향 매핑관계에서 JoinColumn 어노테이션을 가지고 있는 쪽, 즉 외래키를 가진 쪽이 연관 관계의 주인(OrderItem)이 되며
연관 관계 주인이 외래키를 관리(등록, 수정, 삭제)할 수 있습니다. 주인이 아닌 쪽(Order)는 읽기만 가능하며 연관 관계 매핑 시에
mappedBy 속성의 값으로 연관관계 주인의 필드를 넣어줍니다.
```
## 다대다 매핑
```
결론부터 다대다 매핑은 실무에서는 사용하지 않는 매핑입니다. 관계형 데이터베이스는 정규화된 테이블 2개로 다대다를 표현할 수 없습니다.
따라서 연결 테이블을 생성해서 다대다 관계를 일대다, 다대일 관계로 풀어냅니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/202138cc-ad8c-48ee-9dd2-532736f91c7a)
```
@ManyToMany 어노테이션을 사용하여 다대다 매핑이 가능합니다. 이번 쇼핑몰 프로젝트에서 다대다 매핑은 사용하지 않지만
코드로 표현해보면 다음과 같습니다. 다음은 member엔티티와 item의 다대다 매핑입니다.

다대다 매핑을 사용하지 않는 이유는 연결 테이블에는 컬럼을 추가할 수 없기 때문입니다. 연결 테이블에는 조인 컬럼뿐 아니라
추가 커럶이 필요한 경우가 많고 엔티티를 조회할 때 member 엔티티에서 item을 조회하면 중간 테이블이 있기 때문에 어떤 쿼리문이
실행될지 예측하기도 쉽지 않습니다. 따라서 연결 테이블용 엔티티를 하나 생성한 후 일대다 다대일 관계로 매핑을 하면 됩니다.
```

## 영속성 전이 Cascade
```
영속성 전이란 엔티티의 상태를 변경할 때 해당 엔티티와 연관된 엔티티의 상태 변화를 전파시키는 옵션입니다.
이때 부모는 One에 해당자식은 Many에 해당합니다. 
```
#### OrderRepository
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/9af97f56-1d67-48df-9133-e404de5824f1)  
```
주문 엔티티를 저장하기 위해 JpaRepository를 상속받는 OrderRepository 인터페이스를 작성합니다.
```
#### Order엔티티에 Cascade Option 추가
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/8d67b0af-1dc0-4688-8cff-c6d0247fc9cb)
#### OrderTest
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/660b81cd-3d03-4054-9432-8dfdc83b445b)
#### Order insert
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/867aae18-3cef-4a69-b314-7ea4ac9f8b7e)
#### OrderItem insert (cascade by Order)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/19957b15-644d-4a02-adb4-216145fe31d4)
```
고객이 주문할 상품을 선택하고 주문(Order)할 때 주문 엔티티를 저장하면서 cascade All으로 영속성 전이 cascade 되어있는
주문 상품 엔티티도 함께 저장되는 지를 테스트해보았습니다.

코드를 보면 영속성 컨텍스트에 저장되지 않은 orderItem 엔티티를 order엔티티에 넣어주고
order엔티티를 저장하면서 데이터베이스에 반영(saveAndFlush)합니다.
영속성 컨텍스트를 비우면서 em.clear 데이터베이스에 있는 객체들을 조회한 결과로

order 엔티티가 데이터베이스에 저장(save->insert)되고 그 후 영속성 전이로 인해 orderItem 엔티티가 insert됩니다.
order 주문이 orderItem 3개를 담았으므로 3개가 조회되는지 테스트 assertEqulas(3, ~)를 정상적으로 통과합니다.
```
## 고아 객체 제거
```
부모 엔티티와 연관 관계가 끊어진 자식 엔티티를 고아 객체라고 합니다.
영속성 전이 기능과 같이 사용하면 부모 엔티티를 통해서 자식의 생명 주기를 관리할 수 있습니다.
고아 객체 기능은 참조하는 곳이 하나일 때만 사용해야 합니다.
```
#### Order의 @OneToMany orphanRemoval 옵션 추가
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/60e0c99b-6686-4e22-b3f5-56fd47d85a19)
```
고아 객체 제거를 사용하기 위해서 주문엔티티(부모)에서 주문아이템(자식)를 삭제했을 때 orderItem 엔티티가 삭제되는 지 테스트 하였습니다. @OneToMany에 orphanRemoval 옵션을 true로 지정하였습니다.
```
#### OrderTest 고아 객체 제거 테스트
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/872ec615-afdd-4896-8c1e-9702f294b84f)
```
주문 데이터를 생성해서 저장하고 order 엔티티에서 관리하고 있는 orderItem 리스트의 0번째 인덱스 요소를 제거합니다. 부모 엔티티와 연관 관계가 끊어졌기 때문에 고아 객체를 삭제하는 쿼리문이 실행됩니다.
```
#### 고아 객체 제거 테스트 결과
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/80f5de0d-f3d9-42bd-be33-a399f6ac11f7)

## 지연 로딩
```
엔티티를 조회할 때 연관된 엔티티를 함께 조회하는 즉시 로딩을 먼저 알아보겠습니다.
```
#### OrderItemRepository
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/cd90e5b7-0e7e-415d-9419-c5fad65590c7)
```
주문 상품 데이터를 저장할 Repository를 생성해줍니다.
```
#### OrderTest 수정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/067907d0-8ad5-4726-aaeb-fe83e434391b)
```
기존에 생성되어 있던 주문생성메소드를 이용하여 주문을 생성하고 order 엔티티에 저장한 orderItem을
조회합니다.
```
#### OrderItem 즉시 로딩 조회 결과
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/2c2e8fa5-98e6-4c6c-aaf3-1ea76311dd76)
```
orderItem 엔티티 하나를 조회했을 뿐인데 order_item 테이블과 item,orders,member 테이블을 조인해서 한꺼번에 가져오는 것을 알 수 있습니다.
작성하고 있는 비즈니스 로직에서 사용하지 않을 데이터도 가져오는 것은 개발자가 쿼리가 어떻게 실행될지 예측할 수 없게 하며
사용하지 않는 데이터도 한꺼번에 조회하므로 성능 문제도 있을 수 있습니다.
 따라서 즉시 로딩은 실무에서는 사용하기 힘듭니다.
```
#### OrderItem FetchType.Lazy
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/50653786-e6af-4cb6-8ddd-2230ed3aaa9a)
```
일대일, 다대일(@OneToOne, @ManyToOne)은 매핑 기본 전략으로 FetchType.EAGER 즉시 로딩 전략을 사용합니다.
즉시 로딩을 사용하는 대신에 지연 로딩 방식을 사용합니다. OrderItem에서 FetchType.Lazy 방식으로 설정합니다.
```
#### OrderItem 지연로딩 조회 결과
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/a707ba86-211b-4772-b481-0ac3fb63cc5e)
```
orderItem 엔티티만 조회하는 쿼리문이 실행되는 것을 알 수 있습니다.
Order클래스 조회 결과 HibernateProxy 객체가 들어가있는 것을 알 수 있는데 이 프록시 객체는 실제로 사용되기 전까지
데이터 로딩을 하지 않고, 실제 사용 시점에 조회 쿼리문이 실행됩니다.
```
#### 모든 엔티티 매핑 전략에 지연로딩 설정
#### Cart Entity fetch Lazy
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/7f91bf3a-1984-43a6-bff1-1cbf0d6f70a7)
#### CartItem Entity fetch Lazy
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/d8716ed0-b8f6-47f8-b612-c4cfcc978e70)
#### Order Entity fetch Lazy
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/718628df-965f-42c9-b48f-f9203bf0c4e2)
```
일대일, 다대일 어노테이션의 기본 전략은 EAGER 즉시로딩이지만 일대다 어노테이션의 기본전략은 LAZY 지연로딩입니다.
하지만 전략을 설정하지 않았을 때 어떤 어노테이션이 즉시로딩인지 지연로딩인지 구분되지 않기 때문에 모든 매핑되는 엔티티의
전략에 지연로딩을 명시해줍니다.
```

## Auditing을 이용한 엔티티 공통 속성 공통화
```
Spring Data Jpa에서는 Auditing 기능을 제공하여 엔티티가 저장 또는 수정될 때 자동으로 등록일, 수정일, 등록자, 수정자를
입력해줍니다. 이런 공통 멤버 변수들을 추상 클래스로 만들고 해당 클래스를 상속받는 형태로 엔티티를 리팩토링합니다.
```
#### Auditing Class Diagram
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/3227e147-1666-4649-b4e7-0dff4ad6d726)
#### AuditorAwareImpl
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/b4e04d60-2f24-4e92-9030-5bb412844d72)
```
현재 로그인한 사용자의 정보를 등록자와 수정자로 지정하기 위해서 AuditorAware 인터페이스를 구현한 클래스를 생성합니다.
```
#### AuditConfig
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/1254b74e-d0c6-43c6-883d-9eca63120452)
```
Auditing 기능을 사용하기 위해서 Config 파일을 생성합니다.
```
#### BaseTimeEntity
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/3fc4fd2a-650d-4a4c-9cb8-16558c447a06)
```
등록자, 수정자를 넣지 않고 등록일, 수정일만 넣는 테이블을 위한 BaseTimeEntity 추상 클래스를 생성합니다.
```
#### BaseEntity
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/8a0d3e04-32d7-4876-bda5-2a51f63d6eae)
```
BaseTimeEntity를 상속받고 등록자, 수정자를 추가한 BaseEntity 추상 클래스를 생성합니다.
```
#### Member 수정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/14b933a1-40a2-449a-bbc6-b9878c0cd3c6)
```
Member 엔티티에 Auditing 기능을 적용하기 위해서 BaseEntity 클래스를 상속하도록 코드를 수정합니다.
```
#### MemberTest
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/3ee30907-07a4-4ff7-ad98-fcb952b1178d)
```
회원 엔티티 저장 시 자동으로 등록자, 수정자, 등록시간, 수정시간이 저장되는지 테스트를 진행합니다.
```
#### MemberTest Audting 테스트 실행 결과
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/4563becf-509d-4aba-9e4d-856e4f529a2d)
```
member 엔티티를 저장할 때 등록자나 등록일 등을 지정해주지 않았지만
저장 시간과 현재 로그인한 계정의 이름으로 저장되는 것을 확인할 수 있습니다.

org.springframework.security의 spring-security-test 의존성을 추가하여 스프링 시큐리티에서 제공하는
가짜 로그인 객체를 생성해주는 @WithMockUser를 사용하여 gildong 유저를 생성한 후 테스트 하였습니다.
```
#### 공통 변수가 있는 모든 엔티티가 BaseEntity를 상속하도록 설정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/bbb3e640-9722-45ca-8776-e8d19516f956)
#### 공통 변수 삭제
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/14bac198-c74a-406b-b1a7-e2a47a73258b)
#### BaseEntity 상속
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/60b55b11-a508-4f39-9b63-c595fcf773ac)
```
등록일(regTime), 수정일(updateTime) 변수가 공통적으로 있는 OrderItem, Cart, CartItem, Item, Order 엔티티를 수정합니다.
기존에 있던 regTime, updateTime 변수를 삭제하고 BaseEntity를 상속받도록 코드를 수정하였습니다.

+ 모든 엔티티가 BaseEntity를 상속하도록 수정하였습니다.
```








