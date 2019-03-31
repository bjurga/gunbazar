package pl.bjur.shooter.tournament;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.bjur.shooter.commons.BaseRepository;

public interface TournamentRepository extends BaseRepository<Tournament>, QuerydslPredicateExecutor<Tournament> {
}
