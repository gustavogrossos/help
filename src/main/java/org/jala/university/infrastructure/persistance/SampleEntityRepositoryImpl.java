package org.jala.university.infrastructure.persistance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.jala.university.commons.infrastructure.persistance.CrudRepository;
import org.jala.university.domain.entity.SampleEntity;
import org.jala.university.domain.repository.SampleEntityRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SampleEntityRepositoryImpl extends CrudRepository<SampleEntity, UUID>
        implements SampleEntityRepository {

    public SampleEntityRepositoryImpl(EntityManager entityManager) {
        super(SampleEntity.class, entityManager);
    }

    /**
     * Busca uma entidade SampleEntity pelo nome.
     * @param nome nome a ser buscado.
     * @return Optional contendo a entidade, se encontrada.
     */
    @Override
    public Optional<SampleEntity> findByNome(String nome) {
        TypedQuery<SampleEntity> query = getEntityManager().createQuery(
                "SELECT s FROM SampleEntity s WHERE s.nome = :nome", SampleEntity.class);
        query.setParameter("nome", nome);

        List<SampleEntity> resultados = query.getResultList();
        if (resultados.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(resultados.get(0));
    }

    // Expondo protected getEntityManager() se necessário
    protected EntityManager getEntityManager() {
        return super.entityManager;
    }
}
