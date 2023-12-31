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
