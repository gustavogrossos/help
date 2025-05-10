package org.jala.university.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "agencia")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agencia")
    private Integer idAgencia;

    @Column(name = "codigo_agencia", length = 10, nullable = false, unique = true)
    private String codigoAgencia;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "endereco", length = 150, nullable = false)
    private String endereco;

    @Column(name = "telefone", length = 20, nullable = false)
    private String telefone;
}
