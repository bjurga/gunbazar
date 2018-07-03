package pl.bjur.shooter.tournament.competition;

import lombok.*;
import pl.bjur.shooter.commons.IdEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Competition extends IdEntity {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    //TODO: distance, typBroni, typTarczy, czas, isDynamic
}
