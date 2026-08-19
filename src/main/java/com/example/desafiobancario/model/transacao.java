package com.example.desafiobancario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Transacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Transacao;
    @Column
    private Double valor;
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private conta conta1;
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private conta conta2;
}
