package pl.bjur.shooter.commons;


public interface BaseController<D extends IdDto> {

    D getOne(Long id);

    D create(D dto);

    D update(D dto);

    void delete(Long id);
}
