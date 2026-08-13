package com.example.DesafioBancario.Controller;

import com.example.DesafioBancario.DTO.TransacaoDTO;
import com.example.DesafioBancario.Model.Transacao;
import com.example.DesafioBancario.Service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Transacao")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/create")
    public ResponseEntity<Transacao> CriarTransacao(@RequestBody TransacaoDTO dto){
        if(dto == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(transacaoService.create(dto));
    }
}
