package com.example.desafiobancario.dto;

import com.example.desafiobancario.model.conta;
import com.example.desafiobancario.model.usuario;

public record contaresponse(String id, Double saldo, usuario user) {
    public contaresponse(conta dto) {
        this(dto.getId(), dto.getSaldo(), dto.getUsuario());
    }
}
