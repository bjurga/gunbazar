package pl.bjur.shooter.club;

import lombok.*;
import pl.bjur.shooter.address.Address;
import pl.bjur.shooter.commons.IdEntity;
import pl.bjur.shooter.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Club extends IdEntity {

    @NotBlank
    private String name;

    @OneToOne
    private Address address;

    @ManyToOne
    @NotNull
    private User owner;

    private String pzssLicence;

    private boolean confirmed;

    @OneToMany
    private Set<User> members;

    private boolean registrationOpen;
}
