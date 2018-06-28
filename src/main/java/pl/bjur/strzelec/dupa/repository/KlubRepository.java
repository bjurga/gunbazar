package pl.bjur.strzelec.dupa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bjur.strzelec.dupa.model.ShootingClub;

@Repository
public interface KlubRepository extends JpaRepository<ShootingClub, Long> {



}
