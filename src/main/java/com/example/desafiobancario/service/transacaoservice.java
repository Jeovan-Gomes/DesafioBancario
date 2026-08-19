package com.example.desafiobancario.service;

import com.example.desafiobancario.dto.transacaorequest;
import com.example.desafiobancario.dto.transacaoresponse;
import com.example.desafiobancario.model.conta;
import com.example.desafiobancario.model.transacao;
import com.example.desafiobancario.model.users.tipoUsuario;
import com.example.desafiobancario.model.usuario;
import com.example.desafiobancario.repository.contarepository;
import com.example.desafiobancario.repository.transacaorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class transacaoservice {
    @Autowired
    transacaorepository transacaoRepository;
    @Autowired
    contaservice contaService;

    @Autowired
    contarepository contaRepository;

    public transacaoresponse create(transacaorequest dto){
        if(dto == null){throw new IllegalArgumentException();}
        String id_Conta = dto.conta1();
        conta conta1 = this.contaRepository.findById(id_Conta).get();
        conta conta2 = this.contaRepository.findById(dto.conta2()).get();
        usuario usuario = contaRepository.findById(id_Conta).get().getUsuario();
        if(!VerificaTipo(usuario)){throw new RuntimeException("Lojista não paga!");}
        transacao transacao = new transacao(null, dto.valor(), conta1, conta2);
        transacaoRepository.save(transacao);
        contaService.PagouSaldo(conta1, dto.valor());
        contaService.RecebeuSaldo(conta2, dto.valor());
        transacaoRepository.save(transacao);
        return new transacaoresponse(transacao);
    }

    private boolean VerificaTipo(usuario usuario){
        if(usuario.getTipo() == tipoUsuario.Usuario){
            return true;
        }else{
            return false;
        }
    }



    public List<transacaoresponse> All(){

        return transacaoRepository.findAll()
                .stream()
                .map(transacaoresponse::new)
                .toList();
    }
}
