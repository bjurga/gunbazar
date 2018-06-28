package pl.bjur.shooter.address;

import lombok.*;
import pl.bjur.shooter.commons.EntityWithId;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Address extends EntityWithId {

    @NotNull
    private String name;

    @NotNull
    private String streetWithNuber;

    @Pattern(regexp = "^[0-9][0-9]-[0-9][0-9][0-9]$")
    @NotNull
    private String zipcode;

    @NotNull
    private String city;
}
