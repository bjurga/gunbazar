package pl.bjur.shooter.address;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.bjur.shooter.commons.BaseRepository;

public interface AddressRepository extends BaseRepository<Address>, QuerydslPredicateExecutor<Address> {
}
