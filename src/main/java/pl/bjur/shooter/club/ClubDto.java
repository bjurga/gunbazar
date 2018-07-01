package pl.bjur.shooter.club;

import lombok.Getter;
import lombok.Setter;
import pl.bjur.shooter.address.Address;
import pl.bjur.shooter.commons.IdDto;
import pl.bjur.shooter.user.User;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
public class ClubDto extends IdDto {

    @NotBlank
    private String displayName;

    @OneToOne
    private Address address;

    @OneToOne
    @NotBlank
    private User owner;

    private String pzssLicence;

    private boolean confirmed;

    @OneToMany
    private Set<User> members;

    private boolean registrationOpen;
}
