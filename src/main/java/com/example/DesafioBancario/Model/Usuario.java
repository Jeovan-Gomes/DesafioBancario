package com.example.DesafioBancario.Model;

import com.example.DesafioBancario.Model.Users.TipoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
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
    private TipoUsuario tipo;
}
