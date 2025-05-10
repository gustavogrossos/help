package org.jala.university.domain.repository;

import org.jala.university.commons.domain.Repository;
import org.jala.university.domain.entity.SampleEntity;

import java.util.Optional;
import java.util.UUID;

public interface SampleEntityRepository extends Repository<SampleEntity, UUID> {
    Optional<SampleEntity> findByNome(String nome);
}
