package com.example.DesafioBancario.Service;

import com.example.DesafioBancario.DTO.UsuarioDTO;
import com.example.DesafioBancario.Model.Conta;
import com.example.DesafioBancario.Model.Usuario;
import com.example.DesafioBancario.Repository.ContaRepository;
import com.example.DesafioBancario.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ContaRepository contaRepository;

    public Usuario findByCpf(String cpf){
        return usuarioRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("CPF não encontrado!"));
    }

    public Usuario CadastrarUsuario(UsuarioDTO dto){
        if(usuarioRepository.findByCpf(dto.cpf()).isPresent()){
            throw new RuntimeException("CPF já cadastrado!");
        }
        if(usuarioRepository.findByEmail(dto.email()).isPresent()){
            throw new RuntimeException("Email já cadastrado!");
        }
        Usuario usuario = new Usuario(null, dto.nome(), dto.cpf(), dto.email(), dto.senha(),dto.tipo());
        Conta conta = new Conta(aleatorioId(), 0.0, usuario);
        usuarioRepository.save(usuario);
        contaRepository.save(conta);
        return usuario;
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
