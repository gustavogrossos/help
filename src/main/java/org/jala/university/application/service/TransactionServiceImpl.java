package org.jala.university.application.service;

import lombok.RequiredArgsConstructor;
import org.jala.university.application.dto.TransacaoDto;
import org.jala.university.domain.entity.Banco;
import org.jala.university.domain.entity.Conta;
import org.jala.university.domain.entity.Transacao;
import org.jala.university.domain.repository.ContaRepository;
import org.jala.university.domain.repository.TransacaoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final ContaRepository contaRepository;
    private final TransacaoRepository transacaoRepository;
    private final BancoRepository bancoRepository;

    @Override
    @Transactional
    public String transferirEntreContasProprias(Integer idContaOrigem, Integer idContaDestino, BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            return "O valor da transferência deve ser positivo.";
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

        if (contaOrigem.getStatus() != Conta.StatusConta.ativa) {
            return "A conta de origem não está ativa.";
        }

        if (contaDestino.getStatus() != Conta.StatusConta.ativa) {
            return "A conta de destino não está ativa.";
        }

        if (contaOrigem.getSaldo().compareTo(valor) < 0) {
            return "Saldo insuficiente na conta de origem.";
        }

        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));

        // Registra a transação
        Transacao transacao = Transacao.builder()
                .idContaOrigem(idContaOrigem)
                .idContaDestino(idContaDestino)
                .valor(valor)
                .dataHora(LocalDateTime.now())
                .tipo(Transacao.TipoTransacao.transferência)
                .descricao("Transferência entre contas próprias")
                .status(Transacao.StatusTransacao.concluída)
                .codigoAutenticacao(gerarCodigoAutenticacao())
                .build();

        // Salva as alterações
        contaRepository.save(contaOrigem);
        contaRepository.save(contaDestino);
        transacaoRepository.save(transacao);

        return "Transferência realizada com sucesso!";
    }
    }