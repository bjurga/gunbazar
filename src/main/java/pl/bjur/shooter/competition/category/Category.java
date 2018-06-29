package pl.bjur.shooter.competition.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.commons.IdEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends IdEntity {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    //TODO: distance, typBroni, typTarczy, czas, isDynamic
}
