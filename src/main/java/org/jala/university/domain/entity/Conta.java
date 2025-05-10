package org.jala.university.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "conta")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Integer idConta;

    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;

    @Column(name = "id_agencia", nullable = false)
    private Integer idAgencia;

    @Column(name = "numero_conta", nullable = false, unique = true, length = 12)
    private String numeroConta;

    @Column(name = "digito_conta", nullable = false, length = 2)
    private String digitoConta;

    @Column(name = "tipo_conta", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @Column(name = "saldo", precision = 15, scale = 2)
    private BigDecimal saldo;

    @Column(name = "data_abertura")
    private LocalDate dataAbertura;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusConta status;

    public enum TipoConta {
        corrente, poupança, salário
    }

    public enum StatusConta {
        ativa, inativa, bloqueada
    }

    public void debitar(BigDecimal valor) {
        if (this.saldo.compareTo(valor) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        this.saldo = this.saldo.subtract(valor);
    }

    public void creditar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }
}