package pl.bjur.shooter.user.qualification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class QualificationService {

    private final QualificationRepository repository;

    @Transactional
    public Qualification add(Qualification entity) {
        return repository.create(entity);
    }

    public Qualification getById(Long id) {
        return repository.loadOne(id);
    }

    @Transactional
    public Qualification update(Qualification entity) {
        return repository.updateExisting(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteExisting(id);
    }
}
