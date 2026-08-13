package com.example.DesafioBancario.DTO;

import com.example.DesafioBancario.Model.Conta;

public record TransacaoDTO(Double valor, Conta conta1, Conta conta2) {
}
