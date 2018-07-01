package pl.bjur.shooter.commons;

import javax.transaction.Transactional;

public interface BaseService<T extends IdEntity> {

    @Transactional
    public T add(T entity);

    public T getById(Long id);

    @Transactional
    public T update(T entity);

    @Transactional
    public void delete(Long id);
}
