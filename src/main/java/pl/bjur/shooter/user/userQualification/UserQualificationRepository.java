package pl.bjur.shooter.user.userQualification;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.bjur.shooter.commons.BaseRepository;

public interface UserQualificationRepository extends BaseRepository<UserQualification>, QuerydslPredicateExecutor<UserQualification> {
}
