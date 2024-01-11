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

## 주문 이력 조회하기

## 주문 취소하기

