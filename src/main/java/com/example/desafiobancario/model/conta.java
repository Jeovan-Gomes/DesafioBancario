package com.example.desafiobancario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Table(name = "Conta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class conta {
    @Id
    private String id;
    @Column
    private Double saldo;
    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private usuario usuario;
}
