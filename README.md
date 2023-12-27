## Thymeleaf
```
화면을 동적으로 만들어주는 서버 사이드 템플릿 엔진인 Thymeleaf를 사용하여서 개발하였습니다.
Thymeleaf의 확장명은 .html이며, 문법은 html 태그 안쪽에 속성으로 사용됩니다.
Thymeleaf는 스프링에서 권장하는 서버 사이드 템플릿 엔진입니다. 이것 외에도 jsp, freemarker, groovy, mustache 등이 있습니다.
```
#### Thymeleaf 예제용 컨트롤러 작성
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/6aee43b1-3c08-4b1b-aa74-4f824629ce25)
```
url의 /thymeleaf 경로로 오는 요청을 처리하기 위해 RequestMapping 어노테이션을 ThymleafExController에 줘서
ThymeleafExController가 처리하도록 합니다.

/thymeleaf 경로 뒤에오는 /ex01 경로로 오는 요청은 thymeleafExample01 메소드가 처리하도록 하고 이 메소드에서
모델 객체를 이용해서 뷰에 전달한 데이터를 key, value 구조로 넣어줍니다.(model.addAttribute(key,value)
```
#### 서버용 Thymeleaf html 파일 작성
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/cef2f76f-84ff-4569-a30d-5dd4ab9b526b)
```
컨트롤러에서 추가한 키의 데이터를 화면에 출력하도록 <body> 태그 안에 th:text=${key} 값의 형태로 넣어줍니다.
Controller에서 넘겨준 데이터가 화면에 출력되는 것을 알 수 있습니다.
```
#### ShopApplication 실행결과
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/dc763957-1698-4a80-9127-93740faab1e3)

