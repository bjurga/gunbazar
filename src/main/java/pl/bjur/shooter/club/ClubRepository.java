package pl.bjur.shooter.club;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.bjur.shooter.commons.BaseRepository;

public interface ClubRepository extends BaseRepository<Club>, QuerydslPredicateExecutor<Club> {
}
