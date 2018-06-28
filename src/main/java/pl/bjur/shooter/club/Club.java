package pl.bjur.shooter.club;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.address.Address;
import pl.bjur.shooter.commons.EntityId;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Club extends EntityId {

    private String displayName;

    @OneToOne
    private Address address;
}
