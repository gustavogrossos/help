package org.jala.university.domain.repository;

import org.jala.university.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByCpf(String cpf);

    boolean existsByCpf(String cpf);

    Optional<Cliente> findByEmail(String email);
}
