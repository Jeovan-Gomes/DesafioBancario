package com.example.DesafioBancario.Service;

import com.example.DesafioBancario.DTO.TransacaoDTO;
import com.example.DesafioBancario.Model.Conta;
import com.example.DesafioBancario.Model.Transacao;
import com.example.DesafioBancario.Model.Users.TipoUsuario;
import com.example.DesafioBancario.Model.Usuario;
import com.example.DesafioBancario.Repository.ContaRepository;
import com.example.DesafioBancario.Repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {
    @Autowired
    TransacaoRepository transacaoRepository;
    @Autowired
    ContaService contaService;

    @Autowired
    ContaRepository contaRepository;

    public Transacao create(TransacaoDTO dto){
        if(dto == null){throw new IllegalArgumentException();}
        String id_Conta = dto.conta1().getId();
        Usuario usuario = contaRepository.findById(id_Conta).get().getUsuario();
        if(!VerificaTipo(usuario)){throw new RuntimeException("Lojista não paga!");}
        Transacao transacao = new Transacao(0, dto.valor(),  dto.conta1(), dto.conta2());
        transacaoRepository.save(transacao);
        Conta conta1 = contaService.PagouSaldo(dto.conta1(), dto.valor());
        Conta conta2 = contaService.RecebeuSaldo(dto.conta2(), dto.valor());
        return transacaoRepository.save(transacao);
    }

    private boolean VerificaTipo(Usuario usuario){
        if(usuario.getTipo() == TipoUsuario.Usuario){
            return true;
        }else{
            return false;
        }
    }



    public List<Transacao> All(){
        return transacaoRepository.findAll();
    }
}
