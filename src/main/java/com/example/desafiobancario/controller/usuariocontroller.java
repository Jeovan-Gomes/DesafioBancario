package com.example.desafiobancario.controller;

import com.example.desafiobancario.dto.usuariorequest;
import com.example.desafiobancario.dto.usuariodtoresponse;
import com.example.desafiobancario.service.usuarioservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Usuario")
@RequiredArgsConstructor
public class usuariocontroller {

    private final usuarioservice usuarioService;

    @GetMapping("/{cpf}")
    public ResponseEntity<usuariodtoresponse> findByCpf(@PathVariable String cpf){
        if(cpf.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioService.findByCpf(cpf));
    }

    @PostMapping("/CadastrarUser")
    public ResponseEntity<usuariorequest> cadastrarUsuario(@RequestBody usuariorequest dto){
        if(dto == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(usuarioService.CadastrarUsuario(dto));
    }
}