## Spring Boot Devtools
```
Spring Boot Devetools는 애플리케이션 개발 시 생산성을 향상시킬 수 있는 유용한 기능들을 제공합니다.
그 중 세 가지(Automatic Restart, Live Reload, Property Defaults)를 활성화해보겠습니다.
```
#### Automatic Restart 적용하기
#### pom.xml
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/e9c6008c-b04e-402d-ba8f-a4ec4b72138b)
```
spring boot devtools 의존성을 추가합니다.
```
#### Automatic Restart
[IntelliJ 자동빌드 설정 방법](https://velog.io/@jodawooooon/IntelliJ-%EC%9E%90%EB%8F%99-%EB%B9%8C%EB%93%9C-%EC%84%A4%EC%A0%95-%EB%B0%A9%EB%B2%95-Registry%EC%97%90-compiler.automake.allow.when.app.running%EC%9D%B4-%EC%97%86%EB%8A%94-%EA%B2%BD%EC%9A%B0)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/93c7182a-f9e2-466a-b810-2be1fe86ff9e)     
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/f22e8b30-f9a7-49a2-8363-eb76051ae12c)       
```
21.2 버전 이전에는 shift를 두 번 눌러서 나오는 registry-compiler에서 변경을 하고 이후는 setting-advanced setting-compiler
에서 allow autom-make to start even if ~를 체크해줍니다.

file-settings-build, execution, deployment - compiler 메뉴에서 build project automatically에 체크해줍니다.
```
#### Live Reload 적용하기
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/7da3e77c-b47d-4aab-ab12-947655234e54)
```
application.properties 에 Live Reload 적용 설정을 추가합니다.
```
#### 크롬 확장 프로그램 추가
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/a9348746-8b60-4bc2-9515-71e5bc1af2e2)
```
LiveReload 확장 프로그램을 설치하고 모든 사이트에서 적용이 가능하도록 설정합니다.
```
#### Property Defaults 적용하기
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/5c5009b1-e8ca-43fe-a0c2-8de846ecdaf9)
```
pom.xml에 spring.thymeleaf.cache=faslse를 추가합니다 false는 개발환경에서 캐싱 기능을 꺼두는 방법으로
true는 운영환경에서 캐싱 기능을 키는 방법으로 관리할 수 있습니다.
```
## Thymeleaf 예제
#### th:text를 이용한 상품 데이터 출력용 Dto 클래스
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/580b03b0-529f-42bc-8eee-cceeca564680)
```
데이터를 주고 받을 때는 Entity 클래스 자체를 반환하면 안되고 데이터 전달용 객체 Dto를 생성해야 합니다.
상품 데이터 출력용 Dto 클래스를 생성하였습니다.
```
#### th:text를 이용한 상품 데이터 출력용 컨트롤러 클래스
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/afb5b616-17c8-480c-966e-6458b19f70df)
```
앞서 생성한 ThymeleafExController안에 thymeleafExample02 메소드를 생성하고 ItemDto 객체를 생성한 후
모델에 데이터를 담아서 뷰에 전달하였습니다.
```
#### th:text를 이용한 상품 데이터 출력용 thymeleaf 파일
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/e47d2634-aa8c-43ae-bebd-588b753aa149)
```
전달받은 itemDto 객체를 th:text를 이용하여 출력합니다.
```
#### ItemDto 객체를 이용한 화면 출력
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/855c8948-071c-49bc-9034-b33ae9c5831a)
```
ShopApplication을 실행한 후 url을 입력하면 입력한 데이터가 화면에 정상적으로 출력되는 것을 알 수 있습니다.
```
#### th:each를 이용한 상품 리스트 출력용 컨트롤러
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/8b5db734-b35b-4724-90d7-a8c679628a7c)
#### th:each를 이용한 상품 리스트 출력용 thymeleaf 파일
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/add6c6a9-4891-47b5-bf64-ded90d2098a0)
#### th:each를 이용한 상품 리스트 화면 출력
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/675ad58a-f442-4106-b943-c1d0eb95aa78)
```
상품 리스트 출력을 하기 위해 컨트롤러에서 itemDto 객체를 10개 생성하고 이 객체를 리스트에 넣은 후
모델에 담아서 뷰로 전달합니다.

th:each를 사용하여 리스트에 있는 데이터를 객체에 하나씩 담은 후 객체의 데이터들을 테이블의 형태로 출력하였습니다.
```
#### th:if, th:unless를 이용한 조건문 처리용 thymeleaf 파일
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/c5888411-5c24-4828-966f-3119bed6a3eb)
#### th:if, th:unless를 이용한 조건문 처리 화면 출력
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/5352bff6-af38-464f-be2c-1c6aa9fcffd4)
```
th:if와 th:unless를 사용하여 앞선 예제에서 출력한 상품 리스트의 인덱스가 짝수이면 "짝수" 텍스트를
홀수이면 "홀수"텍스트를 출력하는 조건문을 살펴 보았습니다.

th:if="조건" 조건이 true일 경우 실행할 문장, th:unless="조건" 조건이 false일 경우 실행할 문장
조건문에 따라서 인덱스의 텍스트가 결정되는 것을 확인할 수 있습니다.
```
#### th:switch, th:case를 이용한 조건문 처리용 thymeleaf 파일
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/b1e1c3ad-e602-405d-a592-356798a6b7c0)
```
앞서 사용한 th:if, th:unless 대신 th:switch, th:case를 이용하여 인덱스가 짝수일 때 값이 true인 경우에는 짝수를
false일 때는 홀수를 출력합니다. 출력결과는 동일합니다.
```
#### th:href를 이용한 링크 처리용 thymeleaf 파일
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/279213d3-9f3a-469f-a382-0611c479f42e)
#### th:href를 이용한 링크 처리용 화면 출력
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/f2467655-2cb6-4413-96cb-a2546f3b9554)
```
th:href를 사용하여 기존에 작성했던 예제 1페이지와 thymeleaf 공식 사이트로 이동하는 하이퍼링크를 생성하였습니다.
```
#### th:href를 이용한 파라미터 데이터 전달용 thymeleaf 파일
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/36aa1f96-227d-41c4-b002-8e5c817ce7ab)
#### th:href를 이용한 파라미터 데이터 전달용 컨트롤러
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/53031641-684c-404f-b6b2-8cc50e7668ba)
#### th:href를 이용한 파라미터 데이터 전달용 전달받은 thymeleaf 파일
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/1ad17327-207d-4932-94e3-c74d859beb68)
#### th:href를 이용한 파라미터 전달 화면 출력
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/ecafa15e-294b-4655-b684-105aaca2e16e)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/194fca0d-1956-4e3d-955b-f98811f8a281)
```
ex05 thymeleaf파일에서 ex06으로 이동할 때 파라미터를 경로 끝에 키=값 구조로 입력합니다.
ex06 thymeleaf파일은 ex05에서 전달한 파라미터를 받아서 화면에 출력합니다. url은 url?파라미터1 & 파라미터2의 형태입니다.
url에서 공백은 %20입니다.(학부 수업때 들은 내용)
```
#### Thymeleaf Layout Dialect 의존성 추가
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/a6be3b68-ed19-4370-85ef-50fb818f9c75)
#### Thymeleaf 페이지 레이아웃 : 헤더 레이아웃
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/827eab7c-abeb-4998-8245-f19b8941ff57)
#### Thymeleaf 페이지 레이아웃 : 푸터 레이아웃
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/b0eb9747-9f73-4a95-9d61-ffdab888bb00)
#### Thymeleaf 페이지 레이아웃 : 본문 레이아웃
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/79edded6-e6aa-468c-b254-2cd91c78cefa)
#### Thymeleaf 페이지 레이아웃용 thymeleaf 파일
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/ccbfa52b-15c7-4dbc-af6f-bfd3fe1e20b9)
#### Thymeleaf 페이지 레이아웃 화면 출력
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/ea1c712d-4624-4f9e-9c31-c2a9cc8fd011)
```
thymeleafEx07.html 파일에는 header,footer영역을 지정하지 않았지만 작성한 내용이 layout1.html파일에는 포함되어 있습니다.
```
## 부트스트랩 BootStrap
```
보통 웹페이지 상단에는 웹 페이지를 이동할 수 있는 네비게이션 바가 있으며 하단 영역에는 해당 기업의 주소,
전화번호, 이메일 등의 정보를 나타내는 footer 영역이 있습니다. 부트스트랩은 웹 페이지를 쉽게 만들 수 있게 도와주는
HTML, CSS, JS의 프레임워크입니다.
```
#### Bootstrap CDN 추가하기 
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/9de8c175-32a7-4fb9-a020-9bb90dd897b9)
```
BootStrap CDN(Contents Delivery Network)를 layout1.html(본문 레이아웃)의 헤더(head)부분에 추가합니다.
```
#### 헤더영역에 Navbar 추가
[Bootstrap 공식 문서](https://getbootstrap.com/docs/5.3/components/navbar/)     
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/d6ef6692-ec46-457a-9aaf-fad09ac23ee2)     
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/6ce8abd9-b1c0-4aca-9d82-bd3f7be32e23)    
```
Bootstrap 공식 개발 문서에서 NavBar 코드를 header.html에 추가하였습니다.
heder영역에 네비게이션 바가 추가된 것을 확인할 수 있습니다.
```
#### 푸터영역 수정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/13be32b6-1d50-4e14-aacc-37df1b1dfb9f)
```
footer 영역이 content 바로 밑에 나오는 것을 알 수 있습니다.
```

#### css 파일 적용
[정적 자원(css)가 불러와지지 않을 때 해결방법](https://velog.io/@tkaltk123/%EB%B6%80%ED%8A%B8%EC%8A%A4%ED%8A%B8%EB%9E%A9-%EB%A6%AC%EC%86%8C%EC%8A%A4%EB%A5%BC-%EB%B6%88%EB%9F%AC%EC%98%A4%EC%A7%80-%EB%AA%BB%ED%95%98%EB%8A%94-%EB%AC%B8%EC%A0%9C)    
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/6005d7d8-a11b-42e8-ae79-6a874bc5b4b4)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/9c9d1019-183c-4455-a298-6a94c50bbd6f)
```
footer 영역이 하단에 고정될 수 있도록 css파일을 수정하고 css와 layout1.html을 연결해줍니다.
css파일은 static 폴더 아래에 css패키지를 만들고 그 밑에 layout1.css을 작성하였습니다.
```







