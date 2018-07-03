package pl.bjur.shooter.shootingrange;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.address.AddressDto;
import pl.bjur.shooter.commons.IdDto;
import pl.bjur.shooter.user.UserDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ShootingRangeDto extends IdDto {

    @NotBlank
    private String name;

    @NotNull
    private AddressDto address;

    private UserDto owner;

    @Builder
    public ShootingRangeDto(Long id, @NotBlank String name, @NotNull AddressDto address, UserDto owner) {
        super(id);
        this.name = name;
        this.address = address;
        this.owner = owner;
    }
}
