package pl.bjur.shooter.competition.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    @Transactional
    public Category add(Category entity) {
        return repository.create(entity);
    }

    public Category getById(Long id) {
        return repository.loadOne(id);
    }

    @Transactional
    public Category update(Category entity) {
        return repository.updateExisting(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteExisting(id);
    }
}

