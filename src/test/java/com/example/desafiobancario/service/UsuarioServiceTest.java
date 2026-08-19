package com.example.desafiobancario.service;

import com.example.desafiobancario.dto.usuariorequest;
import com.example.desafiobancario.model.users.tipoUsuario;
import com.example.desafiobancario.model.usuario;
import com.example.desafiobancario.repository.usuariorepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;


import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ActiveProfiles
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private usuariorepository usuarioRepository;

    @InjectMocks
    private usuarioservice usuarioService;

    @Test
    void cadastrarUsuarioCpfExistente() {
        usuariorequest dto = new usuariorequest("Admin", "32215498712", "Adminteste@email.com", "teste123", tipoUsuario.Usuario);

        usuario usuarioCPFExistent = new usuario(null, dto.nome(), dto.cpf(), dto.email(), dto.senha(),dto.tipo());
        when(usuarioRepository.findByCpf(dto.cpf())).thenReturn(Optional.of(usuarioCPFExistent));

        assertThrows(RuntimeException.class, () -> usuarioService.CadastrarUsuario(dto));

        verify(usuarioRepository, never()).save(any());
    }

    @Test
    void cadastrarUsuarioEmailExistente(){
        usuariorequest dto = new usuariorequest("Teste", "12345678909", "teste@email.com", "teste123", tipoUsuario.Lojista);

        usuario usuarioEmailExistente = new usuario(null, dto.nome(), dto.cpf(), dto.email(), dto.senha(),dto.tipo());
        when(usuarioRepository.findByEmail(dto.email())).thenReturn(Optional.of(usuarioEmailExistente));

        assertThrows(RuntimeException.class, () -> usuarioService.CadastrarUsuario(dto));

        verify(usuarioRepository, never()).save(any());
    }


    @Test
    void cadastrarUsuarioCpfNulo() {
        assertThrows(RuntimeException.class, () -> usuarioService.CadastrarUsuario(null));
    }
}