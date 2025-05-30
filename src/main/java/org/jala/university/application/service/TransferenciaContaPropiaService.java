package org.jala.university.application.service;

import org.jala.university.domain.entity.Conta;
import org.jala.university.domain.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TransferenciaContaPropriaService {

    private final ContaRepository contaRepository;

    public TransferenciaContaPropriaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public String transferir(Long idContaOrigem, Long idContaDestino, BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            return "O valor da transferência deve ser positivo.";
        }

        if (idContaOrigem.equals(idContaDestino)) {
            return "As contas de origem e destino não podem ser iguais.";
        }

        Optional<Conta> contaOrigemOpt = contaRepository.findById(idContaOrigem);
        Optional<Conta> contaDestinoOpt = contaRepository.findById(idContaDestino);

        if (contaOrigemOpt.isEmpty()) {
            return "Conta de origem não encontrada.";
        }

        if (contaDestinoOpt.isEmpty()) {
            return "Conta de destino não encontrada.";
        }

        Conta contaOrigem = contaOrigemOpt.get();
        Conta contaDestino = contaDestinoOpt.get();

        if (!contaOrigem.getIdCliente().equals(contaDestino.getIdCliente())) {
            return "As contas não pertencem ao mesmo cliente.";
        }

        BigDecimal saldoOrigem = BigDecimal.valueOf(contaOrigem.getSaldo());
        if (saldoOrigem.compareTo(valor) < 0) {
            return "Saldo insuficiente para realizar a transferência.";
        }

        try {
            contaOrigem.debitar(valor.doubleValue());
            contaDestino.creditar(valor.doubleValue());

            contaRepository.save(contaOrigem);
            contaRepository.save(contaDestino);

            return "Transferência realizada com sucesso!";
        } catch (Exception e) {
            return "Erro ao processar a transferência: " + e.getMessage();
        }
    }
}