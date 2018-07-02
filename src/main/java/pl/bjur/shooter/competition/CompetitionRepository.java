package pl.bjur.shooter.competition;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.bjur.shooter.commons.BaseRepository;

public interface CompetitionRepository extends BaseRepository<Competition>, QuerydslPredicateExecutor<Competition> {
}
