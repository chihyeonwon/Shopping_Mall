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
#### application.properties 설정 추가하기
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/d8fa9d12-708a-4d71-9a64-91e60a6ce4fe)
```
상품 이미지 경로와 리소스 업로드 경로 프로퍼티를 추가합니다.
```
#### WebMvcConfig 
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/4175f411-354e-4392-964a-1b10fb20ee64)
```
WebMvcConfigurer 인터페이스를 구현한 WebMvcConfig 파일을 작성합니다.
addResourceHandlers 메소드를 통해서 자신의 로컬 컴퓨터에 업로드한 파일을 찾을 위치를 설정합니다.
```
#### FileService
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/0f3fd38e-6092-45b4-8e0c-3d75055feb0f)
```
파일을 처리하는 FileService 클래스를 작성합니다.
파일을 업로드하는 메소드와 삭제하는 메소드를 작성하였습니다.

파일을 업로드하는 메소드에서는 서로 다른 객체에 이름을 부여하는 uuid와 확장자를 합쳐서 새로운 파일이름을 만들고
그 파일이름으로 파일경로를 생성한 후 생성자로 넘겨줘서 파일 출력 스트림을 생성합니다.

파일을 삭제하는 메소드에서는 파일이 저장된 경로를 이용하여 파일 객체를 생성한 후 객체의 존재여부에 따라 삭제를 합니다.
```
#### ItemImgRepository
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/f0df238f-4df7-4492-981d-2997490a6f3f)
```
상품 이미지 정보를 저장하는 ItemImgRepository 인터페이스를 작성합니다.
```
#### ItemImgService
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/ab403154-6050-4528-9765-aa7664a510eb)
```
상품 이미지를 업로드하고, 상품 이미지 정보를 저장하는 ItemImgService 클래스를 작성합니다.
```
#### ItemService
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/aee818fb-10a4-4e96-aa95-c6ecabb44336)
```
상품을 등록하는 ItemService 클래스를 작성합니다.

상품 등록 폼으로부터 입력 받은 데이터로 item 객체를 생성합니다.
상품 데이터를 저장한 후 첫 번째 이미지일 경우 상품 이미지 여부 값을 Y로하고 나머지는 N으로 합니다.
상품의 이미지 정보를 저장합니다.
```
#### ItemController
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/8de8d890-02fd-4ff0-908c-a44a4dd5800b)
```
상품을 등록하는 url을 ItemController 클래스에 추가합니다.

상품 등록시 필수값(첫 번째 상품이미지)가 없다면 다시 상품 등록 페이지로 전환합니다.
상품 저장 로직을 호출합니다. 상품이 정상적으로 등록되었다면 메인 페이지로 이동합니다.
```
#### 상품 등록 테스트 데이터 입력
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/e6379185-f693-4ce5-9bb7-10988701902c)
#### 상품 등록 테스트 입력 후 메인 화면 이동
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/7e046eb6-5356-4fc6-a956-ff26ecb96e9c)
```
저장 버튼을 눌렀을 때 상품이 정상적으로 저장되었다면 다음과 같이 메인페이지로 이동합니다.
```
#### 상품 등록 후 이미지 저장 결과
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/5426d941-ef23-43f9-96df-c0739b7f2e63)
```
파일 업로드 경로인 C:/shop/item 경로에 업로드한 청바지 사진과 스웨터 사진이 올라온 것을 확인할 수 있습니다.
```
## 상품 수정하기
#### ItemService
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/aa2175ae-ae4b-4a1d-929b-e4dfbbbfc0d3)
```
등록된 상품을 불러오는 getItemDtl 메소드를 ItemService 클래스에 추가합니다.
상품 데이털르 읽어오는 트랜잭션에 읽기 전용을 설정하여 JPA가 변경감지를 수행하지 않도록 합니다.
상품의 이미지를 조회하고 조회한 ItemImg 엔티티를 ItemImgDto 객체로 만들어서 리스트에 추가합니다.
상품의 아이디를 통해서 상품 엔티티를 조회합니다.
```
#### ItemController
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/01d2592b-6ba7-40ef-9b1f-24adb7c9e78b)
```
조회한 상품 데이터를 모델에 담아서 뷰로 전달합니다.
저장한 상품을 상품의 아이디를 이용해서 조회할 수 있습니다.
```
#### 상품 수정 페이지
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/033b7d3a-2145-4ce5-bc67-bb36d2eeda47)
```
http://localhost:8000/admin/item/상품아이디를 입력해보겠습니다.
상품아이디로 조회되는 상품이 없을 경우에는 상품 등록페이지로 이동하고
상품아디디로 조회되는 상품이 있을 경우에는 등록한 상품이 정상적으로 보이는 것을 확인할 수 있습니다.
```
#### ItemImgService
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/26454ebb-77e7-4f31-997d-fc270aec5a8d)
```
상품 이미지 수정하는 updateItemImg 메소드를 작성합니다.
상품 이미지를 수정할 때는 변경감지 기능을 사용합니다.
기존 등록한 이미지 파일을 삭제하고 업데이트한 이미지로 업로드합니다.
변경된 상품이미지 정보를 세팅합니다. savedItemImg는 영속 상태이므로 데이터를 변경하는 것만으로도
변경 감지 기능이 동작하여 트랜잭션이 끝날 때 update 쿼리가 실행됩니다.
```
#### Item
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/2662a1a2-e6c2-456c-b10d-b0e72dcb06bc)
```
Item 상품 엔티티에 상품을 업데이트하는 로직을 구현합니다.
엔티티 클래스에 비즈니스 로직을 추가하여 객체지향적(코드 재활용 목적)으로 코딩할 수 있습니다.
```
#### ItemService
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/b940262a-14ed-4aa9-8921-1de6c6ec3226)
```
상품을 업데이트할 때도 변경감지 기능을 사용합니다.
상품등록할 때 전달받은 상품아이디로 상품엔티티를 조회한 후 상품 등록화면에서 입력받은 데이터로 상품 엔티티를 업데이트합니다.
상품이미지 아이디를 조회하고 상품이미지를 업데이트합니다.(변경감지기능 updateItemImg)
```
#### ItemController
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/3564cc91-5afe-4235-a932-8fc0664f1509)
```
상품을 수정하는 url을 itemController 클래스에 추가합니다. 상품을 등록할 때 추가했던 코드와 비슷합니다.
```
#### 상품 수정 테스트
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/9f6e1061-0e04-4917-a48b-0820f08f0904)
```
새로운 테스트 상품을 등록합니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/286cdc92-7e71-43b5-93be-c10fe2e681ab)
```
새로운 테스트 상품의 상품아이디를 확인하고 item_id = 352입니다. http://localhost:8000/admin/item/352 경로로 접속합니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/0a71d902-d9dc-40fb-a02a-a7883af62f43)
```
해당 상품의 수정 페이지로 이동하게 되고 판매 상태를 품절, 가격을 20000, 재고를 200, 상품 상세 내용을 상품 수정 테스트,
상품의 이미지를 청바지에서 스웨터로 수정해보겠습니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/d9ed4c25-8932-4459-a73f-1a1d87ce40c1)
```
기존에 올린 이미지 파일은 삭제되고 신규로 업로드한 이미지가 스웨터로 변경되고 메인화면으로 이동된 것으로 보아
상품 수정이 정상적으로 이루어진 것을 확인할 수 있습니다.
```
## 상품 관리하기
```
상품을 조회하는 조건(상품 등록일, 판매 상태, 상품명 또는 상품 등록자 아이디)를 설정 후 페이징 기능을 통해
일정 개수의 상품만 불러오며, 선택한 상품 상세 페이지로 이동할 수 있는 기능까지를 Querydsl을 이용하여 구현합니다.
```
#### 추가된 엔티티들의 Qdomain 생성
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/611d487c-85b9-4507-b1e2-46e7e6a04992)
```
maven compile을 실행하여 지금까지 작성한 엔티티 클래스들의 Qdomain 클래스를 생성합니다.
```
#### ItemSearchDto
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/9351f7a4-d7fa-41f3-b1b3-254e23579087)
```
상품 데이터 조회 시 상품 조회 조건을 가지고 있는 ItemSearchDto 클래스를 생성합니다.
```
#### Querydsl + Spring Data Jpa
```
Querydsl을 Spring Data Jpa와 함께 사용하기 위해서는 3단계의 과정으로 사용자 정의 리포지토리를 정의해야 합니다.
1. 사용자 정의 인터페이스 작성
2. 사용자 정의 인터페이스 구현
3. Spring Data Jpa 리포지토리에서 사용자 정의 인터페이스 상속
```
#### ItemRepositoryCustom
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/dd172dc1-f3fc-4077-9c46-4a032d6c3fd6)  
```
사용자 정의 인터페이스를 작성합니다.
Page<Item> 객체를 반환하는 getAdminItemPage 메소드를 작성합니다.
파라미터로 상품 조회 조건을 가지고 있는 itemSearchDto 객체와 페이징 정보를 담고 있는 pageable 객체를 받습니다.
```
#### ItemRepositoryCustomImpl
```
ItemRepositoryCustom 인터페이스를 구현하는 ItemRepositoryCustomImpl 클래스를 작성합니다.
BooleanExpression을 반환하는 메소드를 만들고 해당 조건들을 queryFactory의 where절에 사용합니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/547d507a-f1e3-4fcf-b512-98d5a95e90da)
```
상품 판매 상태에 따른 상품 조회 조건입니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/6f76cb49-a1fc-4ef7-bd65-eaad393208da)
```
searchDateType의 값에 따라서 dateTime의 값을 이전 시간의 값으로 세팅 후 해당 시간 이후 등록된 상품만 조회합니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/b6332a4c-47c0-4ec8-a782-9464ad6dc9b2)
```
searchBy의 값에 따라서 상품명에 검색어를 포함하고 있는 상품 또는 상품 생성자의 아이디에 검색어를 포함하고 있는 상품을
조회하도록 합니다.
```
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/ca392efb-d7ca-464a-803f-c41cbc2c5b16)
```
getAdminItemPage 메소드를 오버라이딩하여 구현합니다. 조회한 데이터를 Page클래스의 구현체 PageImpl 객체로 반환합니다.
```
#### ItemRepository 수정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/87490afe-8036-4152-a237-4f107efb0c89)
```
ItemRepository 인터페이스에서 ItemRepositoryCustom 인터페이스를 상속합니다.
상품 관리 페이지 목록을 불러오는 getAdminItemPage 메소드를 사용할 수 있습니다.
```
#### ItemService 수정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/02dbfcf4-d36f-4140-8491-28a8c5b60a94)
```
ItemService 클래스에 상품 조회 조건과 페이징 정보를 파라미터로 받아서 상품 데이터를 조회하는 getAdminItemPage() 메소드를
추가합니다.
```
#### ItemController 수정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/75a7eaca-e915-4337-8e6f-1ab24cd57de4)
```
ItemContoller 클래스에 상품 관리 화면 이동 및 조회한 상품 데이터를 화면에 전달하는 로직을 구현하였습니다.
한 페이지당 총 3개의 상품만 보여주도록 하였습니다.
```
#### itemMng.html script
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/3bccbf89-5094-4934-87ea-d06c1e81cf1b)
```
itemMng html의 스크립트 쪽 코드입니다.
상품 검색을 할 때 주의해야 할 점은 검색 버튼을 클릭할 때 조회할 페이지 번호를 0으로 설정해서 조회해야 한다는 점입니다.
그래야 현재 조회 조건으로 상품 데이터를 0페이지부터 조회합니다.
```
#### itemMng.html Table
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/e6699013-abc3-49b8-acae-d343c2eda8a4)
```
Table 영역에서는 조회한 상품 데이터를 그려줍니다.
```
#### itemMng.html 하단의 페이지 번호
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/6e626a5e-2ad6-418a-ba7e-f3085b822b4a)
```
첫 번째 페이지면 previous버튼을 눌렀을 때 disabled으로 선택 불가능하도록 합니다.
previous 버튼 클릭 시 현재 페이지에서 이전 페이지로 이동하도록 page 함수를 호출합니다.

마지막 페이지면 next 버튼을 눌렀을 때 disabled으로 선택 불가능하도록 합니다.
next 버튼 클릭 시 현재 페이지에서 다음 페이지로 이동하도록 page 함수를 호출합니다.
```
#### 상품 관리 화면 구현
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/208a44d9-2b72-4889-aa9c-131bb76b8747)
```
상품 관리 메뉴를 클릭하면 상품 관리 화면을 볼 수 있습니다. 하단의 상품 조회 조건을 여러 가지 선택 후 검색해보면
해당 조건에 맞는 상품들만 출력되는 것을 볼 수 있습니다.
```
#### attempt to recreate a file for type 빌드 오류 해결방법
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/9f16fb9e-d7b6-4f61-a30e-5d07e60bf0d0)
```
엔티티로 Qdomain 클래스를 생성할 때 파일이 이미 존재하고 있기 때문에 발생하는 오류로
target/generated-sources 파일을 통째로 삭제한 후 빌드하면 오류가 해결된다.
```

## 메인 화면

## 상품 상세 페이지







