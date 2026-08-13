package com.example.DesafioBancario.Service;

import com.example.DesafioBancario.Model.Conta;
import com.example.DesafioBancario.Model.Users.TipoUsuario;
import com.example.DesafioBancario.Model.Usuario;
import com.example.DesafioBancario.Repository.ContaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles
class ContaServiceTest {
    @Mock
    private ContaRepository contaRepository;
    @InjectMocks
    private ContaService contaService;

    @Test
    void pagouSaldoInsuficiente() {
        Usuario usuario2 = new Usuario(7, "Lucas", "098765432198", "Lucas@email.com", "Lojista123", TipoUsuario.Lojista);

        Conta conta = new Conta("1234", 183.90, usuario2);
        assertThrows(RuntimeException.class, () -> contaService.PagouSaldo(conta, 300.00));
    }

    @Test
    void pagouSaldoComSucesso() {
        Usuario usuario2 = new Usuario(7, "Lucas", "098765432198", "Lucas@email.com", "Lojista123", TipoUsuario.Lojista);
        Conta conta = new Conta("1234", 183.90, usuario2);

        assertThrows(RuntimeException.class, () -> contaService.PagouSaldo(conta, 100.00));
    }
}