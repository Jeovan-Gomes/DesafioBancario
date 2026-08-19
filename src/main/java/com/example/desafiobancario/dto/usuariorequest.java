package com.example.desafiobancario.dto;

import com.example.desafiobancario.model.users.tipoUsuario;

public record usuariorequest(String nome, String cpf, String email, String senha, tipoUsuario tipo) {
}
