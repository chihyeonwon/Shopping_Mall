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
## 주문 이력 조회하기

## 주문 취소하기

