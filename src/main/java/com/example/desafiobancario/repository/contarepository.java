package com.example.desafiobancario.repository;

import com.example.desafiobancario.model.conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface contarepository extends JpaRepository<conta, String> {
}
