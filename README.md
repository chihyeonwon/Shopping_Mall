## Order

## 주문 기능 구현하기
#### OutOfStockException
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/9e51bfdd-1f3e-4200-b5b1-78c9438de975)
```
상품의 주문 수량보다 재고의 수가 적을 때 발생시킬 exception을 정의합니다.
RuntimeException을 상속받는 OutOfStockException 클래스를 작성합니다.
```
#### Item
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/583b7fc0-0187-475f-9ce7-a73ec225e70c)
```
상품을 주문할 경우 상품의 재고를 감소시키는 메소드를 Item 엔티티 클래스 안에 작성합니다.
상품의 재고 수량에서 주문 후 남은 재고 수량을 구합니다.
상품의 재고가 주문 수량보다 작은 경우 재고 부족 예외를 발생시킵니다.
주문 후 남은 재고 수량을 상품의 현재 재고 값으로 할당합니다.
```
#### OrderItem
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/0149cffe-e21c-4d0d-965c-4fcf81af00ef)
```
주문할 상품과 주문 수량을 통해 OrderItem 객체를 만드는 createOrderItem 메소드와
주문 가격과 주문 수량을 곱해서 해당 상품을 주문한 총 가격을 계산하는 getTotalPrice 메소드를 추가합니다.
```
#### Order
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/99833b9c-94fe-4688-8ce1-bae7541d5238)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/3c5d7a21-72be-49b0-81bc-e282f28174cc)
```
orderItems에 주문 상품 정보들을 담아주는 addOrderItem 메소드와
생성한 주문 상품 객체를 이용하여 주문 객체를 만드는 createOrder 메소드를 작성하겠습니다.
또 총 주문 금액을 구하는 getTotalPrice 메소드를 작성하였습니다.
```
#### OrderDto
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/a7e0f389-2236-49c6-a3c5-fd996f354ce8)
```
주문할 상품의 아이디와 주문 수량을 전달받을 OrderDto 클래스를 작성합니다.
주문 최소 수량은 1개, 주문 최대 수량은 999개로 제한하였습니다.
```
#### OrderService
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/08800c56-7801-4737-b61a-014c8ea6681d)
```
주문 로직을 작성하기 위해 OrderService 클래스를 작성합니다.

주문할 상품, 현재 로그인한 회원의 이메일 정보를 이용한 회원 정보를 조회합니다.

주문할 상품 엔티티와 주문 수량으로 주문 상품 엔티티(OrderItem)을 생성합니다.

회원 정보와 주문할 상품 리스트 정보를 이용하여 주문 엔티티(Order)를 생성합니다.

생성한 주문 엔티티를 저장합니다.
```
#### OrderController
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/c05066f5-24c3-4260-9570-300e59b97013)
```
주문 관련 요청들을 처리하기 위해서 OrderController 클래스를 작성합니다.
상품 주문에서 웹 페이지의 새로 고침 없이 서버에 주문을 요청하기 위해서 비동기 방식을 사용하였습니다.
```
#### itemDtl.html (Ajax 비동기 방식)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/0a07125a-fa05-4d15-bc8f-f4a349c2d4e9)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/348fe7d1-bb20-40c1-a808-a401884bfb77)
```
form 태그를 사용하여 submit 방식으로 서버에 요청하게 되면 페이지가 새로 고침이 된다는 단점이 있습니다.
Ajax를 이용하여 주문 로직을 비동기 방식으로 호출하였습니다. 비동기 방식을 사용하면 웹 페이지의 새로고침없이
필요한 부분만 불러와 사용할 수 있다는 장점이 있습니다.

<script th:inline="javascript"> </script> 자바스크립트 영역에 order() 함수를 추가합니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/7be98c04-2ceb-44cb-8dda-b4f80b67e5e9)
```
주문하기 버튼을 클릭했을 때 order() 함수를 호출하도록 onclick 속성을 추가합니다.
```
#### 주문하기 구현 (재고 > 주문 수량)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/4a120aa3-92c1-495b-b9ef-56c911454da0)
```
주문하기 버튼을 누르면 주문이 완료되었다는 메시지가 나타나고 확인을 클릭하면 메인페이지로 이동합니다.
```
#### 주문하기 구현 (재고 < 주문 수량)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/5f2dd3c2-8441-4a70-ae0d-03b95270fea6)
```
주문 수량이 재고보다 많은 경우 상품의 재고가 부족하다는 메시지와 현재 남은 재고 수량을 보여주는 메시지가 나타납니다.
```
#### 주문하기 구현 (로그인을 안했을 때)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/41231411-cce8-4071-97ff-c6b130f4cb21)
```
로그인을 안했을 때 상품을 주문하려고 하면 로그인 후 이용주세요라는 메시지가 나타나고 확인을 클릭하면
로그인 페이지로 이동합니다.
```
## 주문 이력 조회하기
#### OrderItemDto
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/3feda3f5-420d-40aa-896e-5d600b416cff)
```
조회한 주문 데이터를 화면에 보낼 때 사용할 OrderItemDto 클래스를 작성합니다.
```
#### OrderHistDto
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/71265372-47a4-4588-84d7-261ba459e83b)
```
주문 정보를 담을 OrderHistDto 클래스를 작성합니다.
```
#### OrderRepository
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/fbed80b3-92e2-4b1e-817e-4bb11d3704e6)
```
주문 이력을 조회하는 쿼리를 작성하였습니다.
@Query를 사용하여 JPQL의 형식으로 쿼리문을 작성하였습니다.
현재 로그인한 사용자의 주문 데이터를 페이징 조건에 맞춰서 조회합니다.
현재 로그인한 회원의 주문 개수가 몇 개인지 조회합니다.
```
#### ItemImgRepository
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/193911b7-9d96-4107-9bae-1b87998444fa)
```
ItemImgRepository 인터페이스에는 상품의 대표 이미지를 찾는 쿼리 메소드를 추가합니다.
구매 이력 페이지에서 주문 상품의 대표 이미지를 보여주기 위해서 추가합니다.
```
#### OrderService
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/303f98a1-ae6d-47b5-a7ef-0bd5c6660670)
```
주문 목록을 조회하는 getOrderHist 로직을 작성합니다.
```
#### OrderController
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/d18edf57-30ca-4474-a40c-87ac9ec2949d)
```
구매이력을 조회할 수 있도록 OrderController 클래스에 지금까지 구현한 로직을 호출하는 메소드인
OrderHist를 작성합니다.
```
#### orderHist.html
```
구매 이력 페이지를 작성합니다. 구매 이력 페이지는 지금까지 만들었던 페이지와 비슷하고
주문 목록 데이터를 보여주는 역할만 합니다.
```
#### 주문 이력 페이지 구현
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/eed3fb08-dbc8-44c7-8c17-d5ea829f84b3)
```
구매 이력 메뉴를 클릭하면 지금까지 주문했던 상품들의 목록을 화면에서 볼 수 있습니다.
```
## 주문 취소하기

