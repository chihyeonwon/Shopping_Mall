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







