package com.example.DesafioBancario.Repository;

import com.example.DesafioBancario.Model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {
}
