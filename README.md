## 상품 등록하기
#### ItemImg
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/0bdc90b4-11c9-4fd9-8846-f7a6ad844c85)
```
상품의 이미지를 저장하는 상품 이미지 엔티티를 작성합니다.
이미지 파일명, 원본 이미지 파일명, 이미지 조회 경로, 대표 이미지 여부를 갖도록 설계하였습니다.

대표 이미지 여부가 "Y"인 경우 메인 페이지에서 상품을 보여줄 때 사용합니다.

하나의 상품에 여러 개의 상품 이미지를 등록할 수 있도록 다대일 단방향 매핑을 설정합니다.
```
#### modelmapper 의존성 추가
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/d10f3646-78b2-4e20-801d-8300696d7c0c)
```
상품 등록(Create) 및 수정(Update)에 사용할 데이터 전달용 DTO 클래스를 생성합니다.
이 때 상품 등록을 할 때는 DTO 객체를 엔티티 객체로 변환해주어야 하고
상품 수정을 할 때는 엔티티 객체를 DTO 객체로 변환해주는 작업을 해야 합니다.

이 작업은 반복적인 작업으로 상당한 시간을 소요하게 됩니다.
이를 도와주는 modelmapper 라이브러리를 사용합니다.
서로 다른 클래스의 값을 필드의 이름과 자료형이 같으면 getter, setter를 통해 값을 복사해서 객체를 반환해줍니다.
```
#### ItemImgDto
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/4c2e26e1-3603-449d-852d-76ae360530b1)
```
ItemImg 엔티티 객체를 파라미터로 받아서 ItemImg 객체의 자료형과 멤버변수의 이름이 같을 때 ItemImgDto로 값을
복사해서 반환해줍니다.
```
#### ItemFormDto
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/caabb33d-db99-4919-8b9d-70f9c7680dca)
```
상품 데이터의 정보를 전달하는 DTO를 생성합니다.

상품 저장 후 수정할 때 상품 이미지 정보를 저장하는 리스트와 상품의 이미지 아이디를 저장하는 리스트,
modelMapper를 이용하여 엔티티 객체와 dto 객체 간의 데이터를 복사하여
복사한 객체를 반환해주는 메소드를 포함합니다.
```
#### ItemController 수정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/d5bc0f79-4498-4fdf-846c-03c7a79bfb2f)
```
기존에 상품 등록 페이지로 접근할 수 있도록 만들어 두었던 ItemController 페이지를 수정합니다.
ItemFormDto를 model 객체에 담아서 뷰로 전달하도록 합니다.
```
#### ItemForm.html 수정
```
상품 등록 폼 페이지 화면은 소스코드의 양이 길어서 구분하여 코드를 설명합니다.
```
#### ItemForm.html <script>
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/825530e0-a625-49a4-b94e-4817e8704e72)
```
상품 등록 시 실패 메시지르 받아서 상품 등록 페이지에 재진입 시 alert를 통해서 실패 사유를 보여줍니다.
파일 첨부 시 이미지 파일인지 검사를 합니다. 스크립트에서 검사를 한 번 하고, 서버에서 한 번 더 검사합니다.

서버쪽에서 말고 스크립트에서 검사하는 이유는 서버에 요청하고 클라이언트에 반환하는 등 리소스를 소모하기 때문입니다.
```
#### ItemForm.html <Form>
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/2752fd50-ca5e-46be-ab6b-10cc54407dfd)
```
파일을 전송할 때는 form 태그에 enctype(인코딩 타입)값으로 multipart/form-data를 입력합니다.
모든 문자를 인코딩하지않음을 명시합니다. 이 속성은 method의 속성값이 post인 경우에만 사용할 수 있습니다.
```
#### ItemForm.html <SellStatus>
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/4fd69642-b800-4f2c-a6bf-9f9f0ae9341b)
```
상품 판매 상태의 경우 판매 중과 품절 상태가 있습니다.
상품 주문이 많이 들어와서 재고가 없을 경우 주문 시 품절 상태로 변경
상품 등록만 먼저 해놓고 팔지 않을 경우에도 이용할 수 있습니다.
```
#### ItemForm.html <ItemImg>
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/9b67111f-3091-410e-8dc4-9a2d2e287df5)
```
상품 이미지의 경우 상품을 등록할 때와 상품을 저장할 때 2가지의 경우로 나눕니다.

상품 이미지 정보를 담고 있는 리스트가 비어 있다면 상품을 등록하는 경우입니다.

상품 이미지 정보를 담고 있는 리스트가 비어있지 않다면 상품을 수정하는 경우입니다.
```
#### ItemForm.html 이미지 수정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/f1c5c125-d223-4cb6-b6bd-e3c26679f57f)
```
상품 이미지 정보를 담고 있는 리스트가 비어있지 않을 때 상품 아이디가 없는 경우(상품을 처음 등록할 경우)
저장 로직을 호출하는 버튼을 보여줍니다.

상품의 아이디가 있는 경우 수정 로직을 호출하는 버튼을 보여줍니다.
```
#### 상품 등록 페이지 구현
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/b1cbcc3a-1043-4d8c-b1b3-8e33bcd00a7b)
```
상품 등록 페이지를 구현하였습니다.

상품 판매 상태 말고도 상품 타임 세일 등의 기능을 추가하면 상품 구매자의 구매 욕구를 더 증가하도록 하는 등의
기능을 추가할 수 있을 것 같습니다.

상품 상세 이미지 중 대표 이미지등을 관리할 수 있습니다.
```

## 상품 수정하기

## 상품 관리하기

## 메인 화면

## 상품 상세 페이지







