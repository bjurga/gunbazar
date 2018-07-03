package pl.bjur.shooter.user.qualification;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.bjur.shooter.commons.BaseRepository;

public interface QualificationRepository extends BaseRepository<Qualification>, QuerydslPredicateExecutor<Qualification> {
}
