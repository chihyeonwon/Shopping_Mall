## SpringSecurity
```
스프링 시큐리티는 스프링 기반의 애플리케이션을 위한 보안 솔루션을 제공합니다.

보안에서 중요한 두 가지 영역은 인증과 인가입니다.
웹에서 인증이란 해당 리소스에 대해서 작업을 수행할 수 있는 주체인지 확인하는 것입니다.
인가란 인증 과정 이후에 일어나는 것으로 어떤 url에 대한 접근 권한이 인가된 회원인지를 검사하는 것입니다.

스프링 시큐리티를 이용하여 회원 가입 및 로그인을 구현하고 관리자 페이지에 접근 권한을 부여하는 서비스를 구현하였습니다.
```
#### SpringSecurity 의존성 추가
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/67e18822-3968-465a-b2fb-1649ad666a0a)
```
스프링 시큐리티 의존성을 Maven project에 추가하면 이제 모든 요청은 인증을 필요로 하게 됩니다.
의존성을 추가하는 것만으로도 모든 요청에 인증을 요구한다는 점이 인상적입니다.
```
#### SpringSecurity Default Login Page
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/f4d7f7d0-25b9-4c33-b1b8-25f97664601c)
#### SpringSecurity user Password
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/cacc6d08-54bf-498f-811a-5b78ba3f244c)
#### 잘못된 아이디, 패스워드를 입력했을 때
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/2820a136-c8f1-4ffd-80f0-e542d9a7a334)
#### 로그아웃 기능
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/60cd38c4-1a33-40fa-94a0-2c340876e384)
```
의존성을 추가하는 것만으로도 기존 url에 접속했을 때 시큐리티에서 제공하는 로그인 페이지로 이동하게 됩니다.
스프링 시큐리티에서 기본적으로 제공하는 아이디는 user이고 비밀번호는 애플리케이션을 실행할 때마다 변경되는
비밀번호를 콘솔창에 출력해서 보여줍니다.

localhost:8000/logout을 입력하면 로그아웃을 할 지 물어보는 화면이 나타납니다.
로그아웃 후 서버에 다시 요청을 하면 다시 인증을 요구합니다.
```
#### SecurityConfig 클래스 작성
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/ea6c23b8-72f5-4a01-967c-aaab57fc7c56)
```
현재는 모든 요청에 인증을 필요로 하지만  Configure 메소드에 설정을 추가하지 않으면 더 이상 요청에 인증을 요구하지 않습니다.
해당 파일을 사용하여 요청에 인증 요구 설정을 할 수 있습니다.
```
## 회원 가입 기능 구현
#### 회원 가입 역할 생성
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/96b561b8-e0a7-495a-af5e-025df76c5d60)
```
각각의 멤버의 상태가 일반 유저 USER인지 관리자 ADMIN인지 역할을 구분하도록 Role enum 클래스를 작성하였습니다.
```
#### MemberFormDto 생성
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/56a8328f-dfe3-4f0e-82a7-a630a17daa2e)
```
회원 가입 화면으로부터 넘어오는 가입정보를 담을 dto를 생성하였습니다.
```
#### Member 엔티티 생성
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/f8476e2a-0411-48aa-b11d-dc34afc1f746)
```
회원 정보를 저장하는 Member 엔티티를 생성하였습니다. 관리할 회원 정보는 이름, 이메일, 비밀번호, 주소, 역할 입니다.
엔티티에 회원을 생성하는 메소드를 생성하여 관리합니다.
```
#### MemberService
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/960229d7-d375-4275-ad7c-c716c4c422df)
```
멤버 데이터베이스에 회원을 저장하는 서비스 계층 클래스인 MemberService를 작성합니다.
```
#### MemberServiceTest
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/a2476cd7-1202-43d8-a2f3-59831daa7a08)
```
회원가입 기능이 정상적으로 동작하는 지 테스트 코드를 작성하였습니다.
저장하려고 요청했던 값과 실제 저장된 데이터를 비교합니다.
```
#### 회원가입 기능 테스트 결과
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/626b2d9e-52fe-4a09-990d-3cbfd8efd808)
```
회원가입이 정상적으로 이루어진 것을 확인할 수 있습니다.
```
#### 중복 회원가입 테스트
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/910e1636-8218-4e8a-a31c-f902c5e85ac6)
```
동일한 회원 정보를 가지는 member1, member2를 생성하고 서비스 클래스의 saveMember 메소드로 회원을 저장하려고 할 때
서비스 클래스에서 만약 회원정보 중 이메일이 같다면 이미 가입된 회원입니다.라는 예외 메시지를 출력하도록 했었습니다.

이 예외 메시지와 테스트에서 예상한 메시지 결과가 같은지 검증하는 테스트입니다.

테스트 결과 중복 회원가입 테스트를 통과하는 것을 알 수 있습니다.
```
#### 회원 가입 Controller
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/21c1af46-2690-4bb7-88ef-ea85c01449b9)
```
회원 가입을 위한 페이지와 연결한 컨트롤러를 작성합니다.
```
#### 회원 가입 페이지 폼
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/fe924abe-3950-478e-b4b8-eb37844f2ef9)
```
회원가입 페이지도 부트스트랩을 사용하여 만들었습니다.
홈페이지의 예제 Forms에 나와있는 코드를 변형해서 사용하였습니다.

회원 정보인 이름, 이메일, 비밀번호, 주소를 입력하는 폼을 생성하고 post방식으로 입력된 데이터를 url로 전달합니다.
```
#### 회원 가입 Controller 수정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/7e869712-b00c-450f-a0fd-3b2836ab0265)
```
회원 가입 페이지에서 회원 정보를 입력한 후 Submit 버튼을 누르면 post방식으로 /members/new Url에 요청을 하게 되는데
이때 @PostMapping 어노테이션을 들고 있는 컨트롤러의 memberForm 메소드에서 폼에서 생성된 memberFormDto 객체의 정보들로
회원을 생성하고 저장하게 됩니다. 저장이 끝난 후에는 루트 경로에 해당하는 main 화면으로 리다이렉팅합니다.
```






