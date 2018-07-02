package pl.bjur.shooter.competition.result;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.bjur.shooter.commons.BaseRepository;

public interface ResultRepository extends BaseRepository<Result>, QuerydslPredicateExecutor<Result> {
}
