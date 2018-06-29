package pl.bjur.shooter.address;

import lombok.*;
import pl.bjur.shooter.commons.IdEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Address extends IdEntity {

    @NotNull
    private String name;

    @NotNull
    private String street;

    @NotNull
    private String zipCode;

    @NotNull
    private String city;

    private String phone;
}
