package pl.bjur.shooter.user.qualification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.bjur.shooter.commons.IdEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Qualification extends IdEntity {

    @NotBlank
    private String name;

    private String qualificationNumber;

    private LocalDateTime validFrom;

    private LocalDateTime validTo;
}
