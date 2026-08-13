package com.example.DesafioBancario.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Table(name = "Conta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conta {
    @Id
    private String id;
    @Column
    private Double saldo;
    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private Usuario usuario;
}
