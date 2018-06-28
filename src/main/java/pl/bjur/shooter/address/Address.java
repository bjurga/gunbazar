package pl.bjur.shooter.address;

import lombok.*;
import pl.bjur.shooter.commons.EntityId;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Address extends EntityId {

    @NotNull
    private String name;

    @NotNull
    private String street;

    @Pattern(regexp = "^[0-9][0-9]-[0-9][0-9][0-9]$")
    @NotNull
    private String zipcode;

    @NotNull
    private String city;

    private String phoneNumber;
}
