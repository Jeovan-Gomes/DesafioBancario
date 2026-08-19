package com.example.desafiobancario.service;

import com.example.desafiobancario.dto.usuariorequest;
import com.example.desafiobancario.dto.usuariodtoresponse;
import com.example.desafiobancario.model.conta;
import com.example.desafiobancario.model.usuario;
import com.example.desafiobancario.repository.contarepository;
import com.example.desafiobancario.repository.usuariorepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class usuarioservice {
    private usuariorepository usuarioRepository;

    private contarepository contaRepository;

    public usuariodtoresponse findByCpf(String cpf){
        usuario user = usuarioRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Não encontrado"));

        return new usuariodtoresponse(user);
    }

    public usuariorequest CadastrarUsuario(usuariorequest dto){
        if(usuarioRepository.findByCpf(dto.cpf()).isPresent()){
            throw new RuntimeException("CPF já cadastrado!");
        }
        if(usuarioRepository.findByEmail(dto.email()).isPresent()){
            throw new RuntimeException("Email já cadastrado!");
        }
        usuario usuario = new usuario(null, dto.nome(), dto.cpf(), dto.email(), dto.senha(),dto.tipo());
        conta conta = new conta(aleatorioId(), 400.00, usuario); //400 reais só para testes
        usuarioRepository.save(usuario);
        contaRepository.save(conta);
        return dto;
    }

    public String aleatorioId(){
        Random random = new Random();
        random.setSeed(random.nextLong());
        String val = String.valueOf(random.nextInt(10000, 99999));
        while(true){
            if(!contaRepository.existsById(val)){
                return val;
            }
        }
    }
}
