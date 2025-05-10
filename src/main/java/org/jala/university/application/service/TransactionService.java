package org.jala.university.application.service;

import org.jala.university.application.dto.TransacaoDto;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {

    String transferirEntreContasProprias(Integer idContaOrigem, Integer idContaDestino, BigDecimal valor);

    String transferirParaTerceiros(Integer idContaOrigem, Integer idContaDestino, BigDecimal valor, String descricao);

    String transferirParaOutroBanco(Integer idContaOrigem, String codigoBanco,
                                    String agenciaDestino, String contaDestino,
                                    String digitoDestino, BigDecimal valor, String descricao);

    List<TransacaoDto> obterExtrato(Integer idConta, Integer quantidade);

    List<TransacaoDto> obterHistoricoTransacoes(Integer idConta);
}
