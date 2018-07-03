package pl.bjur.shooter.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    @Transactional
    public User add(User entity) {
        return repository.create(entity);
    }

    public User getById(Long id) {
        return repository.loadOne(id);
    }

    @Transactional
    public User update(User entity) {
        return repository.updateExisting(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteExisting(id);
    }
}
