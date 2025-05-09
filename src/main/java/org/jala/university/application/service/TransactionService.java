package org.jala.university.application.service;

import java.math.BigDecimal;

public interface TransactionService {
    void transferirEntreContasProprias(Long idContaOrigem, Long idContaDestino, BigDecimal valor);
}
