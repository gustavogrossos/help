package org.jala.university.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transacao")
    private Integer idTransacao;

    @Column(name = "id_conta_origem", nullable = false)
    private Integer idContaOrigem;

    @Column(name = "id_conta_destino")
    private Integer idContaDestino;

    @Column(name = "id_banco_destino")
    private Integer idBancoDestino;

    @Column(name = "valor", precision = 15, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;

    @Column(name = "descricao", length = 200)
    private String descricao;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusTransacao status;

    @Column(name = "codigo_autenticacao", length = 30)
    private String codigoAutenticacao;

    public enum TipoTransacao {
        depósito, saque, transferência, pagamento
    }

    public enum StatusTransacao {
        pendente, concluída, cancelada, falha
    }
}
