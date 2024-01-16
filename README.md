## Cart

## 장바구니 담기
#### CartItemDto
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/0e7c18f2-e3f1-45d7-838a-1ebf9c543346)
```
장바구니에 담을 상품 클래스 CartItemDto를 작성합니다.
상품 아이디와 수량을 전달 받습니다.
```
#### Cart
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/30344631-039a-46ec-ab81-a31e77f0a990)
```
회원의 장바구니를 생성하는 createCart 메서드를 Cart 클래스에 작성합니다.
```
#### CartItem
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/4036d7a1-c5ad-4120-8889-d8adfd9afc43)
```
장바구니에 담을 상품 엔티티를 생성하는 createCartItem 메소드와 장바구니에 담을 수량을 증가시켜 주는 addCount
메소드를 작성합니다.
```
#### CartRepository
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/df8d4f38-2313-4b97-891a-ebf11768db54)
```
현재 로그인한 회원의 Cart 엔티티를 찾기 위해서 쿼리메소드를 추가합니다.
```
#### CartItemRepository
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/1faf59ab-af3e-4efa-bbfc-1e4fed73d5f9)
```
장바구니에 들어갈 상품을 저장하거나 조회하기 위해서 CartItemRepository 인터페이스를 작성합니다.
```
#### CartService
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/a303b985-9b31-4497-8f18-0346bc81280a)
```
장바구니에 상품을 담는 addCart 로직을 작성합니다.
```
#### CartController
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/de88db2a-e8d5-4421-872e-bc691e47d4c7)
```
장바구니와 관련된 요청들을 처리하기 위해서 CartController 클래스를 작성합니다.
```
#### itemDtl.html script
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/b2c0bff9-5c65-4521-8781-b73a12b70b4c)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/6305f715-27b8-4717-8e9e-e67c99904588)
```
장바구니 담기 로직을 호출하는 addCart 스크립트 함수를 작성합니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/de99d785-45ac-4350-ba6d-bbaf13a25a55)
```
장바구니 담기 onclick 속성에 작성한 addCart 함수를 추가합니다.
```
#### 상품 장바구니 담기 구현
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/56b1b682-c7a4-4559-8434-799f49093b56)
```
장바구님 담기 버튼을 클릭하면 상품을 장바구니에 담았다는 메시지가 나타나고 확인을 누르면 메인 페이지로 이동합니다.
```



## 장바구니 조회하기

## 장바구니 상품 주문하기








