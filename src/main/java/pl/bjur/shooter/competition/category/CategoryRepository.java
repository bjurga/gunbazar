package pl.bjur.shooter.competition.category;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.bjur.shooter.commons.BaseRepository;

public interface CategoryRepository extends BaseRepository<Category>, QuerydslPredicateExecutor<Category> {
}
