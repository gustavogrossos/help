package org.jala.university.application.service;

import lombok.RequiredArgsConstructor;
import org.jala.university.application.dto.TransacaoDTO;
import org.jala.university.domain.entity.Banco;
import org.jala.university.domain.entity.Conta;
import org.jala.university.domain.entity.Transacao;
import org.jala.university.domain.repository.BancoRepository;
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

    @Override
    @Transactional
    public String transferirParaTerceiros(Integer idContaOrigem, Integer idContaDestino,
                                          BigDecimal valor, String descricao) {
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

        if (contaOrigem.getStatus() != Conta.StatusConta.ativa) {
            return "A conta de origem não está ativa.";
        }

        if (contaDestino.getStatus() != Conta.StatusConta.ativa) {
            return "A conta de destino não está ativa.";
        }

        // Verifica saldo
        if (contaOrigem.getSaldo().compareTo(valor) < 0) {
            return "Saldo insuficiente na conta de origem.";
        }

        // Realiza a transferência
        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));

        // Registra a transação
        Transacao transacao = Transacao.builder()
                .idContaOrigem(idContaOrigem)
                .idContaDestino(idContaDestino)
                .valor(valor)
                .dataHora(LocalDateTime.now())
                .tipo(Transacao.TipoTransacao.transferência)
                .descricao(descricao != null ? descricao : "Transferência para terceiros")
                .status(Transacao.StatusTransacao.concluída)
                .codigoAutenticacao(gerarCodigoAutenticacao())
                .build();

        // Salva as alterações
        contaRepository.save(contaOrigem);
        contaRepository.save(contaDestino);
        transacaoRepository.save(transacao);

        return "Transferência para terceiros realizada com sucesso!";
    }

    @Override
    @Transactional
    public String transferirParaOutroBanco(Integer idContaOrigem, String codigoBanco,
                                           String agenciaDestino, String contaDestino,
                                           String digitoDestino, BigDecimal valor, String descricao) {
        // Validações básicas
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            return "O valor da transferência deve ser positivo.";
        }

        Optional<Conta> contaOrigemOpt = contaRepository.findById(idContaOrigem);
        Optional<Banco> bancoDestinoOpt = bancoRepository.findByCodigoBanco(codigoBanco);

        if (contaOrigemOpt.isEmpty()) {
            return "Conta de origem não encontrada.";
        }

        if (bancoDestinoOpt.isEmpty()) {
            return "Banco de destino não encontrado.";
        }

        Conta contaOrigem = contaOrigemOpt.get();
        Banco bancoDestino = bancoDestinoOpt.get();

        if (contaOrigem.getStatus() != Conta.StatusConta.ativa) {
            return "A conta de origem não está ativa.";
        }

        if (contaOrigem.getSaldo().compareTo(valor) < 0) {
            return "Saldo insuficiente na conta de origem.";
        }

        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));

        Transacao transacao = Transacao.builder()
                .idContaOrigem(idContaOrigem)
                .idBancoDestino(bancoDestino.getIdBanco())
                .valor(valor)
                .dataHora(LocalDateTime.now())
                .tipo(Transacao.TipoTransacao.transferência)
                .descricao(String.format("%s - Banco: %s, Agência: %s, Conta: %s-%s",
                        descricao != null ? descricao : "Transferência para outro banco",
                        bancoDestino.getNome(), agenciaDestino, contaDestino, digitoDestino))
                .status(Transacao.StatusTransacao.concluída)
                .codigoAutenticacao(gerarCodigoAutenticacao())
                .build();

        // Salva as alterações
        contaRepository.save(contaOrigem);
        transacaoRepository.save(transacao);

        return "Transferência interbancária realizada com sucesso!";
    }

    @Override
    public List<TransacaoDTO> obterExtrato(Integer idConta, Integer quantidade) {
        // Busca as últimas transações da conta
        Page