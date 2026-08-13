package com.example.DesafioBancario.Repository;

import com.example.DesafioBancario.Model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, String> {
}
