package com.example.DesafioBancario.DTO;

import com.example.DesafioBancario.Model.Users.TipoUsuario;

public record UsuarioDTO(String nome, String cpf, String email, String senha, TipoUsuario tipo) {
}
