package com.example.desafiobancario.service;

import com.example.desafiobancario.dto.transacaorequest;
import com.example.desafiobancario.model.conta;
import com.example.desafiobancario.model.users.tipoUsuario;
import com.example.desafiobancario.model.usuario;
import com.example.desafiobancario.repository.transacaorepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles
class TransacaoServiceTest {
    @Mock
    transacaorepository transacaoRepository;

    @InjectMocks
    transacaoservice transacaoService;

    @Test
    void createDTOvazio(){
        usuario usuario1 = new usuario(2, "Fernando", "12345678910", "Fernando@email.com", "teste123", tipoUsuario.Usuario);
        usuario usuario2 = new usuario(7, "Lucas", "098765432198", "Lucas@email.com", "Lojista123", tipoUsuario.Lojista);

        conta conta1 = new conta("2222", 183.90, usuario1);
        conta conta2 = new conta("4321", 9214.87, usuario2);


        transacaorequest dto = new transacaorequest(100.00, conta1, conta2);
        assertThrows(RuntimeException.class, () -> transacaoService.create(dto));
    }

}