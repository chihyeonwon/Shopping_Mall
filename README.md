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
![image](https://github.com/mr-won/Shopping_Mall/assets/58906858/56a8328f-dfe3-4f0e-82a7-a630a17daa2e)
```
회원 가입 화면으로부터 넘어오는 가입정보를 담을 dto를 생성하였습니다.
```
