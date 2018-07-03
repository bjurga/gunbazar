package pl.bjur.shooter.commons;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import pl.bjur.shooter.commons.exceptions.NotFoundException;

import javax.persistence.EntityManager;

import static java.util.Objects.isNull;

@NoRepositoryBean
public class BaseRepositoryImpl<T extends IdEntity> extends QuerydslJpaRepository<T, Long> implements BaseRepository<T> {

    public BaseRepositoryImpl(JpaEntityInformation<T, Long> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Override
    public T loadOne(Long id) {
        T entity = getOne(id);
        if (isNull(entity)) {
            throw new NotFoundException(id);
        }
        return entity;
    }

    @Override
    @Transactional
    public T create(T createdEntity) {
        createdEntity.setId(null);
        return save(createdEntity);
    }

    @Override
    @Transactional
    public T updateExisting(T sourceEntity) {
        loadOne(sourceEntity.getId());
        return save(sourceEntity);
    }

    @Override
    @Transactional
    public void deleteExisting(Long id) {
        delete(loadOne(id));
    }
}
