package pl.bjur.strzelec.dupa.model;

import lombok.Data;
import pl.bjur.strzelec.dupa.model.abstracts.HasEmailAndPassword;

import javax.persistence.Entity;

@Data
@Entity
public class Klub extends HasEmailAndPassword {

    private String nazwa;
}
