package org.jala.university.domain.repository;

import org.jala.university.domain.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

    Optional<Conta> findByNumeroConta(String numeroConta);

    List<Conta> findByIdCliente(Integer idCliente);

    List<Conta> findByIdClienteAndStatus(Integer idCliente, Conta.StatusConta status);
}
