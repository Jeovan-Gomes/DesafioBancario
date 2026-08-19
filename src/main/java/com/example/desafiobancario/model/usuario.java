package com.example.desafiobancario.model;

import com.example.desafiobancario.model.users.tipoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome_Completo;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String email;
    @Column
    private String senha;
    @Column
    private tipoUsuario tipo;
}
