package com.example.DesafioBancario.Service;

import com.example.DesafioBancario.DTO.UsuarioDTO;
import com.example.DesafioBancario.Model.Users.TipoUsuario;
import com.example.DesafioBancario.Model.Usuario;
import com.example.DesafioBancario.Repository.UsuarioRepository;
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
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void cadastrarUsuarioCpfExistente() {
        UsuarioDTO dto = new UsuarioDTO("Admin", "32215498712", "Adminteste@email.com", "teste123", TipoUsuario.Usuario);

        Usuario usuarioCPFExistent = new Usuario(null, dto.nome(), dto.cpf(), dto.email(), dto.senha(),dto.tipo());
        when(usuarioRepository.findByCpf(dto.cpf())).thenReturn(Optional.of(usuarioCPFExistent));

        assertThrows(RuntimeException.class, () -> usuarioService.CadastrarUsuario(dto));

        verify(usuarioRepository, never()).save(any());
    }

    @Test
    void cadastrarUsuarioEmailExistente(){
        UsuarioDTO dto = new UsuarioDTO("Teste", "12345678909", "teste@email.com", "teste123", TipoUsuario.Lojista);

        Usuario usuarioEmailExistente = new Usuario(null, dto.nome(), dto.cpf(), dto.email(), dto.senha(),dto.tipo());
        when(usuarioRepository.findByEmail(dto.email())).thenReturn(Optional.of(usuarioEmailExistente));

        assertThrows(RuntimeException.class, () -> usuarioService.CadastrarUsuario(dto));

        verify(usuarioRepository, never()).save(any());
    }


    @Test
    void cadastrarUsuarioCpfNulo() {
        assertThrows(RuntimeException.class, () -> usuarioService.CadastrarUsuario(null));
    }
}