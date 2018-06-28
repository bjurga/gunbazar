package pl.bjur.shooter.club;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.address.Address;
import pl.bjur.shooter.commons.EntityId;
import pl.bjur.shooter.user.User;

import javax.persistence.Entity;
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
public class Club extends EntityId {

    @NotBlank
    private String displayName;

    @OneToOne
    private Address address;

    @OneToOne
    @NotBlank
    private User owner;

    @NotBlank //?
    private String pzssClubLicenceNumber;

    @NotNull
    private Boolean isConfirmed;

    @OneToMany
    private Set<User> members;

    @NotNull
    private Boolean isMemberRegistrationOpen;
}
