package com.example.desafiobancario.repository;

import com.example.desafiobancario.model.transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface transacaorepository extends JpaRepository<transacao, Integer> {
}
