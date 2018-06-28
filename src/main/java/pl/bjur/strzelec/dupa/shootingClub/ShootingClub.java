package pl.bjur.strzelec.dupa.shootingClub;

import lombok.*;
import pl.bjur.strzelec.dupa.commons.Address;
import pl.bjur.strzelec.dupa.commons.HasEmailAndPassword;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ShootingClub extends HasEmailAndPassword {

    private String displayName;

    @OneToOne
    private Address address;
}
