package pl.bjur.strzelec.dupa.shootingClub;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShootingClubRepository extends JpaRepository<ShootingClub, Long> {


}
