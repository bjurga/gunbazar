package pl.bjur.shooter.shootingrange;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.bjur.shooter.commons.BaseRepository;

public interface ShootingRangeRepository extends BaseRepository<ShootingRange>, QuerydslPredicateExecutor<ShootingRange> {
}
