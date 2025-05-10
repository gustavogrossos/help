package org.jala.university.domain.repository;

import org.jala.university.domain.entity.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {
    Optional<Banco> findByCodigoBanco(String codigoBanco);
}
