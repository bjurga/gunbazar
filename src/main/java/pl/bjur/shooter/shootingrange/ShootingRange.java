package pl.bjur.shooter.shootingrange;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.address.Address;
import pl.bjur.shooter.commons.IdEntity;
import pl.bjur.shooter.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShootingRange extends IdEntity {

    @NotBlank
    private String name;

    @NotNull
    @OneToOne
    private Address address;

    @ManyToOne
    private User owner;

    //TODO: available shooting lines, opening hours, commercialShooting offer with pricing and available weapons
}
