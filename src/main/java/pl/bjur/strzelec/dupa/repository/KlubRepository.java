package pl.bjur.strzelec.dupa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.bjur.strzelec.dupa.model.Klub;

@Repository
public interface KlubRepository extends JpaRepository<Klub, Long> {



}
