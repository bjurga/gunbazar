package pl.bjur.shooter.tournament.competition.result;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository repository;

    @Transactional
    public Result add(Result entity) {
        return repository.create(entity);
    }

    public Result getById(Long id) {
        return repository.loadOne(id);
    }

    @Transactional
    public Result update(Result entity) {
        return repository.updateExisting(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteExisting(id);
    }
}