package pl.bjur.shooter.tournament;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TournamentService {

    private final TournamentRepository repository;

    @Transactional
    public Tournament add(Tournament entity) {
        return repository.create(entity);
    }

    public Tournament getById(Long id) {
        return repository.loadOne(id);
    }

    @Transactional
    public Tournament update(Tournament entity) {
        return repository.updateExisting(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteExisting(id);
    }

    public List<Tournament> getAll() {
        return repository.findAll();
    }
}