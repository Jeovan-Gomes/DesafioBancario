package com.example.desafiobancario.service;

import com.example.desafiobancario.model.conta;
import com.example.desafiobancario.model.users.tipoUsuario;
import com.example.desafiobancario.model.usuario;
import com.example.desafiobancario.repository.contarepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles
class ContaServiceTest {
    @Mock
    private contarepository contaRepository;
    @InjectMocks
    private contaservice contaService;

    @Test
    void pagouSaldoInsuficiente() {
        usuario usuario2 = new usuario(7, "Lucas", "098765432198", "Lucas@email.com", "Lojista123", tipoUsuario.Lojista);

        conta conta = new conta("1234", 183.90, usuario2);
        assertThrows(RuntimeException.class, () -> contaService.PagouSaldo(conta, 300.00));
    }

    @Test
    void pagouSaldoComSucesso() {
        usuario usuario2 = new usuario(7, "Lucas", "098765432198", "Lucas@email.com", "Lojista123", tipoUsuario.Lojista);
        conta conta = new conta("1234", 183.90, usuario2);

        assertThrows(RuntimeException.class, () -> contaService.PagouSaldo(conta, 100.00));
    }
}