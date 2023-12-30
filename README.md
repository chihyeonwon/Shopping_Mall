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
#### 메인 페이지 컨트롤러
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/177231f6-135f-4747-8374-66bdc643b381)
```
회원가입 후 메인 페이지로 이동할 수 있도록 컨트롤러를 작성합니다.
```
#### 메인 페이지 코드
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/03974bce-ac82-4356-ae72-e8286e18b92e)
```
회원 가입 후 보여지는 메인 페이지 코드입니다. 추후 등록된 상품의 목록을 보여주도록 수정합니다.
```
#### 회원 가입 페이지
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/0b64f5be-ddd5-4e47-940e-a9f32f729d1c)
#### 메인 페이지
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/92130781-48c8-4448-ac87-18f00c9cc88a)
```
localhost:8000/members/new URL를 입력하면 나오는 회원 가입 페이지입니다. 회원 가입 등록을 위해 정보를 입력하고
Submit 버튼을 누르면 회원가입이 되면서 메인 페이지로 화면이 이동합니다.

하지만 지금은 이름이나 비밀번호를 입력하지 않아도 정상적으로 저장됩니다.
```
#### Java Bean Validation 의존성 추가
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/dde825dd-b2da-48e4-8401-ab49ccf3c103)
#### MemberFormDto에 validation 어노테이션 추가
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/62d535be-d2dc-4013-8d88-33fcb123eef5)
```
유효성을 검증할 MemberFormDto의 필드에 적절한 어노테이션(@NotBlank, @NotEmpty, @Length, @Email)을 선언합니다.
```
#### MemberController 수정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/bf509b94-0789-40eb-977a-0931834f5024)
```
회원가입이 성공하면 메인 페이지로 리다이렉트하고, 회원 정보 검증 및 중복회원 가입 조건에 의해 실패한다면
다시 회원 가입 페이지로 돌아가 실패 이유를 화면에 출력해주겠습니다.
```
#### 회원 가입 시 데이터 검증 결과
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/2dda001a-833f-489c-9a13-2545b5e22994)
```
유효하지 않은 회원 가입 정보를 입력 후 서버로 전송하면 해당 이유를 화면에서 보여줍니다.
```
#### 회원 가입 기능 테스트
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/80a330f1-92a8-4d01-9ba5-8c86093591e0)
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/5baa9285-83e5-4ed5-9456-a4807e99c4ad)
```
실제로 MySQL 데이터베이스의 member 테이블에 입력한 회원 정보 데이터(id, 이메일, 암호화된 비밀번호, 주소)가 입력되는 지
확인해보았습니다.
```
## 로그인 로그아웃 기능 구현
#### MemberService 수정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/923268cb-b032-4f25-bfcb-68ad79c2d596)
```
스프링 시큐리티에서 UserDetailsService 클래스를 통해서 로그인 기능을 구현할 수 있습니다.
기존 MemberService 클래스에서 UserDetailsSevice를 구현합니다.
UserDetailsService의 loadUserByUsername 메소드를 오버라이딩하고 memberRepository의 member를 찾아서
member의 정보들로 User 객체를 생성(User.builder.build())합니다.
```
#### SecurityConfig 수정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/976ffb35-6d9e-4a00-a1b8-e71bbbd7d234)
```
http의 .formLogin 메서드와 .logout() 메서드를 사용해서 로그인 시 페이지 설정, 로그아웃 시 페이지 설정 등을 진행합니다.
```
#### 로그인 페이지 작성
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/5b73c5a6-2057-4f9d-8c0e-6c4763482b2e)
```
memberLoginForm 로그인 폼 페이지를 작성합니다. 이메일주소와 비밀번호를 입력할 수 있는 입력창과 로그인, 회원가입 버튼으로
구성하였습니다.
```
#### MemberController 수정
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/2e392b14-1bd8-41cd-a518-be3008ab87f4)
```
로그인 페이지로 이동할 수 있도록 컨트롤러를 수정하였습니다.
로그인 실패 시에는 /login/error 페이지에서 오류메시지를 담아서 다시 로그인 페이지로 이동하도록 합니다.
```
#### 로그인 화면
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/ec5a7811-2574-401d-8b30-81444c9c4f28)
#### 로그인 실패
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/985518f4-b063-4daa-bc6f-49ea677c183d)
#### 로그인 성공
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/7de76bc3-fb53-4a28-b417-7e3a7739be67)

#### 로그인/로그아웃 화면 연동하기
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/7b4197f7-9a4d-4200-95ab-ad7c333fdec6)
```
로그인 상태라면 로그아웃이라는 메뉴가 나타나야하고 다른 아이디로 로그인하려면 현재 계정으로부터 로그아웃하고
다시 로그인을 해야합니다. 또 상품 등록 메뉴의 경우 관리자만 상품을 등록할 수 있도록 노출해야 합니다.

이를 도와주는 라이브러리로 thymeleaf-extras-springsecurty6가 있습니다. 의존성을 추가해줍니다.
```
#### header영역에 thymeleaf-extras-springsecurity 적용
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/b1d08322-a4cd-4b3f-b2dd-f0b689227c72)
```
sec:authorize="hasAnyAuthority", "isAuthenticated", "isAnonymous" 등 인증이 되었을 때와 인증이 안 되었을 때
보여지는 메뉴를 구분할 수 있습니다.
```
#### 수정 후 로그인한 후 메인화면
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/2ad01b58-0a82-40d7-a2c8-9ce053f2a560)
#### 수정 후 로그아웃한 후 메인화면
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/2761e3af-ff41-4d13-8dbb-c8d3a5693ea1)
```
로그인을 하면 "로그아웃" 메뉴가 나타나고 로그아웃을 하면 "로그인" 메뉴가 나타납니다.
인증 상태에 따라서 메뉴를 다르게 보여줍니다.
```
