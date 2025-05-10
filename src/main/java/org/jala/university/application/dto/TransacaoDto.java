package org.jala.university.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jala.university.domain.entity.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDto {

    private Integer idTransacao;
    private Integer idContaOrigem;
    private Integer idContaDestino;
    private Integer idBancoDestino;
    private BigDecimal valor;
    private LocalDateTime dataHora;
    private Transacao.TipoTransacao tipo;
    private String descricao;
    private Transacao.StatusTransacao status;
    private String codigoAutenticacao;

    private String nomeContaOrigem;
    private String nomeContaDestino;
    private String nomeBancoDestino;
}
