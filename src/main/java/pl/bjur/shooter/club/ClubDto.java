package pl.bjur.shooter.club;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
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

    @Builder
    public ClubDto(Long id, @NotBlank String displayName, Address address, @NotBlank User owner, String pzssLicence,
                   boolean confirmed, Set<User> members, boolean registrationOpen) {
        super(id);
        this.displayName = displayName;
        this.address = address;
        this.owner = owner;
        this.pzssLicence = pzssLicence;
        this.confirmed = confirmed;
        this.members = members;
        this.registrationOpen = registrationOpen;
    }
}
