package com.example.desafiobancario.controller;

import com.example.desafiobancario.dto.transacaorequest;
import com.example.desafiobancario.dto.transacaoresponse;
import com.example.desafiobancario.service.transacaoservice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Transacao")
@RequiredArgsConstructor
public class transacaocontroller {

    private final transacaoservice transacaoService;

    @PostMapping("/create")
    public ResponseEntity<transacaoresponse> CriarTransacao(@RequestBody transacaorequest dto){
        if(dto == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(transacaoService.create(dto));
    }
}
