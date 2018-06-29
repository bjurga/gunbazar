package pl.bjur.shooter.address;

import lombok.*;
import pl.bjur.shooter.commons.IdDto;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddressDto extends IdDto {

    @NotNull
    private String name;

    @NotNull
    private String street;

    @NotNull
    private String zipCode;

    @NotNull
    private String city;

    private String phoneNumber;
}
