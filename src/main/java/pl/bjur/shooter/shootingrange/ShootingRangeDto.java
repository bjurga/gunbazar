package pl.bjur.shooter.shootingrange;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.address.Address;
import pl.bjur.shooter.commons.IdDto;
import pl.bjur.shooter.user.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ShootingRangeDto extends IdDto {

    @NotBlank
    private String name;

    @NotNull
    private Address address;

    private User owner;

    @Builder
    public ShootingRangeDto(Long id, @NotBlank String name, @NotNull Address address, User owner) {
        super(id);
        this.name = name;
        this.address = address;
        this.owner = owner;
    }
}
