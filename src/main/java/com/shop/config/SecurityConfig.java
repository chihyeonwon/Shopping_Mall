package com.shop.config;

import com.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    MemberService memberService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin((formLogin) -> formLogin
                        .usernameParameter("email") // 로그인 시 사용할 파라미터로 email 사용
                        .failureUrl("/members/login/error") // 로그인 실패시 이동할 페이지
                        .loginPage("/members/login") // 로그인 페이지 설정
                        .defaultSuccessUrl("/"))// 로그인 성공시 이동할 페이지)
                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout")) // 로그아웃 url 설정
                        .logoutSuccessUrl("/") // 로그아웃 성공 시 이동할 url
                        .invalidateHttpSession(true)) // 기존에 생성된 사용자 세션도 invalidateHttpSession 을 통해 삭제하도록 처리
        ;
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}