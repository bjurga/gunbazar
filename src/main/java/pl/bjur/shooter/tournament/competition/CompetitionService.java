package pl.bjur.shooter.tournament.competition;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetitionService {

    private final CompetitionRepository repository;

    @Transactional
    public Competition add(Competition entity) {
        return repository.create(entity);
    }

    public Competition getById(Long id) {
        return repository.loadOne(id);
    }

    @Transactional
    public Competition update(Competition entity) {
        return repository.updateExisting(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteExisting(id);
    }

    public List<Competition> getAll() {
        return repository.findAll();
    }
}

