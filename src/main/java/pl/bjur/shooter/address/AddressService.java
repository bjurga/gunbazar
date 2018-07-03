package pl.bjur.shooter.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository repository;

    @Transactional
    public Address add(Address entity) {
        return repository.create(entity);
    }

    public Address getById(Long id) {
        return repository.loadOne(id);
    }

    @Transactional
    public Address update(Address entity) {
        return repository.updateExisting(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteExisting(id);
    }

    public List<Address> getAll() {
        return repository.findAll();
    }
}
