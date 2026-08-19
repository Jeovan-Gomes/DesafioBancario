package com.example.desafiobancario.repository;

import com.example.desafiobancario.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface usuariorepository extends JpaRepository<usuario, Integer> {
    Optional<usuario> findByCpf(String cpf);
    Optional<usuario> findByEmail(String email);
}
