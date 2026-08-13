package com.example.DesafioBancario.Service;

import com.example.DesafioBancario.Model.Conta;
import com.example.DesafioBancario.Model.Users.TipoUsuario;
import com.example.DesafioBancario.Repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta findById(String id) {
        return contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    public Conta depositarSaldo(String id, Double valor) {
        Conta conta = findById(id);
        conta.setSaldo(conta.getSaldo() + valor);
        return contaRepository.save(conta);
    }

    public Conta RecebeuSaldo(Conta conta, Double valor) {

        conta.setSaldo(conta.getSaldo() + valor);
        return contaRepository.save(conta);
    }

    public Conta PagouSaldo(Conta conta, Double valor) {
        if(conta.getSaldo() < valor) {
            throw new RuntimeException("Saldo insuficiente");
        }
        if(conta.getUsuario().getTipo() == TipoUsuario.Lojista){
            throw new RuntimeException("Lojista só pode receber");
        }
        conta.setSaldo(conta.getSaldo() - valor);
        return contaRepository.save(conta);
    }

}
