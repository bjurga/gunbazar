package pl.bjur.shooter.user.userQualification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserQualificationService {

    private final UserQualificationRepository repository;

    @Transactional
    public UserQualification add(UserQualification entity) {
        return repository.create(entity);
    }

    public UserQualification getById(Long id) {
        return repository.loadOne(id);
    }

    @Transactional
    public UserQualification update(UserQualification entity) {
        return repository.updateExisting(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteExisting(id);
    }
}
