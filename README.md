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
#### CartItemDto
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/3395d632-b963-42e3-9b0c-06e2c8738ef0)
```
장바구니 조회 페이지에 전달할 장바구니 상품 Dto 클래스를 작성합니다.
JPQL로 쿼리 작성시 생성자를 이용해서 DTO로 바로 변환하는 방법을 사용합니다.
```
#### CartItemRepository
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/df64bcc5-0f6e-4061-bf4b-b598be738c40)
```
장바구니 페이지에 전달할 CartDetailDto 리스트를 쿼리 하나로 조회하는 JPQL문을 작성합니다.
성능최적화가 필요할 때 DTO의 생성자를 이용하여 반환 값으로 DTO 객체를 생성할 수 있습니다.
```
#### CartService
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/1ecc85a6-7a0e-4e33-ba18-910b926cead8)
```
현재 로그인한 회원의 정보를 이용하여 장바구니에 들어있는 상품을 조회하는 getCartList를 작성합니다.
```
#### CartController
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/d4dd5f1c-e60c-4906-b2e4-ab9f1f4e5749)
```
장바구니 페이지로 이동할 수 있도록 CartController 클래스에 orderHist 메소드를 작성합니다.
```
#### cartList.html script
```
조회한 장바구니 상품 정보를 이용하여 장바구니 목록을 보여주는 페이지를 구현합니다.
화면에서 구현해야 하는 이벤트가 많아서 자바스크립트 함수가 많습니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/104fff6e-28c2-4f50-8b4a-81bb0ec130fb)
```
총 주문 금액을 구하는 함수 입니다.
주문 상품을 체크하거나 해제할 경우 총 주문 금액을 구하는 getOrderTotalPrice 함수를 호출하도록 합니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/1d5e0bee-be96-48ed-8844-cc7d93f3b3f6)
```
장바구니 상품의 수량 변경 시 수량과 가격을 곱해서 상품금액을 변경하는 changeCount 함수입니다.
상품 금액을 변경 한 후 총 주문 금액을 변경하는 getOrderTotalPrice 함수를 호출합니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/4c8fcd39-4635-4b30-94da-e4461cc95f48)
```
장바구니에 들어있는 전체 상품을 체크하거나 체크 해제하는 함수입니다.
변경된 총 주문 금액을 계산하기 위해서 getOrderTotalPrice 함수를 호출합니다.
```
#### 장바구니 목록 조회 페이지 구현
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/69904673-a4f6-4480-9779-66bfc3043eda)
#### CartItem
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/637db164-9169-4c3c-97d6-8f98cc1a476b)
```
현재 장바구니에 담겨있는 수량을 변경하는 updateCount 메소드를 작성합니다. 
```
#### CartService
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/5627499b-e4c0-4800-80c9-35883bf7a962)
```
현재 로그인한 회원과 해당 장바구니 상품을 저장한 회원이 같은지 검사하는 validateCartItem 메소드와
장바구니 상품의 수량을 업데이트하는 updateCartItem 메소드를 작성합니다.
```
#### CartController
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/eec7402b-00d3-492d-bacf-a91556240695)
```
장바구니 상품의 수량을 업데이트하는 요청을 처리할 수 있도록 로직을 추가합니다.
```
#### cartList.html
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/d5f80b4a-a0bb-4302-9f5c-f8613ec51253)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/e2dc0767-6114-42e3-b786-25b1f758f139)
```
장바구니 상품의 수량을 수정할 경우 업데이트 요청을 하도록하는 updateCartItemCount 자바스크립트 함수를
추가해줬습니다. 작성한 updateCartItem 함수를 기존에 작성한 changeCount()함수 마지막에 추가합니다.
```
#### 장바구니 목록
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/f0c5de96-e776-49b1-8328-61a5ffec5f85)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/dcf03dd9-4096-4712-a270-16e04aa2801e)
```
장바구니 상품의 수량을 변경 후 페이지를 새로고침하면 변경된 수량이 유지되는 것을 볼 수 있습니다.

장바구니 목록 페이지에서 장바구니 상품의 수량을 변경할 수 있게 되었습니다.
```
#### CartService
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/6fd4b598-e066-48d9-b8f0-a157586bc0f4)
```
상품 정보에 있는 X 버튼을 클릭할 때 장바구니에 넣어놓은 상품을 삭제하기 위해서
장바구니 상품 번호를 파라미터로 받아서 삭제하는 deleteCartItem 메소드를 작성합니다.
```
#### CartController
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/6e335770-3993-4418-be13-4ccd8e2f889c)
```
장바구니 상품을 삭제하는 요청을 처리할 수 있도록 로직을 추가합니다.
```
#### cartList.html
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/b19b2d20-2578-49ae-b278-15d2dd895410)
```
x 버튼을 클릭하면 해당 상품을 삭제하는 deleteCartItem 자바스크립트 함수를 작성합니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/657eabae-6c46-4056-bb62-54fc8bc69e3b)
```
삭제 버튼의 onclick 속성에 deleteCartItem() 함수가 호출되도록 추가합니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/832fca69-f881-45a2-befe-80e89e61ec81)
```
삭제 버튼 x를 눌러서 해당 상품이 삭제되는 것을 확인할 수 있습니다.
```
## 장바구니 상품 주문하기
#### CartOrderDto
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/410d142e-e037-40b7-825e-1536c35547ae)
```
주문할 상품 데이터를 전달할 DTO 클래스를 작성합니다.
```
#### OrderService
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/83ca46a2-405e-4f1e-b83c-0fb1b541d1cf)
```
장바구니에서 주문할 상품 데이터를 전달받아서 주문하는 Orders 메서드 작성합니다.
```
#### CartService
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/43c4a4f5-fe5f-41fd-a964-25cbe667a4a9)
```
orderDto 리스트 생성 및 주문 로직 호출, 주문한 상품은 장바구니에서 제거하는 orderCartItem 메서드를 작성합니다.
```
#### CartController
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/603a9244-2ece-4d52-ba77-89dcf4451c02)
```
CartController 클래스에 장바구니 상품의 수량을 업데이트하는 요청을 처리할 수 있도록 로직을 작성합니다.
```
#### cartList.html
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/1837974a-7f9c-4c9d-a143-3549bb29fa10)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/f3996338-c5d1-4817-b351-9b2cd3900464)
```
장바구니에서 선택한 상품 주문을 요청하는 orders() 자바스크립트 함수를 추가합니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/ffaf5807-13d8-4424-a399-3e3b8e3c31a6)
```
주문하기 버튼의 onclick 속성에 orders()함수가 실행될 수 있도록 추가합니다.
```
#### 장바구니 상품 선택
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/deebc9a2-986f-4522-8059-3614400a15e1)
#### 장바구니 상품 주문 성공
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/da8e5300-1b63-4b1e-a251-622d9f33e249)
#### 구매 이력 확인
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/dd8e5e65-cd9c-418b-8314-472959f0e227)





