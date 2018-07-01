package pl.bjur.shooter.commons;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
public class BaseControllerImpl<D extends IdDto, Tservice extends BaseServiceImpl<T>> implements BaseController<D> {

    protected final MapperFacade mapper;
    protected final Tservice service;


    @Override
    @GetMapping("/{id}")
    public D getOne(Long id) {
        return mapper.map(service.getById(id), D.class);
    }

    @Override
    public D create(D dto) {
        return null;
    }

    @Override
    public D update(D dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
