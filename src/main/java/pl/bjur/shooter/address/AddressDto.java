package pl.bjur.shooter.address;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.commons.IdDto;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class AddressDto extends IdDto {

    @NotNull
    private String name;

    @NotNull
    private String street;

    @NotNull
    private String zipCode;

    @NotNull
    private String city;
  
    private String phone;

    @Builder
    public AddressDto(Long id, @NotNull String name, @NotNull String street, @NotNull String zipCode, @NotNull String city, String phone) {
        super(id);
        this.name = name;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.phone = phone;
    }
}
