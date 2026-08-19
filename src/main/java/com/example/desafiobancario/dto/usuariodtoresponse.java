package com.example.desafiobancario.dto;

import com.example.desafiobancario.model.users.tipoUsuario;
import com.example.desafiobancario.model.usuario;

public record usuariodtoresponse(Integer id, String nome, String cpf, String email, String senha, tipoUsuario tipo) {
    public usuariodtoresponse(usuario user){
        this(user.getId(), user.getNome_Completo(), user.getCpf(), user.getEmail(), user.getSenha(), user.getTipo());
    }
}
