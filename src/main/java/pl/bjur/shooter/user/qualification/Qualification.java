package pl.bjur.shooter.user.qualification;

import lombok.*;
import pl.bjur.shooter.commons.IdEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Qualification extends IdEntity {

    @NotBlank
    private String name;

    private String qualificationNumber;

    private LocalDateTime validFrom;

    private LocalDateTime validTo;
}
