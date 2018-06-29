package pl.bjur.shooter.address;

import lombok.*;
import pl.bjur.shooter.commons.EntityId;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address extends EntityId {

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
