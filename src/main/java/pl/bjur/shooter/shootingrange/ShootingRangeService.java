package pl.bjur.shooter.shootingrange;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ShootingRangeService {

    private final ShootingRangeRepository repository;

    @Transactional
    public ShootingRange add(ShootingRange entity) {
        return repository.create(entity);
    }

    public ShootingRange getById(Long id) {
        return repository.loadOne(id);
    }

    @Transactional
    public ShootingRange update(ShootingRange entity) {
        return repository.updateExisting(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteExisting(id);
    }
}
