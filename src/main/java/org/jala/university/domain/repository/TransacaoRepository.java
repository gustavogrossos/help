package org.jala.university.domain.repository;

import org.jala.university.domain.entity.Transacao;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    List<Transacao> findByIdContaOrigem(Integer idContaOrigem);

    List<Transacao> findByIdContaOrigem(Integer idContaOrigem, Pageable pageable);

    List<Transacao> findByIdContaOrigemOrIdContaDestino(Integer idConta, Integer idContaMesmo);

    List<Transacao> findByIdContaOrigemAndDataHoraBetween(Integer idContaOrigem, LocalDateTime inicio, LocalDateTime fim);

    List<Transacao> findByIdContaOrigemAndTipo(Integer idContaOrigem, Transacao.TipoTransacao tipo);
}
