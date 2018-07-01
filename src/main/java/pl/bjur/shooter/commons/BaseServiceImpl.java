package pl.bjur.shooter.commons;

import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public class BaseServiceImpl<T extends IdEntity, TRepository extends BaseRepositoryImpl> implements BaseService<T> {

    protected TRepository repository;


    @Transactional
    public T add(T entity) {
        return (T) repository.create(entity);
    }

    public T getById(Long id) {
        return (T) repository.loadOne(id);
    }

    @Transactional
    public T update(T entity) {
        return (T) repository.updateExisting(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteExisting(id);
    }
}
