package com.example.DesafioBancario.Service;

import com.example.DesafioBancario.DTO.TransacaoDTO;
import com.example.DesafioBancario.Model.Conta;
import com.example.DesafioBancario.Model.Transacao;
import com.example.DesafioBancario.Model.Users.TipoUsuario;
import com.example.DesafioBancario.Model.Usuario;
import com.example.DesafioBancario.Repository.TransacaoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles
class TransacaoServiceTest {
    @Mock
    TransacaoRepository transacaoRepository;

    @InjectMocks
    TransacaoService transacaoService;

    @Test
    void createDTOvazio(){
        Usuario usuario1 = new Usuario(2, "Fernando", "12345678910", "Fernando@email.com", "teste123", TipoUsuario.Usuario);
        Usuario usuario2 = new Usuario(7, "Lucas", "098765432198", "Lucas@email.com", "Lojista123", TipoUsuario.Lojista);

        Conta conta1 = new Conta("2222", 183.90, usuario1);
        Conta conta2 = new Conta("4321", 9214.87, usuario2);


        TransacaoDTO dto = new TransacaoDTO(100.00, conta1, conta2);
        assertThrows(RuntimeException.class, () -> transacaoService.create(dto));
    }

}