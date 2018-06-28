package pl.bjur.strzelec.dupa.model;

import lombok.*;
import pl.bjur.strzelec.dupa.model.abstracts.HasEmailAndPassword;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ShootingClub extends HasEmailAndPassword {

    private String displayName;

    @OneToOne
    private Address address;
}
