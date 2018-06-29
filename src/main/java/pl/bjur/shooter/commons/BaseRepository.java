package pl.bjur.shooter.commons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface BaseRepository<T extends IdEntity> extends JpaRepository<T, Long>, QuerydslPredicateExecutor<T> {

    T loadOne(Long id);

    T create(T createdEntity);

    T updateExisting(T sourceEntity);

    void deleteExisting(Long id);
}
