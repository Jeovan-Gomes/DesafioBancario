package com.example.desafiobancario.dto;

import com.example.desafiobancario.model.transacao;

public record transacaoresponse(Integer id, Double valor, String conta1, String conta2) {
    public transacaoresponse(transacao t){
        this(t.getId_Transacao(), t.getValor(), t.getConta1().toString(), t.getConta2().toString());
    }
}
