package pl.bjur.shooter.user;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.bjur.shooter.commons.BaseRepository;

public interface UserRepository extends BaseRepository<User>, QuerydslPredicateExecutor<User> {
}
