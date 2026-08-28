package com.example.desafiobancario.service;

import com.example.desafiobancario.dto.contaresponse;
import com.example.desafiobancario.model.conta;
import com.example.desafiobancario.model.users.tipoUsuario;
import com.example.desafiobancario.repository.contarepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class contaservice {

    private final contarepository contaRepository;

    public conta findById(String id) {
        return contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    public List<contaresponse> findall() {
        return contaRepository.findAll()
                .stream()
                .map(conta -> new contaresponse(conta))
                .toList();
    }

    public contaresponse depositarSaldo(String id, Double valor) {
        conta conta = findById(id);
        conta.setSaldo(conta.getSaldo() + valor);
        contaRepository.save(conta);
        return new contaresponse(conta);
    }

    public contaresponse RecebeuSaldo(conta conta, Double valor) {

        conta.setSaldo(conta.getSaldo() + valor);
        contaRepository.save(conta);
        return new contaresponse(conta);
    }

    public contaresponse PagouSaldo(conta conta, Double valor) {
        if(conta.getSaldo() < valor) {
            throw new RuntimeException("Saldo insuficiente");
        }
        if(conta.getUsuario().getTipo() == tipoUsuario.Lojista){
            throw new RuntimeException("Lojista só pode receber");
        }
        conta.setSaldo(conta.getSaldo() - valor);
        contaRepository.save(conta);
        return new  contaresponse(conta);
    }

}
