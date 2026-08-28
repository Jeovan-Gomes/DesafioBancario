package com.example.desafiobancario.controller;

import com.example.desafiobancario.dto.loginrequest;
import com.example.desafiobancario.dto.loginresponse;
import com.example.desafiobancario.service.security.jwtservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Auth")
@RequiredArgsConstructor
public class authcontroller {

    private final AuthenticationManager authenticationManager;
    private final jwtservice jwtService;

    @PostMapping("/login")
    public ResponseEntity<loginresponse> login(@RequestBody loginrequest request) {
        var authToken = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
        var authentication = authenticationManager.authenticate(authToken);

        UserDetails user = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(user);

        return ResponseEntity.ok(new loginresponse(token));
    }
}