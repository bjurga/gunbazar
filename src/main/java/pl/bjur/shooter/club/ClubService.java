package pl.bjur.shooter.club;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubService {

    private final ClubRepository repository;

    @Transactional
    public Club add(Club entity) {
        return repository.create(entity);
    }

    public Club getById(Long id) {
        return repository.loadOne(id);
    }

    @Transactional
    public Club update(Club entity) {
        return repository.updateExisting(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteExisting(id);
    }

    public List<Club> getAll() {
        return repository.findAll();
    }
}
