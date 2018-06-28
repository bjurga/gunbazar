package pl.bjur.shooter.club;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.address.Address;
import pl.bjur.shooter.commons.EntityId;
<<<<<<< HEAD
import pl.bjur.shooter.user.User;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;
=======

import javax.persistence.Entity;
import javax.persistence.OneToOne;
>>>>>>> 3ad0c7aa2ec0cba142a022b4d6fa58ea1d12869b


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Club extends EntityId {

<<<<<<< HEAD
    @NotBlank
=======
>>>>>>> 3ad0c7aa2ec0cba142a022b4d6fa58ea1d12869b
    private String displayName;

    @OneToOne
    private Address address;
<<<<<<< HEAD

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
=======
>>>>>>> 3ad0c7aa2ec0cba142a022b4d6fa58ea1d12869b
}
