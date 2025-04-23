package com.example.auth.controller;

import com.example.auth.dto.AuthRequest;
import com.example.auth.service.JwtService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) throws Exception {
        // login 사용자의 username + password를 UsernamePasswordAuthenticationToken에 담아서 인증필터에 전달
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());

        // 인증 요청을 받아서 실제 인증을 처리
        // 이 때 CustomUserDetailsService 로직이 사용됨
        Authentication auth = authenticationManager.authenticate(token);

        // UserDetails: 유저 정보를 딱 한타입으로 관리하고 싶어서 정의한 인터페이스
        String jwt = jwtService.generateToken((UserDetails) auth.getPrincipal());
        return ResponseEntity.ok(Map.of("token", jwt));
    }
}
