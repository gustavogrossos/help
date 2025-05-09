package org.jala.university.application.service;

import org.jala.university.domain.entity.Conta;
import org.jala.university.domain.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final ContaRepository contaRepository;

    public TransactionServiceImpl(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public String transferirEntreContasProprias(Long idContaOrigem, Long idContaDestino, BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            return "O valor da transferência deve ser positivo.";
        }

        Optional<Conta> contaOrigemOpt = contaRepository.findById(idContaOrigem);
        Optional<Conta> contaDestinoOpt = contaRepository.findById(idContaDestino);

        if (contaOrigemOpt.isEmpty() || contaDestinoOpt.isEmpty()) {
            return "Conta de origem ou destino não encontrada.";
        }

        Conta contaOrigem = contaOrigemOpt.get();
        Conta contaDestino = contaDestinoOpt.get();

        // Verifica se são do mesmo cliente
        if (!contaOrigem.getIdCliente().equals(contaDestino.getIdCliente())) {
            return "As contas não pertencem ao mesmo cliente.";
        }

        // Verifica saldo
        if (contaOrigem.getSaldo().compareTo(valor) < 0) {
            return "Saldo insuficiente na conta de origem.";
        }

        // Realiza a transferência
        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));

        // Salva as alterações
        contaRepository.save(contaOrigem);
        contaRepository.save(contaDestino);

        return "Transferência realizada com sucesso!";
    }
}

